package com.pturo.lonerwolf.mapper;

import com.pturo.lonerwolf.dto.SubwolfDto;
import com.pturo.lonerwolf.model.Post;
import com.pturo.lonerwolf.model.Subwolf;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubwolfMapper {
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subwolf.getPosts()))")
    SubwolfDto mapSubwolfToDto(Subwolf subwolf);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subwolf mapDtoToSubwolf(SubwolfDto subwolfDto);
}
