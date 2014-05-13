package me.aboz.ui.controller;

import me.aboz.model.user.IUserAdminService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	public static String LastMessage = "none";
	
	private IUserAdminService userAdminService;
	
	public void setUserAdminService(IUserAdminService userAdminService){
		this.userAdminService = userAdminService;
	}

	@RequestMapping(value={"","/"})
	public String index(Model model){
		model.addAttribute("total", this.userAdminService.total());
		return "note";
	}
	
	@ResponseBody
	@RequestMapping(value="/lastmessage")
	public String LastMessage(){
		return LastMessage;
	}
}
