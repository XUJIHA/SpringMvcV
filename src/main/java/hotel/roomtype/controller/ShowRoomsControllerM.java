package hotel.roomtype.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hotel.roomtype.model.RoomsBean;
import hotel.roomtype.service.RoomTypeService;

@Controller
public class ShowRoomsControllerM {

	@Autowired
	private RoomTypeService rService;
	
	@RequestMapping(path = "/ShowAllServletM", method = RequestMethod.GET)
	public String processAction(Model m) {
		List<RoomsBean> beans = rService.findAll();
		m.addAttribute("beans", beans);
		return "roomType/ManageRoom";
	}
}
