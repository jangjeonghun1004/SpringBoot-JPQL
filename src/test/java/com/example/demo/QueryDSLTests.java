package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.entity.QProduct;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QueryDSLTests {
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void jpaQuery() {
		JPAQuery<Product> query = new JPAQuery<>(this.entityManager);
		QProduct qProduct = QProduct.product;

		List<Product> productList = query
				.from(qProduct)
				.where(qProduct.productName.eq("apple2"))
				.orderBy(qProduct.productPrice.asc())
				.fetch();

		productList.forEach((product) -> {
			System.out.println("Query Result = " + product.getProductName());
		});
	}

	@Test
	public void jpaQueryFactory1() {
		JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(this.entityManager);
		QProduct qProduct = QProduct.product;

		// selectForm = 전체 컬럼을 가져온다.
		List<Product> products = jpaQueryFactory.selectFrom(qProduct)
				.where(qProduct.productName.contains("apple"))
				.fetch();

		products.forEach((product) -> {
			System.out.println("productName = " + product.getProductName());
		});
	}

	@Test
	public void jpaQueryFactory2() {
		JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(this.entityManager);
		QProduct qProduct = QProduct.product;

		// List<String> = 선택적 단일 컬럼을 가져옵니다.
		List<String> products = jpaQueryFactory
				.select(qProduct.productName)
				.from(qProduct)
				.where(qProduct.productName.contains("apple"))
				.orderBy(qProduct.productPrice.asc())
				.fetch();

		products.forEach((product) -> {
			System.out.println("productName = " + product);
		});

		// List<Tuple> = 선택적 복수 컬럼을 가져 옵니다.
		List<Tuple> tuples = jpaQueryFactory
				.select(qProduct.productName, qProduct.productPrice, qProduct.productStock)
				.from(qProduct)
				.where(qProduct.productName.contains("apple"))
				.fetch();

		tuples.forEach((tuple) -> {
			System.out.println("productName = " + tuple.get(qProduct.productName));
			System.out.println("productPrice = " + tuple.get(qProduct.productPrice));
			System.out.println("productStock = " + tuple.get(qProduct.productStock));
		});
	}
}
