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
		System.out.println(" ====================== 학생 통계 =======================");
		int menu = 0;
		while(menu != 5){
			try {
				System.out.println("1.성별 그룹\n2.반별 평균 점수\n3.주소별 평균 점수\n4.학년별 평균 키\n5.나가기");
				System.out.print("메뉴를 선택하세요 > ");
				menu = scan.nextInt(); scan.nextLine();
				System.out.println();
				
				switch(menu){		
				case 1:
					Map<String, List<Student>> map1 = StudentManager.genderGroup();
					Iterator<String> it = map1.keySet().iterator();
					while(it.hasNext()){
						String gender = it.next();
						System.out.println("  -------------------------- "+gender+" --------------------------");
						System.out.println("   번호        이름      지역    성별     반       키       나이   점수  학년  성적");
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
					System.out.println("  -------------------- 반별 성적 평균 --------------------");
					Map<String, Double> map2 = StudentManager.banAverageScore();
					map2.entrySet().stream()
					.forEach( t  -> {
						System.out.printf("  %s반 : %4.2f점\n",t.getKey(),t.getValue());
					});
					System.out.println();
					break;
					
				case 3:
					System.out.println("  ------------------- 지역별 성적 평균 -------------------");
					Map<String, Double> map3 = StudentManager.addrAverageScore();
					map3.entrySet().stream()
					.forEach( t  -> {
						System.out.printf("  %s지역 : %4.2f점\n",t.getKey(),t.getValue());
					});
					System.out.println();
					break;
				case 4:
					System.out.println("  ------------------- 학년별 신장 평균 -------------------");

					Map<Integer, Double> map4 = StudentManager.yearAverageHeight();
					map4.entrySet().stream()
					.forEach( t  -> {
						System.out.printf("  %d학년 : %4.2fcm\n",t.getKey(),t.getValue());
					});
					System.out.println();
					break;
				case 5:
					System.out.println("이전 단계로 돌아갑니다\n");
					break;
				default :
					System.out.println("메뉴의 숫자를 입력해 주세요\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("메뉴의 숫자를 입력해 주세요\n");
			}
			
		}	
	}
	// 5. 통계
	//   5-1. 성별별 그룹핑
	//   5-2. 반별 성적 평균
	//   5-3. 주소별 성적 평균
	//   5-4. 학년별 키 평균

}
