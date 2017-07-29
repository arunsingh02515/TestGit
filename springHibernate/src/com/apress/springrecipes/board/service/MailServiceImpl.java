package com.apress.springrecipes.board.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.apress.springrecipes.board.domain.EmpRegistrationForm;
import com.apress.springrecipes.board.domain.LeaveApplyForm;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;
    
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }       
    public boolean sendMail(LeaveApplyForm leaveApplyForm,EmpRegistrationForm empRegistrationForm)
    {
        SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);

        //EmpRegistrationForm empRegistrationForm=new EmpRegistrationForm();
        String to=leaveApplyForm.getFirstApprover();

    //  String to1=leaveApplyForm.getFinalApprover();
        String text=leaveApplyForm.getReason();         
        String from=empRegistrationForm.getEmail();
        String subject="Application for the Leave";

        message.setFrom(from);          
                message.setTo(to);          
                message.setSubject(subject);            
                message.setText(text);          
                mailSender.send(message);           

    return true;    

    }
}
