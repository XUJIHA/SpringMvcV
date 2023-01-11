package hotel.orderRoom.service;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotel.orderRoom.dao.OrderDao;
import hotel.orderRoom.model.OrderBean;
import hotel.orderRoom.model.OrderDetailsBean;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDao oDao;

	public OrderBean InsertOrder(OrderBean obean) {
		return oDao.InsertOrder(obean);
	}

	public OrderDetailsBean InsertOrderDetails(OrderDetailsBean odbean) {
		return oDao.InsertOrderDetails(odbean);
	}

	public List<OrderBean> searchOrder() {
		return oDao.searchOrder();
	}

	public OrderBean findByIdforOrder(int id) {
		return oDao.findByIdforOrder(id);
	}

	public OrderDetailsBean findByIdforDetails(int id) {
		return oDao.findByIdforDetails(id);
	}

	public int CancelOrder(int orderid) {
		return oDao.CancelOrder(orderid);
	}

	public int modifyOrderDetails(int detailid, OrderDetailsBean odb) {
		return oDao.modifyOrderDetails(detailid, odb);
	}

	public int modifyOrder(int orderid, OrderBean ob) {
		return oDao.modifyOrder(orderid, ob);
	}
	public Date searchCheckindate(String roomname) {
		return oDao.searchCheckindate(roomname);
	}
	public Date searchCheckoutdate(String roomname) {
		return oDao.searchCheckoutdate(roomname);
	}
	
}
