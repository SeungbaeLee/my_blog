package com.example.demo.tag.mapper;

import com.example.demo.tag.dto.TagDto;
import com.example.demo.tag.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    Tag tagPostToTag(TagDto.Post post);

    TagDto.Response tagToTagResponse(Tag tag);
}
