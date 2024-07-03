package com.jang.app.robot;

import org.springframework.stereotype.Component;

@Component // new Robot();
public class Robot {
	
	private String company;
	private int age;
	// 같은 타입이 여러개 라면 변수명을 찾아서 실행시켜준다.  | bean
	
public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

//	@Autowired // set.RightArm 주입시켜줌
//	@Qualifier("ra")
	private Arm rightArm;
	
//	@Autowired
//	@Qualifier("la")
	private Arm leftArm;

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}




}
