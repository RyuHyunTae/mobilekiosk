package com.mo.biz.shop;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class shopDAO {
	@Autowired
	SqlSession sqlSession;
	
	public int join(shopVO vo) {
		return sqlSession.insert("shopDAO.join",vo);
	}
	
	public shopVO login(shopVO vo) {
		return sqlSession.selectOne("shopDAO.login",vo);
	}
	
	
}
