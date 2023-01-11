package hotel.roomtype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.roomtype.model.RoomsBean;
import hotel.roomtype.service.RoomTypeService;

@Controller
public class SearchServletM2 {
	
	@Autowired
	private RoomTypeService rService;
	
	@GetMapping("/SearchServletM2")
	public String processSearchActionM(Model m, @RequestParam("findInput")@Nullable String input) {
		List<RoomsBean> beans = null;
		beans = rService.findAnyMatch(input);
		m.addAttribute("beans", beans);
		return "roomType/ManageRoom";
	}
}
