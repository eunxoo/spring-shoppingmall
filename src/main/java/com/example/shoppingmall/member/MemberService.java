package com.example.shoppingmall.member;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class MemberService {
    private MemberRepository memberRepository;
    private MemberJpaRepository memberJPARepository;
    @Transactional
    public String join(Member member) {
//        memberRepository.save(member);
//        return memberRepository.findByUserId(member.getUserId()).getUserId();
        memberJPARepository.save(member);
        return memberJPARepository.findByUserId(member.getUserId())
                .map(Member::getUserId)
                .orElseThrow(() -> new RuntimeException("Member not found userId" + member.getUserId()));
    }


    public boolean checkId(String id) {
        return memberRepository.checkId(id);
    }

    public boolean checkDuplicateId(String userId) {
//        Member existMember = memberRepository.findByUserId(userId);
//        if (existMember == null)
//            return false;
//        else
//            return true;
        return memberJPARepository.findByUserId(userId).isPresent();
    }

    public Member login(LoginForm loginForm) {
       return memberRepository.login(loginForm);
    }
}
