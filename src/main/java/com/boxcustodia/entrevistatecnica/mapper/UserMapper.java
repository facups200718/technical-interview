package com.boxcustodia.entrevistatecnica.mapper;

import com.boxcustodia.entrevistatecnica.dto.in.UserInResponseDTO;
import com.boxcustodia.entrevistatecnica.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "lastLogin", target = "lastLogin")
    UserInResponseDTO toDTO(UserEntity userEntity);
}
