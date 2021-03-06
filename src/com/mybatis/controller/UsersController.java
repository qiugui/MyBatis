 package com.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.interfaces.UsersMapper;
import com.mybatis.model.Article;
 @Controller
 @RequestMapping("/article")
 public class UsersController {

	 @Autowired
	 UsersMapper usersMapper;
	 
	 @RequestMapping("/list")
	 public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
		 List<Article> articles = usersMapper.getUsersArticles(1);
		 for (Article article : articles) {
			System.out.println(article.getTitle());
		}
		 ModelAndView mav = new ModelAndView("list");
		 mav.addObject("articles", articles);
		 return mav;
	 }
}

 