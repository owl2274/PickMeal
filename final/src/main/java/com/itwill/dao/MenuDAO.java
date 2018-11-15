package com.itwill.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.dto.Menu;
import com.itwill.dto.MenuCategory;
import com.itwill.interfaceDAO.MenuDAOI;
import com.itwill.mapper.MenuMapper;

@Repository
public class MenuDAO implements MenuDAOI{
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public int insertMenuCategory(MenuCategory menuCategory) {
		return sqlsession.getMapper(MenuMapper.class).insertMenuCategory(menuCategory);
	}

	@Override
	public int updateMenuCategory(MenuCategory menuCategory) {
		return sqlsession.getMapper(MenuMapper.class).updateMenuCategory(menuCategory);
	}

	@Override
	public int deleteMenuCategory(int categoryCode) {
		return sqlsession.getMapper(MenuMapper.class).deleteMenuCategory(categoryCode);
	}

	@Override
	public MenuCategory selectMenuCategory(int categoryCode) {
		return sqlsession.getMapper(MenuMapper.class).selectMenuCategory(categoryCode);
	}

	@Override
	public List<MenuCategory> selectMenuCategoryList(int rstNo) {
		return sqlsession.getMapper(MenuMapper.class).selectMenuCategoryList(rstNo);
	}

	@Override
	public int insertMenu(Menu menu) {
		return sqlsession.getMapper(MenuMapper.class).insertMenu(menu);
	}

	@Override
	public int updateMenu(Menu menu) {
		return sqlsession.getMapper(MenuMapper.class).updateMenu(menu);
	}

	@Override
	public int deleteMenu(int code) {
		return sqlsession.getMapper(MenuMapper.class).deleteMenu(code);
	}

	@Override
	public Menu selectMenu(int code) {
		return sqlsession.getMapper(MenuMapper.class).selectMenu(code);
	}

	@Override
	public List<Menu> selectMenuList(int rstNo) {
		return sqlsession.getMapper(MenuMapper.class).selectMenuList(rstNo);
	}

	@Override
	public List<MenuCategory> getMenuCategoryByRstNo(int rstNo) {
		return sqlsession.getMapper(MenuMapper.class).getMenuCategoryByRstNo(rstNo);
	}

	@Override
	public List<Menu> getMenuByRstNo(int rstNo) {
		return sqlsession.getMapper(MenuMapper.class).getMenuByRstNo(rstNo);
	}



}
