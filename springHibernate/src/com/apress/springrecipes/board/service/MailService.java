package com.apress.springrecipes.board.service;

import com.apress.springrecipes.board.domain.EmpRegistrationForm;
import com.apress.springrecipes.board.domain.LeaveApplyForm;

public interface MailService {
	public boolean sendMail(LeaveApplyForm leaveApplyForm,EmpRegistrationForm empRegistrationForm);
}
