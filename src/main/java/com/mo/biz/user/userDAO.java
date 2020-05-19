package com.mo.biz.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mo.biz.shop.shopVO;

@Repository
public class userDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int join(userVO vo) {
		return sqlSession.insert("userDAO.join",vo);
	}
	
	public userVO login(userVO vo) {
		return sqlSession.selectOne("userDAO.login",vo);
	}
	
	public int usershopInsert(usershopVO vo) {
		return sqlSession.insert("userDAO.usershopInsert",vo);
	}
	
	public shopVO getBusinessNum(shopVO vo) {
		return sqlSession.selectOne("userDAO.getBusinessNum",vo);
	}
	
	public List<usershopVO> shopList(usershopVO vo){
		return sqlSession.selectList("userDAO.shopList",vo);
	}
}
