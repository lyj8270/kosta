package kosta.student.service;

import java.util.Scanner;

import kosta.student.manage.StudentManager;

public class SearchStudent implements StudentService{

	@Override
	public void excute(Scanner scan) {
		System.out.println(" ==================== 학생 정보 검색 ====================");
		int menu = 0;
		while(menu !=3){
			try {
				System.out.println("1.주소 검색\n2.이름 검색\n3.나가기");
				System.out.print("메뉴를 선택하세요 > ");		
				menu = scan.nextInt(); scan.nextLine();
				System.out.println();
				String parm = "";
				
				switch(menu){
				case 1:
					System.out.print("검색할 주소를 입력하세요 > ");
					parm = scan.nextLine();
					System.out.println();
					
					if(StudentManager.addrSearch(parm).isEmpty()){
						System.out.println("해당 지역의 학생이 없습니다\n");
					}else{
						System.out.println(" ---------------------- "+parm+" 지역 학생 ----------------------");
						System.out.println("   번호        이름      지역    성별    반       키       나이   점수  학년  성적");
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
					System.out.print("검색할 이름을 입력하세요 > ");
					parm = scan.nextLine();
					System.out.println();
					
					if(StudentManager.nameSearch(parm).isEmpty()){
						System.out.println("해당 학생이 없습니다.\n");
					}else{
						System.out.println(" --------------------- 학생이름 : "+parm+" --------------------");
						System.out.println("   번호        이름      지역    성별    반       키       나이   점수  학년  성적");
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
					System.out.println("이전 단계로 돌아갑니다\n");
					break;
				default :
					System.out.println("메뉴의 숫자를 선택해주세요\n");
					break;
				}
			} catch (Exception e) {
				System.out.println("메뉴의 숫자를 입력해주세요\n");
				scan.nextLine();
			}
		}
		
		
		
	}

}
