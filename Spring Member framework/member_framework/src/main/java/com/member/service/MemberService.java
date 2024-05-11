package com.member.service;

import com.member.dto.MemberDTO;
import com.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO) {
        return memberRepository.save(memberDTO); // repository에 값을 넘겨주는 중간다리 역할
    }

    public boolean login(MemberDTO memberDTO) {
        MemberDTO loginMember = memberRepository.login(memberDTO);
        if(loginMember != null){
            return true;
        } else {
            return false;
        }
    }

    public List<MemberDTO> findAll() {
         return memberRepository.findAll();
    }

    public MemberDTO findbyId(Long id) {
        return memberRepository.findbyId(id);
    }

    public void delete(Long id) {
        memberRepository.delete(id);
    }

    public MemberDTO findByMemberEmail(String loginEmail) {
        return memberRepository.findByMemberEmail(loginEmail);
    }

    public boolean update(MemberDTO memberDTO) {
        int result = memberRepository.update(memberDTO);

        if(result > 0){
            return true;
        } else {
            return false;
        }
    }

    public String emailCheck(String memberEmail) {
        MemberDTO memberDTO = memberRepository.findByMemberEmail(memberEmail);
        if(memberDTO == null){
            return "ok";
        } else {
            return "no";
        }
    }
}
