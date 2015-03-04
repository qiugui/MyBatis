 package com.mybatis.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		MybatisSpringTest mybatisSpringTest = new MybatisSpringTest();
		mybatisSpringTest.getUsersArticles();
	}
	
	public void getUsersArticles(){
		UsersMapper usersMapper=(UsersMapper) ctx.getBean("usersMapper");
		System.out.println("得到用户id=1的用户信息");
		System.out.println();
		
		//foreach 中接收list
		/*List<String> list = new ArrayList<String>();
		list.add("summer");
		list.add("邱桂");
		list.add("张三");
		List<Users> users=usersMapper.selectUsers(list);
		for (Users user : users) {
			System.out.println(user.getUserAddress());
		}*/
		
		//foreach 中接收数组
		/*String[] usesnames = {"summer","张三"};
		List<Users> users=usersMapper.selectUsers2(usesnames);
		for (Users users2 : users) {
			System.out.println(users2.getUserAddress());
		}*/
		
		//foreach 中接收Map
		/*List<String> listname = new ArrayList<String>();
		
		listname.add("张三");
		listname.add("summer");
		listname.add("邱桂");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("listname", listname);
		List<Users> users = usersMapper.selectUsers3(map);
		for (Users users1 : users) {
			System.out.println(users1.getUserAddress());
		}*/
		
		/*System.out.println("得到用户id为1的所有文章列表");
		List<Article> articles = usersMapper.getUsersArticles(1);
		
		for (Article article : articles) {
			System.out.println(article.getId()+"--"+article.getTitle()+"--"+article.getContent());
		}*/
	}
}

 