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
	
	public int basketInsert(basketVO vo) {
		return sqlSession.insert("userDAO.basketInsert",vo);
	}
	
	public int basketCountUp(basketVO vo) {
		return sqlSession.update("userDAO.basketCountUp",vo);
	}
	
	public int basketCountDown(basketVO vo) {
		return sqlSession.update("userDAO.basketCountDown",vo);
	}
	
	public int basketDelete(basketVO vo) {
		return sqlSession.delete("userDAO.basketDelete",vo);
	}
	
	public basketVO basketCheck(basketVO vo) {
		return sqlSession.selectOne("userDAO.basketCheck",vo);
	}
	
	public List<basketVO> basketList(basketVO vo){
		return sqlSession.selectList("userDAO.basketList",vo);
	}
	
	public int basketAllDelete(String id) {
		return sqlSession.delete("userDAO.basketAllDelete",id);
	}
	
	public int menuhitsInsert(menuhitsVO vo) {
		return sqlSession.insert("userDAO.menuhitsInsert",vo);
	}
	
	public List<menuhitsVO> getMenuhits(String businessNum){
		return sqlSession.selectList("userDAO.getMenuhits",businessNum);
	}
	
}
