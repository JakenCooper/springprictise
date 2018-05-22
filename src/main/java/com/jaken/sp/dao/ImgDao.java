package com.jaken.sp.dao;

import org.springframework.stereotype.Repository;

import com.jaken.sp.entity.Img;

@Repository("imgDao")
public interface ImgDao {

	public void save(Img img);
}
