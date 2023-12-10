package com.example.demo.member.service;

import com.example.demo.global.exception.BusinessException;
import com.example.demo.global.exception.ExceptionCode;
import com.example.demo.member.entity.Member;
import com.example.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member createMember(Member member) {

        //Email 중복 검사
        Boolean newEmail = checkEmail(member.getEmail());
        if (!newEmail) {
            throw new BusinessException(ExceptionCode.EMAIL_EXISTS);
        }
        //비밀번호 암호화
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        //객체 생성
        Member newMember = Member.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(encryptedPassword)
                .build();
        //ORM을 사용해 생성된 객체 DB에 저장
        return memberRepository.save(newMember);
    }

    //Email 중복 검사
    private Boolean checkEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        return optionalMember.isEmpty();
    }


}
