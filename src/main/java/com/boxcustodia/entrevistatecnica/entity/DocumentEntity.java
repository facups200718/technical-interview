package com.boxcustodia.entrevistatecnica.entity;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "username")
    private UserEntity accountId;
}
