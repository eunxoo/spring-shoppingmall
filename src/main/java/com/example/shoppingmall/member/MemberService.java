package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class MemberService {
    private MemberRepository memberRepository;
    @Transactional
    public String join(Member member) {
        memberRepository.save(member);
        return memberRepository.findByUserId(member.getUserId()).getUserId();
    }


    public boolean checkId(String id) {
        return memberRepository.checkId(id);
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember = memberRepository.findByUserId(userId);
        if(existMember == null)
            return false;
        else
            return true;
    }

    public Member login(LoginForm loginForm) {
       return memberRepository.login(loginForm);
    }
}
