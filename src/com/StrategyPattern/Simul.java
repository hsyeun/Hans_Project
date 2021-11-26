package com.StrategyPattern;

public class Simul {

	public static void main(String[] args) {
		Member holder = new Holder();
		
		holder.performPossess();
		holder.performBorrow();
		
		System.out.println();
		
		Member lender = new Lender();
		
		lender.performPossess();
		lender.performBorrow();
		
		System.out.println();
		
		Member just = new JustMember();
		
		just.performPossess();
		just.performBorrow();

	}

}
