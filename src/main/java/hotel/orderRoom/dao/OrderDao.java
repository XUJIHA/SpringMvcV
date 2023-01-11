package hotel.orderRoom.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hotel.orderRoom.model.OrderBean;
import hotel.orderRoom.model.OrderDetailsBean;

@Repository
@Transactional
public class OrderDao {
	@Autowired
	private SessionFactory sessionFactory;

	public OrderBean InsertOrder(OrderBean obean) {
		Session session = sessionFactory.openSession();
		session.save(obean);
		session.close();
		return obean;
	}

	public OrderDetailsBean InsertOrderDetails(OrderDetailsBean odbean) {
		Session session = sessionFactory.openSession();
		session.save(odbean);
		session.close();
		return odbean;
	}

	public List<OrderBean> searchOrder() {
		Session session = sessionFactory.openSession();
		String hql = "from OrderBean o WHERE o.canceltag is null";
		List<OrderBean> result = session.createQuery(hql, OrderBean.class).getResultList();
		session.close();
		return result;
	}

//	public List<OrderDetailsBean> searchOrderDetails() {
//		Session session = factory.getCurrentSession();
//		Query<OrderDetailsBean> query = session.createQuery("from OrderDetailsBean", OrderDetailsBean.class);
//
////    	query.list();
//		List<OrderDetailsBean> result = query.getResultList();
//
//		return result;
//	}

	public OrderBean findByIdforOrder(int id) {
		Session session = sessionFactory.openSession();
		OrderBean orderBean = session.get(OrderBean.class, id);
		session.close();
		return orderBean;

	}

	public OrderDetailsBean findByIdforDetails(int id) {
		Session session = sessionFactory.openSession();
		OrderDetailsBean orderDetailsBean = session.get(OrderDetailsBean.class, id);
		session.close();
		return orderDetailsBean;
	}

	public int CancelOrder(int orderid) {
		Session session = sessionFactory.openSession();
		OrderBean obean = session.get(OrderBean.class, orderid);
		obean.setCanceltag(1);
		session.flush();
		session.close();
		return 1;
	}

	public int modifyOrderDetails(int detailid, OrderDetailsBean odb) {
		Session session = sessionFactory.openSession();

		OrderDetailsBean odbean = session.get(OrderDetailsBean.class, detailid);

		if (odbean != null) {
			odbean.setUseremail(odb.getUseremail());
			odbean.setUserphone(odb.getUserphone());
			odbean.setAdults(odb.getAdults());
			odbean.setCompany(odb.getCompany());
			odbean.setChildren(odb.getChildren());
			odbean.setNotes(odb.getNotes());
		}
		session.flush();
		session.close();
		return 1;
	}

	public int modifyOrder(int orderid, OrderBean ob) {
		Session session = sessionFactory.openSession();

		OrderBean orderbean = session.get(OrderBean.class, orderid);

		orderbean.setUsername(ob.getUsername());
		orderbean.setCheckindate(ob.getCheckindate());
		orderbean.setCheckoutdate(ob.getCheckoutdate());
		orderbean.setRoomname(ob.getRoomname());
		orderbean.setRoomprice(ob.getRoomprice());
		session.flush();
		session.close();
		return 1;
	}
	
	public Date searchCheckindate(String roomname) {
		Session session = sessionFactory.openSession();
		OrderBean obean = session.get(OrderBean.class, roomname);
		Date checkindate=obean.getCheckindate();
		session.close();
		return checkindate;	
	}
	public Date searchCheckoutdate(String roomname) {
		Session session = sessionFactory.openSession();
		OrderBean obean = session.get(OrderBean.class, roomname);
		Date checkoutdate=obean.getCheckoutdate();
		session.close();
		return checkoutdate;	
	}
}
