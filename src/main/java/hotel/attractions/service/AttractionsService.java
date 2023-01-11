package hotel.attractions.service;

import java.util.List;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hotel.attractions.model.AttractionsBean;
import hotel.attractions.model.IAttractionsDao;

@Service
@Transactional
public class AttractionsService implements IAttractionsService{
	
	@Autowired
	private IAttractionsDao aDao;
	
	@Override
	public AttractionsBean findById(int id) {
		return aDao.findById(id);
	}
	
	@Override
	public List<AttractionsBean> findAll(){
		return aDao.findAll();
	}
	
	@Override
	public List<AttractionsBean> likeSearch(String search) {
		return aDao.likeSearch(search);
	}
	
	@Override
	public AttractionsBean save(AttractionsBean bean) {
		return aDao.save(bean);
	}
	
	@Override
	public AttractionsBean updateAttractions(AttractionsBean bean) {
		return aDao.updateAttractions(bean);
	}
	
	@Override
	public boolean deleteById(int id) {
		return aDao.deleteById(id);
	}
}
