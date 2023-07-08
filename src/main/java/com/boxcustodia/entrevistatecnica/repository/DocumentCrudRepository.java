package com.boxcustodia.entrevistatecnica.repository;

import com.boxcustodia.entrevistatecnica.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentCrudRepository extends CrudRepository<DocumentEntity, String> {
    Optional<DocumentEntity> findByHashSha256(String hashSha256);
    Optional<DocumentEntity> findByHashSha512(String hashSha512);
}
