package hotel.restaurant.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import hotel.restaurant.hibernatedemo.model.Arrange;
import hotel.restaurant.hibernatedemo.model.Restaurant;
@Transactional
public interface RestaurantDao {
	
	
	public  boolean checkRes(int id) ;
		
	public void AddRestautant(Restaurant resBean);
	
	public void DeleteRestaurant(Integer id);
	
	public void RewriteRestaurant(Restaurant resBean);
	
	public List<Restaurant> SearchRestaurant(int id) ;
	
	public List<Restaurant> selectAll();
	
	public List<Restaurant> SearchResAddress(String resturantaddress);
	 
	public List<Restaurant> SearchResName(String resturantname); 
	
	public List<Restaurant> SearchResType(String resturanttype);
	
	public void AddArrange(Arrange arr);
	
	public void DeleteArrange(int id);
	
	public void RewriteArrange(Arrange arrBean) ;
	
	public List<Arrange> selectArrange();
	
	public List<Arrange> selectArrangeName(String name);
	
	public List<Arrange> selectArrangeResid(int resid);
	
	public List<Arrange> selectArrangePhone(String phone);
	
	public boolean checkArr(int id);

	public boolean checkArrangeResid(int resid);
}
