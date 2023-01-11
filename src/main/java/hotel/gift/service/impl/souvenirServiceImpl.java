package hotel.gift.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.gift.dao.souvenirDao;
import hotel.gift.model.souvenirBean;
import hotel.gift.service.souvenirService;


@Service
@Transactional
public class souvenirServiceImpl implements souvenirService {
	
//	private SessionFactory factory;
//	private Session session;
	@Autowired
	private souvenirDao sDao;

	public souvenirServiceImpl() {
//		factory = HibernateUtil.getSessionFactory();
	}


	public souvenirBean findById(int souvenir_id) {
//		session = factory.getCurrentSession();
//		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
//			session.beginTransaction();
//			souvenirBean sBean = souvenirDao.findById(souvenir_id);
//			session.getTransaction().commit();
//			return sBean;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return null;
		return sDao.findById(souvenir_id);
	}
	@Override
	public List<souvenirBean> findByAll() {
		return sDao.findByAll();
	}


	@Override
	public void deleteById(int souvenir_id) {
//		session = factory.getCurrentSession();
//		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
//			session.beginTransaction();
//			souvenirDao.deleteById(souvenir_id);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
		sDao.deleteById(souvenir_id);
//		return sDao.deleteById(souvenir_id);
	}


	@Override
	public souvenirBean save(souvenirBean bean) {
//		session = factory.getCurrentSession();
//		
//		try {
//			session.beginTransaction();
//			souvenirDao = new souvenirDaoImpl_Jdbc(session);
//			souvenirDao.save(bean);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
		return sDao.save(bean);
	}


	@Override
	public int updateSouvenir(souvenirBean bean, long sizeInBytes) {
//		session = factory.getCurrentSession();
//		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
//			session.beginTransaction();
//			souvenirDao.updateSouvenir(bean, sizeInBytes);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return 0;
//		}
		return 1;
	}


//	@Override
//	public int updateSouvenir(Integer souvenir_id, String souvenir_no, String souvenir_name, Blob souvenir_pic,
//			String fileName, String souvenir_des, double souvenir_price, String souvenir_num) {
//		session = factory.getCurrentSession();
//		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
//			session.beginTransaction();
//			souvenirDao.updateSouvenir(souvenir_id, souvenir_no, souvenir_name, souvenir_pic, fileName, souvenir_des, souvenir_price, souvenir_num);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return 0;
//		}
//		return 1;
//	}
//	@Override
	public souvenirBean updateSouvenir(souvenirBean bean) {
//		session = factory.getCurrentSession();
//		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
//			session.beginTransaction();
//			if (sizeInBytes == -1) { // 不修改圖片
//				souvenirDao.updateSouvenir(bean);
//			}else {
//				souvenirDao.updateSouvenir(bean,sizeInBytes);
//			}
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//			return 0;
//		}
		return sDao.updateSouvenir(bean);
	}
//	public int updateSouvenir(souvenirBean bean) {
////		session = factory.getCurrentSession();
////		souvenirDao = new souvenirDaoImpl_Jdbc(session);
//		try {
////			session.beginTransaction();
//			souvenirDao.updateSouvenir(bean);
////			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
////			session.getTransaction().rollback();
//			return 0;
//		}
//		return 1;
//	}


	@Override
	public int getTotalPages() {
//		session = factory.getCurrentSession();
//		try {
//			session.beginTransaction();
//			souvenirDao.getTotalPages();
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
		return sDao.getTotalPages();
		 
	}


	


	



	

}

