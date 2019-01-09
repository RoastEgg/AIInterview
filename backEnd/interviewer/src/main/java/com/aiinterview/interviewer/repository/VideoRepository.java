package com.aiinterview.interviewer.repository;

import com.aiinterview.interviewer.entity.Interviewee;
import com.aiinterview.interviewer.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: lhl
 * @Date: 2019/1/9 19:04
 */


public interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByinterviewee(Interviewee interviewee);
}
