package hotel.loginlogout.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.loginlogout.dao.HotelDao;
import hotel.loginlogout.model.hotelBean;

@Repository @Transactional
public class HotelDaoImpl implements HotelDao{
//public class HotelDaoImpl{
	@Autowired
	private SessionFactory factory;

//	// 新增
//	@Override
//	public void addhotel(String uSER_NAME, String uSER_PASSWORD, String uSER_EMAIL, String uSER_PHONE, String uSER_IDENTITY,
//	String uSER_BIRTHDAY, String uSER_REGISTRATION){
//		Session session = factory.openSession();
//		hotelBean hotelBean = new hotelBean(uSER_NAME, uSER_PASSWORD, uSER_EMAIL, uSER_PHONE, uSER_IDENTITY,
//				uSER_BIRTHDAY, uSER_REGISTRATION);
//		if (hotelBean!=null) {
//			session.save(hotelBean);
//		}
//		session.close();
//	}
	
	// 新增
		@Override
		public hotelBean addhotel(hotelBean hBean){
			Session session = factory.openSession();
			
			if (hBean!=null) {
				session.save(hBean);
			}
			session.close();
			return hBean;
		}

	// 透過id拿資料
	@Override
	public List<hotelBean> findById(int USER_ID) {
		Session session = factory.openSession();
		String hql = "from hotelBean where USER_ID=:USER_ID";
		Query<hotelBean> query = session.createQuery(hql, hotelBean.class).setParameter("USER_ID", USER_ID);
		List<hotelBean> classlist = query.getResultList();
		session.close();
		return classlist;
	}

	// 刪除
	@Override
	public hotelBean deleteById(int USER_ID) {
		Session session = factory.openSession();
		hotelBean hb = session.get(hotelBean.class, USER_ID);
		if (hb!=null) {
			session.delete(hb);
			session.flush();
			session.close();
		}
		session.close();
		return hb;
	}

	// 修改
	@Override
	public hotelBean updatehotel(int USER_ID, String USER_NAME, String USER_PASSWORD, String USER_IDENTITY,
			String USER_EMAIL, String USER_PHONE, String USER_BIRTHDAY, String USER_REGISTRATION){
		Session session = factory.openSession();
		hotelBean hb = session.get(hotelBean.class, USER_ID);

		System.out.println("123abc");
		if (hb!=null) {
			System.out.println("hb!=null)");
			hb.setUSER_NAME(USER_NAME);
			hb.setUSER_PASSWORD(USER_PASSWORD);
			hb.setUSER_IDENTITY(USER_IDENTITY);
			hb.setUSER_EMAIL(USER_EMAIL);
			hb.setUSER_PHONE(USER_PHONE);
			hb.setUSER_BIRTHDAY(USER_BIRTHDAY);
			hb.setUSER_REGISTRATION(USER_REGISTRATION);
			session.update(hb);
			session.flush();
		}
		session.close();
		return hb;
	}
	

	// 查詢全部
	@Override
	@Transactional
	public List<hotelBean> selecthotel(){
		Session session = factory.openSession();
		String hql = "from hotelBean";
		Query<hotelBean> query = session.createQuery(hql, hotelBean.class);

		List<hotelBean> classlist = query.getResultList();
		for (hotelBean hb : classlist) {
			System.out.println(hb);
		}
		session.close();
		return classlist;
	}

	// 查詢帳號密碼
	@Override
	public hotelBean loginhotel(String USER_EMAIL, String USER_PASSWORD){
		Session session = factory.openSession();
		String hql = "from hotelBean c where c.USER_EMAIL=:USER_EMAIL and c.USER_PASSWORD=:USER_PASSWORD";

		try {
			hotelBean result = session.createQuery(hql, hotelBean.class).setParameter("USER_EMAIL", USER_EMAIL)
					.setParameter("USER_PASSWORD", USER_PASSWORD).getSingleResult();
			session.close();
			return result;
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			session.close();
			return null;
		}

	}
}
