package com.StrategyPattern;

public class SuperMember extends Member {

	public SuperMember() {
		possess = new SignUP();
		borrow = new Lend();
	}
	
	@Override
	public void status() {
		System.out.println("나는 책을 빌려주기도 하고 빌리기도 해!");

	}


}