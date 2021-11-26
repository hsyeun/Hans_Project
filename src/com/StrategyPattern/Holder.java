package com.StrategyPattern;

public class Holder extends Member {

	public Holder() {
		possess = new SignUP();
		borrow = new NoLend();
	}
	@Override
	public void status() {
		System.out.println("나는 책 주인이야");

	}

}
