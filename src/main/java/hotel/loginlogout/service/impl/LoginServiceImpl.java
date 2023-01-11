//package hotel.loginlogout.service.impl;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import hotel.loginlogout.dao.HotelDao;
//import hotel.loginlogout.dao.impl.HotelDaoImpl;
//import hotel.loginlogout.model.hotelBean;
//import hotel.loginlogout.service.LoginService;
//
//@Service
//@Transactional
//public class LoginServiceImpl implements LoginService{
//	@Autowired
//	private HotelDao hDao;
//	private SessionFactory factory;
//	
//	
//	// 查詢帳號密碼
//	@Override
//	public hotelBean loginhotel(String USER_EMAIL, String USER_PASSWORD) {
//		
//		try {
//			HotelDao Hdao=new HotelDaoImpl(session);
//			hotelBean hBean = Hdao.loginhotel(USER_EMAIL, USER_PASSWORD);
//			
//			if (hBean != null) {
//				session.getTransaction().commit();
//				return hBean;
//			}
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return null;
//		}
//	}
//		
//
//	// 新增
//	@Override
//	public void addhotel(String USER_NAME, String USER_PASSWORD, String USER_EMAIL ,String USER_PHONE,String USER_IDENTITY,
//			 String USER_BIRTHDAY, String USER_REGISTRATION) {
//
//		hDao = new HotelDaoImpl(session);
//		try {
//			
//			hDao.addhotel(USER_NAME, USER_PASSWORD, USER_EMAIL,  USER_PHONE, USER_IDENTITY, USER_BIRTHDAY,USER_REGISTRATION);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//
//	@Override
//	public List<hotelBean> findById(int USER_ID) {
//		List<hotelBean> list = null;
//		session = factory.getCurrentSession();
//		hDao = new HotelDaoImpl(session);
//		try {
//			session.beginTransaction();
//			list = hDao.findById(USER_ID);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return list;
//	}
//
//
//	@Override
//	public void deleteById(int USER_ID) {
//		session = factory.getCurrentSession();
//		hDao = new HotelDaoImpl(session);
//		try {
//			session.beginTransaction();
//			hDao.deleteById(USER_ID);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//	}
//
//
//	@Override
//	public void updatehotel(int USER_ID, String USER_NAME, String USER_PASSWORD, String USER_IDENTITY,
//			String USER_EMAIL, String USER_PHONE, String USER_BIRTHDAY, String USER_REGISTRATION) {
//		session = factory.getCurrentSession();
//		hDao = new HotelDaoImpl(session);
//		try {
//			session.beginTransaction();
//			hDao.updatehotel(USER_ID, USER_NAME,USER_PASSWORD, USER_IDENTITY,USER_EMAIL,USER_PHONE,USER_BIRTHDAY,USER_REGISTRATION);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		
//	}
//
//
//	@Override
//	public List<hotelBean> selecthotel() {
//		List<hotelBean> list = null;
//		session = factory.getCurrentSession();
//		hDao = new HotelDaoImpl(session);
//		try {
//			session.beginTransaction();
//			list = hDao.selecthotel();
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return list;
//	}
//}
