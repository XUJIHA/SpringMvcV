package hotel.restaurant.hibernatedemo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.restaurant.dao.RestaurantDao;
import hotel.restaurant.dao.RestaurantDaoImpl;
import hotel.restaurant.hibernatedemo.model.Arrange;
@Controller
public class SearchArrangeServlet {
	@Autowired
	RestaurantDao dao ;

	@PostMapping("/SearchArrange")
	protected String searchArr( Model m){
		System.out.println(123);
		List<Arrange> list = dao.selectArrange();

		m.addAttribute("arrange", list);
		
		return "/Restaurant/SearchArrangeAns";
 }
}
