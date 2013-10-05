package com.bdqn.mystruts.manager;

import com.bdqn.mystruts.action.Action;

/**
 * ͨ��JAVA������Ƹ���mystruts.xml��class�ַ�������ö�ӦACTION��
 * @author lzybj
 *
 */
public class ActionManager {
	public static Action createAction(String classForName){
		Action myAction = null;
		try {
			myAction = (Action)loadClass(classForName).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myAction;
	}
	public static Class loadClass(String classForName){
		Class myClass = null;
		//��һ�ӵ�ǰ�߳��в鿴�Ƿ���Action����
		try {
			myClass = Thread.currentThread().getContextClassLoader().loadClass(classForName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ڵ�ǰ�߳�û�и�class����ͨ��Class.forName�������
		if(myClass == null){
			try {
				myClass = Class.forName(classForName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myClass;
	}
}
