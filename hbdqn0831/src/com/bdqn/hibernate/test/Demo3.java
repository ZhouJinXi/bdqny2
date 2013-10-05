package com.bdqn.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.bdqn.hibernate.domain.HosHouse;
import com.bdqn.hibernate.domain.HosType;
import com.bdqn.hibernate.factory.HibernateSessionFactory;

public class Demo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//QBC����ѯ
		//String hsql = "select xxxxx from HosHouse hh inner join hh.hosType where xxx?";
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(HosHouse.class,"hh");
		criteria.createCriteria("hh.hosType","ht");
		criteria.add(Restrictions.between("hh.price",new Double(1000),new Double(3000)));
		criteria.add(Restrictions.eq("ht.htname","һ��һ��"));
		criteria.addOrder(Order.desc("hh.price"));
		criteria.setFirstResult(2);//�ڶ�ҳ��ʼ����
		criteria.setMaxResults(2);//ÿҳ��ʾ����
		List<HosHouse> data = criteria.list();
		for (HosHouse hosHouse : data) {
			System.out.println(hosHouse.getHosType().getHtname() + "," + hosHouse.getPrice());
		}
		
		
		HibernateSessionFactory.closeSession();
	}

}
