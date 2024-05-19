package com.example.shoppingmall.member;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    Map<String, Member> memberTable = new HashMap<>();

    public String save(Member member) {
        if(memberTable.get(member.getUserId()) == null){
            memberTable.put(member.getUserId(), member);
        } else {
            return "dup";
        }

        Member savedMember = memberTable.get(member.getUserId());
        return savedMember.getUserId();
    }

    public Member findById(String userId) {
        return memberTable.get(userId);
    }

    public OAuth2ResourceServerProperties.Jwt login(LoginForm loginForm) {
        for(int i = 0; i < memberTable.size() ; i++){
            if(memberTable.get(i).getUserId() == loginForm.getUserId()){
                if(memberTable.get(i).getPw() == loginForm.getPw()){
                    return new OAuth2ResourceServerProperties.Jwt();
                } else{
                    System.out.println("비번 틀림");
                }
            }else {
                System.out.println("잘못된 id");
            }
        }
        return new OAuth2ResourceServerProperties.Jwt();
    }

    public boolean checkId(String id) {
        return memberTable.get(id) != null;
    }
}
