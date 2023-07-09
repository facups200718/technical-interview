package com.boxcustodia.entrevistatecnica.repository.impl;

import com.boxcustodia.entrevistatecnica.dto.in.UserInResponseDTO;
import com.boxcustodia.entrevistatecnica.entity.UserEntity;
import com.boxcustodia.entrevistatecnica.mapper.UserMapper;
import com.boxcustodia.entrevistatecnica.repository.UserJpaRepository;
import com.boxcustodia.entrevistatecnica.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public UserInResponseDTO findById(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userJpaRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found."));
        return userMapper.toDTO(userEntity);
    }
}
