package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.DataAccessObject;
import com.techpalle.model.Student;

@Controller
public class StudentController 
{	
	@RequestMapping("/log")
	public ModelAndView f1(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login.jsp");
		//we have to jump to login.jsp
		return mv;
	}
	@RequestMapping("/reg")
	public ModelAndView f2()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		//we have to jump to login.jsp
		return mv;
	}
	@RequestMapping("/studentregistration")
	public ModelAndView f3(HttpServletRequest req, HttpServletResponse res)
	{
		String name = req.getParameter("studentName");
		String email = req.getParameter("studentEmail");
		String pw = req.getParameter("studentPassword");
		String mobile = req.getParameter("studentMobile");
		//now we have to insert this data to table
		Student s = new Student();
		s.setName(name);
		s.setEmail(email);
		s.setPw(pw);
		s.setMobile(mobile);
		//pass student object to dao layer
		DataAccessObject dao = new DataAccessObject();
		dao.insertStudent(s);
		
		//reopen the same page
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		mv.addObject("result", "inserted..");
		return mv;
	}
	@RequestMapping("/show")
	public ModelAndView f4()
	{
		ModelAndView mv = new ModelAndView();
		DataAccessObject dao = new DataAccessObject();
		ArrayList<Student> all = dao.getStudents();
		mv.setViewName("display.jsp");
		mv.addObject("students", all);
		return mv;
	}
}
