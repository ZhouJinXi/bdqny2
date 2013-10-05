package com.bdqn.struts.action;

import java.util.Map;

import com.bdqn.hibernate.domain.SysUser;
import com.bdqn.hibernate.service.SysUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String uname = "";
	private String upassword = "";
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
	@Override
	public void validate() {
		//�ڴ˽��б���֤��������У��ȹ���
		if(uname.equals("")){
			this.addFieldError("uname","�Բ����û�������Ϊ�գ�");
		}else{
			if(upassword.equals("")){
				this.addFieldError("upassword","�Բ������벻��Ϊ�գ�");
			}
		}
	}
	
	public String execute(){
		SysUserService sus = new SysUserService();
		SysUser myuser = sus.login(uname, upassword);
		if(myuser != null){
			//��session
            Map<String,Object> session = ActionContext.getContext().getSession();
            session.put("myuser",myuser);
			return "toaction";
		}else{
			this.addActionError("�Բ����û������������");
		}
		return INPUT;
	}
	
}
