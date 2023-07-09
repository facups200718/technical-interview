package com.boxcustodia.entrevistatecnica.repository;

import com.boxcustodia.entrevistatecnica.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
}
