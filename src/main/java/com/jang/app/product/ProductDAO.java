package com.jang.app.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jang.app.members.MemberDTO;
import com.jang.app.util.Pager;


@Repository
public class ProductDAO {
	
	// private SqlSession : 가 가르키는 애 
	// 	<bean class="org.mybatis.spring.SqlSessionTemplate">
	// <constructor-arg name="sqlSessionFactory" ref="sqlSessionFactoryBean"></constructor-arg>
	//	</bean>
	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE= "com.jang.app.product.ProductDAO.";
	
	
	public List<ProductDTO> wishList(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE + "wishList", memberDTO);
	}
	
	public int addWish(Map<String, Object> map) throws Exception {
		return sqlSession.insert(NAMESPACE + "addWish", map);
	}
	
	public List<ProductDTO> getList(Pager pager) throws Exception {
		// selectOne :  값이 1나 일 때
		// selectList : 값이 여러개 일 때 | DTO가 여러개인데 나머진 메소드가 알아서 해줌
		return sqlSession.selectList(NAMESPACE+"getList", pager);

	}
	
	public Long getTotalCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getTotalCount", pager);
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception {
		// selectOne : 조건값이 1나일때 
		 return sqlSession.selectOne(NAMESPACE +"detail", productDTO); 
	}
	
	public Integer getNum() throws Exception {
		return sqlSession.selectOne(NAMESPACE + "getNum");
	}
	
	public int add(ProductDTO productDTO) throws Exception {

		return sqlSession.insert(NAMESPACE +"add",productDTO);
	}
	
	public int addFile(ProductFileDTO productFileDTO) throws Exception {

		return sqlSession.insert(NAMESPACE +"addFile",productFileDTO);
	}
	
	public int delete(ProductDTO productDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete", productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", productDTO);
	}

}
