package com.jang.app.util;

public class Pager {
	
	private String kind;
	private String search;
	private Long startRow;
	private Long lastRow;
	private Long page;
	
	
	// -------------
	private Long startNum;
	private Long lastNum;
	private boolean pre;
	private boolean next;
	private long perPage = 10L; // 한페이지에 몇개 화면에 나타낼 것인지 
	
	
	//rownum을 계산하는 메서드
	public void makerow() throws Exception {
		this.startRow = (this.getPage() - 1) * perPage + 1; // 처음 시작하는 row
		// this.startRow = (this.getPage() - 1) * perPage + 1; 
		// getPage()를 실행함으로써 page null 들어온게 1로 바뀐다.
		// 밑에는 바뀐 1값이 page로 들어 갔기에 구지 호출안해도된다.
		this.lastRow = page * perPage; // 마지막 row
	}
	
	//페이징 처리 하는 메서드
	public void makeNum(long totalCount) throws Exception {
		//dao에서 perpage를 리턴받음 
		// 1. 총 갯수로 총페이지수 구하기
		long totalPage = totalCount / perPage;
		
		if(totalCount % perPage != 0) {
			totalPage++;
		}
		
		// 2.총 페이지수로 총블럭수 구하기
		long perBlock = 5L;
		long totalBlock = 0; 
		
		totalBlock = totalPage / perBlock; 
		
		if(totalPage % perBlock !=0) {
			totalBlock++;
		}
		
		// 3.현재 페이지 번호로 현재 블럭 번호를 구하기
		long curBlock =0;
		curBlock = page/perBlock;
		
		if(page % perBlock != 0) {
			curBlock++;
		}
		
		//4.현재 블럭 번호로 시작번호와 끝 번호 구하기
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock * perBlock;
		
		//5. 이전블록과 다음 블럭 유무 판단
		this.pre = true;
		this.next = true;
		
		if(curBlock == 1) {
			pre = false;
		}
		
		if(curBlock == totalBlock) {
			next = false;
			
			lastNum = totalPage;
		}
	}
	
	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Long getPage() {
		if(this.page == null || this.page<1) {
			this.page=1L;
		}
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSearch() {
		if(this.search == null) {
			this.search= "";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

}
