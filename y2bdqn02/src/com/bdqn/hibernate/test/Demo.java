package com.bdqn.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bdqn.hibernate.domain.TblUsers;
import com.bdqn.hibernate.factory.HibernateSessionFactory;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		//�������ö���
//		Configuration conf = new Configuration().configure();
//		//����SESSIONFACTORY
//		SessionFactory sessionFactory = conf.buildSessionFactory();
//		//���session
//		Session session = sessionFactory.openSession();
//		//�����������
//		Transaction t  = session.beginTransaction();
//		t.begin();
//		//insert����
//		TblUsers myuser = new TblUsers("С��","qaz123");
//		//����
//		session.save(myuser);
//		t.commit();
//		//�ر�SESSION
//		session.close();
//		System.out.println("�ɹ���");
		Session session = HibernateSessionFactory.getSession();
		Transaction t = session.beginTransaction();
		t.begin();
		TblUsers myuser = new TblUsers("СС","qaz123");
		session.save(myuser);
		t.commit();
		HibernateSessionFactory.closeSession();
	}

}
