package com.miraclestudio.livesol.constant;

import lombok.Getter;

public enum ErrorCode {

    BAD_REQUEST(400, "BAD REQUEST", 14001),
    USER_EXIST(400, "USER EXIST", 14002),

    ACCESS_DENIED(403, "ACCESS DENIED", 14003),
    EXPIRED_ACCESS_TOKEN(403, "Expired Access Token", 14004),
    NOT_FOUND(404, "NOT FOUND", 14005),
    NOT_FOUND_COOKIE(404, "NOT FOUND COOKIE", 14006),
    ACCESS_DENIED_REQUEST_API(403, "ACCESS_DENIED_REQUEST_API", 14007),
    ARGUMENT_MISMATCH_BAD_REQUEST(400, "ARGUMENT_MISMATCH_BAD_REQUEST", 14008),
    BLOCK_OR_INACTIVE_USER(403, "차단 또는 탈퇴 회원 입니다.", 14009),
    USER_INACTIVE(403, "User Inactive" , 14010),

    NOT_FOUND_USER(404, "회원을 찾을수 없습니다.", 14011),
    WRONG_PASSWORD(403, "비밀번호가 틀렸습니다.", 14013),
    EXCEL_IO_ERROR(400, "Excel IO Error.", 14019),
    NO_PERMISSIONS(401, "NO_PERMISSIONS", 14020),







    INTERNAL_SERVER_ERROR(500, "Internal Server Error" , 15001),
    DATA_ACCESS_ERROR(500, "Data Access Error", 15002),
    NOT_IMPLEMENTED(501, "NOT IMPLEMENTED", 15003);

    @Getter
    private final int status;


    @Getter
    private final int code;

    @Getter
    private final String message;

    ErrorCode(int status, String message, int code) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
