package com.bdqn.hibernate.test;

import java.sql.CallableStatement;
import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bdqn.hibernate.factory.HibernateSessionFactory;

public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction t = session.beginTransaction();
		t.begin();
		Connection conn = session.connection();
		CallableStatement cstmt = conn.prepareCall("{call proc_inserttblusers(?,?,?)}");
		//�����������ֵ
		cstmt.setString(1,"jhy");
		cstmt.setString(2,"qaz123");
		//ע���������
		cstmt.registerOutParameter(3,oracle.jdbc.OracleTypes.NUMBER);
		//ִ�д洢����(true:�н���� false:�޽����)
		System.out.println(cstmt.execute());
		//������������ֵ
		System.out.println(cstmt.getInt(3));
		//�ر�
		cstmt.close();
		conn.close();
		t.commit();
		HibernateSessionFactory.closeSession();
	}

}
