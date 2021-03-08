package com.pturo.lonerwolf.controller;

import com.pturo.lonerwolf.dto.SubwolfDto;
import com.pturo.lonerwolf.service.SubwolfService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subwolf")
@AllArgsConstructor
@Slf4j
public class SubwolfController {
    private final SubwolfService subwolfService;

    @PostMapping
    public ResponseEntity<SubwolfDto> createSubwolf(@RequestBody SubwolfDto subwolfDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subwolfService.save(subwolfDto));
    }

    @GetMapping
    public ResponseEntity<List<SubwolfDto>> getAllSubwolves() {
        return ResponseEntity.status(HttpStatus.OK).body(subwolfService.getAll());
    }
}
