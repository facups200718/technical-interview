package com.boxcustodia.entrevistatecnica.repository;

import com.boxcustodia.entrevistatecnica.dto.in.UserInResponseDTO;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserRepository {
    UserInResponseDTO findById(String username) throws UsernameNotFoundException;
}
