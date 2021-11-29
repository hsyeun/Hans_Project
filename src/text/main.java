package text;

import java.util.Scanner;

	public class main {
		 public static void main(String[] args) {
		  Scanner scanner=new Scanner(System.in); //스캐너 객체 생성
		  system systems=new system();//시스템클래스 객체 생성
		  String UserInput="";//사용자가 입력한것을 넣어두는 변수
		  System.out.println("책검색프로그램");
		  systems.setting();//시스템의 세팅메서드 실행
		  while(true) {//무한반복문
		   System.out.println("1.책검색 2.책리스트 3.책추가하기");
		   UserInput=scanner.nextLine();//엔터후 입력받은 문자를 UserInput에 넣어둠
		   if(UserInput.equals("1")) {//1을 입력했는지 체크
		    System.out.println("찾을 책을 입력하세요");
		    UserInput=scanner.nextLine();//엔터후 입력받은걸 UserInput에 넣어둠
		    systems.search(UserInput);//시스템의 검색메서드에 사용자가 입력한걸 넘겨줌
		   }
		   else if(UserInput.equals("2")) { //2를 입력했는지 체크
		    systems.list();
		    
		   }
		   else if(UserInput.equals("3")) { //3을 체크했는지 체크
		    System.out.println("추가할책의 이름을 입력하세요");
		    UserInput=scanner.nextLine(); //엔터후 나온 문자를 입력받고 넣어둠
		    systems.add(UserInput);//시스템의 add에 사용자에게 입력받은걸 넣어줌
		    
		   }
		   else { //잘못했는지 체크
		    System.out.println("잘못입력");
		   }
		  }
		  
		  
		 }

		}




