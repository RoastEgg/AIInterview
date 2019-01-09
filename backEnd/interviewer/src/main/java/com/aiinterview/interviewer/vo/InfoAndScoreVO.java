package com.aiinterview.interviewer.vo;

import com.aiinterview.interviewer.entity.Video;

/**
 * @Author: lhl
 * @Date: 2019/1/9 19:11
 */
public class InfoAndScoreVO {
    private String organization;
    private Video video;

    public InfoAndScoreVO() {
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
