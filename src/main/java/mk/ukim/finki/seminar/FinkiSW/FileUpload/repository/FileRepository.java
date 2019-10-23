package mk.ukim.finki.seminar.FinkiSW.FileUpload.repository;

import mk.ukim.finki.seminar.FinkiSW.FileUpload.payload.UploadFileResponse;

public interface FileRepository {

    UploadFileResponse getFileById(Long id);

    UploadFileResponse addNewFile(UploadFileResponse fileResponse);
}
