package com.pturo.lonerwolf.service;

import com.pturo.lonerwolf.dto.SubwolfDto;
import com.pturo.lonerwolf.mapper.SubwolfMapper;
import com.pturo.lonerwolf.model.Subwolf;
import com.pturo.lonerwolf.repository.SubwolfRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SubwolfService {
    private final SubwolfRepository subwolfRepository;
    private final SubwolfMapper subwolfMapper;

    @Transactional
    public SubwolfDto save(SubwolfDto subwolfDto) {
        Subwolf save = subwolfRepository.save(subwolfMapper.mapDtoToSubwolf(subwolfDto));
        subwolfDto.setId(save.getId());
        return subwolfDto;
    }

    @Transactional
    public List<SubwolfDto> getAll() {
        return subwolfRepository.findAll()
                .stream()
                .map(subwolfMapper::mapSubwolfToDto)
                .collect(Collectors.toList());
    }
}
