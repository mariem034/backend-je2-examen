package com.example.backend_gym.services;
import org.springframework.stereotype.Service;
import com.example.backend_gym.repositories.MemberRepositories;
import com.example.backend_gym.models.Member;



@Service
public class MemberService {
 
    final MemberRepositories memberRepositories;

    public MemberService(MemberRepositories memberRepositories) {
        this.memberRepositories = memberRepositories;
    }

    // add a member
    public Member addMember(Member member) {
        return memberRepositories.save(member);
    }

    // get a member by id
    public Member getMemberById(Long id) {
        return memberRepositories.findById(id).orElse(null);
    }

    // update a member
    public Member updateMember(Long id, Member updatedMember) {
        return memberRepositories.findById(id)
                .map(member -> {
                    member.setEmail(updatedMember.getEmail());
                    member.setPhoneNumber(updatedMember.getPhoneNumber());
                    member.setBirthDate(updatedMember.getBirthDate());
                    member.setMembershipStatus(updatedMember.getMembershipStatus());
                    member.setSubscription(updatedMember.getSubscription());
                    return memberRepositories.save(member);
                })
                .orElse(null);
    }

    // delete a member
    public void deleteMember(Long id) {
        memberRepositories.deleteById(id);
    }
    
}
