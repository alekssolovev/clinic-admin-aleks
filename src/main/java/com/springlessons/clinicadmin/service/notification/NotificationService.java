package com.springlessons.clinicadmin.service.notification;

import com.springlessons.clinicadmin.repository.PatientRepository;
import com.springlessons.clinicadmin.service.PatientService;
import jakarta.mail.MessagingException;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * Сервис, отвечающий за рассылку email пользователям,
 * при добавлении нового врача.
 * Расылка реализуется в отдельном потоке
 * */
@Service
public class NotificationService  {
    private final JavaMailSender javaMailSender;
    private PatientService patientService;

    public NotificationService(PatientService patientService, JavaMailSender javaMailSender) {
        this.patientService=patientService;
        this.javaMailSender = javaMailSender;
    }

    @Async(value = "patient-executor")
    public void send() throws MessagingException {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("admin@yandex.ru");
        mailMessage.setTo(String.valueOf(patientService.findAllEmail()));
        mailMessage.setSubject("Новый доктор ");
        mailMessage.setText("Появился новый доктор");
        javaMailSender.send(mailMessage);

    }
}
