package com.jaken.sp.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jaken.sp.entity.Img;
import com.jaken.sp.entity.ImgResponseModel;
import com.jaken.sp.entity.User;
import com.jaken.sp.service.ImgService;
import com.jaken.sp.service.UserService;
import com.jaken.sp.util.CommonUtil;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ImgService imgService;
	
	@RequestMapping(value="/upload")
	public ResponseEntity<ImgResponseModel> upload(MultipartHttpServletRequest request){
		MultipartFile file=request.getFile("userFile");
		String filename=file.getOriginalFilename();
		File localfile=new File("e:/upload/"+filename);
		try {
			if (localfile.exists() == false) {
				localfile.createNewFile();
			} 
			file.transferTo(localfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String userid=CommonUtil.getUUID();
		Img img=new Img(CommonUtil.getUUID(),userid,localfile.getAbsolutePath());
		imgService.save(img);
		ResponseEntity<ImgResponseModel> re
			=new ResponseEntity<ImgResponseModel>(new ImgResponseModel(0,userid),HttpStatus.OK);
		return re;
	}
	
	@RequestMapping("/addUser")
	public String addUser(User user){
		if(StringUtils.isEmpty(user.getUserId())){
			throw new IllegalArgumentException("userid is null");
		}
		user.setId(user.getUserId());
		userService.save(user);
		return "main";
	}
}
