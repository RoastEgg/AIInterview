package com.aiinterview.interviewer.service;

import com.aiinterview.interviewer.entity.Interviewee;
import com.aiinterview.interviewer.entity.Video;
import com.aiinterview.interviewer.repository.IntervieweeRepository;
import com.aiinterview.interviewer.repository.VideoRepository;
import com.aiinterview.interviewer.vo.InfoAndScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: lhl
 * @Date: 2019/1/9 19:09
 */

@Service
public class ScoreService {

    @Autowired
    private IntervieweeRepository intervieweeRepo;
    @Autowired
    private VideoRepository videoRepo;


    public ArrayList<String> getInterviewees() {
        Iterable iterable = intervieweeRepo.findAll();
        Iterator iter = iterable.iterator();

        ArrayList<String> nameList = new ArrayList<String>();

        while (iter.hasNext()) {
            Interviewee interviewee = (Interviewee) iter.next();
            String name = interviewee.getName();
            nameList.add(name);
        }
        if (nameList.size() == 0) {
            System.out.println("get nothing from db");
        } else {
            System.out.println("name: " + nameList.get(0));
        }

        return nameList;
    }

    public InfoAndScoreVO getDescAndScore(String name) {
        InfoAndScoreVO vo = new InfoAndScoreVO();
        Interviewee interviewee = intervieweeRepo.findByName(name);

        Video video = videoRepo.findByinterviewee(interviewee);
        vo.setOrganization(interviewee.getOrganization());
        vo.setVideo(video);
        return vo;
    }
}
