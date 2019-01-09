package com.aiinterview.interviewer.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: lhl
 * @Date: 2019/1/9 11:51
 */
@Entity
@Table(name = "interviewee")
public class Interviewee implements Serializable{
    public static final long serialVersionUID =10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String organization;

    @Column
    private String description;

    public Interviewee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
