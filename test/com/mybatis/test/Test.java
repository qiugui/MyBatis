 package com.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.interfaces.UsersMapper;
import com.mybatis.model.Article;
import com.mybatis.model.Users;
 /** 
* @ClassName: Test 
* @Description: 测试类
* @author qiugui 
* @date 2015年3月3日 上午9:53:11 
*  
*/ 
public class Test {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static{
		try {
			reader = Resources.getResourceAsReader("config/Configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory gerSession(){
		return sqlSessionFactory;
	}
	
	public static void main(String[] args){
		
		Test test = new Test();
		
		//返回一个数据的非接口查询
//		test.selectUsersByIDNoInterface(1);
		
		//返回一个数据的接口查询
//		test.selectUsersByID(1);
			
		//返回数据列表的接口查询
//		test.selectUsers("%");
		
		//增加数据
//		test.addUsers();
			
		//更新用户
//		test.updateUsers();
		
		//删除记录
//		test.deleteUsers(4);
		
		//关联查询
		test.getUsersArticles(1);
	}
	
	/**   
	 * @Title: selectUsersByIDNoInterface   
	 * @Description: 返回一个数据的非接口查询  
	 * @param i        
	 */
	 
	public void selectUsersByIDNoInterface(int i){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Users users = session.selectOne("com.mybatis.interfaces.UsersMapper.selectUsersByID", 2);
			System.out.println(users.getUserAddress());
			System.out.println(users.getUserName());
		} finally {
			session.close();
		}
	}
	
	
	/**   
	 * @Title: selectUsersByID   
	 * @Description: 返回一个数据的接口查询
	 * @param i        
	 */
	 
	public void selectUsersByID(int i){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UsersMapper usersMapper = session.getMapper(UsersMapper.class);
			Users users = usersMapper.selectUsersByID(2);
			System.out.println(users.getUserAddress());
			System.out.println(users.getUserName());
		} finally {
			session.close();
		}
	}
	
	/**   
	 * @Title: selectUsers   
	 * @Description: 返回数据列表的接口查询  
	 * @param userName        
	 */
	 
	public void selectUsers(String userName){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UsersMapper usersMapper = session.getMapper(UsersMapper.class);
			List<Users> listUsers = usersMapper.selectUsers(userName);
			for (Users user: listUsers){
				System.out.println(user.getId()+"\t"+user.getUserName()+"\t"+user.getUserAddress());
			}
		} finally {
			session.close();
		}
	}
	
	/**   
	 * @Title: addUsers   
	 * @Description: 增加数据          
	 */
	 
	public void addUsers(){
		Users users = new Users();
		users.setUserAddress("人民广场");
		users.setUserAge(26);
		users.setUserName("张三");
		SqlSession session = sqlSessionFactory.openSession();
		try{
			UsersMapper usersMapper = session.getMapper(UsersMapper.class);
			usersMapper.addUsers(users);
			session.commit();
			System.out.println("当前增加的用户id为："+users.getId());
		} finally {
			session.close();
		}
	}
	
	/**   
	 * @Title: updateUsers   
	 * @Description: 更新记录          
	 */
	 
	public void updateUsers(){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			UsersMapper usersMapper = session.getMapper(UsersMapper.class);
			Users users = usersMapper.selectUsersByID(4);
			users.setUserAddress("上海，浦东");
			usersMapper.updateUsers(users);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	/**   
	 * @Title: deleteUsers   
	 * @Description: 删除记录 
	 * @param id        
	 */
	 
	public void deleteUsers(int id){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UsersMapper usersMapper = session.getMapper(UsersMapper.class);
			usersMapper.deleteUsers(4);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	/**   
	 * @Title: getUsersArticles   
	 * @Description: 多表关联查询  
	 * @param userid        
	 */
	 
	public void getUsersArticles(int userid){
		SqlSession session = sqlSessionFactory.openSession();
		try {
			UsersMapper usersMapper = session.getMapper(UsersMapper.class);
			List<Article> articles = usersMapper.getUsersArticles(userid);
			for (Article article : articles){
				System.out.println("文章名："+article.getTitle()+" 文章内容:"+article.getContent()+
						" 作者："+article.getUsers().getUserName()+" 地址："+
						article.getUsers().getUserAddress());
			}
		} finally {
			session.close();
		}
	}
}

 