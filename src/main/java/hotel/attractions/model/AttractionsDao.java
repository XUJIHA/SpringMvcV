package hotel.attractions.model;

import java.util.List;
//import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AttractionsDao implements IAttractionsDao{
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public AttractionsBean findById(int id) {
		Session session = factory.openSession();
		
		AttractionsBean aBean = session.get(AttractionsBean.class, id);
		session.close();
		return aBean;
		
	}
	
	@Override
	public List<AttractionsBean> findAll() {
		Session session = factory.openSession();
		
		String hql = "from AttractionsBean";
		
		try {
			List<AttractionsBean> result = session.createQuery(hql, AttractionsBean.class)
					.getResultList();
//			for (AttractionsBean attractionsBean : result) {
//			System.out.println(attractionsBean);
//			}
			return result;
		}catch(NoResultException | NonUniqueResultException e){
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<AttractionsBean> likeSearch(String search) {
		Session session = factory.openSession();
		
		String hql = "from AttractionsBean where name like :n or address like :a or introduction like :i or phone like :p";
		Query<AttractionsBean> query = session.createQuery(hql, AttractionsBean.class)
				.setParameter("n", "%" + search + "%")
				.setParameter("a", "%" + search + "%")
				.setParameter("i", "%" + search + "%")
				.setParameter("p", "%" + search + "%");
//			System.out.println("query" + query);
		List<AttractionsBean> resultList = query.getResultList();
//			System.out.println("resultList" + resultList);
//			for (AttractionsBean attractions : resultList) {
//				System.out.println(attractions);
//			}
		session.close();
		return resultList;
	}
	
	@Override
	public AttractionsBean save(AttractionsBean bean) {
		Session session = factory.openSession();
		
		if(bean != null) {
			session.save(bean);
		}
		
		session.close();
		return bean;
	}
	
	@Override
	public AttractionsBean updateAttractions(AttractionsBean bean) {
		Session session = factory.openSession();
		
		if(bean != null) {
			session.update(bean);
			session.flush();
		}
		
		session.close();
		
		return bean;
		}
	
	@Override
	public boolean deleteById(int id) {
		Session session = factory.openSession();
		
		AttractionsBean aBean = session.get(AttractionsBean.class, id);
		
		if(aBean != null) {
			session.delete(aBean);
			session.flush();
			session.close();
			
			return true;
		}else {
			session.close();
			
			return false;
		}
	}
	
}
