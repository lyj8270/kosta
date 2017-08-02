package kosta.student.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class PrintStudent implements StudentService{

	@Override
	public void excute(Scanner scan) {
		
		System.out.println(" ==================== �л� ����Ʈ ��� =====================");		
		int menu = 0;
		
		while(menu !=4){

			try {
				System.out.println("1.�̸���(��������)\n2.������(��������)\n3.�ݺ�\n4.������");
				System.out.print("�޴��� �����ϼ��� > ");	
				menu = scan.nextInt(); scan.nextLine();
				System.out.println();
				
				switch(menu){		
				case 1:
					System.out.println("  ------------------------  �̸���   ------------------------");
					System.out.println("   ��ȣ        �̸�      ����    ����     ��       Ű       ����   ����  �г�  ����");
					StudentManager.nameSort().stream()
					.forEach( s -> {
						System.out.printf(
								"%5d  %5s  %4s    %3s     %3s   %4.1f  %3d  %4d  %2d   %3s\n",
								s.getNum(), s.getName(), s.getAddr(), s.getGender(), s.getBan(), s.getHeight(), s.getAge(), s.getScore(),s.getYear(),s.getGrade());
					});
					System.out.println();
					break;
					
				case 2:
					System.out.println("  ------------------------  ������   ------------------------");
					System.out.println("   ��ȣ        �̸�      ����    ����     ��       Ű       ����   ����  �г�  ����");
					StudentManager.scoreSort().stream()
					.forEach( s -> {
						System.out.printf(
								"%5d  %5s  %4s    %3s     %3s   %4.1f  %3d  %4d  %2d   %3s\n",
								s.getNum(), s.getName(), s.getAddr(), s.getGender(), s.getBan(), s.getHeight(), s.getAge(), s.getScore(),s.getYear(),s.getGrade());
					});	
					System.out.println();
					break;
					
				case 3:
					Map<String, List<Student>> map = StudentManager.banMap();
//					Iterator<String> it = map.keySet().iterator();
//					Iterator<Entry<String, List<Student>>> ite = map.entrySet().iterator();					
//					while(it.hasNext()){
//						String s = it.next();
//												
//					}
					
					Iterator<String> it = map.keySet().iterator();
					while(it.hasNext()){
						String ban = it.next();
						System.out.println("  --------------------------- "+ban+"�� --------------------------");
						System.out.println("   ��ȣ        �̸�      ����    ����     ��       Ű       ����   ����  �г�  ����");
						map.get(ban).stream()
						.forEach( s -> {
							System.out.printf(
									"%5d  %5s  %4s    %3s     %3s   %4.1f  %3d  %4d  %2d   %3s\n",
									s.getNum(), s.getName(), s.getAddr(), s.getGender(), s.getBan(), s.getHeight(), s.getAge(), s.getScore(),s.getYear(),s.getGrade());
						});			
					
					}
					System.out.println();
					break;
				case 4:
					System.out.println("���� �޴��� ���ư��ϴ�\n");
					break;
				default :
					System.out.println("�޴��� ���ڸ� �Է����ּ���\n");
					break;
						
					
				}
			} catch (Exception e) {
				System.out.println("�޴��� ���ڸ� �Է��� �ּ���\n");
				scan.nextLine();
			}

		}
		
	}
}
