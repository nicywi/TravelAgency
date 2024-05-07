package com.travelagency.nastokpl.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SecurityApiPaths {
    HOME_PAGE("/"),
    SIGN_IN_PAGE("/sign-in"),
    SIGN_IN_API("/api/sign-in"),
    SIGN_OUT_API("/api/sign-out"),
    REGISTER_PAGE("/register/**");

    private final String endpoint;
}
