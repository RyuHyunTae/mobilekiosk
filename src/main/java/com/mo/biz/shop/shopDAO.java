package com.mo.biz.shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mo.biz.order.orderListVO;

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
	
	public List<calculateVO> todayCalculateList(calculateVO vo) {
		return sqlSession.selectList("shopDAO.todayCalculateList",vo);
	}
	
	public List<calculateVO> preCalculateList(calculateVO vo) {
		return sqlSession.selectList("shopDAO.preCalculateList",vo);
	}
	
	public List<orderListVO> orderList(orderListVO vo){
		return sqlSession.selectList("orderDAO.shopOrderList",vo);
	}
	
	public List<shopVO> approvalList(shopVO vo){
		return sqlSession.selectList("shopDAO.approvalList",vo);
	}
	
	public shopVO approvalDetail(shopVO vo) {
		return sqlSession.selectOne("shopDAO.approvalDetail",vo);
	}
	
	public int qrcodeInsert(shopVO vo) {
		return sqlSession.update("shopDAO.qrcodeInsert",vo); 
	}
	
	public shopVO getQRcode(String businessNum) {
		return sqlSession.selectOne("shopDAO.getQRcode",businessNum);
	}
	
	public int shopOpen(String businessNum) {
		return sqlSession.update("shopDAO.shopOpen",businessNum);
	}
	
	public int shopClose(String businessNum) {
		return sqlSession.update("shopDAO.shopClose",businessNum);
	}
	
	public shopVO shopState(String businessNum) {
		return sqlSession.selectOne("shopDAO.shopState",businessNum);
	}
	
}
