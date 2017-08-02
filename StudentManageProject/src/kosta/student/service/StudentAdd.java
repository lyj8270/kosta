package kosta.student.service;
import java.util.Scanner;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class StudentAdd implements StudentService {

	@Override
	public void excute(Scanner scan) {
		int num = 0;
		String name = "";
		String addr = ""; 
		String gender = "";
		String ban = "";
		double height = 0.0;
		int age = 0;
		int year = 0;
		
	
			System.out.println("==================== �л� ���� �Է� ====================");
			try {
				System.out.print("��ȣ�� �Է��ϼ��� > ");
				num = scan.nextInt(); scan.nextLine();
				System.out.print("�̸��� �Է��ϼ��� > ");
				name = scan.nextLine();
				System.out.print("�ּҸ� �Է��ϼ��� > ");
				addr = scan.nextLine();
				System.out.print("������ �Է��ϼ��� > ");
				gender = scan.nextLine();
				System.out.print("���� �Է��ϼ���(A/B/C/D) > ");
				ban = scan.nextLine();
				System.out.print("Ű�� �Է��ϼ��� > ");
				height = scan.nextDouble(); scan.nextLine();
				System.out.print("���̸� �Է��ϼ��� > ");
				age = scan.nextInt(); scan.nextLine();
				System.out.print("�г��� �Է��ϼ���(1/2/3/4) > ");
				year = scan.nextInt(); scan.nextLine();
				
				StudentManager.studentAdd(new Student(num, name, addr, gender, ban, height, age, year));
				System.out.println("�л����� ������ �Ϸ��Ͽ����ϴ�\n");
				
			} catch (Exception e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� �޴��� ���ư��ϴ�\n");
			}
			
			
		//	StudentManager.studentAdd();

	}
}










