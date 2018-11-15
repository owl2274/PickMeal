package com.itwill.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;

import com.itwill.dao.BookStatusDAO;
import com.itwill.dto.Book;
import com.itwill.dto.Member;
import com.itwill.dto.Restaurant;
import com.itwill.dto.Review;
import com.itwill.exception.ExistNotMemberException;
import com.itwill.exception.MemberNotFoundException;
import com.itwill.exception.passwordNotMatchException;
import com.itwill.interfaceDAO.RestaurantDAOI;
import com.itwill.interfaceService.BookServiceI;
import com.itwill.interfaceService.MemberServiceI;
import com.itwill.interfaceService.RestaurantServiceI;
import com.itwill.interfaceService.ReviewServiceI;
import com.itwill.service.RestaurantService;
import com.itwill.service.ReviewService;
import com.itwill.util.ThePager;

@Controller
//@SessionAttributes(value="restList")
@SessionAttributes(value="messageForUP")
public class MypageController implements ApplicationContextAware {
	private WebApplicationContext context;
	@Autowired
	private RestaurantServiceI restaurantService;
	@Autowired
	private ReviewServiceI reviewService;
	@Autowired
	private MemberServiceI memberService;
	@Autowired
	private BookServiceI bookService;
	
	@Autowired
	private BookStatusDAO bookStatusDAO;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = (WebApplicationContext)context;
		
	}
/*	@RequestMapping(value="/mypage")
	public String mypage() {
		return "/mypage/mypage";
	}*/
	
	@RequestMapping(value="/mypage")
	public String mypage() {
		return "redirect:/mypage/bookings";
	}
	@RequestMapping(value="/mypage/{type}")
	public String mypage(HttpServletRequest request,@PathVariable String type,Model model) throws UnsupportedEncodingException {
		if(type == null){
			type="bookings";
		} 
		String forJavascript = "";
		if(request.getQueryString() != null){
			String [] queries = request.getQueryString().split("&");
			
			Map<String,String> map = new HashMap<String,String>();
			for(String query:queries){
				String [] parts = query.split("=");
				if(parts.length==2)
					map.put(parts[0], parts[1]);
			}
	
			
			Set<String> keys = map.keySet();
			if(!keys.isEmpty()){
				for(String key:keys){
					forJavascript += ",'"+key+"':'"+map.get(key)+"'";
				}
				forJavascript = forJavascript.substring(1);
			}
		}

		model.addAttribute("forJavascript",forJavascript);
		model.addAttribute("type",type);
		return "/mypage/mypage";
		
	}
	
	@RequestMapping(value="/favorite")
	
	public String favoritePage(@RequestParam(required=false,defaultValue="1") String pageNum, Model model,HttpSession session) {
		
		Member loginMember = (Member) session.getAttribute("loginMember");
		int pageNumInt = Integer.parseInt(pageNum);
		int pageSize = 9;
		
		int blockSize= 10;
		String id = loginMember.getId();
		int totalContents = restaurantService.getTotalgetRestaurantForWant(id);
	 	List<Restaurant> restList = restaurantService.getRestaurantForWant(pageNumInt,pageSize,id);
	 	model.addAttribute("restList", restList);
		
		
		
		//요오기 페이지 작업하다 말았다.
		ThePager pager = new ThePager(pageNumInt,blockSize,pageSize,totalContents,
				context.getServletContext().getContextPath()+"/mypage/favorite?");
		model.addAttribute("pager",pager);
		return "/mypage/myContent/favorite";
	}
	 
	@RequestMapping(value="/modifyMember",method=RequestMethod.POST)
	public String modifyMember(
			@Valid Member member,Errors error,HttpSession session) throws ExistNotMemberException {
		if(error.hasErrors()) {
			List<FieldError> fieldErrors = error.getFieldErrors();
			for(FieldError fe:fieldErrors) {
				System.out.println("fe.getDefaultMessage() = "+fe.getDefaultMessage());
				
			}
			return "/mypage/profile";
		}
		Member loginMember = (Member) session.getAttribute("loginMember");
		member.setId(loginMember.getId());
		member.combinePhone();
		memberService.modifyMember(member);
		session.setAttribute("loginMember", member);
		return "redirect:/mypage/profile";
	}
	//비밀번호 변경
	@RequestMapping(value="/modifyPassword",method=RequestMethod.POST)

	public String modifyPassword(
			@RequestParam String curPassword, @RequestParam String newPassword,HttpSession session, Model model)
					throws ExistNotMemberException {

		if(!Pattern.matches(Member.regRexPassword(), newPassword)) {
//			model.addAttribute("newPasswordMessage", "형식에 맞게 입력해 주세요");
			return "/mypage/myContent/profile";
		}

		try {
			Member loginMember = (Member) session.getAttribute("loginMember");
			memberService.modifyPassword(loginMember.getId(), curPassword, newPassword);
		} catch (passwordNotMatchException e) {
			//session.setAttribute("isMessageUsed", "yes");
			model.addAttribute("messageForUP", "현재 비밀번호가 일치하지 않습니다.");
			return "redirect:/mypage/profile";
		}
		model.addAttribute("messageForUP", "비밀번호가 성공적으로 변경되었습니다.");
		return "redirect:/mypage/profile";
	}
	
	
