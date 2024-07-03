package com.jang.app.robot;

//@Component("ra") // bean의 이름을 지어주면 객체를 찾을 때 이걸 보고 찾아준다.
public class RightArm implements Arm {
	
	public void info() {
		System.out.println("오른팔 입니다.");
	}
	
}
