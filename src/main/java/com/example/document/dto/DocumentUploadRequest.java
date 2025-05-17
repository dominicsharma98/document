package com.example.document.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;

public class DocumentUploadRequest {
    @Schema(description = "Title of the document", example = "My Document")
    public String title;

    @Schema(description = "Author of the document", example = "Alice")
    public String author;

    @Schema(description = "Type of the document", example = "pdf")
    public String type;

    @Schema(description = "The file to upload", type = "string", format = "binary")
    public MultipartFile file;

}
