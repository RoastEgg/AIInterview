package com.aiinterview.interviewer.controller;

import com.aiinterview.interviewer.service.ScoreService;
import com.aiinterview.interviewer.util.CookieInfo;
import com.aiinterview.interviewer.vo.InfoAndScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * @Author: lhl
 * @Date: 2019/1/9 19:15
 */

@RestController
@RequestMapping("/interviewee")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping(value = "/getInterviewees")
    public ArrayList<String> getInterviewees(HttpServletRequest httpServletRequest) {
        return scoreService.getInterviewees();
    }

    @PostMapping(value = "/getDescAndScore")
    public InfoAndScoreVO getDescAndScore(HttpServletRequest httpServletRequest,String name) {
        return scoreService.getDescAndScore(name);
    }
}
