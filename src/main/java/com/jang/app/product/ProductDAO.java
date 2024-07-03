package com.jang.app.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAO {
	
	// private SqlSession : 가 가르키는 애 
	// 	<bean class="org.mybatis.spring.SqlSessionTemplate">
	// <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactoryBean"></constructor-arg>
	//	</bean>
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE= "com.jang.app.product.ProductDAO.";
	
	public List<ProductDTO> getList() throws Exception {
		// selectList : 값이 여러개 일 때 | DTO가 여러개인데 나머진 메소드가 알아서 해줌
		return sqlSession.selectList(NAMESPACE+"getList");

	}
	
	public ProductDTO detail(ProductDTO product_id) throws Exception {
		// selectOne : 조건값이 1나일때 
		 return sqlSession.selectOne(NAMESPACE +"detail", product_id); 
	}
	
	public int add(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE +"add",productDTO);
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete", productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", productDTO);
	}
	
}
