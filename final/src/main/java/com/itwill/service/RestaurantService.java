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
		//��������� ��ȣ�� ���� ���� ���ȣ�� ������ ���ȣ�� ����Ͽ� ����
		//1������:1~10, 2������:11~20, 3������:21~30, 4������:31~40,...
		
		//��������� ��ȣ�� ���� ���� ���ȣ�� ����Ͽ� ����
		//�������ȣ=(�����������ȣ-1)*��°Խñ۰���+1
		int startRow=(pageNum-1)*pageSize+1;//���� ���ȣ�� �����ϱ� ���� ����
		
		//��������� ��ȣ�� ���� ������ ���ȣ�� ����Ͽ� ����
		//��������ȣ=�����������ȣ*��°Խñ۰���
		int endRow=pageNum*pageSize;//������ ���ȣ�� �����ϱ� ���� ����
		
		//������ �������� ������ ���ȣ�� ����
		if(endRow>totalRestaurant) {
			endRow=totalRestaurant;
		}
		
		//BOARD ���̺� ����� �Խñ� �� ��������� ������������� �Խñ���
		//�˻��Ͽ� ��ȯ�ϴ� DAO �ν��Ͻ��� �޼ҵ� ȣ��
		//List<BoardDTO> boardList=BoardDAO.getDAO().getBoardList(startRow, endRow);
		
		//BOARD ���̺� ����� �˻� �Խñ� �� ��������� ������������� �Խñ���
		//�˻��Ͽ� ��ȯ�ϴ� DAO �ν��Ͻ��� �޼ҵ� ȣ��
		List<Restaurant> restList=restaurantDAO.getRestaurantForWant(startRow, endRow, id);
		return restList;
	}
	
	//������� ��ȣ�� ������� ���� �˻�
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
		//��������� ��ȣ�� ���� ���� ���ȣ�� ������ ���ȣ�� ����Ͽ� ����
		//1������:1~10, 2������:11~20, 3������:21~30, 4������:31~40,...
		
		//��������� ��ȣ�� ���� ���� ���ȣ�� ����Ͽ� ����
		//�������ȣ=(�����������ȣ-1)*��°Խñ۰���+1
		int startRow=(pageNum-1)*pageSize+1;//���� ���ȣ�� �����ϱ� ���� ����
		
		//��������� ��ȣ�� ���� ������ ���ȣ�� ����Ͽ� ����
		//��������ȣ=�����������ȣ*��°Խñ۰���
		int endRow=pageNum*pageSize;//������ ���ȣ�� �����ϱ� ���� ����
		
		//������ �������� ������ ���ȣ�� ����
		if(endRow>totalRestaurant) {
			endRow=totalRestaurant;
		}
		
		//BOARD ���̺� ����� �Խñ� �� ��������� ������������� �Խñ���
		//�˻��Ͽ� ��ȯ�ϴ� DAO �ν��Ͻ��� �޼ҵ� ȣ��
		//List<BoardDTO> boardList=BoardDAO.getDAO().getBoardList(startRow, endRow);
		
		//BOARD ���̺� ����� �˻� �Խñ� �� ��������� ������������� �Խñ���
		//�˻��Ͽ� ��ȯ�ϴ� DAO �ν��Ͻ��� �޼ҵ� ȣ��
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
