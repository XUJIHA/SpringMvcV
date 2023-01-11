package hotel.orderRoom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.roomtype.model.RoomsBean;
import hotel.roomtype.service.RoomTypeService;

//@WebServlet("/orderRoom/CheckRoomServlet")

@Controller
public class CheckRoomController {

	@Autowired
	private RoomTypeService rService;

//	@RequestMapping(path = "/checkroommain", method = RequestMethod.GET)
//	public String processMainAction() {
//		return "RoomDetails";
//	}

	@RequestMapping(path = "/checkroom", method = RequestMethod.GET)
	public String processAction1(@RequestParam("roomId") String roomId, Model m) {
		List<RoomsBean> roombeans = rService.findById(roomId);
		RoomsBean roombean = null;
		for (RoomsBean b : roombeans) {
			roombean = b;
		}
		m.addAttribute("roombean", roombean);
		return "orderRoom/orderCheck";
	}

	@RequestMapping(path = "/checkroom", method = RequestMethod.POST)
	public String processAction2(@RequestParam("roomId") String roomId, Model m) {
		List<RoomsBean> roombeans = rService.findById(roomId);
		RoomsBean roombean = null;
		for (RoomsBean b : roombeans) {
			roombean = b;
		}
		m.addAttribute("roombean", roombean);
		return "orderRoom/orderCheck";
	}


	

	}

