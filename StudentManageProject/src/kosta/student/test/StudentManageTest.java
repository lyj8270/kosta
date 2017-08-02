package kosta.student.test;

import java.util.Scanner;

import kosta.student.exception.AllException;
import kosta.student.service.PrintStudent;
import kosta.student.service.ScoreAdd;
import kosta.student.service.SearchStudent;
import kosta.student.service.StatisticStudent;
import kosta.student.service.StudentAdd;
import kosta.student.service.StudentService;

public class StudentManageTest {

	// 1. �л����� �߰� (��ȣ/�̸�/�ּ�/����/��/Ű/����/�г�)
	// 2. �������� �߰� (��ȣ�Է� -> �����Է�)
	// 3. �л�����Ʈ ���
	//   3.1. �̸� �������� ����
	//   3.2. ���� �������� ����
	//   3.3. �ݺ� ����Ʈ ���
	// 4. �л����� �˻�
	//   4.1. �ּ� �˻�
	//   4.2. �̸� �˻�
	// 5. ���
	//   5.1. ������ �׷���
	//   5.2. �ݺ� ���� ���
	//   5.3. �ּҺ� ���� ���
	//   5.4. �г⺰ Ű ���
	// 0. ����
	// Exception ó��, ����/���п��θ޽��� ���

	public static void main(String[] args) {

		StudentService studentService = null;
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		System.out.println("���α׷��� �����մϴ�\n");

		while (true) {

			try {
				System.out.println(" ********************** ���� �޴� ***********************");
				System.out.println("1.�л� ���� �߰�\n2.���� ���� �߰�\n3.�л� ����Ʈ ���\n4.�л� ���� �˻�\n5.���\n0.����");
				System.out.print("�޴��� �����ϼ��� > ");
				menu = scan.nextInt();
				scan.nextLine();
				System.out.println();
				switch (menu) {

				case 1:
					studentService = new StudentAdd();
					studentService.excute(scan);
					break;
				case 2:
					studentService = new ScoreAdd();
					studentService.excute(scan);
					break;
				case 3:
					studentService = new PrintStudent();
					studentService.excute(scan);
					break;
				case 4:
					studentService = new SearchStudent();
					studentService.excute(scan);
					break;
				case 5:
					studentService = new StatisticStudent();
					studentService.excute(scan);
					break;
				case 0:
					System.out.println("���α׷��� �����մϴ�");
					if (scan != null)
						scan.close();
					System.exit(0);
					break;
				default :
					System.out.println("�޴��� ���ڸ� �Է����ּ���\n");
					break;					
				}
			} catch (Exception e) {
				System.out.println("�޴��� ���ڸ� �Է����ּ���\n");
				scan.nextLine();
				
//				throw new AllException("���ڸ� �Է��ϼ���");
			}

		}

	}

}

// Logger logger = Logger.getLogger("Student project");
// logger.info("Student");
