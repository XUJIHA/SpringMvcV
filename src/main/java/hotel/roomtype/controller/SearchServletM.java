package hotel.roomtype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.roomtype.model.RoomsBean;
import hotel.roomtype.service.RoomTypeService;

@Controller
public class SearchServletM {
	
	@Autowired
	private RoomTypeService rService;
	
	@GetMapping("/SearchServletM")
	public String processSearchAction (Model m, @RequestParam("selection")@Nullable String input,
												@ModelAttribute("row")	  @Nullable int row) {
		List<RoomsBean> beans = null;
		System.out.println(row + "----------------------------test");
		if (input == null || input.equals("none") || input.equals("")) {
			beans = rService.findAll();
			m.addAttribute("beans", beans);
			return "roomType/ManageRoom";
		}
		int capacity = Integer.parseInt(input);
		beans = rService.findByCapacity(capacity);
		m.addAttribute("row", row);
		m.addAttribute("beans", beans);
		m.addAttribute("selection", input);
		return "roomType/ManageRoom";
	}
}

