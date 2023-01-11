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
public class SearchServlet {
	
	@Autowired
	private RoomTypeService rService;
	
	@GetMapping("/SearchServlet")
	public String processSearchAction(Model m,
									  @RequestParam("selection")@Nullable String inputCapacity,
									  @RequestParam("minPrice")@Nullable String inputMinPrice,
									  @RequestParam("maxPrice")@Nullable String inputMaxPrice,
									  @RequestParam("cbStatus")@Nullable String inputStatus) {
		if (inputStatus == null) {
			if (inputMinPrice.equals("")) {
				inputMinPrice = "0";
			}
			if (inputMaxPrice.equals("")) {
				inputMaxPrice = "99999999";
			}
			int minPrice = Integer.parseInt(inputMinPrice);
			int maxPrice = Integer.parseInt(inputMaxPrice);
			List<RoomsBean> beans = null;
			int capacity = 0;
			if (inputCapacity.equals("none")) {
				beans = rService.findByPriceRange(minPrice, maxPrice);
				m.addAttribute("beans", beans);
				return "roomType/Rooms";
			} else {
				capacity = Integer.parseInt(inputCapacity);
			}
			beans = rService.findByCapacityAndPriceRange(capacity, minPrice, maxPrice);
			m.addAttribute("beans", beans);
			return "roomType/Rooms";
		} else {
			if (inputMinPrice.equals("")) {
				inputMinPrice = "0";
			}
			if (inputMaxPrice.equals("")) {
				inputMaxPrice = "99999999";
			}
			int minPrice = Integer.parseInt(inputMinPrice);
			int maxPrice = Integer.parseInt(inputMaxPrice);
			int status = Integer.parseInt(inputStatus);
			List<RoomsBean> beans = null;
			int capacity = 0;
			if (inputCapacity.equals("none")) {
				beans = rService.findByStatusAndPriceRange(status, minPrice, maxPrice);
				m.addAttribute("beans", beans);
				m.addAttribute("cbstatus", status);
				return "roomType/Rooms";
			} else {
				capacity = Integer.parseInt(inputCapacity);
				beans = rService.findByCapacityAndStatusAndPriceRange(capacity, status, minPrice, maxPrice);
			}
			m.addAttribute("beans", beans);
			m.addAttribute("cbstatus", status);
			return "roomType/Rooms";
		}
	}
}
