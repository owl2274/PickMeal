package com.itwill.interfaceService;

import java.util.List;

import com.itwill.dto.Menu;
import com.itwill.dto.MenuCategory;

public interface MenuServiceI {
	public int insertMenuCategory(MenuCategory menuCategory);
	public int updateMenuCategory(MenuCategory menuCategory);
	public int deleteMenuCategory(int categoryCode);
	public MenuCategory selectMenuCategory(int categoryCode);
	public List<MenuCategory> selectMenuCategoryList(int rstNo);
	
	public int insertMenu(Menu menu);
	public int updateMenu(Menu menu);
	public int deleteMenu(int code);
	public Menu selectMenu(int code);
	public List<Menu> selectMenuList(int rstNo);
	
	public List<MenuCategory> getMenuCategoryByRstNo(int rstNo);
	public List<Menu> getMenuByRstNo(int rstNo);
}
