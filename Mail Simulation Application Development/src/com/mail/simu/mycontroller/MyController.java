package com.mail.simu.mycontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mail.simu.dto.MDTO;
import com.mail.simu.dto.UserDTO;
import com.mail.simu.service.MyService;

@Component
@RequestMapping("/")
public class MyController {
	@Autowired
	MyService ms;
	
	@Autowired
	HttpSession hs;
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	@RequestMapping("/logoutmail")
	public ModelAndView logout(HttpSession ss){
		if (hs.getAttribute("umail")!=null) {
			hs.setAttribute("umail", null);
		
			return new ModelAndView("login","msg","Logout");
	}else {
			return new ModelAndView("login","msg","Please Login");
		}
	}
	@RequestMapping("/registration")
	public String registration(){
		return "registration";
	}
	@RequestMapping("/home")
	public String home(){
		return "home";
	}
	@RequestMapping("/compose")
	public ModelAndView compose() {
	  if(hs.getAttribute("umail")!=null) {
	  String email=(String) hs.getAttribute("umail");
		return new ModelAndView("compose","msg",email);
	  }else {
		  return new ModelAndView("login","msg","Please Login");
	  }
	}
	@RequestMapping("/sent")
	public ModelAndView sent() {
		if (hs.getAttribute("umail")!=null) {
			List<MDTO> list=ms.sent();
			return new ModelAndView("sent","list",list);
		}else {
			return new ModelAndView("login","msg","Please Login");
		}
	}
	@RequestMapping("/draft")
	public ModelAndView draft() {
		if (hs.getAttribute("umail")!=null) {
			List<MDTO> list=ms.draft();
			return new ModelAndView("draft","list",list);
		}else {
			return new ModelAndView("login","msg","Please Login");
		}
	}
	@RequestMapping("/inbox") 
	  public ModelAndView inbox() {
		  if(hs.getAttribute("umail")!=null) {
		 List<MDTO> list=ms.inbox();
		  return new ModelAndView("inbox","list",list);
		  }else {
			  return new ModelAndView("login","msg","Login First");
			  }
    }
	@RequestMapping("/change")
	public ModelAndView change() {
		if (hs.getAttribute("umail")!= null) {
			return new ModelAndView("change");
			}
			else {
				return new ModelAndView("login","msg","Login First");
			}
	}
	@RequestMapping(value="/changePass",method=RequestMethod.POST)
	public ModelAndView changePass(@RequestParam String pass,String newpass) {
		 boolean b=ms.change(pass, newpass);
		  if(b) {
		  return new ModelAndView("home","msg","Password Succesfully Changed ");
		  }else {
			  return new ModelAndView("change","msg","Sorry");
		  }	
	}
	@RequestMapping("/forget")
	public ModelAndView forget() {
		return new ModelAndView("forget");
	}
	@RequestMapping(value="/forgetPass",method = RequestMethod.POST)
	public ModelAndView forgetPass(@RequestParam String umail,String question,String answer,String pass,String cpass) {
	boolean b = ms.forget(umail, question, answer, pass, cpass);
	  if(b) {
	  return new ModelAndView("forget","msg","Changed successful");
	  }else {
		  return new ModelAndView("forget","msg","Invalid");
	  }
}
	@RequestMapping("/delete")
	public ModelAndView delete() {
		 List<MDTO> list=ms.deleteList(); 
		return new ModelAndView("delete","list",list);
	}
	@RequestMapping("/deleteMail")
	  public ModelAndView deleteMail(@RequestParam int id) {
		System.out.println(id);
		boolean b=ms.deletedMail(id);
		  if(b) {
		  return new ModelAndView("home","msg","delete successful");
	  }else {
		  return new ModelAndView("home","msg","delete failed");
	  }
	}
	
	@RequestMapping("/deleteshow")
	public ModelAndView deleteshow() {
		if(hs.getAttribute("umail")!=null) {
			 List<MDTO> list=ms.deleteList();
			 return new ModelAndView("delete","list",list);
		  }else {
			  return new ModelAndView("login","msg","Login First");
			  }
	}
	@RequestMapping(value="/loginValidation",method=RequestMethod.POST)
	public ModelAndView loginValidation(@ModelAttribute UserDTO dto, HttpServletRequest req){
		UserDTO mdto=ms.login(dto);
		if(mdto!=null){
			hs=req.getSession();
			hs.setAttribute("umail", dto.getUmail());
			System.out.println("Login Success");
			return new ModelAndView("home","data",mdto);
		}else{
			System.out.println("Login Failed");
			return new ModelAndView("login","msg","login failed invalid email and password try again");
		}
		
	}
	
	@RequestMapping(value="/registrationData",method=RequestMethod.POST)
	public ModelAndView registrationData(@ModelAttribute UserDTO dto){
		boolean b=ms.register(dto);
		System.out.println("Registration Success");
		if(b){
		return new ModelAndView("registration","dto","Registration Done");
		}else{
		return new ModelAndView("registration","dto","Registration Not Done User already Existed");	
		}
	}
	  @RequestMapping(value="/composeData") 
	  public ModelAndView composeData(@RequestParam String to,String subject,String body){ 
	  String from=(String) hs.getAttribute("umail");
	  UserDTO u=ms.composeEmail(from,to,subject,body);
	  
	  if(u!=null){
		  return new ModelAndView("compose","msg","Mail Sent");
		  }
	  else {
		  return new ModelAndView("home","msg","Mail Not Sent"); }
	  }	 
	  @RequestMapping("/editMail")
	  public ModelAndView editMail(@RequestParam int id) {
		 MDTO dto=ms.mailCompose(id);
		 if(hs.getAttribute("umail")!=null) {
			 hs.setAttribute("mid", dto.getMid());
		  return new ModelAndView("composedraft","dto",dto);
		 }else {
			 return new ModelAndView("login","msg","Login First");
		 }
	  }
	  
	  @RequestMapping(value = "/composeDraft" ,method = RequestMethod.POST)
		public ModelAndView composeDraft(@RequestParam String to, String message, String subject) {
			boolean b = ms.composeDraft(to, message, subject);
			if (b) {
				return new ModelAndView("home", "msg", "Email Send Successfully");
				
			} else {
				return new ModelAndView("home", "msg", "Error saved to draft");

			}
	  }
	  
}
