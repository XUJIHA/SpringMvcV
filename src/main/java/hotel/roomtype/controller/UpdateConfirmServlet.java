package hotel.roomtype.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import hotel.roomtype.model.RoomsBean;
import hotel.roomtype.service.RoomTypeService;

@Controller
public class UpdateConfirmServlet {

	@Autowired
	private RoomTypeService rService;

	@PostMapping("/UpdateConfirmServlet")
	public String processAction(Model m, @RequestParam("roomId") String roomId,
			@RequestParam("capacity") String inputCapacity, @RequestParam("name") String name,
			@RequestParam("status") String inputStatus, @RequestParam("bed") String inputBed,
			@RequestParam("size") String inputSize, @RequestParam("price") String inputPrice,
			@RequestPart("img") MultipartFile part, @RequestParam("description") String description,
			@RequestParam("cbEquipment1") @Nullable String equipment1, @RequestParam("cbEquipment2") @Nullable String equipment2,
			@RequestParam("cbEquipment3") @Nullable String equipment3, @RequestParam("cbEquipment4") @Nullable String equipment4,
			@RequestParam("cbEquipment5") @Nullable String equipment5, @RequestParam("cbEquipment6") @Nullable String equipment6,
			@RequestParam("cbEquipment7") @Nullable String equipment7, @RequestParam("cbEquipment8") @Nullable String equipment8) {
		int row = 0;
		roomId = roomId.trim();
		inputCapacity = inputCapacity.trim();
		if (roomId.equals("")) {
			m.addAttribute("idNull", "必填欄位不可空白!!");
		}
		if (inputCapacity.equals("")) {
			m.addAttribute("capacityNull", "必填欄位不可空白!!");
		}
		if (roomId.equals("") || inputCapacity.equals("")) {
			return "/roomType/InsertRoom";
		}
		name = name.trim();
		if (name.equals("")) {
			name = "未命名客房";
		}
		int status = Integer.parseInt(inputStatus);
		int capacity = Integer.parseInt(inputCapacity);
		inputBed = inputBed.trim();
		if (inputBed.equals("")) {
			inputBed = "0";
		}
		int bed = Integer.parseInt(inputBed);
		inputSize = inputSize.trim();
		if (inputSize.equals("")) {
			inputSize = "0.0";
		}
		double size = Double.parseDouble(inputSize);
		inputPrice = inputPrice.trim();
		if (inputPrice.equals("")) {
			inputPrice = "0";
		}
		int price = Integer.parseInt(inputPrice);
		
		if (equipment1==null) {
			equipment1 = "";
		}
		if (equipment2==null) {
			equipment2 = "";
		}
		if (equipment3==null) {
			equipment3 = "";
		}
		if (equipment4==null) {
			equipment4 = "";
		}
		if (equipment5==null) {
			equipment5 = "";
		}
		if (equipment6==null) {
			equipment6 = "";
		}
		if (equipment7==null) {
			equipment7 = "";
		}
		if (equipment8==null) {
			equipment8 = "";
		}
		String equipment = String.format("%s %s %s %s %s %s %s %s", equipment1, equipment2, equipment3, equipment4,
				equipment5, equipment6, equipment7, equipment8);
		Blob img = null;
		try {
			if (part.getSize() != 0) {
				InputStream is = part.getInputStream();
				byte[] bytes = is.readAllBytes();
				img = new SerialBlob(bytes);
			} else {
				List<RoomsBean> beans = rService.findById(roomId);
				for (RoomsBean b : beans) {
					img = b.getImg();
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		row = rService.updateFormById(roomId, name, status, capacity, bed, size, price, img, description, equipment);
		List<RoomsBean> beans = rService.findById(roomId);
			RoomsBean bean = null;
			for (RoomsBean b : beans) {
				bean = b;
			}
		String[] equipments = bean.getEquipment().split(" ");
		for (int i = 0; i < equipments.length; i++) {
			if (equipments[i].length() == 0) {
				String key = "e" + i;
				int e = 0;
				m.addAttribute(key, e);
			} else {
				String key = "e" + i;
				int e = 1;
				m.addAttribute(key, e);
			}
		}
		m.addAttribute("row", row);
		m.addAttribute("bean", bean);
		return "roomType/UpdateRoom";
	}
}
