package com.example.readhaven.repository;

import com.example.readhaven.model.Member;

public interface MemberRepository {
    boolean usernameExists(String name);
    String registerMember(Member member);
    String updateMember(Member member);
    String deactivateUser(Member member);
}
