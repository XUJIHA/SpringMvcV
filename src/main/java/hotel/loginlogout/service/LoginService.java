package hotel.loginlogout.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.loginlogout.dao.HotelDao;
import hotel.loginlogout.model.hotelBean;
import hotel.loginlogout.service.impl.LoginService1;

@Service
@Transactional
public class LoginService implements LoginService1{
	
	@Autowired 
	private HotelDao hDao;

	// 查詢帳號密碼
	public hotelBean loginhotel(String USER_EMAIL, String USER_PASSWORD) {
		return hDao.loginhotel(USER_EMAIL, USER_PASSWORD);
	};

//	// 新增
//	public void addhotel(String USER_NAME, String USER_PASSWORD, String USER_EMAIL ,String USER_PHONE,String USER_IDENTITY,
//			 String USER_BIRTHDAY, String USER_REGISTRATION) {
//	};
	
	public hotelBean addhotel(hotelBean hBean) {
		return hDao.addhotel(hBean);
	};

	// 透過id拿資料
	public List<hotelBean> findById(int USER_ID){
		return hDao.findById(USER_ID);	
	};

	// 刪除
	public hotelBean deleteById(int USER_ID) {
		return hDao.deleteById(USER_ID);
	};

	// 修改
	public hotelBean updatehotel(int USER_ID, String USER_NAME, String USER_PASSWORD, String USER_IDENTITY,
			String USER_EMAIL, String USER_PHONE, String USER_BIRTHDAY, String USER_REGISTRATION) {	
		return hDao.updatehotel(USER_ID, USER_NAME, USER_PASSWORD, USER_IDENTITY, USER_EMAIL, USER_PHONE, USER_BIRTHDAY, USER_REGISTRATION);	
	};

	// 查詢全部
	public List<hotelBean> selecthotel(){
		return hDao.selecthotel();	
	};

}
