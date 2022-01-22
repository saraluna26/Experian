package com.sarasoliszambrano.experian.dto;

import com.sarasoliszambrano.experian.model.ExperianModel;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ExperianDto {
    private Integer id;
    private String companyName;
    private Date registrationDate;
    private Float score;
    private Integer directorsCount;
    private Date lastUpdated;

    public static ExperianDto from (ExperianModel experianModel){
        return ExperianDto.builder()
                .id(experianModel.getId())
                .companyName(experianModel.getCompanyName())
                .registrationDate(experianModel.getRegistrationDate())
                .score(experianModel.getScore())
                .directorsCount(experianModel.getDirectorsCount())
                .lastUpdated(experianModel.getLastUpdated())
                .build();
    }
}