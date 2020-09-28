package mk.ukim.finki.seminar.FinkiSW.Model;

public class GitRepo {

    private String token;
    private String name;
    private String description;
    private String homepage;
    private boolean isPrivate;
    private boolean hasIssues;
    private boolean hasProjects;
    private boolean hasWiki;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getHomepage() { return homepage; }

    public void setHomepage(String homepage) { this.homepage = homepage; }

    public boolean isPrivate() { return isPrivate; }

    public void setPrivate(boolean aPrivate) { isPrivate = aPrivate; }

    public boolean isHasIssues() { return hasIssues; }

    public void setHasIssues(boolean hasIssues) { this.hasIssues = hasIssues; }

    public boolean isHasProjects() {
        return hasProjects;
    }

    public void setHasProjects(boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }
}
