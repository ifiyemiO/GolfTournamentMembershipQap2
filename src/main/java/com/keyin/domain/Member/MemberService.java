package com.keyin.domain.Member;

import com.keyin.domain.Member.Member;
import com.keyin.domain.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    /**
     * Add a new member.
     * @param member The member to be added.
     * @return The saved member.
     */
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    /**
     * Retrieve all members.
     * @return A list of all members.
     */
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    /**
     * Retrieve a member by ID.
     * @param id The ID of the member.
     * @return An Optional containing the member if found, or empty if not.
     */
    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    /**
     * Search members by name.
     * @param name The name to search for.
     * @return A list of members with the matching name.
     */
    public List<Member> searchMembersByName(String name) {
        return memberRepository.findMemberByMemberName(name);
    }

    /**
     * Search members by phone number.
     * @param phoneNumber The phone number to search for.
     * @return A list of members with the matching phone number.
     */
    public List<Member> searchMembersByPhoneNumber(String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    /**
     * Delete a member by ID.
     * @param id The ID of the member to delete.
     */
    public void deleteMemberById(Long id) {
        if (memberRepository.existsById(id)) {
            memberRepository.deleteById(id);
        } else {
            throw new RuntimeException("Member not found with ID: " + id);
        }
    }
}
