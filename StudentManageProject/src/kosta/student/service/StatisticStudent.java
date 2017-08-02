package kosta.student.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class StatisticStudent implements StudentService{

	@Override
	public void excute(Scanner scan) {
		System.out.println(" ====================== �л� ��� =======================");
		int menu = 0;
		while(menu != 5){
			try {
				System.out.println("1.���� �׷�\n2.�ݺ� ��� ����\n3.�ּҺ� ��� ����\n4.�г⺰ ��� Ű\n5.������");
				System.out.print("�޴��� �����ϼ��� > ");
				menu = scan.nextInt(); scan.nextLine();
				System.out.println();
				
				switch(menu){		
				case 1:
					Map<String, List<Student>> map1 = StudentManager.genderGroup();
					Iterator<String> it = map1.keySet().iterator();
					while(it.hasNext()){
						String gender = it.next();
						System.out.println("  -------------------------- "+gender+" --------------------------");
						System.out.println("   ��ȣ        �̸�      ����    ����     ��       Ű       ����   ����  �г�  ����");
						map1.get(gender).stream()
						.forEach( s -> {
							System.out.printf(
									"%5d  %5s  %4s    %3s     %3s   %4.1f  %3d  %4d  %2d  %3s\n",
									s.getNum(), s.getName(), s.getAddr(), s.getGender(), s.getBan(), s.getHeight(), s.getAge(), s.getScore(),s.getYear(),s.getGrade());
						});				
					}
					System.out.println();
					break;
					
				case 2:
					System.out.println("  -------------------- �ݺ� ���� ��� --------------------");
					Map<String, Double> map2 = StudentManager.banAverageScore();
					map2.entrySet().stream()
					.forEach( t  -> {
						System.out.printf("  %s�� : %4.2f��\n",t.getKey(),t.getValue());
					});
					System.out.println();
					break;
					
				case 3:
					System.out.println("  ------------------- ������ ���� ��� -------------------");
					Map<String, Double> map3 = StudentManager.addrAverageScore();
					map3.entrySet().stream()
					.forEach( t  -> {
						System.out.printf("  %s���� : %4.2f��\n",t.getKey(),t.getValue());
					});
					System.out.println();
					break;
				case 4:
					System.out.println("  ------------------- �г⺰ ���� ��� -------------------");

					Map<Integer, Double> map4 = StudentManager.yearAverageHeight();
					map4.entrySet().stream()
					.forEach( t  -> {
						System.out.printf("  %d�г� : %4.2fcm\n",t.getKey(),t.getValue());
					});
					System.out.println();
					break;
				case 5:
					System.out.println("���� �ܰ�� ���ư��ϴ�\n");
					break;
				default :
					System.out.println("�޴��� ���ڸ� �Է��� �ּ���\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("�޴��� ���ڸ� �Է��� �ּ���\n");
			}
			
		}	
	}
	// 5. ���
	//   5-1. ������ �׷���
	//   5-2. �ݺ� ���� ���
	//   5-3. �ּҺ� ���� ���
	//   5-4. �г⺰ Ű ���

}
