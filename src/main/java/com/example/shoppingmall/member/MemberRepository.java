package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberRepository {
    Map<String, Member> memberTable = new HashMap<>();

    @Autowired
    DataSource dataSource;

    @Autowired
    EntityManager entityManager;

    public void makeConnection(){
        DataSourceUtils.getConnection(dataSource);
    }

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

    public boolean checkId(String id) {
        return memberTable.get(id) != null;
    }
}
