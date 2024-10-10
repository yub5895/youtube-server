package com.server.youtube.controller;

import com.server.youtube.domain.Comment;
import com.server.youtube.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/*")
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class CommentController {

    @Autowired
    private CommentService service;

    // 댓글 추가
    @PostMapping("/private/comment")
    public ResponseEntity add(@RequestBody Comment vo) {
        return ResponseEntity.ok(service.create(vo));
    }
}
