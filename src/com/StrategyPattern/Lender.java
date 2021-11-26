package com.StrategyPattern;

public class Lender extends Member {
	
	public Lender() {
		possess = new NoSignUp();
		borrow = new Lend();
	}
	
	@Override
	public void status() {
		System.out.println("나는 책 대여자");

	}

}
