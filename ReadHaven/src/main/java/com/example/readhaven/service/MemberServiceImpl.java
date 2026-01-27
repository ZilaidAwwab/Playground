package com.example.readhaven.service;

import com.example.readhaven.model.Member;
import com.example.readhaven.repository.MemberRepository;
import com.example.readhaven.repository.MemberRepositoryImpl;

public class MemberServiceImpl implements MemberService {

    // DI
    private MemberRepository memberRepo;

    public MemberServiceImpl() {
        this.memberRepo = new MemberRepositoryImpl();
    }

    @Override
    public String register(Member member) {
        if (memberRepo.usernameExists(member.getName())) {
            // return the exception
            return "Username already exist, try with a different username";
        }
        String response = memberRepo.registerMember(member);
        return response;
    }

    @Override
    public String update(Member member) {
        if (memberRepo.usernameExists(member.getName())) {
            // return the exception
            return "Username doesn't exist";
        }
        String response = memberRepo.updateMember(member);
        return response;
    }

    @Override
    public String deactivateMember(Member member) {
        if (memberRepo.usernameExists(member.getName())) {
            String response = memberRepo.deactivateUser(member);
            return response;
        }
        return "Username does not exist";
    }
}
