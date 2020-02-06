package com.mail.simu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mail.simu.dao.MyDAO;
import com.mail.simu.dto.MDTO;
import com.mail.simu.dto.UserDTO;

@Component
public class MyServiceInf implements MyService {
@Autowired
MyDAO mdao;

	@Override
	public UserDTO login(UserDTO dto) {
		UserDTO mdto=mdao.login(dto);
	    return mdto;
	}

	@Override
	public boolean register(UserDTO dto) {
		boolean b=mdao.register(dto);
		return b;
	}

	@Override
	public UserDTO composeEmail(String from, String to, String subject, String body) {
		UserDTO dto=mdao.composeEmail(from, to, subject, body);
		return dto;
	}

	@Override
	public List<MDTO> inbox() {
		List<MDTO> list=mdao.inbox();
		return list;
	}

	@Override
	public List<MDTO> sent() {
		List<MDTO> list=mdao.sent();
		return list;
	}

	@Override
	public List<MDTO> draft() {
		List<MDTO> list=mdao.draft();
		return list;
	}
	@Override
	public boolean change(String pass, String newpass) {
		boolean b=mdao.change(pass, newpass);
		return b;
	}

	@Override
	public boolean forget(String umail,String question,String answer,String pass,String cpass) {
		boolean b =mdao.forget(umail, answer, question, pass, cpass);
		return b;
	}

	@Override
	public boolean deletedMail(int id) {
		boolean b=mdao.deletedMail(id);
		return b;
	}

	@Override
	public MDTO mailCompose(int id) {
		MDTO dto=mdao.mailCompose(id);
		return dto;
	}

	@Override
	public List<MDTO> deleteList() {
		List<MDTO> list=mdao.deleteList();
		return list;
	}

	@Override
	public boolean composeDraft(String to, String message, String subject) {
		return mdao.composeDraft(to, message, subject);
	}

}




