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

	// 1. 학생정보 추가 (번호/이름/주소/성별/반/키/나이/학년)
	// 2. 성적정보 추가 (번호입력 -> 성적입력)
	// 3. 학생리스트 출력
	//   3.1. 이름 오름차순 정렬
	//   3.2. 성적 내림차순 정렬
	//   3.3. 반별 리스트 출력
	// 4. 학생정보 검색
	//   4.1. 주소 검색
	//   4.2. 이름 검색
	// 5. 통계
	//   5.1. 성별별 그룹핑
	//   5.2. 반별 성적 평균
	//   5.3. 주소별 성적 평균
	//   5.4. 학년별 키 평균
	// 0. 종료
	// Exception 처리, 성공/실패여부메시지 출력

	public static void main(String[] args) {

		StudentService studentService = null;
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		System.out.println("프로그램을 시작합니다\n");

		while (true) {

			try {
				System.out.println(" ********************** 메인 메뉴 ***********************");
				System.out.println("1.학생 정보 추가\n2.성적 정보 추가\n3.학생 리스트 출력\n4.학생 정보 검색\n5.통계\n0.종료");
				System.out.print("메뉴를 선택하세요 > ");
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
					System.out.println("프로그램을 종료합니다");
					if (scan != null)
						scan.close();
					System.exit(0);
					break;
				default :
					System.out.println("메뉴의 숫자를 입력해주세요\n");
					break;					
				}
			} catch (Exception e) {
				System.out.println("메뉴의 숫자를 입력해주세요\n");
				scan.nextLine();
				
//				throw new AllException("숫자를 입력하세요");
			}

		}

	}

}

// Logger logger = Logger.getLogger("Student project");
// logger.info("Student");
