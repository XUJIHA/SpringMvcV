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
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.restaurant.dao.RestaurantDao;
import hotel.restaurant.dao.RestaurantDaoImpl;
import hotel.restaurant.hibernatedemo.model.Arrange;

@Controller
public class DeleteRestaurantServletbyid  {

	@Autowired
	RestaurantDao dao ;

	@PostMapping("/DeleteRestaurantServletbyid")
	protected String DeleteRes(@RequestParam("restaurantid")@Nullable String id,Model m) {
		
		String error = "不能輸入空白";
		String inputId = id;
		if (id == "") {
			m.addAttribute("nullError1", error);
			
			return "/Restaurant/DeleteRes";
		}
		
		int id2 = Integer.parseInt(id);
		boolean checkRes = dao.checkRes(id2);
		if (checkRes==true) {
			m.addAttribute("nullError9", "編號不存在");
			
			return "/Restaurant/DeleteRes";
		}
		
		int id3 = Integer.parseInt(inputId);
		boolean checkResult = dao.checkArrangeResid(id3);
		if(checkResult==true) {
			m.addAttribute("nullError10", "此餐廳底下尚有訂單");
			
			return "/Restaurant/DeleteRes";
			
		}

		dao.DeleteRestaurant(id2);
		m.addAttribute("success", 1);
		
		return "/Restaurant/DeleteRes";

	}
}
