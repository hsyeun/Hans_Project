package com.StrategyPattern;

public class NoLend implements BorrowBehavior {

	@Override
	public void borrow() {
		System.out.println("대여하지 않았어");

	}

}
