package com.imooc.mvcdemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.imooc.mvcdemo.model.User;

@Service
public class TotalPoint  {
  
	public User updateUser(User userBack){
		User userTodata =new User();
		Date nowD=new Date(System.currentTimeMillis());//取当前时间
		 Date befD=new Date(userBack.getLoginDate().getTime());//取自身表最后更新的时间
		 SimpleDateFormat fmt= new SimpleDateFormat("yyyy-MM-dd");
		 String s1=fmt.format(nowD); 
		 String s2=fmt.format(befD);

		 Date d1=null;
		 Date d2=null;
		 
		 try {
			d1=fmt.parse(s1);
			d2=fmt.parse(s2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		 System.out.println(d1.getTime());
		 System.out.println(d2.getTime());
		 
		 if(DateUtils.isSameDay(d1,d2)){ //一天内登陆
			 userTodata.setContiDays(userBack.getContiDays());//则连续登陆天数、积分都不变					 
			 userTodata.setPoint(userBack.getPoint());				
		 }
		 else if((d1.getTime()-d2.getTime())==(24*60*60*1000)){//两次登陆时间相差一天
			 userTodata.setContiDays(userBack.getContiDays()+1);//连续登陆时间+1
			 if(userTodata.getContiDays()==1){
				 userTodata.setPoint(userBack.getPoint()+1);
			 }else if(userTodata.getContiDays()==2){
				 userTodata.setPoint(userBack.getPoint()+2);
			 }else if(userTodata.getContiDays()>=3){
				 userTodata.setPoint(userBack.getPoint()+3);
			 }
		 }else{												//连续两次登陆时间相差一天（不包括）以上			
			 userTodata.setContiDays(0);
			 userTodata.setPoint(1);
		 }
		 userTodata.setUserName(userBack.getUserName());
		 userTodata.setPassword(userBack.getPassword());
		
		return userTodata; 
	}
}
