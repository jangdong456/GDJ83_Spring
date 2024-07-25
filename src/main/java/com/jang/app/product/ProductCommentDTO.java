package com.jang.app.product;

import com.jang.app.boards.CommentDTO;

public class ProductCommentDTO extends CommentDTO {
	private Integer product_id;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
}
