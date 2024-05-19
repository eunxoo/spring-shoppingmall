package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MemberService {
    private MemberRepository memberRepository;
    public String join(Member member) {
        return memberRepository.save(member);
    }

    public OAuth2ResourceServerProperties.Jwt login(LoginForm loginForm) {
        return memberRepository.login(loginForm);
    }

    public boolean checkId(String id) {
        return memberRepository.checkId(id);
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember = memberRepository.findById(userId);
        if(existMember == null)
            return false;
        else
            return true;
    }
}
