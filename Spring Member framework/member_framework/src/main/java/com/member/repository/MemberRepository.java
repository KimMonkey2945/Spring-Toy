package com.member.repository;

import com.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sql;

    public int save(MemberDTO memberDTO) {

//        System.out.println("memberDTO : " + memberDTO );
        return sql.insert("Member.save", memberDTO);
        //Member 라는 namespace를 갖는 mapper의 save를 호춣하면서 memberDTO를 넘긴다.
    }

    public MemberDTO login(MemberDTO memberDTO){
        return sql.selectOne("Member.login", memberDTO);
    }

    public List<MemberDTO> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDTO findbyId(Long id) {
        return sql.selectOne("Member.findbyId", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);

    }

    public MemberDTO findByMemberEmail(String loginEmail) {
       return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDTO memberDTO) {
        System.out.println(memberDTO);
        return sql.update("Member.update", memberDTO);
    }

}
