package com.boxcustodia.entrevistatecnica.dto.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInResponseDTO {
    private ErrorDetails error;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ErrorDetails {
        private Long timestamp;
        private Integer status;
        private String message;
        private String path;

        public ErrorDetails(Integer status, String message, String path) {
            this.timestamp = System.currentTimeMillis();
            this.status = status;
            this.message = message;
            this.path = path;
        }
    }
}

