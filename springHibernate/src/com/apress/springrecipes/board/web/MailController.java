package com.apress.springrecipes.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apress.springrecipes.board.domain.EmpRegistrationForm;
import com.apress.springrecipes.board.domain.LeaveApplyForm;
import com.apress.springrecipes.board.service.MailService;

@Controller
@RequestMapping("/emailsending")
public class MailController {
    @Autowired
	private MailService mailService;
    @RequestMapping(method = RequestMethod.GET)
	public void sendMail(){
		System.out.println("service Hit");
		LeaveApplyForm leaveApplyForm= new LeaveApplyForm();
		leaveApplyForm.setFirstApprover("arunksingh229@gmail.com");
		leaveApplyForm.setReason("Holiday");
		EmpRegistrationForm empRegistrationForm= new EmpRegistrationForm();
		empRegistrationForm.setEmail("arunksingh015@gmail.com");
		boolean status=mailService.sendMail(leaveApplyForm, empRegistrationForm);
		System.out.println("message status "+status);
	}
}
