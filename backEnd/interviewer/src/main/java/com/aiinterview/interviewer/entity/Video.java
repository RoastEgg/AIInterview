package com.aiinterview.interviewer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: lhl
 * @Date: 2019/1/9 11:51
 */
@Entity
@Table(name = "video")
public class Video implements Serializable {
    public static final long serialVersionUID =11;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String filePath;
    @Column
    private Double face;
    @Column
    private Double affinity;
    @Column
    private Double confidence;
    @Column
    private Double stability;
    @Column
    private Double expression;
    @Column
    private Double autognosis;
    @Column
    private Double applyPurpose;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private Interviewee interviewee;

    public Video() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Interviewee getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(Interviewee interviewee) {
        this.interviewee = interviewee;
    }
}
