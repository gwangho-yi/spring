package com.example.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
// DB와 접속하는 구현체 역할을 한다.
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
