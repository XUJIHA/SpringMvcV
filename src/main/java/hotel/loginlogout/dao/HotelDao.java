package hotel.loginlogout.dao;


import java.util.List;
import hotel.loginlogout.model.hotelBean;

public interface HotelDao {
//		// 新增
//		public void addhotel(String USER_NAME, String USER_PASSWORD, String USER_IDENTITY, String USER_EMAIL,
//				String USER_PHONE, String USER_BIRTHDAY, String USER_REGISTRATION);
	
		public hotelBean addhotel(hotelBean hBean);

		// 透過id拿資料
		public List<hotelBean> findById(int USER_ID);

		// 刪除
		public hotelBean deleteById(int USER_ID);

		// 修改
		public hotelBean updatehotel(int USER_ID, String USER_NAME, String USER_PASSWORD, String USER_IDENTITY,
				String USER_EMAIL, String USER_PHONE, String USER_BIRTHDAY, String USER_REGISTRATION);

		// 查詢全部
		public List<hotelBean> selecthotel();

		// 查詢帳號密碼
		public hotelBean loginhotel(String USER_EMAIL, String USER_PASSWORD);

}
