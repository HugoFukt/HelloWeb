package com.yiibai.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello")
public class HelloController{

	@RequestMapping(value = "/user/createUser",method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello World!");

      return "hello";
   }
//	@RequestMapping(value = "/user/createUser", method = RequestMethod.GET)
//	public String getString(ModelMap model) {
//		return "Hello World!";
//	}
}