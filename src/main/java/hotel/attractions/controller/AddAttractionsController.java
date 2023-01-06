package hotel.attractions.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import hotel.attractions.model.AttractionsBean;
import hotel.attractions.model.Picture;
import hotel.attractions.service.AttractionsService;
import hotel.attractions.service.PictureService;

@Controller
public class AddAttractionsController {
	
	@Autowired
	private AttractionsService aService;

	@RequestMapping(path = "addattractionsmain", method = RequestMethod.GET)
	public String processMainAction() {
		return "AddAttractionsForm";
	}
	
	@RequestMapping(path = "attractionsList", method = RequestMethod.GET)
	public String processShowAllAction(Model m) {
		List<AttractionsBean> list = aService.findAll();
		m.addAttribute("aBean", list);
		return "AttractionsList";
	}
	
	@RequestMapping(path = "editAttractions", method = RequestMethod.POST)
	public String processEditAction() {
		return "EditAttractions";
	}
	
	@RequestMapping(path = "checkadd", method = RequestMethod.POST)
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
			return "AddAttractionsForm";
		}
		try {
			b = mf.getBytes();
			if(fileName != null && fileName.length() != 0) {
				savePicture(fileName, b);
			}
			AttractionsBean ab = new AttractionsBean(name, address, serviceHour, serviceHour2, introduction, phone, b, fileName);
//			if(ab != null) {
				aService.save(ab);
				m.addAttribute("aBean", ab);
				return "AttractionsList";
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "AddAttractionsForm";
	}
	
//	@PutMapping("/profiles/{pid}")
//	@ResponseBody
//	public String processUpdateAction(@PathVariable("pid") int pid,@RequestParam("userName") String userName, @RequestParam("userAddress") String userAddress, 
//            @RequestParam("userPhone") String userPhone) {
//		
//		Profiles p2 = new Profiles(pid, userName, userAddress, userPhone);
//		pService.update(p2);
//		return "Update Ok";
//	}
	
	@RequestMapping(path = "checkEdit", method = RequestMethod.POST)
	public String processEditAction(@RequestParam("id") int id,@RequestParam("name") String name, @RequestParam("address") String address, 
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
			return "EditAttractions";
		}
		try {
			b = mf.getBytes();
			if(fileName != null && fileName.length() != 0) {
				savePicture(fileName, b);
			}
			AttractionsBean ab = new AttractionsBean(name, address, serviceHour, serviceHour2, introduction, phone, b, fileName);
			if(ab != null) {
				aService.updateAttractions(ab);
				m.addAttribute("aBean", ab);
				return "AttractionsList";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "EditAttractions";
	}
	
	@Autowired
	private PictureService pService;
	
	private void savePicture(String fileName, byte[] b) {
		Picture p1 = new Picture(fileName, b);
		pService.insert(p1);
	}
	
	@PostMapping(path ="file", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processAction(@RequestParam("id") int id,@RequestParam("file1") MultipartFile mf) throws IOException {
		AttractionsBean bean = aService.findById(id);
		byte[] b = bean.getImage1();
//		String fileName = mf.getOriginalFilename();
//		System.out.println("fileName1: " + fileName);
		
//		String saveFileDir = "c:/temp/upload/";
//		File saveFilePath = new File(saveFileDir, fileName);
		
//		byte[] b = mf.getBytes();
//		mf.transferTo(saveFilePath);
		
//		if(fileName != null && fileName.length() != 0) {
//			savePicture(fileName, b);
//		}
		System.out.println("b"+b);
		return b;
	}
}
