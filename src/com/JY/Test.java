package com.JY;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Member no1 = new Holder();
		Member no2 = new Lender();
		Member no3 = new Booker();
		
		System.out.println("대여버튼을 눌렀을 때: ");
		System.out.print("소유자: ");
		no1.borrowView();
		System.out.print("대여자: ");
		no2.borrowView();
		System.out.print("예약자: ");
		no3.borrowView();
		System.out.println();
		
		System.out.println("반납신청 버튼을 눌렀을 때: ");
		System.out.print("소유자: ");
		no1.returnTryView();
		System.out.print("대여자: ");
		no2.returnTryView();
		System.out.print("예약자: ");
		no3.returnTryView();
		System.out.println();
		
		System.out.println("예약취소 버튼을 눌렀을 때: ");
		System.out.print("소유자: ");
		no1.reservebackView();
		System.out.print("대여자: ");
		no2.reservebackView();
		System.out.print("예약자: ");
		no3.reservebackView();
		System.out.println();
		
		
//		no1.borrowView();
//		no1.reservebackView();
		
	}

}
