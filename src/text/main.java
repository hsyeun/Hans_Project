package text;

import java.util.Scanner;

	public class main {
		 public static void main(String[] args) {
		  Scanner scanner=new Scanner(System.in); //��ĳ�� ��ü ����
		  system systems=new system();//�ý���Ŭ���� ��ü ����
		  String UserInput="";//����ڰ� �Է��Ѱ��� �־�δ� ����
		  System.out.println("å�˻����α׷�");
		  systems.setting();//�ý����� ���ø޼��� ����
		  while(true) {//���ѹݺ���
		   System.out.println("1.å�˻� 2.å����Ʈ 3.å�߰��ϱ�");
		   UserInput=scanner.nextLine();//������ �Է¹��� ���ڸ� UserInput�� �־��
		   if(UserInput.equals("1")) {//1�� �Է��ߴ��� üũ
		    System.out.println("ã�� å�� �Է��ϼ���");
		    UserInput=scanner.nextLine();//������ �Է¹����� UserInput�� �־��
		    systems.search(UserInput);//�ý����� �˻��޼��忡 ����ڰ� �Է��Ѱ� �Ѱ���
		   }
		   else if(UserInput.equals("2")) { //2�� �Է��ߴ��� üũ
		    systems.list();
		    
		   }
		   else if(UserInput.equals("3")) { //3�� üũ�ߴ��� üũ
		    System.out.println("�߰���å�� �̸��� �Է��ϼ���");
		    UserInput=scanner.nextLine(); //������ ���� ���ڸ� �Է¹ް� �־��
		    systems.add(UserInput);//�ý����� add�� ����ڿ��� �Է¹����� �־���
		    
		   }
		   else { //�߸��ߴ��� üũ
		    System.out.println("�߸��Է�");
		   }
		  }
		  
		  
		 }

		}




