package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class MemberDto {
    @JsonProperty("user_id")
    @NotBlank (message = "id는 필수입니다.")
    private String userId;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,15}", message = "비밀번호는 영문과 숫자, 특수기호가 적어도 1개 이상씩 포함된 8~15자의 비밀번호여야 합니다.")
    private String pw;

    private String name;

    @Email (message = "이메일 형식이 아닙니다.")
    private String email;
    private String contact;

    public MemberDto() {
    }

    public Member convertToEntity(){
        return new Member(userId, pw, name, email, contact);
    }
}
