package com.JY;

public class Borrow implements Behavior {
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
		System.out.println("반납 신청되었습니다.");		
	}
	public void reserveback() {
		System.out.println("예약자가 아닙니다.");
	}
}
