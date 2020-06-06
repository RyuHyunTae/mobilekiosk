package com.mo.biz.menu;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class menuDAO {

	@Autowired
	SqlSession sqlSession;
	
	public int menuInsert(menuVO vo) {
		return sqlSession.insert("menuDAO.insert",vo);
	}
	
	public menuVO menuDetail(menuVO vo) {
		return sqlSession.selectOne("menuDAO.detail",vo);
	}
	
	public int menuUpdate(menuVO vo) {
		return sqlSession.update("menuDAO.update",vo);
	}
	
	public List<menuVO> menuList(menuVO vo){
		return sqlSession.selectList("menuDAO.list",vo);
	}
	
	public int menuDelete(menuVO vo) {
		return sqlSession.delete("menuDAO.delete",vo);
	}
	
	public List<menuVO> menuDetail2(menuVO vo) {
		return sqlSession.selectList("menuDAO.detail",vo);
	}
	
	public int menuBasketDelete(int menuNum) {
		return sqlSession.delete("menuDAO.menuBasketDelete",menuNum);
	}
	
	public int menuMenuhitsDelete(int menuNum) {
		return sqlSession.delete("menuDAO.menuMenuhitsDelete",menuNum);
	}
}
