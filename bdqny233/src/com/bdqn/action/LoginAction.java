package com.bdqn.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bdqn.service.UsersService;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	//�������������ΪAction�е�����ʵ��
	//userName
	private String userName = "";
	//passWord
	private String passWord = "";
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassWord() {
		return passWord;
	}



	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}



	public String execute(){
		//1.����ҵ���߼�
		UsersService us = new UsersService();
		if(us.login(userName, passWord)){
			//����session--��servlet�޹�
//			Map<String,Object> session = ActionContext.getContext().getSession();
//			session.put("username",userName);
			//����session--��servlet�й�,
			//����ͨ��ServletActionContext�����ò���Servlet����,
			//���磺HttpServletRequest,HttpServletResponse,HttpSession
            	HttpSession session = ServletActionContext.getRequest().getSession();
            	session.setAttribute("username",userName);
			return "succ";
		}
		return "fail";
	}
}
