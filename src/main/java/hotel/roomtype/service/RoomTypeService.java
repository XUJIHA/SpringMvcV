package hotel.roomtype.service;

import java.sql.Blob;
import java.util.List;

import hotel.roomtype.model.RoomsBean;

public interface RoomTypeService {
	
	List<RoomsBean> findAll();

	List<RoomsBean> findAnyMatch(String input);

	List<RoomsBean> findById(String Id);

	List<RoomsBean> findByCapacity(int capacity);

	List<RoomsBean> findByName(String name);

	List<RoomsBean> findByStatus(int status);

	List<RoomsBean> findByCapacityAndStatus(int capacity, int status);

	List<RoomsBean> findByPriceRange(int minPrice, int maxPrice);

	List<RoomsBean> findByMinPrice(int minPrice);

	List<RoomsBean> findByMaxPrice(int maxPrice);

	List<RoomsBean> findByCapacityAndPriceRange(int capacity, int minPrice, int maxPrice);

	List<RoomsBean> findByStatusAndPriceRange(int status, int minPrice, int maxPrice);

	List<RoomsBean> findByCapacityAndStatusAndPriceRange(int capacity, int status, int minPrice, int maxPrice);

	int insertRoomType(RoomsBean bean);

	int insertRoomType(String roomId, String name, int status, int capacity, int bed, double size, int price,
			Blob img, String description, String equipment);

	int updateStatusById(String id, int status);

	int updateNameById(String id, String name);

	int updateFormById(String roomId, String name, int status, int capacity, int bed, double size, int price,
			Blob img, String description, String equipment);

	int deleteById(String id);

	
}
