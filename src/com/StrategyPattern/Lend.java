package com.StrategyPattern;

public class Lend implements BorrowBehavior {

	@Override
	public void borrow() {
		System.out.println("책을 대여했어");

	}

}
