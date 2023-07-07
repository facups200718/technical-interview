package com.boxcustodia.entrevistatecnica.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum HashType {
    SHA256("SHA-256"),
    SHA512("SHA-512");

    private final String value;

    public static boolean isValid(String hashType) {
        return Arrays.stream(values())
                .map(HashType::getValue)
                .anyMatch(type -> type.equalsIgnoreCase(hashType));
    }
}
