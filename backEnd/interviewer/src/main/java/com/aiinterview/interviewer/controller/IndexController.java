package com.aiinterview.interviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: lhl
 * @Date: 2019/1/18 12:41
 */

@Controller
@RequestMapping("/interviewee")

public class IndexController {

    @RequestMapping(value = "/")
    public String getIndex(){
        System.out.println("index controller");
        return "index.html";
    }
}
