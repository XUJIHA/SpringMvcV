package hotel.attractions.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hotel.attractions.model.AttractionsBean;
//import hotel.attractions.model.Picture;
import hotel.attractions.service.IAttractionsService;
//import hotel.attractions.service.PictureService;

@Controller
public class AttractionsController {
	
	@Autowired
	private IAttractionsService aService;

	@RequestMapping(path = "/addattractions", method = RequestMethod.GET)
	public String processMainAction() {
		return "attractions/attractionsInsert";
	}
	
	@RequestMapping(path = "/editattractions", method = RequestMethod.GET)
	public String processUpdateAction() {
		return "attractions/attractionsUpdate";
	}
	
	@RequestMapping(path = "/searchattractions", method = RequestMethod.GET)
	public String processShowAllAction(Model m) {
		List<AttractionsBean> list = aService.findAll();
		m.addAttribute("aBean", list);
		return "attractions/attractionsList";
	}
	
	@RequestMapping(path = "/likesearchattractions", method = RequestMethod.POST)
	public String processLikeSearchAction(@RequestParam("search") String search, Model m) {
		List<AttractionsBean> list = aService.likeSearch(search);
		m.addAttribute("aBean", list);
		return "attractions/attractionsList";
	}
	
	@RequestMapping(path = "/deleteattractions", method = RequestMethod.POST)
	public String processDeleteAction(@RequestParam("id") int id) {
		System.out.println("id"+id);
		 aService.deleteById(id);
		 return "attractions/attractionsList";
	}
	
	@RequestMapping(path = "/edit", method = RequestMethod.GET)
	public String processGetIdAction(@RequestParam("id") int id, Model m) {
		AttractionsBean ab = aService.findById(id);
		m.addAttribute("aBean", ab);
		return "attractions/attractionsUpdate";
	}
	
	@RequestMapping(path = "/checkadd", method = RequestMethod.POST)
	public String processAction(@RequestParam("name") String name, @RequestParam("address") String address, 
			@RequestParam("serviceHour") String serviceHour, @RequestParam("serviceHour2") String serviceHour2, 
			@RequestParam("introduction") String introduction, @RequestParam("phone") String phone, 
			@RequestParam("file1") MultipartFile mf, Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if(name==null || name.trim().length()==0) {
			errors.put("name", "景點名稱必須輸入");
		}
		
		if(address==null || address.trim().length()==0) {
			errors.put("address", "地址必須輸入");
		}
		
		if((serviceHour == null || serviceHour.trim().length() == 0)||(serviceHour2 == null || serviceHour2.trim().length() == 0)) {
			errors.put("serviceHour", "營業時間必須輸入");
		}
		
		if(introduction == null || introduction.trim().length() == 0) {
			errors.put("introduction", "介紹必須輸入");
		}
		
		if(phone.trim().length() < 7 || phone.trim().length() == 0) {
			errors.put("phone", "電話格式錯誤");
		}
		
		String fileName = mf.getOriginalFilename();
		byte[] b;
		
		if(!errors.isEmpty()) {
			return "attractions/attractionsInsert";
		}
		try {
			b = mf.getBytes();
//			if(fileName != null && fileName.length() != 0) {
//				savePicture(fileName, b);
//			}
			AttractionsBean ab = new AttractionsBean(name, address, serviceHour, serviceHour2, introduction, phone, b, fileName);
			if(ab != null) {
				aService.save(ab);
				m.addAttribute("aBean", ab);
				return "redirect: searchattractions";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "attractions/attractionsInsert";
	}
	
	@RequestMapping(path = "/checkedit", method = RequestMethod.POST)
	public String processEditAction(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("address") String address, 
			@RequestParam("serviceHour") String serviceHour, @RequestParam("serviceHour2") String serviceHour2, 
			@RequestParam("introduction") String introduction, @RequestParam("phone") String phone, 
			@RequestParam("file1") MultipartFile mf, Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		if(name==null || name.trim().length()==0) {
			errors.put("name", "景點名稱必須輸入");
		}
		
		if(address==null || address.trim().length()==0) {
			errors.put("address", "地址必須輸入");
		}
		
		if((serviceHour == null || serviceHour.trim().length() == 0)||(serviceHour2 == null || serviceHour2.trim().length() == 0)) {
			errors.put("serviceHour", "營業時間必須輸入");
		}
		
		if(introduction == null || introduction.trim().length() == 0) {
			errors.put("introduction", "介紹必須輸入");
		}
		
		if(phone.trim().length() < 7 || phone.trim().length() == 0) {
			errors.put("phone", "電話格式錯誤");
		}
		
		String fileName = mf.getOriginalFilename();
		byte[] b;
		if(!errors.isEmpty()) {
			return "attractions/attractionsUpdate";
		}
		try {
			long size = fileName.length();
			if(fileName != null && size != 0) {
				b = mf.getBytes();
//				savePicture(fileName, b);
			}else {
				AttractionsBean bean = aService.findById(id);
				b = bean.getImage1();
			}
			AttractionsBean ab = new AttractionsBean(id, name, address, serviceHour, serviceHour2, introduction, phone, b, fileName);
			if(ab != null) {
				aService.updateAttractions(ab);
				m.addAttribute("aBean", ab);
				return "redirect: searchattractions";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "attractions/attractionsUpdate";
	}
	
//	@Autowired
//	private PictureService pService;
//	
//	private void savePicture(String fileName, byte[] b) {
//		Picture p1 = new Picture(fileName, b);
//		pService.insert(p1);
//	}
	
	@RequestMapping(path = "/file", method = RequestMethod.GET)
	@ResponseBody
	public byte[] processGetImageAction(@RequestParam("id") int id) throws IOException {
		AttractionsBean bean = aService.findById(id);
		byte[] b = bean.getImage1();
		
		return b;
	}
	
}
