package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class MemberDto {
    @JsonProperty("user_id")
    @NotBlank (message = "id는 필수입니다.")
    private String userId;

    @NotBlank (message = "비밀번호는 필수입니다.")
    @Size(min = 8, message = "최소 8자리 이상 입력해주세요.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,15}", message = "비밀번호는 영문과 숫자, 특수기호가 적어도 1개 이상씩 포함된 8~15자의 비밀번호여야 합니다.")
    private String pw;

    @NotBlank (message = "이름은 필수입니다.")
    private String name;

    @NotBlank (message = "email은 필수입니다.")
    @Email (message = "이메일 형식이 아닙니다.")
    private String email;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "올바른 연락처 형식이 아닙니다. ex. 010-0000-0000")
    @NotBlank (message = "연락처는 필수입니다.")
    private String contact;

    public Member convertToEntity(){
        return new Member(userId, pw, name, email, contact);
    }
}
