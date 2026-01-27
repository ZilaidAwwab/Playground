package com.example.readhaven.repository;

import com.example.readhaven.model.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MemberRepositoryImpl implements MemberRepository {

    // Map for quick username lookup
    private Map<String, String> userCredentials;
    private List<Member> memberList;

    public MemberRepositoryImpl() {
        this.userCredentials = new HashMap<>();
        this.memberList = new ArrayList<>();
    }

    @Override
    public boolean usernameExists(String name) {
        for (String username: userCredentials.keySet()) {
            if (name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String registerMember(Member member) {
        // adding user's name and password to the hashmap for quick lookup for login
        this.userCredentials.put(member.getName(), member.getPassword());
        this.memberList.add(member);
        return "User registered successfully";
    }

    @Override
    public String updateMember(Member member) {
        // updating the existing user's object
        IntStream.range(0, memberList.size())
                .filter(i -> memberList.get(i).getId() == member.getId())
                .findFirst()
                .ifPresent(i -> memberList.set(i, member));
        return "User updated successfully";
    }

    @Override
    public String deactivateUser(Member member) {
        memberList.stream()
                .filter(user -> user.getId() == member.getId())
                .findFirst()
                .ifPresent(memberList::remove);
        return "User deleted successfully";
    }
}
