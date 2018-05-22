package com.jaken.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaken.sp.dao.ImgDao;
import com.jaken.sp.entity.Img;

@Service
@Transactional
public class ImgService {

	@Autowired
	private ImgDao imgDao;
	
	public void save(Img img){
		imgDao.save(img);
	}
}
