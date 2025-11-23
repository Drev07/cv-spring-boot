package com.devtalles.tu_cv_spring_boot.tuCv.Services;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devtalles.tu_cv_spring_boot.tuCv.Model.CvData;
import com.devtalles.tu_cv_spring_boot.tuCv.Model.Education;
import com.devtalles.tu_cv_spring_boot.tuCv.Model.Experience;
import com.devtalles.tu_cv_spring_boot.tuCv.Model.PersonalDetailsServices;
import com.devtalles.tu_cv_spring_boot.tuCv.Model.Skill;

@Service
public class CvInitializeServicesImpl implements CvInitializationServices{

    @Override
    public CvData initializaeCvData() {
       CvData cvData = new CvData();

       //DATAOS PERSONALES
       PersonalDetailsServices perosnalDetails = new PersonalDetailsServices();
       perosnalDetails.setFirstName("Andrew");
       perosnalDetails.setLastName("Salazar");
       perosnalDetails.setEmail("andrewsalazar629@gmail.com");
       perosnalDetails.setAddres("Gautemala, Guatemala");
       perosnalDetails.setProfessionalProfile("Desrrollador Backend");

       cvData.setPersonDetails(perosnalDetails);

       //Education
       Education education1 = new Education();

       education1.setInstitution("CENSE");
       education1.setDescription("Description...");
       education1.setDagree("Bachiler en ciencias y letras ");
       education1.setPeriod("2018 - 2020");

       cvData.setEducations(Collections.singletonList(education1));
       //Expereincia

       Experience experience1 = new Experience();
       experience1.setJobTitle("Analista programador");
       experience1.setCompany("Soluciones Un");
       experience1.setPeriod("2023 - present");

       cvData.setExperiences(List.of(experience1));



       //Skill\
       Skill skill = new Skill();

       skill.setName("Java");
       skill.setLevel("medium");
       Skill skill2 = new Skill();

       skill2.setName("Spring-boot");
       skill2.setLevel("medium");

       cvData.setSkills(Arrays.asList(skill, skill2));

        return cvData;
    }

}
