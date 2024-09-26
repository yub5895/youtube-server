package com.server.youtube.repo;

import com.server.youtube.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoDAO extends JpaRepository<Video, Integer> {
}
