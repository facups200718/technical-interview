package com.boxcustodia.entrevistatecnica.util;

import com.boxcustodia.entrevistatecnica.dto.in.ErrorInResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class ErrorUtil {
    public static ResponseEntity getErrorResponse(Integer status, String message) {
        var errorDetails = new ErrorInResponseDTO.ErrorDetails(status, message, getPath());
        return ResponseEntity.badRequest().body(ErrorInResponseDTO.builder().error(errorDetails).build());
    }

    public static String getPath() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String path = null;

        if (Objects.nonNull(requestAttributes)) {
            path = requestAttributes.getRequest().getRequestURI();
        }
        return path;
    }
}
