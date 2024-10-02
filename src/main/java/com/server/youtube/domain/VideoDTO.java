package com.server.youtube.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Builder @NoArgsConstructor @AllArgsConstructor
@Data
public class VideoDTO {

    private MultipartFile videoFile;
    private MultipartFile imageFile;
    private String videoTitle;
    private String videoDesc;
    private int channelCode;
}
