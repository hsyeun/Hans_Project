package text;

import java.util.*;

class system{ //�ϳ��� ��踦 ��Ÿ���� Ŭ����
 int index=9;//å�� �߰��Ҷ� �˸´� �ε����� �ֱ����� ���纯��
 int found=0;//ã�Ҵ��� ��ã�Ҵ��� �Ǻ��ϴº���
 String[] list=new String[100];//100���ڸ��� �迭�� ������. å����Ʈ�� �����صδ°�
 void setting() {//�⺻å�� �־���°�
  list[0]="�佺Ʈ";
  list[1]="����� �Ǵ�";
  list[2]="1cm ���̺�";
  list[3]="���� ����4";
  list[4]="��Ÿ���� �н���";
  list[5]="�̰��� �ڹٴ�";
  list[6]="ȥ�� �����ϴ� �ڹ�";
  list[7]="Do it! �ڹ� ���α׷��� �Թ�";
  list[8]="Do it! ����Ŭ�� ���� �����ͺ��̽� �Թ�";
 }
 void search(String Name) {//å�� ã�� �޼���
  System.out.println("�˻����");
  for(int i=0;i<index; i++) {//�迭�� ����Ǿ��ִ¸�ŭ �ݺ��ϵ�����
   if(list[i].indexOf(Name)!=-1) {//�迭�� i��°�� ����Ǿ��ִ°��� �˻��ҷ��ϴ� �ܾ ���ԵǾ����������� �ƴ϶�� ���Ե�
    System.out.println(list[i]);
    found=1; //ã�Ҵٴ� ���� 1�� ����
   }
  }
  if(found==0) {//��ã������
   System.out.println("ã�����߽��ϴ�");
  }
 }
 void list() {//å����Ʈ�� �����ִ� �޼���
  System.out.println("�����å����Ʈ");
  for(int i=0;i<index; i++) {//�迭�� ����Ǿ��ִ� ���ڸ�ŭ�� �ݺ�
   System.out.println(list[i]);
  }
 }
 void add(String Name) {//å�� �߰��ϴ� �޼���
  list[index]=Name;//�迭�� �ε�����°�� �߰���å�� �̸��� �־��
  index+=1;//�ε����� 1����. �ȴ��ϸ� �����ڸ����� ���ƹ���
  System.out.println("�߰��Ǿ����ϴ�");
 }
}

