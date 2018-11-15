package com.itwill.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.dto.Holiday;
import com.itwill.dto.Member;
import com.itwill.dto.Want;
import com.itwill.interfaceService.HolidayServiceI;
import com.itwill.interfaceService.RestaurantServiceI;
import com.itwill.interfaceService.WantServiceI;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantServiceI restaurantService;
	@Autowired
	private WantServiceI wantService;
	@Autowired
	private HolidayServiceI holidayService;
	
	
	@RequestMapping(value="/toggleWant")
	public ResponseEntity<String> toggleWant(@RequestParam int rstNo,HttpSession session,HttpServletResponse response) {
		String id = null;
		try {
			id = ((Member)session.getAttribute("loginMember")).getId();
		}catch(NullPointerException e) {
			
		}		System.out.println("toggleWant id = "+id);
		Want want = new Want();
		want.setId(id);
		want.setRstNo(rstNo);
		if(wantService.hasWant(want)>0) {
			return removeWant(rstNo, session, response);
		}else {
			return addWant(rstNo, session, response);
		}
		
	}
	
	@RequestMapping(value="/removeWant")
	public ResponseEntity<String> removeWant(@RequestParam int rstNo,HttpSession session,HttpServletResponse response) {
		String id = null;
		try {
			id = ((Member)session.getAttribute("loginMember")).getId();
		}catch(NullPointerException e) {
			
		}		Want want = new Want();
		want.setRstNo(rstNo);
		want.setId(id);
		int rows = wantService.removeWant(want);
		response.setContentType("text/plain");
	    response.setCharacterEncoding("UTF-8");
	    String result = null;
		if(rows>0) {
			result = "success";
		}else {
			result = "fail";
		}
		 HttpHeaders httpHeaders = new HttpHeaders();
		 httpHeaders.setContentType(org.springframework.http.MediaType.TEXT_PLAIN);
		 return new ResponseEntity(result, httpHeaders, HttpStatus.OK);

	}
	@RequestMapping(value="/addWant")
	public ResponseEntity<String> addWant(@RequestParam int rstNo,HttpSession session,HttpServletResponse response) {
		String id = null;
		try {
			id = ((Member)session.getAttribute("loginMember")).getId();
		}catch(NullPointerException e) {
			
		}		Want want = new Want();
		want.setRstNo(rstNo);
		want.setId(id);
		int rows = wantService.addWant(want);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		String result = null;
		if(rows>0) {
			result = "success";
		}else {
			result = "fail";
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(org.springframework.http.MediaType.TEXT_PLAIN);
		return new ResponseEntity(result, httpHeaders, HttpStatus.OK);
		
	}
	@RequestMapping(value="/isWant",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> isWant(@RequestParam int rstNo,HttpSession session){
		Map<String,String> json = new HashMap<String,String>();
		String id = null;
		try {
			id = ((Member)session.getAttribute("loginMember")).getId();
		}catch(NullPointerException e) {
			
		}
		System.out.println("isWant id = "+id);
		Want want = new Want();
		want.setId(id);
		want.setRstNo(rstNo);
		if(wantService.hasWant(want)>0) {
			json.put("isWant", "true");
		}else {
			json.put("isWant", "false");
		}
		json.put("countWant",""+wantService.countWant(rstNo));
		return json;
	}
	
	@RequestMapping(value="/toggleWantJSON")
	@ResponseBody
	public  Map<String,String> toggleWantJSON(@RequestParam int rstNo,HttpSession session,HttpServletResponse response) {
		
		Map<String,String> json = new HashMap<String,String>();
		json.put("result",toggleWant(rstNo, session, response).getBody());
		json.put("countWant",""+wantService.countWant(rstNo));
		
		return json;
	}
	
	@RequestMapping(value="/holidayList")
	@ResponseBody
	public List<Holiday> getHolidayList(int rstNo){
		return holidayService.getHoliday(rstNo);
	}
}
