package com.itwill.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.dao.RestaurantDAO;
import com.itwill.dto.Restaurant;
import com.itwill.exception.RestautantNotFoundException;
import com.itwill.interfaceDAO.BookDAOI;
import com.itwill.interfaceService.RestaurantServiceI;


@Service
public class RestaurantService implements RestaurantServiceI{
	@Autowired
	private RestaurantDAO restaurantDAO;
	@Autowired
	private BookDAOI bookDAO;
	
	public RestaurantService() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<Restaurant> getRestaurantForWant(int pageNum,int pageSize,String id){
		int totalRestaurant=restaurantDAO.getTotalgetRestaurantForWant(id);
		//출력페이지 번호에 대한 시작 행번호와 마지막 행번호를 계산하여 저장
		//1페이지:1~10, 2페이지:11~20, 3페이지:21~30, 4페이지:31~40,...
		
		//출력페이지 번호에 대한 시작 행번호를 계산하여 저장
		//시작행번호=(출력페이지번호-1)*출력게시글갯수+1
		int startRow=(pageNum-1)*pageSize+1;//시작 행번호를 저장하기 위한 변수
		
		//출력페이지 번호에 대한 마지막 행번호를 계산하여 저장
		//마지막번호=출력페이지번호*출력게시글갯수
		int endRow=pageNum*pageSize;//마지막 행번호를 저장하기 위한 변수
		
		//마지막 페이지의 마지막 행번호를 변경
		if(endRow>totalRestaurant) {
			endRow=totalRestaurant;
		}
		
		//BOARD 테이블에 저장된 게시글 중 시작행부터 마지막행까지의 게시글을
		//검색하여 반환하는 DAO 인스턴스의 메소드 호출
		//List<BoardDTO> boardList=BoardDAO.getDAO().getBoardList(startRow, endRow);
		
		//BOARD 테이블에 저장된 검색 게시글 중 시작행부터 마지막행까지의 게시글을
		//검색하여 반환하는 DAO 인스턴스의 메소드 호출
		List<Restaurant> restList=restaurantDAO.getRestaurantForWant(startRow, endRow, id);
		return restList;
	}
	
	//레스토랑 번호로 레스토랑 정보 검색
	@Override
	public Restaurant getRestaurantByRstNo(int rstNo) throws RestautantNotFoundException {
		Restaurant restaurant=restaurantDAO.getRestaurantByRstNo(rstNo);
		
		if(restaurant==null) {
			throw new RestautantNotFoundException();
		}
		
		return restaurant;
		
	}
	@Override
	public List<Restaurant> getRestaurantForSearch(int pageNum,int pageSize,List<Integer> areas,List<Integer> foodTypes,String keyword){

		System.out.println("start getRestaurantForSearch");
		int totalRestaurant=restaurantDAO.getTotalRestaurantForSearch(areas,foodTypes,keyword);
		System.out.println("totalRestaurant = "+totalRestaurant);
		//출력페이지 번호에 대한 시작 행번호와 마지막 행번호를 계산하여 저장
		//1페이지:1~10, 2페이지:11~20, 3페이지:21~30, 4페이지:31~40,...
		
		//출력페이지 번호에 대한 시작 행번호를 계산하여 저장
		//시작행번호=(출력페이지번호-1)*출력게시글갯수+1
		int startRow=(pageNum-1)*pageSize+1;//시작 행번호를 저장하기 위한 변수
		
		//출력페이지 번호에 대한 마지막 행번호를 계산하여 저장
		//마지막번호=출력페이지번호*출력게시글갯수
		int endRow=pageNum*pageSize;//마지막 행번호를 저장하기 위한 변수
		
		//마지막 페이지의 마지막 행번호를 변경
		if(endRow>totalRestaurant) {
			endRow=totalRestaurant;
		}
		
		//BOARD 테이블에 저장된 게시글 중 시작행부터 마지막행까지의 게시글을
		//검색하여 반환하는 DAO 인스턴스의 메소드 호출
		//List<BoardDTO> boardList=BoardDAO.getDAO().getBoardList(startRow, endRow);
		
		//BOARD 테이블에 저장된 검색 게시글 중 시작행부터 마지막행까지의 게시글을
		//검색하여 반환하는 DAO 인스턴스의 메소드 호출
		List<Restaurant> restList=restaurantDAO.getRestaurantForSearch(startRow,endRow,areas, foodTypes, keyword);
		return restList;
	}
	@Override
	public int getTotalRestaurantForSearch(List<Integer> areas,List<Integer> foodTypes,String keyword) {
		return restaurantDAO.getTotalRestaurantForSearch(areas, foodTypes, keyword);
	}
	@Override
	public List<Restaurant> getRestaurantByFoodType(int foodTypeNo,int count){
		return restaurantDAO.getRestaurantByFoodType(foodTypeNo, count);
	}


	@Override
	public int addRestaurant(Restaurant dto) {
		return restaurantDAO.addRestaurant(dto);
	}


	@Override
	public int getTotalgetRestaurantForWant(String id) {
		return restaurantDAO.getTotalgetRestaurantForWant(id);
	}


	@Override
	public List<Restaurant> getRestaurantAll() {
		return restaurantDAO.getRestaurantAll();
	}

	@Override
	public String getFoodTypeName(int rstNo) throws RestautantNotFoundException {
		
		String foodTypeName=restaurantDAO.getFoodTypeName(rstNo);
		if(foodTypeName==null || foodTypeName.equals("")) {
			throw new RestautantNotFoundException();
		}
		
		return foodTypeName;
	}
}
