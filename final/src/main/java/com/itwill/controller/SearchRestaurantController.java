package com.itwill.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.itwill.dao.FoodTypeDAO;
import com.itwill.dao.RestaurantDAO;
import com.itwill.dto.Area;
import com.itwill.dto.FoodType;
import com.itwill.dto.Restaurant;
import com.itwill.dto.Want;
import com.itwill.interfaceDAO.FoodTypeDAOI;
import com.itwill.interfaceDAO.RestaurantDAOI;
import com.itwill.interfaceService.AreaServiceI;
import com.itwill.interfaceService.FoodTypeServiceI;
import com.itwill.interfaceService.WantServiceI;
import com.itwill.service.RestaurantService;
import com.itwill.util.ThePager;
import com.sun.xml.bind.CycleRecoverable.Context;

@Controller
public class SearchRestaurantController implements ApplicationContextAware {
	private WebApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = (WebApplicationContext)context;
		
	}
/*	@Autowired
	RestaurantDAOI restaurantDAO;*/
	@Autowired
	RestaurantService restaurantService;	
	@Autowired
	private FoodTypeServiceI foodTypeService;
	@Autowired
	private AreaServiceI areaService;
	@Autowired
	private WantServiceI wantService;
	
	
	@RequestMapping(value="/")
	public String firstGate(Model model) {


		List<FoodType> foodTypes = foodTypeService.getFoodTypeAll();
		List<List<Restaurant>> restLists = new ArrayList<List<Restaurant>>();
		model.addAttribute("foodTypes", foodTypes);
		
		for(FoodType foodType:foodTypes){
			List<Restaurant> restList = restaurantService.getRestaurantByFoodType(foodType.getFtNo(), 3);
			System.out.println( restList.size());
			restLists.add(restList);
		}
		model.addAttribute("restLists", restLists);
		
		return "/main/gate";
	}
	
	@RequestMapping(value="/search")
	public String searchRestaurant(
			@RequestParam(name="pageNum",required=false,defaultValue="1")String pageNumStr,
			@RequestParam(required=false) String [] areaList,
			@RequestParam(required=false) String [] foodTypeList,
			@RequestParam(required=false) String keyword,
			Model model,
			HttpSession session
			) {
		
		int pageNum = Integer.parseInt(pageNumStr);
		
		int pageSize = 7;
		
		List<Integer> areas = null;
		
		
		
		if(areaList != null){
			areas = new ArrayList<Integer>();
			for(String area:areaList){
				areas.add(Integer.parseInt(area));
			}
		}
	/*  	List<Integer> foodTypes = null; */ 


	  	List<Integer> foodTypes =  null;
	  	
	  	if(foodTypeList != null){
		  	foodTypes =  new ArrayList<Integer>();
			for(String foodType:foodTypeList){
				foodTypes.add(Integer.parseInt(foodType));
				System.out.println("foodType = "+foodType);
			}
	  	}		

		
		int blockSize = 10;
		
		int totalContents = restaurantService.getTotalRestaurantForSearch(areas, foodTypes, keyword);

		session.setAttribute("areas", areas);
		session.setAttribute("foodTypes", foodTypes);
		session.setAttribute("keyword", keyword);
		
	 	List<Restaurant> restList = 
	 			restaurantService.getRestaurantForSearch(pageNum, pageSize, areas, foodTypes, keyword); 
	/* 	List<RestaurantDTO> restList = RestaurantDAO.getDAO().getRestaurantForSearch(null, null, null); */
		model.addAttribute("restList", restList);
		model.addAttribute("totalContents",totalContents);
		List<Integer> rstNoList=new ArrayList<Integer>();
		
		for(Restaurant rst:restList) {
			rstNoList.add(rst.getRstNo());
		}

//		String url = "index.jsp?category=main&part=items&";
		String url = context.getServletContext().getContextPath()+"/search?";
		ThePager pager = new ThePager(pageNum,blockSize,pageSize,totalContents,url);
		model.addAttribute("pager", pager);
		return "/main/items";
	}

	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String searchRestaurant(			
			@RequestParam(name="pageNum",required=false,defaultValue="1")String pageNumStr,
			Model model,
			HttpSession session) {
		int pageNum = Integer.parseInt(pageNumStr);
		int pageSize = 7;
		int blockSize = 10;
		
		List<Integer> areas = (List<Integer>)session.getAttribute("areas");
		List<Integer> foodTypes = (List<Integer>)session.getAttribute("foodTypes");
		String keyword = (String)session.getAttribute("keyword");
		
		int totalContents = restaurantService.getTotalRestaurantForSearch(areas, foodTypes, keyword);
	 	List<Restaurant> restList = 
	 			restaurantService.getRestaurantForSearch(pageNum, pageSize, areas, foodTypes, keyword);
	 	model.addAttribute("restList", restList);
	 	
		String url = context.getServletContext().getContextPath()+"/search?";
		ThePager pager = new ThePager(pageNum,blockSize,pageSize,totalContents,url);
		model.addAttribute("pager", pager);
		return "/main/items";
	}
	
	
	@RequestMapping("/header")
	public String init() {
		return "layout/header";
	}
	
	@RequestMapping("/foodType")
	@ResponseBody
	public List<FoodType> foodType() {
		return foodTypeService.getFoodTypeAll();
	}
	
	@RequestMapping("/city")
	@ResponseBody
	public List<String> city() {
		return areaService.getCityList();
	}
	
	@RequestMapping("/dong")
	@ResponseBody
	public List<Area> dong(@RequestParam(required=false) String area1) {
		 
		
		return areaService.getAreaList(area1); 
	}
}
