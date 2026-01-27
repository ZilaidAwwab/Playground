package com.example.readhaven.service;

import com.example.readhaven.model.Member;

public interface MemberService {
    String register(Member member);
    String update(Member member);
    String deactivateMember(Member member);
}
