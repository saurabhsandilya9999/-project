package com.mail.simu.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mail.simu.dto.MDTO;
import com.mail.simu.dto.UserDTO;
@Component
public class MyDaoInf implements MyDAO{
	
	@Autowired
	SessionFactory sf;
	@Autowired
	HttpSession hs;

	@Override
	public boolean register(UserDTO udto) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("umail", udto.getUmail()));
		UserDTO mdto=(UserDTO) cr.uniqueResult();
		System.out.println("mdto"+mdto);
		if(mdto==null){
			ss.save(udto);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else{
			ss.close();
			return false;
		}
		
	}
    @Override
	public UserDTO login(UserDTO dto) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(UserDTO.class);
			cr.add(Restrictions.eq("umail", dto.getUmail()));
			cr.add(Restrictions.eq("password", dto.getPassword()));
			UserDTO mdto=(UserDTO) cr.uniqueResult();
			ss.close();
			return mdto;
	}
        @Override
    	public UserDTO composeEmail(String from, String to, String subject, String body) {
    		Session ss=sf.openSession();
    		Criteria cr=ss.createCriteria(UserDTO.class);
		
    		cr.add(Restrictions.eq("umail", from));
		 
    		UserDTO dto=(UserDTO) cr.uniqueResult();
    		cr=ss.createCriteria(UserDTO.class);
    		cr.add(Restrictions.eq("umail", to));
    		UserDTO udto=(UserDTO) cr.uniqueResult();
    		List<MDTO> list;
    		
    		if(udto!=null) {
    		MDTO md=new MDTO();
    		md.setFrommail(from);
    		md.setTomail(to);     
    		md.setSubject(subject);
    		md.setMessage(body);
    		md.setStatus("MailSent");
    		list=dto.getMlist();
    		
    		list.add(md);
    		dto.setMlist(list);
    		ss.save(dto);
    		ss.beginTransaction().commit();
    		ss.close();
    		return dto;
    		}
    		else {
    			MDTO md=new MDTO();
    			md.setFrommail(from);
    			md.setSubject(subject);
    			md.setTomail(to);
    			md.setMessage(body);
    			md.setStatus("DraftMail");
    			list=dto.getMlist();
    			list.add(md);
    			dto.setMlist(list);
    			ss.save(dto);
    			ss.beginTransaction().commit();
    			ss.close();
    			return null;
    		}
    }
		@Override
		public List<MDTO> inbox() {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(MDTO.class);
			String umail=(String) hs.getAttribute("umail");
			cr.add(Restrictions.eq("tomail",umail));
			cr.add(Restrictions.eq("status", "MailSent"));                        
			List<MDTO> mlist=cr.list();
			return mlist;
		}
		@Override
		public List<MDTO> sent() {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(MDTO.class);
			String umail=(String) hs.getAttribute("umail");
			cr.add(Restrictions.eq("frommail",umail));
		//	cr.add(Restrictions.eq("status", "MailSent"));
			List<MDTO> mlist=cr.list();
			return mlist;
			}
		@Override
		public List<MDTO> draft() {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(MDTO.class);
			String umail=(String) hs.getAttribute("umail");
			cr.add(Restrictions.eq("frommail",umail));
			cr.add(Restrictions.eq("status", "DraftMail"));
			List<MDTO> mlist=cr.list();
			return mlist;
		}
		@Override
		public boolean change(String pass, String newpass) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(UserDTO.class);
			String umail=(String) hs.getAttribute("umail");
			cr.add(Restrictions.eq("umail", umail));
			UserDTO dto=(UserDTO) cr.uniqueResult();
			if(dto!=null) {
				if(pass.equals(pass)) {
					dto.setPassword(newpass);
					ss.saveOrUpdate(dto);
					ss.beginTransaction().commit();
					ss.close();
				return true;
				}else {
					ss.close();
					return false;
				}
			}else {
				ss.close();
				return false;
			}
			
		}
		@Override
		public boolean forget(String umail, String question, String answer,String pass,String cpass ) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(UserDTO.class);
			cr.add(Restrictions.eq("question", answer));
			cr.add(Restrictions.eq("answer", question));
			cr.add(Restrictions.eq("umail", umail));
			UserDTO udto=(UserDTO) cr.uniqueResult();
			if(udto!=null) {
				System.out.println("outer");
				if(pass.equals(cpass)) {
					udto.setPassword(cpass);
					ss.saveOrUpdate(udto);
					ss.beginTransaction().commit();
					ss.close();
				return true;
				}else {
					ss.close();
					return false;
				}
			}else {
			ss.close();
			return false;		
		}
		}
		@Override
		public boolean deletedMail(int id) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(MDTO.class);
			cr.add(Restrictions.eq("mid", id));
			MDTO m=(MDTO) cr.uniqueResult();
			m.setStatus("deletedMail");
			ss.save(m);
			ss.beginTransaction().commit();
			ss.close();
			return true;
	}
		
		@Override
		public List<MDTO> deleteList(){
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(MDTO.class);
			String umail=(String) hs.getAttribute("umail");
			cr.add(Restrictions.eq("frommail",umail));
		    cr.add(Restrictions.eq("status", "deletedMail"));
			List<MDTO> mlist=cr.list();
			
//			String umail=(String) hs.getAttribute("umail");
//			Query qry=ss.createQuery("from MDTO where frommail=? and status=? and tomail=? and status=?");
//			qry.setParameter(0,new String(umail) );
//			qry.setParameter(1, new String("deletedMail"));
//			qry.setParameter(2,new String(umail ));
//			qry.setParameter(3, new String("deletedMail"));
//			List<MDTO> mlist=qry.list();
			return mlist;
		}	
     	@Override
		public MDTO mailCompose(int id) {
			Session ss=sf.openSession();
			Criteria cr=ss.createCriteria(MDTO.class);
			cr.add(Restrictions.eq("mid", id));
			MDTO dto=(MDTO) cr.uniqueResult();
			return dto;
		}
		@Override
		public boolean composeDraft(String to, String message, String subject) {
			Session ss=sf.openSession();
    		Criteria cr=ss.createCriteria(UserDTO.class);
    		cr.add(Restrictions.eq("umail", to));
    		UserDTO udto=(UserDTO) cr.uniqueResult();
    		List<MDTO> list;
    		
    		if(udto!=null) {
    			Criteria crr = ss.createCriteria(MDTO.class);
    			int id=(int) hs.getAttribute("mid");
    			crr.add(Restrictions.eq("mid", id));
    			MDTO edto = (MDTO) crr.uniqueResult();
    		edto.setTomail(to);
    		edto.setSubject(subject);
    		edto.setMessage(message);
    		edto.setStatus("MailSent");
 
    		ss.save(edto);
    		ss.beginTransaction().commit();
    		ss.close();
    		return true;
    		}
    		else {
    			Criteria crr = ss.createCriteria(MDTO.class);
    			int id=(int) hs.getAttribute("mid");
    			crr.add(Restrictions.eq("mid", id));
    			MDTO edto = (MDTO) crr.uniqueResult();
    		edto.setTomail(to);
    		edto.setSubject(subject);
    		edto.setMessage(message);
    		edto.setStatus("DraftMail");
 
    		ss.save(edto);
    		ss.beginTransaction().commit();
    		ss.close();
    		return true;
    		}
		}
	
}