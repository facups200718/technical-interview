package com.boxcustodia.entrevistatecnica.mapper;

import com.boxcustodia.entrevistatecnica.dto.in.DocumentByHashInResponseDTO;
import com.boxcustodia.entrevistatecnica.dto.in.DocumentInResponseDTO;
import com.boxcustodia.entrevistatecnica.entity.DocumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    @Mapping(source = "fileName", target = "fileName")
    @Mapping(source = "hashSha256", target = "hashSha256")
    @Mapping(source = "hashSha512", target = "hashSha512")
    @Mapping(source = "lastUpload", target = "lastUpload")
    DocumentInResponseDTO toDTO(DocumentEntity documentEntity);
    List<DocumentInResponseDTO> toDTOs(List<DocumentEntity> documentEntities);

    @Mapping(source = "fileName", target = "fileName")
    @Mapping(source = "lastUpload", target = "lastUpload")
    DocumentByHashInResponseDTO byHashToDTO(DocumentEntity documentEntity);
}
