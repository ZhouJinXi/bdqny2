package com.bdqn.hibernate.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import org.hibernate.Session;

import com.bdqn.hibernate.factory.HibernateSessionFactory;

public class Demo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Connection conn = session.connection();
		String sql = "{call proc_getusersdata(?,?)}";
		CallableStatement cstmt = conn.prepareCall(sql);
		//�������������
		cstmt.setInt(1,100);
		//ע���������
		cstmt.registerOutParameter(2,oracle.jdbc.OracleTypes.CURSOR);
		//ִ��
		System.out.println(cstmt.execute());
		//��ȡ�α�����������������Ƕ��ڳ�����Ե�ResultSet
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		//����
		while(rs.next()){
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
		}
		rs.close();
		cstmt.close();
		conn.close();
		HibernateSessionFactory.closeSession();
	}

}
