package com.sarasoliszambrano.experian.model;

import lombok.Data;

import java.util.Date;

@Data
public class ExperianModel {
    private String companyName;
    private Date registrationDate;
    private Float score;
    private Integer directorsCount;
    private Date lastUpdated;

    public ExperianModel(String companyName, Date registrationDate, Float score, Integer directorsCount, Date lastUpdated) {
        this.companyName = companyName;
        this.registrationDate = registrationDate;
        this.score = score;
        this.directorsCount = directorsCount;
        this.lastUpdated = lastUpdated;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Integer getDirectorsCount() {
        return directorsCount;
    }

    public void setDirectorsCount(Integer directorsCount) {
        this.directorsCount = directorsCount;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
