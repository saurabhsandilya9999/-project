package com.mail.simu.dao;

import java.util.List;

import com.mail.simu.dto.MDTO;
import com.mail.simu.dto.UserDTO;

public interface MyDAO {

	boolean register(UserDTO dto);

	public UserDTO login(UserDTO dto);

	UserDTO composeEmail(String from, String to, String subject, String body);

	public List<MDTO> inbox();

	public List<MDTO> sent();

	public List<MDTO> draft();

	boolean change(String pass, String newpass);

	public boolean forget(String umail,String question,String answer,String pass,String cpass);

	public boolean deletedMail(int id);
	
	public MDTO mailCompose(int id);

	public List<MDTO> deleteList();
	
	public boolean composeDraft(String to, String message, String subject);

}
