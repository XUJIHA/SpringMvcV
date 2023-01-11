package hotel.roomtype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RoomJspMainController {
	@RequestMapping(path = "/showroom.controller", method = RequestMethod.GET)
	public String processShowRoomAction(Model m) {
		return "redirect:ShowAllServlet";
	}
	@RequestMapping(path = "/insertroommain", method = RequestMethod.GET)
	public String processShowInsertAction(Model m) {
		return "roomType/InsertRoom";
	}
}
