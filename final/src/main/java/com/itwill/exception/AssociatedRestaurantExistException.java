package com.itwill.exception;

//import java.util.List;

//import com.itwill.dto.Restaurant;

public class AssociatedRestaurantExistException extends Exception{
	private static final long serialVersionUID = 1L;
	//private List<Restaurant> rstList;
	//private String id;
	//private int cnt;
	public AssociatedRestaurantExistException() {
		// TODO Auto-generated constructor stub
	}
	public AssociatedRestaurantExistException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
	
	
	
	/*  //id¿Í restaurant °¹¼ö
	public AssociatedRestaurantExistException(String message,String id, int cnt) {
		super(message);
		this.id = id;
		this.cnt = cnt;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
*/	
/*
	public AssociatedRestaurantExistException(String message, List<Restaurant> rstList) {
		super(message);
		//this.rstList=rstList;
	}
	*/
/*
	public List<Restaurant> getRstList() {
		return rstList;
	}

	public void setRstList(List<Restaurant> rstList) {
		this.rstList = rstList;
	}
*/
	
	
}
