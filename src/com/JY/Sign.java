package com.JY;

public class Sign implements Behavior{
	public void borrow() {
		System.out.println("대여 되었습니다.");
	}
	public void returning() {
		System.out.println("반납되었습니다.");
		
	}
	public void delete() {
		System.out.println("책 제거하였습니다.");
	}
	public void returnTry() {
		System.out.println("대여자가 아닙니다.");		
	}
	public void reserveback() {
		System.out.println("예약자가 아닙니다.");
	}
}
