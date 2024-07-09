package com.springlessons.clinicadmin.service.notification;

import com.springlessons.clinicadmin.service.PatientService;
import org.springframework.mail.javamail.JavaMailSender;

public class NotificationServiceBuilder {
    private PatientService patientService;
    private JavaMailSender javaMailSender;

    public NotificationServiceBuilder setPatientService(PatientService patientService) {
        this.patientService = patientService;
        return this;
    }

    public NotificationServiceBuilder setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
        return this;
    }

    public NotificationService createNotificationService() {
        return new NotificationService( javaMailSender);
    }
}