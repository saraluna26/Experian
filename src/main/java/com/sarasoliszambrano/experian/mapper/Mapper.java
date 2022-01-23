package com.sarasoliszambrano.experian.mapper;

import com.sarasoliszambrano.experian.dto.ExperianDto;
import com.sarasoliszambrano.experian.model.ExperianModel;

public class Mapper {
    public static ExperianDto fromModelToDto (ExperianModel experianModel){
        return ExperianDto.builder()
                .msg_id(experianModel.getId())
                .company_name(experianModel.getCompanyName())
                .registration_date(experianModel.getRegistrationDate())
                .score(experianModel.getScore())
                .directors_count(experianModel.getDirectorsCount())
                .last_updated(experianModel.getLastUpdated())
                .build();
    }

    public static ExperianModel fromDtoToModel (ExperianDto experianDto){
        return ExperianModel.builder()
                .id(experianDto.getMsg_id())
                .companyName(experianDto.getCompany_name())
                .registrationDate(experianDto.getRegistration_date())
                .score(experianDto.getScore())
                .directorsCount(experianDto.getDirectors_count())
                .lastUpdated(experianDto.getLast_updated())
                .build();
    }
}
