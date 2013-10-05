package com.bdqn.freamwork.manager;

import com.bdqn.freamwork.action.Action;

/**
 * ͨ����·���ַ���������һ��Action����
 * ����java�������
 * @author lzybj
 *
 */
public class ActionManager {
	public static Action createAction(String classForName){
		Action action = null;
		try {
			action = (Action)loadClass(classForName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return action;
	}
	
	public static Class loadClass(String classForName) {
		Class myclass = null;
		try {
			myclass = Thread.currentThread().getContextClassLoader().loadClass(classForName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(myclass == null){//�������߳�û��ʵ�����󣬼�û�б�ʵ����
			try {
				myclass = Class.forName(classForName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myclass;
	}
}
