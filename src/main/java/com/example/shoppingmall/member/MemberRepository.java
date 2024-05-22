package com.example.shoppingmall.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemberRepository  {
    Map<String, Member> memberTable = new HashMap<>();

//    @Override
//     public Member save(Member member);
//
//    @Override
//    Optional<Member> findById(Integer integer);


    @Autowired
    EntityManager entityManager;


    public void save(Member member) {
        entityManager.persist(member);
    }

    public Member findById(int id){
        return entityManager.find(Member.class, id);
    }
    public Member findByUserId(String userId) {
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";
//        try {
//            return entityManager.createQuery(jpql, Member.class)
//                    .setParameter("userId", userId).getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
        return entityManager.createQuery(jpql, Member.class)
                    .setParameter("userId", userId).getSingleResult();

    }

    public boolean checkId(String id) {
        return memberTable.get(id) != null;
    }

    public Member login(LoginForm loginForm) {
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId AND m.pw = :pw";
        TypedQuery<Member> query = entityManager.createQuery(jpql, Member.class);
        query.setParameter("userId", loginForm.getUserId());
        query.setParameter("pw", loginForm.getPw());

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}