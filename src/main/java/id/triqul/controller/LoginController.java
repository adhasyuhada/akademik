package id.triqul.controller;

import javax.xml.ws.RequestWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "redirect:login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error, 
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView mav = new ModelAndView();
		if(error!=null) {
			mav.addObject("error", "Invalid credentials provided");
		}
		if(logout!=null) {
			mav.addObject("logout", "Logout successfully");
		}
		
		mav.setViewName("login");
		return mav;
	}
	
	
}
