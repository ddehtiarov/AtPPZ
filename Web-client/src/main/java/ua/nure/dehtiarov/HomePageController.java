package ua.nure.dehtiarov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomePageController {

	@RequestMapping(method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "login";
	}

	@RequestMapping("/register")
	public String registerPage(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "register";
	}

	@RequestMapping("/login")
	public String loginAccount(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "login";
	}

}