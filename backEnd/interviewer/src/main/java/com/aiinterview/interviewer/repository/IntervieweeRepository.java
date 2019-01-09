package com.aiinterview.interviewer.repository;

import com.aiinterview.interviewer.entity.Interviewee;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: lhl
 * @Date: 2019/1/9 19:07
 */

public interface IntervieweeRepository extends CrudRepository<Interviewee, Long> {
    Interviewee findByName(String name);

}
