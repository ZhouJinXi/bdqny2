package com.bdqn.action;

import java.util.Map;

import com.bdqn.service.UsersService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UsersAction{
	private String uname = "";
	private String upwd = "";
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	//��¼�Ķ���
	public String login(){
		UsersService us = new UsersService();
		if(us.login(uname, upwd)){
			Map<String,Object> session = ActionContext.getContext().getSession();
			session.put("uname",uname);
			return "succ";
		}
		return "fail";
	}
	//ע��Ķ���
	public String register(){
		UsersService us = new UsersService();
		if(us.register(uname, upwd)){
			return "mytest";
		}
		return "fail";
	}
	//��ѯ�Ķ���
	public String cxall(){
		return "succ";
	}
	
}
