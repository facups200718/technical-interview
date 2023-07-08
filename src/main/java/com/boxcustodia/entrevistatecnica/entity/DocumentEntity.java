package com.boxcustodia.entrevistatecnica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "files")
public class DocumentEntity {
    @Id
    @Column(name = "file_name")
    private String fileName;

    @Column(name = "hash_sha_256")
    private String hashSha256;

    @Column(name = "hash_sha_512")
    private String hashSha512;

    @Column(name = "last_upload")
    private LocalDateTime lastUpload;
}
