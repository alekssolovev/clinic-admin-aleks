package com.springlessons.clinicadmin.controller;

import com.springlessons.clinicadmin.entity.Feedback;
import com.springlessons.clinicadmin.repository.FeedbackRepository;
import com.springlessons.clinicadmin.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FeedbackController {
        private  FeedbackService feedbackService;

    private FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Secured("ROLE_MODERATOR")
    @GetMapping
    public String getFeedback(Model model) {
       Feedback feedback = feedbackService.getFeedbackById(1);
       model.addAttribute("feedback", feedback);
       return "feedback";

    }

    @Secured("ROLE_MODERATOR")
    @PostMapping("/feedback/feedback")
    public void setFeedbackStatusById(Feedback feedback) {
        Feedback feedbackSetStatus= feedbackService.getFeedbackById(1);
        feedbackSetStatus.setActiveStatus(false);
    }


}
