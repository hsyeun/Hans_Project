package com.JY;

public class Reserve implements Behavior {
	
	public void borrow() {
		System.out.println("소유자가 아닙니다.");
	}
	public void returning() {
		System.out.println("소유자가 아닙니다.");
		
	}
	public void delete() {
		System.out.println("소유자가 아닙니다.");
	}
	public void returnTry() {
		System.out.println("대여자가 아닙니다.");		
	}
	public void reserveback() {
		System.out.println("예약 취소되었습니다.");

	}
}
