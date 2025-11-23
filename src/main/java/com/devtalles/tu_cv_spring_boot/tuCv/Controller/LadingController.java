package com.devtalles.tu_cv_spring_boot.tuCv.Controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devtalles.tu_cv_spring_boot.tuCv.Model.CvData;
import com.devtalles.tu_cv_spring_boot.tuCv.Services.CvInitializationServices;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
public class LadingController {
    private final  CvInitializationServices cvInitializationServices;

    @GetMapping("/cv-form")
    public String showFormCvString( Model model) {
        CvData cvData = cvInitializationServices.initializaeCvData();

        model.addAttribute("cvData", cvData);

        return "cv-form";
    }
    
    @PostMapping("/generate-cv")
    public String generateCv( @ModelAttribute CvData cvData, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("cvData", cvData);
        
        return "redirect:cv-display";
    }
    
    @GetMapping("/cv-display")
    public String cvDisplay(  @ModelAttribute("cvData") CvData cvData, Model model ) {
        if( cvData.getPersonDetails() == null ){
            cvData = cvInitializationServices.initializaeCvData();
        }
        model.addAttribute("cvData", cvData);
        return "index";
    }
    
}



