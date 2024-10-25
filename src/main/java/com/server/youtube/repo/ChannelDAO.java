package com.server.youtube.repo;

import com.server.youtube.domain.Channel;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChannelDAO extends JpaRepository<Channel, Integer> {
}
