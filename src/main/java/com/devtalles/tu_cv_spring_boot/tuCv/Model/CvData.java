package com.devtalles.tu_cv_spring_boot.tuCv.Model;

import java.util.List;

import lombok.Data;

@Data
public class CvData {

    private PersonalDetailsServices personDetails;
    private List<Education> educations;
    private List<Experience> experiences;
    private List<Skill> skills;
}
