package hotel.gift.dao.impl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hotel.gift.dao.souvenirDao;
import hotel.gift.model.souvenirBean;

//public class souvenirDaoImpl_Jdbc  {
@Repository
@Transactional
public class souvenirDaoImpl_Jdbc implements souvenirDao {
	@Autowired
	private SessionFactory factory;
//	private Session session;
	public static final int recordsPerPage = 3; // 預設值：每頁三筆
	private int totalPages = -1;
	
	public souvenirDaoImpl_Jdbc() {
		
	}
//	public souvenirDaoImpl_Jdbc(Session session) {
////		this.session = session;
////		Session session = factory.openSession();
//	}
	//showAll
	@Override
	public List<souvenirBean> findByAll() {
		
		String hql = "from souvenirBean";
		Session session = factory.openSession();
		Query<souvenirBean> query = session.createQuery(hql,souvenirBean.class);
		
		List<souvenirBean> list = query.getResultList();
		session.close();
		return list;
	}
	//deleteById
	@Transactional
	@Override
	public void deleteById(int souvenir_id) {
		Session session = factory.openSession();
		souvenirBean bean = session.get(souvenirBean.class, souvenir_id);
		session.delete(bean);
		session.flush();
		session.close();
		
	}
	//findById
	@Override
	public souvenirBean findById(int souvenir_id) {
//		String hql = "from souvenirBean where souvenir_id like :id";
//		return  session.get(souvenirBean.class, souvenir_id);
		Session session = factory.openSession();
		souvenirBean resultBean = session.get(souvenirBean.class, souvenir_id);
		session.close();
		return resultBean;
	}
	//insert into DB
	@Override
	public souvenirBean save(souvenirBean bean) {
		Session session = factory.openSession();
		if(bean != null) {
			session.save(bean);
		}
		session.close();
		return bean;
	}
	//update all 
	@Override
	public int updateSouvenir(souvenirBean bean, long sizeInBytes) {
//		Integer souvenir_id = bean.getSouvenir_id();
//		souvenirBean sBean = session.get(souvenirBean.class,souvenir_id);
//		if (sizeInBytes == -1) { // 不修改圖片
//			updateSouvenir(bean);
//		}
//		sBean.setSouvenir_name(bean.getSouvenir_name());
//		sBean.setSouvenir_no(bean.getSouvenir_no());
//		sBean.setSouvenir_price(bean.getSouvenir_price());
//		sBean.setSouvenir_des(bean.getSouvenir_des());
//		sBean.setSouvenir_num(bean.getSouvenir_num());
//		sBean.setSouvenir_pic(bean.getSouvenir_pic());
//		sBean.setFileName(bean.getFileName());
//		session.update(sBean);
		
//		Session session = factory.openSession();
//		if (sizeInBytes == -1) { // 不修改圖片
//			updateSouvenir(bean);
//		}
//		session.update(bean);
//		session.flush();
		return 1;
	}
	//update all expect pic
	//2023/1/8 -> update ALL
	public souvenirBean updateSouvenir(souvenirBean sBean) {

		Session session = factory.openSession();
//		
//		Integer souvenir_id = sBean.getSouvenir_id();
//		souvenirBean bean = session.get(souvenirBean.class, souvenir_id);
//		sBean.setSouvenir_name(bean.getSouvenir_name());
//		sBean.setSouvenir_no(bean.getSouvenir_no());
//		sBean.setSouvenir_price(bean.getSouvenir_price());
//		sBean.setSouvenir_des(bean.getSouvenir_des());
//		sBean.setSouvenir_num(bean.getSouvenir_num());
//		sBean.setSouvenir_pic(bean.getSouvenir_pic());
//		String no ="123";
//		bean.setSouvenir_no(no);
		System.out.println("sBean:---------------------------------------------------"+sBean);
		if(sBean != null) {
//			session.clear();
			session.update(sBean);
			session.flush();
		}
		session.close();
		
		return sBean;
	}
	
	@Override
	public int getTotalPages() {
		// 注意下一列敘述的每一個型態轉換
		totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));
		return totalPages;
	}
	@Override
	public long getRecordCounts() {
		// TODO Auto-generated method stub
		return 0;
	}


}