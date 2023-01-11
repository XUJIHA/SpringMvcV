package hotel.gift.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.gift.model.souvenirBean;
import hotel.gift.service.souvenirService;
import hotel.gift.service.impl.souvenirServiceImpl;

//@WebServlet("/giftMaintain/DisplayAll")
@Controller
public class DisplayAll{
	
		
		@Autowired
		private souvenirService Sservice;
		
		@RequestMapping(path ="/giftDisplay.controller", method = RequestMethod.GET)
		 public String searchAction(@ModelAttribute("souvenirBean") souvenirBean hb,Model hModel)  {
			  List<souvenirBean> classlist = Sservice.findByAll();
			  hModel.addAttribute("beans", classlist);
			  return "Gift/gift";
		 }
		@RequestMapping(path ="/giftDetail.controller/{souvenir_id}", method = RequestMethod.GET)
		 public String searchDetail(@PathVariable("souvenir_id") int id,Model hModel)  {
			souvenirBean sBean = Sservice.findById(id);
			hModel.addAttribute("bean", sBean);
			  return "Gift/giftDetail";
		 }
		

	
}