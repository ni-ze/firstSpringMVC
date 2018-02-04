package com.imooc.mvcdemo.DataDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.imooc.mvcdemo.DB.DBAccess;
import com.imooc.mvcdemo.model.User;
import com.imooc.mvcdemo.service.TotalPoint;

//执行sql语句，获取操作结果封装信息，返回操作结果
@Repository 
 public class DataDao {
	 
	private TotalPoint totalPoint;
	@Autowired
	public void setUserService(TotalPoint totalPoint ) {//必须加入自动注入初始化bean TotalPoint,否则使用时报错
		this.totalPoint  =totalPoint;
	} 
	

	 
	@SuppressWarnings("deprecation")
	public  User  queryUser(String arg0,String arg1) {
		 User userBack=new User();    					//从数据库去除的数据
		 User userTodata =new User();  					//最后要返回给controller的对象
		 
		 DBAccess dbAccess=new DBAccess();
		 SqlSession sqlSession=null;
		
		 try {
			 sqlSession=dbAccess.getSqlSession(); 
			 User user=new User();
			 user.setUserName(arg0);
			 user.setPassword(arg1);
			// user.setContiDays(0);//默认连续登陆0天；
 			 user.setPoint(1); //默认得1分。
			 System.out.println(user.getPoint()+"	1");
 			//向userslist中查询user对象 不存在时插入一列，并创建一张新表
			 if(sqlSession.selectOne("User.queryUser",user)==null){//如果数据库没有相应用户  
				 //通过sqlSession执行sql语句
				 sqlSession.insert("User.insertuserslist",user);// 插入该用户到userslist,
				 sqlSession.update("User.createTable", user);//并动态创建一个用户名为自身，存储积分明细的新表
				 sqlSession.insert("User.insertself",user);//在新建表中插入第一行。
				 sqlSession.commit();//一定要提交，不然插入不进去，我也不知道为啥
				 userTodata=sqlSession.selectOne("User.queryUser",user);//从userslist中选择username的一行，并返回
			 }else{											//如果userslist中存在该用户，则在更新用户积分	
				 userBack=sqlSession.selectOne("User.querypoint",user);//取自身表的最近更新的一行
				 userTodata=totalPoint.updateUser(userBack);           //计算用户新的积分
				 
				 sqlSession.insert("User.insertself",userTodata);//向动态创建的表中插入更新后的对象
				 sqlSession.update("User.updateUserList", userTodata);//更新userslist中的用户积分
				 sqlSession.commit();
			 }
			 
			 System.out.println(user.getPoint()+"	5");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return userTodata; 
		 
	 }
	public  List<User>  queryUserList(){
		List<User> userList=new ArrayList<User>();
		 DBAccess dbAccess=new DBAccess();
		 SqlSession sqlSession=null;
		 try {
			sqlSession=dbAccess.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 userList=sqlSession.selectList("User.queryUserList");
		 Integer j=1;
		 for (int i=0;i<userList.size();i++) { 
			 userList.get(i).setId(j);
			 j=j+1;
			 
//			 System.out.println(j+" "+userList.get(i).getId()+" "+userList.get(i).getUserName()
//					 +" "+userList.get(i).getCreateTime()+" "+userList.get(i).getPoint());
		}
		 
		return userList;
	}
	public List<User> queryEachUserList(String arg0){
		List<User> userList=new ArrayList<User>();
		User toDatabase=new User();
		 
		toDatabase.setUserName(arg0);
		
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		userList=sqlSession.selectList("User.queryEachUserList",toDatabase);
		return userList;
	}
	
}
