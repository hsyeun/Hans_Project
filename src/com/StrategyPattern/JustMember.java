package com.StrategyPattern;

public class JustMember extends Member {

	public JustMember() {
		possess = new NoSignUp();
		borrow = new NoLend();
	}
	
	@Override
	public void status() {
		System.out.println("나는 그냥 가입만 한 사람");

	}


}
