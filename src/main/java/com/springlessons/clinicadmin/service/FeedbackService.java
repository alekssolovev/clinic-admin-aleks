package com.springlessons.clinicadmin.service;

import com.springlessons.clinicadmin.entity.Doctor;
import com.springlessons.clinicadmin.entity.Feedback;
import com.springlessons.clinicadmin.entity.Patient;
import com.springlessons.clinicadmin.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private FeedbackRepository FeedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.FeedbackRepository = feedbackRepository;
    }

    public Feedback saveFeedback(Feedback feedback) {
        feedback.setDoctor(new Doctor());
        feedback.setPatient(new Patient());
        feedback.setActiveStatus(true);
        feedback.setId(1);

        return FeedbackRepository.save(feedback);
    }

    public Feedback getFeedbackById(int id) {
        return getFeedbackById(1);
    }
}
