package com.jang.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class SampleTest extends DefaultTest {
	
	
	@AfterClass // 모든 메서드가 다 끝나고 나서 1번만 실행
	public static void afterAll() {
		System.out.println("==== AfterAll ====");
	}
	
	@BeforeClass // 모든 메서드가 시작되기전 1번만 실행
	public static void beforeAll() {
		System.out.println("==== BeforeAll =======");
	}
	
	@Before // 테스트 호출되기전에 각각 
	public void before() {
		System.out.println("---- Before -------");
	}
	
	@After // 시간이 얼마나 걸리는가 파악가능
	public void After() {
		System.out.println("-------- After ----------");
	}
	
	@Test
	public void t1() {
		System.out.println("t1 메서드");
		fail("--- t1 실패 ---");
	}
	
	@Test
	public void t2() {
		System.out.println("t2 메서드");
		assertEquals(0, 0);
	}
	
}
