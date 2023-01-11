package hotel.roomtype.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hotel.roomtype.service.RoomTypeService;

@Controller
public class DeleteServlet {
	
	@Autowired
	private RoomTypeService rService;
	
	@PostMapping("/DeleteServlet")
	public String processDeleteAction(Model m, @RequestParam("roomId") String roomId,
										RedirectAttributes attr) {
		int row = 0;
		row = rService.deleteById(roomId);
		attr.addFlashAttribute("row",row);
		return "redirect:SearchServletM";
	}
}