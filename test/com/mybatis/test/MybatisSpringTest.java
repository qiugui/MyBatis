 package com.mybatis.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.interfaces.UsersMapper;
import com.mybatis.model.Article;
import com.mybatis.model.Users;
 /** 
* @ClassName: MybatisSpringTest 
* @Description: mybatis与spring整合的测试类
* @author qiugui 
* @date 2015年3月3日 下午2:57:04 
*  
*/ 
public class MybatisSpringTest {

	private static ApplicationContext ctx;
	
	static {
		ctx=new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}
	
	public static void main(String[] args){
		UsersMapper usersMapper = (UsersMapper) ctx.getBean("userMapper");
		System.out.println("得到用户id=1的用户信息");
		Users users=usersMapper.selectUsersByID(1);
		System.out.println(users.getUserName());
		
		System.out.println("得到用户id为1的所有文章列表");
		List<Article> articles = usersMapper.getUsersArticles(1);
		
		for (Article article : articles) {
			System.out.println(article.getTitle()+"--"+article.getContent());
		}
	}
}

 