package com.imooc.mvcdemo.controller; 
import java.io.IOException;
import java.rmi.server.SocketSecurityException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imooc.mvcdemo.DataDAO.DataDao;
import com.imooc.mvcdemo.model.User;
  
@Controller
@RequestMapping("/loading")
public class loadingUpController {
	
 	private DataDao dataDao;
	
	@Autowired
	public void setCourseService(DataDao dataDao ) {
		this.dataDao  =dataDao;
	}
	
	@RequestMapping(value="/")
	public String homeController(){ 
		return "home";
	}
	
	@RequestMapping(value="/admin")
	public String createUser(){
		System.out.println("由我来请求登录页面的呈现！");
		return "user_admin/edit";
	}
	
	//将输入的信息保存到数据库，注册
	@RequestMapping(value="/save",method=RequestMethod.POST)//拦截edit里面“登陆”后提交过来的save方法
	public String doSave(@ModelAttribute User user,HttpServletRequest req)// HttpServletRequest req, HttpServletResponse resp
			throws ServletException, IOException{
		 
/*		//在此进行业务操作，比如数据库持久化
		String username=req.getParameter("userName");
		String password=req.getParameter("password");
		
		req.setAttribute("userName", username);
		req.setAttribute("password", password);*/
		// 查询消息列表并传给页面
		req.setAttribute("userBack",dataDao.queryUser(user.getUserName(),user.getPassword()) );
		 
		
		// 向页面跳转
		return "index";
	}
	//登陆，将输入的信息与数据库核对并实现积分更新。
	public String dologin(){
		return "";
	}
	
	//从数据库返回刚才输入用户名的信息
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public String checkAllUsers(Model model){
		 model.addAttribute(dataDao.queryUserList()); //model 里面存放的是list<User>;
		return "alluser";
	}
	//
	@RequestMapping(value="/checkforeachone/{userName}" )
	public String checkEveUser(@PathVariable("userName")String userName,Model model){
 
		model.addAttribute(dataDao.queryEachUserList(userName));
		System.out.println("积分"+dataDao.queryEachUserList(userName).get(1).getPoint());
		return "eachuser";
	}
}
