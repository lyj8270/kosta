package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

public class SearchStudent implements StudentService{

	@Override
	public void excute(Scanner scan) {
		System.out.println(" ==================== �л� ���� �˻� ====================");
		int menu = 0;
		while(menu !=3){
			try {
				System.out.println("1.�ּ� �˻�\n2.�̸� �˻�\n3.������");
				System.out.print("�޴��� �����ϼ��� > ");		
				menu = scan.nextInt(); scan.nextLine();
				System.out.println();
				String parm = "";
				
				switch(menu){
				case 1:
					System.out.print("�˻��� �ּҸ� �Է��ϼ��� > ");
					parm = scan.nextLine();
					System.out.println();
					
					if(StudentManager.addrSearch(parm).isEmpty()){
						System.out.println("�ش� ������ �л��� �����ϴ�\n");
					}else{
						System.out.println(" ---------------------- "+parm+" ���� �л� ----------------------");
						System.out.println("   ��ȣ        �̸�      ����    ����    ��       Ű       ����   ����  �г�  ����");
						StudentManager.addrSearch(parm).stream()
						.forEach( s -> {
							System.out.printf(
									"%5d  %5s  %4s    %3s    %3s   %4.1f  %3d  %4d  %2d   %2s\n",
									s.getNum(), s.getName(), s.getAddr(), s.getGender(), s.getBan(), s.getHeight(), s.getAge(), s.getScore(),s.getYear(),s.getGrade());
						});	
						System.out.println();
					}					
					break;
					
				case 2:
					System.out.print("�˻��� �̸��� �Է��ϼ��� > ");
					parm = scan.nextLine();
					System.out.println();
					
					if(StudentManager.nameSearch(parm).isEmpty()){
						System.out.println("�ش� �л��� �����ϴ�.\n");
					}else{
						System.out.println(" --------------------- �л��̸� : "+parm+" --------------------");
						System.out.println("   ��ȣ        �̸�      ����    ����    ��       Ű       ����   ����  �г�  ����");
						StudentManager.nameSearch(parm).stream()
						.forEach( s -> {
							System.out.printf(
									"%5d  %5s  %4s    %3s    %3s   %4.1f  %3d  %4d  %2d   %2s\n",
									s.getNum(), s.getName(), s.getAddr(), s.getGender(), s.getBan(), s.getHeight(), s.getAge(), s.getScore(),s.getYear(),s.getGrade());
						});
						System.out.println();
					}					
					break;
					
				case 3:
					System.out.println("���� �ܰ�� ���ư��ϴ�\n");
					break;
				default :
					System.out.println("�޴��� ���ڸ� �������ּ���\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���\n");
				scan.nextLine();
			}
		}
		
		
		
	}

}
