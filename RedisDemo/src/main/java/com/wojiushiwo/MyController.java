package com.wojiushiwo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class MyController {
	public String toHello() {
		return "hello";
	}
}
