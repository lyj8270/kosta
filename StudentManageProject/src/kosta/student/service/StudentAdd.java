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
		
	
			System.out.println("==================== 학생 정보 입력 ====================");
			try {
				System.out.print("번호를 입력하세요 > ");
				num = scan.nextInt(); scan.nextLine();
				System.out.print("이름을 입력하세요 > ");
				name = scan.nextLine();
				System.out.print("주소를 입력하세요 > ");
				addr = scan.nextLine();
				System.out.print("성별을 입력하세요 > ");
				gender = scan.nextLine();
				System.out.print("반을 입력하세요(A/B/C/D) > ");
				ban = scan.nextLine();
				System.out.print("키를 입력하세요 > ");
				height = scan.nextDouble(); scan.nextLine();
				System.out.print("나이를 입력하세요 > ");
				age = scan.nextInt(); scan.nextLine();
				System.out.print("학년을 입력하세요(1/2/3/4) > ");
				year = scan.nextInt(); scan.nextLine();
				
				StudentManager.studentAdd(new Student(num, name, addr, gender, ban, height, age, year));
				System.out.println("학생정보 저장을 완료하였습니다\n");
				
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다. 이전 메뉴로 돌아갑니다\n");
			}
			
			
		//	StudentManager.studentAdd();

	}
}










