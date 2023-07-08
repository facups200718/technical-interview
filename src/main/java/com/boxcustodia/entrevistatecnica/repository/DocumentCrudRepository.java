package com.boxcustodia.entrevistatecnica.repository;

import com.boxcustodia.entrevistatecnica.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCrudRepository extends CrudRepository<DocumentEntity, String> {
}
