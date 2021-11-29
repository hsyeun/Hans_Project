package text;

import java.util.*;

class system{ //하나의 기계를 나타내는 클래스
 int index=9;//책을 추가할때 알맞는 인덱스에 넣기위해 만든변수
 int found=0;//찾았는지 못찾았는지 판별하는변수
 String[] list=new String[100];//100개자리의 배열을 만들어둠. 책리스트를 저장해두는곳
 void setting() {//기본책을 넣어놓는곳
  list[0]="페스트";
  list[1]="당신이 옳다";
  list[2]="1cm 다이빙";
  list[3]="흔한 남매4";
  list[4]="메타인지 학습법";
  list[5]="이것이 자바다";
  list[6]="혼자 공부하는 자바";
  list[7]="Do it! 자바 프로그래밍 입문";
  list[8]="Do it! 오라클로 배우는 데이터베이스 입문";
 }
 void search(String Name) {//책을 찾는 메서드
  System.out.println("검색결과");
  for(int i=0;i<index; i++) {//배열에 저장되어있는만큼 반복하도록함
   if(list[i].indexOf(Name)!=-1) {//배열의 i번째에 저장되어있는것중 검색할려하는 단어가 포함되어있지않은게 아니라면 들어가게됨
    System.out.println(list[i]);
    found=1; //찾았다는 변수 1로 정함
   }
  }
  if(found==0) {//못찾았을시
   System.out.println("찾지못했습니다");
  }
 }
 void list() {//책리스트를 보여주는 메서드
  System.out.println("저장된책리스트");
  for(int i=0;i<index; i++) {//배열에 저장되어있는 문자만큼만 반복
   System.out.println(list[i]);
  }
 }
 void add(String Name) {//책을 추가하는 메서드
  list[index]=Name;//배열의 인덱스번째에 추가할책의 이름을 넣어둠
  index+=1;//인덱스를 1더함. 안더하면 같은자리에서 돌아버림
  System.out.println("추가되었습니다");
 }
}

