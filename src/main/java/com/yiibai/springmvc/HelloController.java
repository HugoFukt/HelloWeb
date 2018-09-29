package com.yiibai.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public final String printHello(final ModelMap model) {
		model.addAttribute("message", "Hello World!");
		return "hello";
	}

	@ResponseBody
	@RequestMapping(value = "/user/createUser", method = RequestMethod.GET)
	public final String getString(final ModelMap model) {
		return "Hello World!";
	}
}
