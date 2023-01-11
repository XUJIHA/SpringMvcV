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
import hotel.restaurant.hibernatedemo.model.Restaurant;
//用種類找餐廳
@Controller
public class SearchRestaurantServletbytype  {
	@Autowired	
	RestaurantDao res1 ;
	@PostMapping("/SearchRestype")
	protected String searchResType(@RequestParam("resturanttype")@Nullable String type, Model m)  {
		String resturanttype = type;
		System.out.println(resturanttype);
		 String error = "不能輸入空白";
			if (type == "") {
				m.addAttribute("nullError3", error);
				
				return "/Restaurant/Search";
			}
		  
		List<Restaurant> list =  res1.SearchResType(resturanttype);
		m.addAttribute("resturant", list);
		
		return "/Restaurant/SearchbyidAns";}
}