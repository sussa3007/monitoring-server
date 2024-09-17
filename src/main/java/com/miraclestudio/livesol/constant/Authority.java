package com.miraclestudio.livesol.constant;

import lombok.Getter;

import java.util.List;

@Getter
public enum Authority {
    ADMIN(List.of("ADMIN", "USER"), "관리자"),
    USER(List.of("USER"), "사용자");

    private final List<String> stringRole;

    private final String title;

    Authority(List<String> stringRole, String title) {
        this.stringRole = stringRole;
        this.title = title;
    }
}

