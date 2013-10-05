package com.bdqn.hibernate.test;

import java.util.Iterator;
import java.util.List;

import com.bdqn.hibernate.domain.TblUsers;
import com.bdqn.hibernate.factory.HibernateSessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;

public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 1.iterate��ʽ����list��ͬ������iterate��ʽ������ȡ����ID�����󣬸�����Ҫ��ȡ�������
		 *   ����ʱ����ִ�и�������ID��ѯ����ֵ��Ҳ����˵��������Ҫִ��2��.
		 * 2.һ��������iterate��ʽ��ϵ����ĳ��������˵��iterate��ʽ��֧�ֶ����ظ���ȡIDֵ�Ļ������.
		 *   ע�⣺��֧�ָ�������Ϊ�����Ĳ�ѯ
		 */
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String hsql = "from TblUsers t where t.usid = 100";
		Query query = session.createQuery(hsql);
//		List<TblUsers> data = query.list();
		Iterator<TblUsers> data = query.iterate();
		while (data.hasNext()) {
			TblUsers myuser = data.next();
			System.out.println(myuser.getUname());
		}
		Query query2 = session.createQuery(hsql);
//		List<TblUsers> data2 = query2.list();
		Iterator<TblUsers> data2 = query2.iterate();
		while (data2.hasNext()) {
			TblUsers myuser = data2.next();
			System.out.println(myuser.getUname());
		}
		HibernateSessionFactory.closeSession();
	}

}
