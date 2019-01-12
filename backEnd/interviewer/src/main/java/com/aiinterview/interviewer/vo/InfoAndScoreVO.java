package com.aiinterview.interviewer.vo;

import com.aiinterview.interviewer.entity.Video;


/**
 * @Author: lhl
 * @Date: 2019/1/9 19:11
 */
public class InfoAndScoreVO {
    private String organization;//show where the man from
    //score:
    private String filePath;//show the filePath of current video
    private Double face;//how beautiful or hansome she/he is
    private Double affinity;//a strong feeling that you like and understand someone
    private Double confidence;
    private Double stability;//stability of emotion
    private Double expression;//ability of expression
    private Double autognosis;//whether know yourself
    private Double applyPurpose;//the reason for applying for this job

    public InfoAndScoreVO() {
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Double getFace() {
        return face;
    }

    public void setFace(Double face) {
        this.face = face;
    }

    public Double getAffinity() {
        return affinity;
    }

    public void setAffinity(Double affinity) {
        this.affinity = affinity;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Double getStability() {
        return stability;
    }

    public void setStability(Double stability) {
        this.stability = stability;
    }

    public Double getExpression() {
        return expression;
    }

    public void setExpression(Double expression) {
        this.expression = expression;
    }

    public Double getAutognosis() {
        return autognosis;
    }

    public void setAutognosis(Double autognosis) {
        this.autognosis = autognosis;
    }

    public Double getApplyPurpose() {
        return applyPurpose;
    }

    public void setApplyPurpose(Double applyPurpose) {
        this.applyPurpose = applyPurpose;
    }
}
