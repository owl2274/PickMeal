package com.itwill.util;

//페이지번호 출력 및 링크 기능을 제공하기 위한 클래스
public class ThePager {
	private int pageNum;
	private int blockSize;
	private int totalPage;
	private int pageSize;
	private String linkUrl;
	
	private int totalContents;
	public ThePager(int pageNum, int blockSize,int pageSize, int totalContents, String linkUrl) {
		super();
		this.pageNum = pageNum;
		this.blockSize = blockSize;
//		this.totalPage = totalPage;
		this.linkUrl = linkUrl;
		this.totalContents = totalContents;
		this.pageSize = pageSize;
	}
	public String getResult() {
		return toString();
	}
	@Override
	public String toString() {
		int startPage=(pageNum-1)/blockSize*blockSize+1;
		
		int endPage=startPage+blockSize-1;
		totalPage=(totalContents/pageSize)+(totalContents%pageSize==0?0:1);
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		String html="";
		
		if(startPage>0) {		
			html+="<div class=\"paginationCommon blogPagination categoryPagination\">";
			html+="<nav aria-label=\"Page navigation\">";
			html+="<ul class=\"pagination\">";
			if(startPage>blockSize) {
//				html+="<a href='"+linkUrl+"pageNum=1'>처음</a>";
				html+="<li>" + 
						"<a href= '"+linkUrl+"pageNum="+(startPage-blockSize)+"' aria-label=\"Previous\">" + 
						"&lt" + 
						"</a>" + 
						"</li>";
			} else {
//				html+="<span class='disabled'>처음</span>";
				html+="<li>" + 
						"<a aria-label=\"Previous\">" + 
						"&lt" + 
//						"<span aria-hidden=\"true\">&lt</span>" + 
						"</a>" + 
						"</li>";
			}
			for(int i=startPage;i<=endPage;i++) { 
				if(pageNum==i) {
					html+="<li class='active'><a>"+i+"</a></li>";
//					html+="<li class='active'>"+i+"</li>";
				} else {
					html+="<li><a href= '"+linkUrl+"pageNum="+i+"'  >"+i+"</a></li>";
				}
			}
			if(endPage!=totalPage) {
				html+="<li>" + 
						"<a href=  '"+linkUrl+"pageNum="+(startPage+blockSize)+"'  aria-label=\"Next\">" + 
						"<span aria-hidden=\"true\">&gt</span>" + 
						"</a>" + 
						"</li>";
//				html+="<a href='"+linkUrl+"pageNum="+totalPage+"'>마지막</a>";	
			} else {
				html+="<li>" + 
						"<a aria-label=\"Next\">" + 
						"<span aria-hidden=\"true\">&gt</span>" + 
						"</a>" +
						"</li>";
//				html+="<span class='disabled'>마지막</span>";	
			}
			html+="</ul>";
			html+="</nav>";
			html+="</div>";
		}
/*		if(startPage>0) {		
			html+="<style type='text/css'>";
			html+=".list_number { text-align: center; }";
			html+=".list_n_menu { padding: 3px; margin: 3px; text-align: center; }";
			html+=".list_n_menu a { padding: 5px 8px 4px 8px; margin: 2px; border: 1px solid #000; color: #000; text-decoration: none; font-size:13px; }";
			html+=".list_n_menu a:hover { color: orange; }";
			html+=".list_n_menu .current { border: 1px solid #698B22; padding: 5px 8px 4px 8px; font-weight: bold; margin: 2px; color: #698B22; font-size:13px; }";
			html+=".list_n_menu .disabled { border: 1px solid #999; padding: 5px 8px 4px 8px; margin: 2px; color: #999; font-size:13px; }";
			html+="</style>";
			html+="<div class='list_number'>";
			html+="<div>";
			html+="<p>";
			html+="<div class='list_n_menu'>";
			if(startPage>blockSize) {
				html+="<a href='"+linkUrl+"pageNum=1'>처음</a>";
				html+="<a href='"+linkUrl+"pageNum="+(startPage-blockSize)+"'>이전</a>";
			} else {
				html+="<span class='disabled'>처음</span>";
				html+="<span class='disabled'>이전</span>";
			}
			for(int i=startPage;i<=endPage;i++) {
				if(pageNum==i) {
					html+="<span class='current'>"+i+"</span>";
				} else {
					html+="<a href='"+linkUrl+"pageNum="+i+"'>"+i+"</a>";
				}
			}
			if(endPage!=totalPage) {
				html+="<a href='"+linkUrl+"pageNum="+(startPage+blockSize)+"'>다음</a>";
				html+="<a href='"+linkUrl+"pageNum="+totalPage+"'>마지막</a>";	
			} else {
				html+="<span class='disabled'>다음</span>";
				html+="<span class='disabled'>마지막</span>";	
			}
			html+="</div>";
			html+="</p>";
			html+="</div>";
			html+="</div>";
		}
*/		return html;
	}
}