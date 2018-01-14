package com.wojiushiwo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wojiushiwo.util.RedisListUtil;

@Controller
@RequestMapping(value = "/hello")
public class MyController {
	@Autowired
	private RedisListUtil redisListUtil;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String toHello() {
		return "hello";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<String> list = redisListUtil.list("myList", 0, -1);
		write(resp, list);
		return null;
	}

	private void write(HttpServletResponse resp, List<String> list)
			throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		for (String str : list) {
			writer.write(str);
		}
		writer.flush();
		writer.close();

	}
}
