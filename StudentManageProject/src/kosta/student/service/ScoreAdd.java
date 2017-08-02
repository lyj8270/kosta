package kosta.student.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import kosta.student.manage.StudentManager;
import kosta.student.vo.Student;

public class ScoreAdd implements StudentService{

	@Override
	public void excute(Scanner scan) {
		int num = 0;
		int score = 0;		
		
		try {
			System.out.print("�л� ��ȣ�� �Է��ϼ��� > ");
			num = scan.nextInt(); scan.nextLine();
			

			System.out.println();
			
			System.out.print("������ �Է��ϼ��� > ");
			score = scan.nextInt(); scan.nextLine();
			System.out.println();
			
			StudentManager.scoreAdd(num, score);
			
		} catch (Exception e) {
			System.out.println("�߸� �ԷµǾ� ���� �޴��� ���ư��ϴ�");
		}
	}
}