/*	@RequestMapping(value="/modifyPassword",method=RequestMethod.POST)
	public ResponseEntity<String> modifyPassword(String id,String curPassword,String newPassword) {
		String result = null;
		try {
			memberService.modifyPassword(id, curPassword, newPassword);
			result="success";
		}catch(Exception e) {
			result="fail";
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(org.springframework.http.MediaType.TEXT_PLAIN);
		return new ResponseEntity(result, httpHeaders, HttpStatus.OK);
	}
*/	
	@RequestMapping(value="/review")
	public String reviewPage(
			@RequestParam(required=false,defaultValue="1") String pageNum, @RequestParam(required=false)String rstName,
			HttpSession session,Model model) throws UnsupportedEncodingException {
		
		int pageNumInt = Integer.parseInt(pageNum);
		int pageSize = 5;
		int blockSize = 10;
		String id=((Member) session.getAttribute("loginMember")).getId();
		String pagerUri="/mypage/review?";
		if(rstName != null) {
			System.out.println("rstName before = "+rstName);
			rstName = URLDecoder.decode(rstName,"UTF-8");
			System.out.println("rstName after = "+rstName);
			pagerUri += "rstName="+rstName+"&";
		}
		int totalContents = reviewService.getTotalReviewById(id, rstName);
		List<Review> reviewList = reviewService.getReviewByIdList(pageNumInt,pageSize,id,rstName);

		
		
		model.addAttribute("reviewList", reviewList);
		
		ThePager pager = new ThePager(pageNumInt,blockSize,pageSize,totalContents,
				context.getServletContext().getContextPath()+pagerUri);
		model.addAttribute("pager",pager);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("rstName",rstName);
		return "/mypage/myContent/review";
	}
	
	@RequestMapping(value="/bookings")
	public String bookingsPage(
			@RequestParam(required=false,defaultValue="1") String pageNum,
			@RequestParam(required=false) String bookStatus,
			HttpSession session,Model model) {
		int pageNumInt = Integer.parseInt(pageNum);
		int pageSize = 5;
		int blockSize = 10;
		String id=((Member) session.getAttribute("loginMember")).getId();
		List<Book> bookList = null;
		int totalContents = 0;
		
		if(bookStatus!=null && bookStatusDAO.getBookStatusByNo(Integer.parseInt(bookStatus))!=null) {
			bookList = bookService.getBookingById(pageNumInt, pageSize, id,Integer.parseInt(bookStatus));
			totalContents = bookService.getTotalBookingById(id,Integer.parseInt(bookStatus));
		}else {
			bookList = bookService.getBookingById(pageNumInt, pageSize, id,null);
			totalContents = bookService.getTotalBookingById(id,null);
		}
		
		for(Book book:bookList) {
			book.setBookDate(book.getBookDate().substring(0, 10));
		}
		
		model.addAttribute("bookList", bookList);
		
		String query="";
		if(bookStatus!=null) {
			query+="bookStatus="+bookStatus+"&";
		}
		
		ThePager pager = new ThePager(pageNumInt,blockSize,pageSize,totalContents,
				context.getServletContext().getContextPath()+"/mypage/bookings?"+query);
		if(pageNum != null) {
			query="&"+query+"pageNum="+pageNum;
		}
		model.addAttribute("bookStatusList",bookStatusDAO.getBookStatusAll());
		model.addAttribute("pager",pager);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("query", query);
		return "/mypage/myContent/bookings";
	}
	@RequestMapping(value="/cancelBook")
	public String cancelBooking(
			@RequestParam int bookNo,
			@RequestParam(required=false) String pageNum,
			@RequestParam(required=false) String bookStatus,
			/*@RequestParam(required=false,defaultValue="1") String pageNum,
			@RequestParam(required=false) String bookStatus,*/
			HttpSession session,Model model) {
		Book book = bookService.getBookingByBookNo(bookNo);
		if(book==null || !book.getId().equals(((Member) session.getAttribute("loginMember")).getId())) {
			return "redirect:/mypage/bookings";
		}
		
		bookService.cancelBooking(bookNo);
		

		String query="";
		if(pageNum!=null) {
			query += "?pageNum="+pageNum;
			if(bookStatus!=null) 
				query += "&bookStatus="+bookStatus;
		}else if(bookStatus!=null) {
			query += "?bookStatus="+bookStatus;
		}
		
		return "redirect:/mypage/bookings"+query;
	}
	
	@RequestMapping(value="/profile")
	public String profilePage(@ModelAttribute Member member,HttpSession session,SessionStatus status,Model model) throws MemberNotFoundException {
		Member loginMember = (Member) session.getAttribute("loginMember");
		model.addAttribute("loginMember", loginMember);
//		System.out.println("session.getAttribute(\"isMessageUsed\")="+session.getAttribute("isMessageUsed"));
/*		if(session.getAttribute("isMessageUsed")!=null) {
			session.removeAttribute("isMessageUsed");
		}else {
			status.setComplete();
		}*/
		status.setComplete();
		return "/mypage/myContent/profile";
	}

	
	
}
