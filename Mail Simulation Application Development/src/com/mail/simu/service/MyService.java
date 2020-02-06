package com.mail.simu.service;

import java.util.List;

import com.mail.simu.dto.MDTO;
import com.mail.simu.dto.UserDTO;

public interface MyService {

	public UserDTO login(UserDTO dto);

	boolean register(UserDTO dto);

	public UserDTO composeEmail(String from, String to, String subject, String body);

	public List<MDTO> inbox();

	public List<MDTO> sent();
	
	public List<MDTO> draft();

	boolean change(String pass, String newpass);

	public boolean forget(String umail,String question,String answer,String pass,String cpass);

	public boolean deletedMail(int id);
	
	public MDTO mailCompose(int id);
	
	public boolean composeDraft(String to, String message, String subject);

	public List<MDTO> deleteList();


}
