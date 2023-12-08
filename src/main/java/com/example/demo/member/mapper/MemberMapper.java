package com.example.demo.member.mapper;

import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostToMember(MemberDto.Post post);

    MemberDto.Response memberToResponse(Member member);
}
