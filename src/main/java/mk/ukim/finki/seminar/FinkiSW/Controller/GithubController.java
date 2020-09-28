package mk.ukim.finki.seminar.FinkiSW.Controller;

import com.sun.deploy.net.HttpResponse;
import mk.ukim.finki.seminar.FinkiSW.Model.GitRepo;
import mk.ukim.finki.seminar.FinkiSW.Model.GitRequests;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/github")
public class GithubController {

    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('TEACHER_USER') or hasAuthority('STUDENT_USER')")
    public String getAuth(@Valid @RequestBody GitRequests gitRequests) throws IOException {

        String uri = gitRequests.getUri();
        String code = gitRequests.getData();
        StringBuilder response = new StringBuilder();

        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        JSONObject obj=new JSONObject();
        obj.put("client_id","d21b46f17bbb88708038");
        obj.put("client_secret","63f638ca571d838ccf77f826a9ed8916640e77eb");
        obj.put("code",code);
        String jsonInputString = obj+"";

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

        return response.toString();
    }

    @RequestMapping(value = "/repo",method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('TEACHER_USER') or hasAuthority('STUDENT_USER')")
    public String getAuth(@Valid @RequestBody GitRepo gitRepo) throws IOException {

        String token = gitRepo.getToken();
        StringBuilder response = new StringBuilder();

        JSONObject obj=new JSONObject();
        obj.put("name",gitRepo.getName());
        obj.put("description",gitRepo.getDescription());
        obj.put("homepage",gitRepo.getHomepage());
        obj.put("private",gitRepo.isPrivate());
        obj.put("has_issues",gitRepo.isHasIssues());
        obj.put("has_projects",gitRepo.isHasProjects());
        obj.put("has_wiki",gitRepo.isHasWiki());
        String jsonInputString = obj+"";

        URL url = new URL("https://api.github.com/user/repos");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Authorization", "token "+token);
        con.setRequestProperty("Accept", "application/vnd.github.v3+json");
        con.setRequestProperty("X-OAuth-Scopes", "repo");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

        return response.toString();
    }


}
