package com.server.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.server.youtube.service.VideoService;

@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class VideoController {

    @Autowired
    private VideoService service;

    // 비디오 전체 목록 보기
    @GetMapping("/video")
    public ResponseEntity viewAll() {
        System.out.println("!!");
        return ResponseEntity.status(HttpStatus.OK).body(service.viewAll());
    }
}
