package hotel.gift.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import hotel.gift.model.souvenirBean;
import hotel.gift.service.souvenirService;

@Controller
public class giftBackEnd {
	
	@Autowired
	private souvenirService sService;
	
	//顯示圖片
	@RequestMapping("/getSouImage/{souvenir_id}")
    @ResponseBody
    public byte[] processByteArrayImageAction(@PathVariable("souvenir_id") int souvenir_id,HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

		souvenirBean sBean = (souvenirBean) sService.findById(souvenir_id);
        Blob pBlob =sBean.getSouvenir_pic();
        InputStream inputStream = pBlob.getBinaryStream();

        return IOUtils.toByteArray(inputStream);
    }
	
	//後臺顯示所有商品
	@GetMapping(path = "/maintainGift.controller")
	public String displayAllGift(@ModelAttribute("souvenirBean") souvenirBean sBean,Model hModel){
		List<souvenirBean> claassList = sService.findByAll();
		hModel.addAttribute("beans",claassList);
		return "Gift/giftMaintain";
	}
	
	//後臺新增商品
	@GetMapping("/giftpreinsert.controller")
	public String giftPreInsert() {
		return "Gift/giftInsert";
	}
	
	@RequestMapping(path = "/giftInsert.controller",method = RequestMethod.POST)
	public String giftInsert(@RequestParam("souvenir_no")String souvenir_no ,@RequestParam("souvenir_name")String souvenir_name,
			@RequestParam("souvenir_pic")MultipartFile souvenir_pic,@RequestParam("souvenir_des")String souvenir_des,
			@RequestParam("souvenir_price")double souvenir_price,@RequestParam("souvenir_num") String souvenir_num) {
		try {
			String fileName = souvenir_pic.getOriginalFilename();
			byte[] bytes = souvenir_pic.getBytes();
			Blob img = null;
			if(bytes.length == 0) {
				
			}else {
				img = new SerialBlob(bytes);
			}
			souvenirBean s1 = new souvenirBean(souvenir_no,souvenir_name,img,souvenir_des,souvenir_price,souvenir_num);
			sService.save(s1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/maintainGift.controller";
	}
	//後臺修改商品
	@RequestMapping(path = "/giftPreupdate.controller/{souvenir_id}",method = RequestMethod.GET)
    public String giftPreupdate(@PathVariable("souvenir_id") int id,Model theModel) {
		System.out.println("giftPreupdate.controller");
		souvenirBean sBean = sService.findById(id);
        theModel.addAttribute("bean", sBean);
        return "Gift/giftUpdate";
    }
	
//	@PutMapping("/updateGift/{souvenir_id}") 
//	@ResponseBody
//	@RequestMapping(path="/updateGift",method = RequestMethod.POST)
	
	
//	public String giftUpdate(@PathVariable("souvenir_id") int id,@RequestParam("souvenir_no")String souvenir_no ,@RequestParam("souvenir_name")String souvenir_name,
//			@RequestParam("souvenir_pic")MultipartFile img,@RequestParam("souvenir_des")String souvenir_des,
//			@RequestParam("souvenir_price")double souvenir_price,@RequestParam("souvenir_num") String souvenir_num,Model sm) throws IOException, SerialException, SQLException {
//	@GetMapping(path="/updateGift/{souvenir_id}")
	@PostMapping(path="/updateGift/{souvenir_id}")
	public String giftUpdate(@PathVariable("souvenir_id") int souvenir_id,@RequestParam("souvenir_no")String souvenir_no,@RequestParam("souvenir_name")String souvenir_name,
			@RequestParam("souvenir_pic")MultipartFile img,@RequestParam("souvenir_des")String souvenir_des,
			@RequestParam("souvenir_price")double souvenir_price,@RequestParam("souvenir_num") String souvenir_num) throws IOException, SerialException, SQLException {
		System.out.println("----------------");
		souvenirBean s2 = sService.findById(souvenir_id);
//		souvenirBean sBean = new souvenirBean();
//		sService.findById(souvenir_id);
//		byte[] bytes = img.getBytes();
//		Blob newimg = new SerialBlob(bytes);
//		souvenirBean newBean = new souvenirBean();
//		String no = s2.getSouvenir_no();
//				
//		String name = s2.getFileName();
//		Blob pic = s2.getSouvenir_pic();
//		String des = s2.getSouvenir_des();
//		Double price = s2.getSouvenir_price();
//		String num = s2.getSouvenir_num();
//		@Column(name = "souvenir_num")
//		private String souvenir_num;
//		String noString ="003";
		s2.setSouvenir_no(souvenir_no);
//		System.out.println("souvenir_no________--"+souvenir_no);
		s2.setSouvenir_name(souvenir_name);
		s2.setSouvenir_des(souvenir_des);
		s2.setSouvenir_num(souvenir_num);
		s2.setSouvenir_price(souvenir_price);
		byte[] b = img.getBytes();
		Blob imgBlob = bytesToBlob(b);
		s2.setSouvenir_pic(imgBlob);
//		s2.set
		sService.updateSouvenir(s2);
		System.out.println("s2________-"+s2.toString());
		return "redirect:../maintainGift.controller";
		
//			System.out.println("update");
//			String fileName = img.getOriginalFilename();
//			byte[] bytes;
//			try {
//				bytes = img.getBytes();
//				if(img != null && fileName != null && fileName.length() > 0) {
//					bytes = img.getBytes();
//					Blob newimg = null;
//					if(bytes.length == 0) {
//						
//					}else {
//						newimg = new SerialBlob(bytes);
//					}
//					souvenirBean s1 = new souvenirBean(souvenir_no,souvenir_name,newimg,souvenir_des,souvenir_price,souvenir_num);
//					System.out.println(s1);
//
//					sService.updateSouvenir(s1);
//					sm.addAttribute(s1);
//					return "redirect:maintainGift.controller";
//				}else {
//					souvenirBean sBean =sService.findById(id);
//					Blob pBlob =sBean.getSouvenir_pic();
//					souvenirBean s2 = new souvenirBean(souvenir_no,souvenir_name,pBlob,souvenir_des,souvenir_price,souvenir_num);
//					System.out.println(s2);
//					sService.updateSouvenir(s2);
//
//					sm.addAttribute(s2);
//					return "redirect:maintainGift.controller";
//				}
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		return "redirect:maintainGift.controller";
	}

	@RequestMapping(path = "deleteGift", method = RequestMethod.POST)
	public String giftDelete(@RequestParam("souvenir_id") int id) {
		System.out.println("id"+id);
		sService.deleteById(id);
		 return "redirect:maintainGift.controller";
	}
	private Blob bytesToBlob(byte[] b ) throws SerialException, SQLException {
		return new SerialBlob(b);
	}
}
