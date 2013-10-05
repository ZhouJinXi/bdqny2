package com.bdqn.mystruts.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bdqn.mystruts.action.ActionMapping;
import com.bdqn.mystruts.action.ActionResult;

/**
 * 1.����xml�����ļ�(dom4j)
 * 
 * 2.���һ��ActionMapping��ʵ��
 * @author lzybj
 *
 */
public class ActionMappingManager {
	public static Map<String,ActionMapping> mappings = new HashMap<String, ActionMapping>();
	
	private void init(String configName) throws DocumentException{
		SAXReader sax = new SAXReader();
		String xmlPath = this.getClass().getClassLoader().getResource(configName).getPath();
		Document doc = sax.read(xmlPath);
		//��ø��ڵ�
		Element root = doc.getRootElement();
		//��ROOT�ڵ��»��actions�ڵ�
		Element actions = root.element("actions");
		//��actions�ڵ��»��action�ڵ㼯��
		List<Element> actionList = actions.elements("action");
		//�����ڵ㼯�ϻ��ÿһ��action�ڵ�
		for (Element action : actionList) {
			//���action��������name,class
			String name = action.attributeValue("name");
			String className = action.attributeValue("class");
			//����һ��reulst��Map����
			Map<String,ActionResult> results = new HashMap<String, ActionResult>();
			//��action�ڵ��»��reulst�ڵ㼯��
			List<Element> resultList = action.elements("result");
			//����result�ڵ㼯�ϻ��ÿһ��result�ڵ�
			for (Element result : resultList) {
				//���result�ڵ����������name,redirect
				String resName = result.attributeValue("name");
				String resRedirect = result.attributeValue("redirect");
				boolean redirect = false;
				if(resRedirect != null){
					if(resRedirect.equals("true")){
						redirect = true;
					}
				}
				//���result�ڵ��ı��ڵ�ֵ
				String resValue = result.getText();
				//����ActionResult����
				ActionResult myres = new ActionResult(resName, resValue, redirect);
				results.put(resName,myres);
			}//����result�ڵ㼯�Ͻ���
			//����ActionMapping����
			ActionMapping mapping = new ActionMapping(name, className, results);
			mappings.put(name, mapping);			
		}//����action����
	}//����xml��������
	
	public ActionMappingManager(String[] configNames){
		for (String configName : configNames) {
			try {
				init(configName);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static ActionMapping getActionMapping(String name){
		return (ActionMapping)mappings.get(name);
	}
	
}
