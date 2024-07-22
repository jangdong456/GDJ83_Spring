package com.jang.app.boards.qna;

import com.jang.app.boards.BoardDTO;

public class QnaDTO extends BoardDTO{
	// NoticeDTO와 동일하니 상속시킨다.
	// 자식 is a 부모
	private Integer del;
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	private Long ref;
	private Long step;
	private Long depth;

	public Long getRef() {
		return ref;
	}
	public void setRef(Long ref) {
		this.ref = ref;
	}
	public Long getStep() {
		return step;
	}
	public void setStep(Long step) {
		this.step = step;
	}
	public Long getDepth() {
		return depth;
	}
	public void setDepth(Long depth) {
		this.depth = depth;
	}
}
