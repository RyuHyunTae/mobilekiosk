package com.mo.biz.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class orderDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int orderInsert(orderVO vo) {
		return sqlSession.insert("orderDAO.orderInsert",vo);
	}
	
	public int orderDetailInsert(orderVO vo) {
		return sqlSession.insert("orderDAO.orderDetailInsert",vo);
	}
	
	public orderVO getOrderNum(orderVO vo) {
		return sqlSession.selectOne("orderDAO.getOrderNum",vo);
	}
	
	public List<orderVO> userOrderList(orderListVO vo){
		return sqlSession.selectList("orderDAO.userOrderList",vo);
	}
	
	public int orderApproval(int orderNum) {
		return sqlSession.update("orderDAO.orderApproval",orderNum);
	}
	
	public int orderDetailCancel(int orderNum) {
		return sqlSession.delete("orderDAO.orderDetailCancel",orderNum);
	}
	
	public int orderCancel(int orderNum) {
		return sqlSession.delete("orderDAO.orderCancel",orderNum);
	}
}
