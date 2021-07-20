package com.hojae.spring.demo.model.dao;

import java.util.List;

import com.hojae.spring.demo.model.vo.Dev;

public interface DemoDao {

	
	int insertDev(Dev dev);

	List<Dev> selectDevList();

	Dev selectOneDev(int no);

	int updateDev(Dev dev);

	int deleteDev(int no);

}
