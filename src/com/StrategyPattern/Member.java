package com.StrategyPattern;

public abstract class Member {
	PossessBehavior possess;
	BorrowBehavior borrow;
	
	public PossessBehavior getPossess() {
		return possess;
	}

	public void setPossess(PossessBehavior possess) {
		this.possess = possess;
	}

	public BorrowBehavior getBorrow() {
		return borrow;
	}

	public void setBorrow(BorrowBehavior borrow) {
		this.borrow = borrow;
	}
	
	public abstract void status();
	
	public void performPossess() {
		possess.possess();
	}
	public void performBorrow() {
		borrow.borrow();
	}
}
