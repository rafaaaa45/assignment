package com.assignment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

class AdditionControllerTest {

	@InjectMocks
	AdditionController additionController;
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAdd() {
		when(request.getParameter("t1")).thenReturn("10");
		when(request.getParameter("t2")).thenReturn("5");
		when(request.getParameter("operation")).thenReturn("+");
		
		ModelAndView mv = additionController.add(request, response);
		
		System.out.println("View Name: " + mv.getViewName());
        System.out.println("Result: " + mv.getModel().get("result"));
		
		assertEquals("resultpage", mv.getViewName());
		assertEquals(15, mv.getModel().get("result"));
	}
	
	@Test
	void testSubtract() {
		when(request.getParameter("t1")).thenReturn("10");
		when(request.getParameter("t2")).thenReturn("5");
		when(request.getParameter("operation")).thenReturn("-");
		
		ModelAndView mv = additionController.add(request, response);
		
		System.out.println("View Name: " + mv.getViewName());
        System.out.println("Result: " + mv.getModel().get("result"));
		
		assertEquals("resultpage", mv.getViewName());
		assertEquals(5, mv.getModel().get("result"));
	}
	
	@Test
	void testMultiply() {
		when(request.getParameter("t1")).thenReturn("10");
		when(request.getParameter("t2")).thenReturn("5");
		when(request.getParameter("operation")).thenReturn("*");
		
		ModelAndView mv = additionController.add(request, response);
		
		System.out.println("View Name: " + mv.getViewName());
        System.out.println("Result: " + mv.getModel().get("result"));
		
		assertEquals("resultpage", mv.getViewName());
		assertEquals(50, mv.getModel().get("result"));
	}
	
	@Test
	void testDivide() {
		when(request.getParameter("t1")).thenReturn("10");
		when(request.getParameter("t2")).thenReturn("5");
		when(request.getParameter("operation")).thenReturn("/");
		
		ModelAndView mv = additionController.add(request, response);
		
		System.out.println("View Name: " + mv.getViewName());
        System.out.println("Result: " + mv.getModel().get("result"));
		
		assertEquals("resultpage", mv.getViewName());
		assertEquals(2, mv.getModel().get("result"));
	}
	
}
