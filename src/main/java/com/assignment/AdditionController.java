package com.assignment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdditionController {
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		int a = Integer.parseInt(request.getParameter("t1"));
		int b = Integer.parseInt(request.getParameter("t2"));
		String op = request.getParameter("operation");
		int c = 0;
		
		switch(op) {
			case "+":
				c = a + b;
				break;
			case "-":
				c = a - b;
				break;
			case "/":
				c = a / b;
				break;
			case "*":
				c = a * b;
				break;
			default:
				mv.addObject("error", "Invalid operation");
                break;
		}
		
		mv.setViewName("resultpage");
		mv.addObject("result", c);
		
		return mv;
	}
}
