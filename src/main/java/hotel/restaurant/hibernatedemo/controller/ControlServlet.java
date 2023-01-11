package hotel.restaurant.hibernatedemo.controller;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.restaurant.dao.RestaurantDao;
import hotel.restaurant.dao.RestaurantDaoImpl;
import hotel.restaurant.hibernatedemo.model.Arrange;
import hotel.restaurant.hibernatedemo.model.Restaurant;

@Controller
public class ControlServlet  {
	
	@Autowired
	private  RestaurantDao dao ;
	
	@PostMapping("/ControlServlet")
//	@RequestMapping(path ="/Team3/jsp01/ControlServlet", method = RequestMethod.POST)
	protected String controll(@RequestParam("id") String id, Model m) {


		

		if (id.equals("1")) {
			List<Restaurant> list = dao.selectAll();
			m.addAttribute("resturant", list);
			return "/Restaurant/AddRestaurant";

		} else if (id.equals("2")) {
			List<Restaurant> list = dao.selectAll();
			m.addAttribute("resturant", list);
			return "/Restaurant/DeleteRes";

		} else if (id.equals("3")) {
			List<Restaurant> list = dao.selectAll();
			m.addAttribute("resturant", list);
			return "/Restaurant/RewriteRestaurant";

		} else if (id.equals("4")) {
			List<Restaurant> list = dao.selectAll();
			m.addAttribute("resturant", list);
			return "/Restaurant/Search";

		} else if (id.equals("5")) {
			List<Arrange> list = dao.selectArrange();
			m.addAttribute("arrange", list);
			return "/Restaurant/AddArrange";

		} else if (id.equals("6")) {
			List<Arrange> list = dao.selectArrange();
			m.addAttribute("arrange", list);
			return "/Restaurant/DeleteArrange";

		} else if (id.equals("7")) {
			List<Arrange> list = dao.selectArrange();
			m.addAttribute("arrange", list);
			return "/Restaurant/RewriteArrange";

		} else {
			List<Arrange> list = dao.selectArrange();
			m.addAttribute("arrange", list);
			return "/Restaurant/SearchArrange";

		}
	}
}
