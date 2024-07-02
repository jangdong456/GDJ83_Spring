package com.jang.app;

import org.springframework.stereotype.Component;

import com.jang.app.robot.Arm;

@Component("la")
public class LeftArm implements Arm {
	
	public void info() {
		System.out.println("왼팔 입니다.");
	}
}
