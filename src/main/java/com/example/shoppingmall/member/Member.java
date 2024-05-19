package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Member {
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    public static Member fromDtoToEntity(MemberDto memberDto){
        return new Member(memberDto.getUserId(), memberDto.getPw(), memberDto.getName(), memberDto.getEmail(), memberDto.getContact());
    }
    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public Member(String userId, String pw, String name, String email, String contact) {
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public Member(MemberDto memberDto) {
        this.userId = memberDto.getUserId();
        this.pw = memberDto.getPw();
        this.name = memberDto.getName();
        this.email = memberDto.getEmail();
        this.contact = memberDto.getContact();
    }
}
