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
		
		System.out.println(" ==================== 학생 리스트 출력 =====================");		
		int menu = 0;
		
		while(menu !=4){

			try {
				System.out.println("1.이름순(오름차순)\n2.성적순(내림차순)\n3.반별\n4.나가기");
				System.out.print("메뉴를 선택하세요 > ");	
				menu = scan.nextInt(); scan.nextLine();
				System.out.println();
				
				switch(menu){		
				case 1:
					System.out.println("  ------------------------  이름순   ------------------------");
					System.out.println("   번호        이름      지역    성별     반       키       나이   점수  학년  성적");
					StudentManager.nameSort().stream()
					.forEach( s -> {
						System.out.printf(
								"%5d  %5s  %4s    %3s     %3s   %4.1f  %3d  %4d  %2d   %3s\n",
								s.getNum(), s.getName(), s.getAddr(), s.getGender(), s.getBan(), s.getHeight(), s.getAge(), s.getScore(),s.getYear(),s.getGrade());
					});
					System.out.println();
					break;
					
				case 2:
					System.out.println("  ------------------------  성적순   ------------------------");
					System.out.println("   번호        이름      지역    성별     반       키       나이   점수  학년  성적");
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
						System.out.println("  --------------------------- "+ban+"반 --------------------------");
						System.out.println("   번호        이름      지역    성별     반       키       나이   점수  학년  성적");
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
					System.out.println("이전 메뉴로 돌아갑니다\n");
					break;
				default :
					System.out.println("메뉴의 숫자를 입력해주세요\n");
					break;
						
					
				}
			} catch (Exception e) {
				System.out.println("메뉴의 숫자를 입력해 주세요\n");
				scan.nextLine();
			}

		}
		
	}
}
