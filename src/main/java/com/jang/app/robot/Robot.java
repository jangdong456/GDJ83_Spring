package com.jang.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // new Robot();
public class Robot {
	
	// 같은 타입이 여러개 라면 변수명을 찾아서 실행시켜준다.  | bean
	
	@Autowired // set.RightArm 주입시켜줌
	@Qualifier("ra")
	private Arm rightArm;
	
	@Autowired
	@Qualifier("la")
	private Arm leftArm;

	public Arm getRa() {
		return ra;
	}

	public void setRa(Arm ra) {
		this.ra = ra;
	}

	public Arm getLa() {
		return la;
	}

	public void setLa(Arm la) {
		this.la = la;
	}
	
}
