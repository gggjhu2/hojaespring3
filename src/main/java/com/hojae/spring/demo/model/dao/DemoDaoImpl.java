package com.hojae.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hojae.spring.demo.model.vo.Dev;

@Repository
public class DemoDaoImpl implements DemoDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertDev(Dev dev) {
		return session.insert("demo.insertDev", dev);
	}

	@Override
	public List<Dev> selectDevList() {
		return session.selectList("demo.selectDevList");
	}

	@Override
	public Dev selectOneDev(int no) {
		return session.selectOne("demo.selectOneDev", no);
	}

	@Override
	public int updateDev(Dev dev) {
		return session.update("demo.updateDev", dev);
	}

	@Override
	public int deleteDev(int no) {
		return session.delete("demo.deleteDev", no);
	
	}

}
