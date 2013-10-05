package com.bdqn.mystruts.action;

/**
 * ��װ��ACTION�Ľ����Ϣ
 * name:�߼���ַ
 * value:��ʵ��ַ
 * redirect:�Ƿ��ض���,true,�ض��� falseת��
 * @author lzybj
 *
 */
public class ActionResult {
	private String name = "";
	private String value = "";
	private boolean redirect = false;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public ActionResult(String name, String value, boolean redirect) {
		super();
		this.name = name;
		this.value = value;
		this.redirect = redirect;
	}
	
}
