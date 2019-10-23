package mk.ukim.finki.seminar.FinkiSW.FileUpload.repository;

import mk.ukim.finki.seminar.FinkiSW.FileUpload.payload.UploadFileResponse;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository {

    private FileJpaRepository repository;

    public FileRepositoryImpl(FileJpaRepository repository) { this.repository = repository; }

    @Override
    public UploadFileResponse getFileById(Long id) {
        return repository.getFileById(id);
    }

    @Override
    public UploadFileResponse addNewFile(UploadFileResponse fileResponse) {
        repository.save(fileResponse);
        return fileResponse;
    }
}