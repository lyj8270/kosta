
package kosta.student.manage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import kosta.student.vo.Student;

/**
 * Student 관련 데이터 처리
 *  - 입출력 불가
 */

public class StudentManager {
	
	private static List<Student> list = new LinkedList<>();
	
	
//	static{
//		list.add(new Student());
//	}
//	public static void studentAdd(){	
//		
//		list.add(new Student(101, "일길동", "서울", "남", "A", 180, 21, 89, 1));
//		list.add(new Student(102, "이길동", "대전", "여", "B", 170, 20, 85, 2));
//		list.add(new Student(103, "삼길동", "대구", "남", "C", 170, 22, 95, 2));
//		list.add(new Student(104, "사길동", "부산", "여", "D", 171, 21, 85, 2));
//		list.add(new Student(105, "오길동", "인천", "남", "D", 165, 26, 98, 4));
//		list.add(new Student(106, "육길동", "충남", "여", "C", 166, 23, 86, 3));
//		list.add(new Student(107, "칠길동", "전남", "남", "B", 182, 25, 77, 3));
//		list.add(new Student(108, "팔길동", "전북", "남", "A", 176, 24, 99, 2));
//		list.add(new Student(109, "구길동", "경북", "남", "B", 169, 30, 80, 4));
//		list.add(new Student(110, "홍길동", "경남", "여", "C", 166, 19, 92, 1));
//		
//		//list.add(s);	
//	}
		
	public static void studentAdd(Student s){	
		list.add(new Student(101, "일길동", "서울", "남", "A", 180, 21, 89, 1));
		list.add(new Student(102, "이길동", "대전", "여", "B", 170, 20, 85, 2));
		list.add(new Student(103, "삼길동", "대구", "남", "C", 170, 22, 95, 2));
		list.add(new Student(104, "사길동", "부산", "여", "D", 171, 21, 85, 2));
		list.add(new Student(105, "오길동", "인천", "남", "D", 165, 26, 98, 4));
		list.add(new Student(106, "육길동", "충남", "여", "C", 166, 23, 86, 3));
		list.add(new Student(107, "칠길동", "전남", "남", "B", 182, 25, 77, 3));
		list.add(new Student(108, "팔길동", "전북", "남", "A", 176, 24, 99, 2));
		list.add(new Student(109, "구길동", "경북", "남", "B", 169, 30, 80, 4));
		list.add(new Student(110, "홍길동", "경남", "여", "C", 166, 19, 92, 1));
		list.add(s);	
	}
	
	public static void scoreAdd(int num, int score){
		// 자바 7버전
//		Iterator<Student> it = list.iterator();		
//		while(it.hasNext()){
//			Student s = it.next();
//			if( s.getNum() == num ){
//				s.setScore(score);
//			}
//		}
		
		list.stream()
		.filter( s -> s.getNum()==num )
		.forEach( t -> t.setScore(score));
		
		
		
		
	}	
	
	public static List<Student> nameSort(){ // 이름 오름차순 정렬
		// 자바 7버전
//		list.sort(new Comparator<Student>() {
//			@Override
//			public int compare(Student s1, Student s2) {
//				return s1.getName().compareTo(s2.getName());
//			}
//		});		
//		return list;
	
		
		return list.stream()
				.sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
				.collect(Collectors.toList());
		
	}
	
	public static List<Student> scoreSort(){ // 성적 내림차순 정렬
		// 자바 7버전
//		list.sort(new Comparator<Student>(){
//			@Override
//			public int compare(Student s1, Student s2) {
//				return s2.getScore() - s1.getScore();
//			}			
//		});
//		return list;
		
		return list.stream()
				.sorted((s1,s2) -> s2.getScore()-s1.getScore())
				.collect(Collectors.toList());
	}
	
	public static Map<String, List<Student>> banMap(){
		// 자바 7버전
//		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
//		Iterator<Student> it = list.iterator();		
//		Set<String> tmpBan = new HashSet<String>();
//		
//		while(it.hasNext()){
//			tmpBan.add(it.next().getBan());
//		}
//		
//		for(String s : tmpBan){
//			List<Student> tmpList = new LinkedList<>();
//			for(Student student : list){
//				if(student.getBan().equals(s)){
//					tmpList.add(student);
//				}
//			}
//			map.put(s, tmpList);
//		}		
//		return map;
		
		return list.stream()
				.collect( Collectors.groupingBy( s -> s.getBan() , // 반별 그룹핑
								Collectors.toList())); // 반별 리스트
	}
	
	public static List<Student> addrSearch (String addr){
		// 자바 7버전
//		List<Student> addrList = new LinkedList<>();
//		Iterator<Student> it = list.iterator();
//		Student student = null;
//		while(it.hasNext()){
//			student = it.next();
//			if(addr.equals(student.getAddr())){
//				addrList.add(student);
//			}
//		}
//		return addrList;
		
		
		return list.stream()
				.filter( s -> addr.equals(s.getAddr()))
				.collect(Collectors.toList());
	}
	
	public static List<Student> nameSearch (String name){
		//자바 7버전
//		List<Student> nameList = new LinkedList<>();
//		Iterator<Student> it = list.iterator();
//		Student student = null;
//		while(it.hasNext()){
//			student = it.next();
//			if(name.equals(student.getName())){
//				nameList.add(student);
//			}
//		}
//		return addrList;
		
		return list.stream()
				.filter( s -> name.equals(s.getName()))
				.collect(Collectors.toList());
	}
	
	// 5. 통계
	//   5-1. 성별별 그룹핑
	//   5-2. 반별 성적 평균
	//   5-3. 주소별 성적 평균
	//   5-4. 학년별 키 평균
	
	public static Map<String, List<Student>> genderGroup(){
		// 자바 7버전
		Map<String, List<Student>> map = new HashMap<String, List<Student>>();
		Iterator<Student> it = list.iterator();		
		Set<String> tmpGender = new HashSet<String>();
		
		while(it.hasNext()){
			tmpGender.add(it.next().getGender());
		}
		
		for(String s : tmpGender){
			List<Student> tmpList = new LinkedList<>();
			for(Student student : list){
				if(student.getGender().equals(s)){
					tmpList.add(student);
				}
			}
			map.put(s, tmpList);
		}		
		return map;	
		
//		return list.stream()
//				.collect(Collectors.groupingBy( s -> s.getGender() ,
//						Collectors.toList()));
	}
	
	public static Map<String, Double> banAverageScore(){
		// 자바 7버전
		Map<String, Double> map = new HashMap<String, Double>();
		Iterator<Student> it = list.iterator();		
		Set<String> tmpBan = new HashSet<String>();
		
		while(it.hasNext()){
			tmpBan.add(it.next().getBan());
		}
		
		for(String s : tmpBan){
			Double avgScore = 0.0;
			int total = 0;
			int count = 0;
			for(Student student : list){
				if(student.getBan().equals(s)){
					total += student.getScore();
					count++;
				}
			}
			avgScore = (double)total/count;
			map.put(s, avgScore);
		}		
		return map;
//		return list.stream()
//				.collect(Collectors.groupingBy( s -> s.getBan() , // 반별
//						Collectors.averagingDouble( t -> (double)t.getScore()))); // 성적평균
	}
	
	public static Map<String, Double> addrAverageScore(){
		// 자바 7버전
		Map<String, Double> map = new HashMap<String, Double>();
		Iterator<Student> it = list.iterator();		
		Set<String> tmpAddr = new HashSet<String>();
		
		while(it.hasNext()){
			tmpAddr.add(it.next().getAddr());
		}
		
		for(String s : tmpAddr){
			Double avgScore = 0.0;
			int total = 0;
			int count = 0;
			for(Student student : list){
				if(student.getAddr().equals(s)){
					total += student.getScore();
					count++;
				}
			}
			avgScore = (double)total/count;
			map.put(s, avgScore);
		}		
		return map;
		
//		return list.stream()
//				.collect(Collectors.groupingBy( s -> s.getAddr() , // 주소별
//						Collectors.averagingDouble( t -> (double)t.getScore()))); // 성적평균
	}
	
	public static Map<Integer, Double> yearAverageHeight(){
		// 자바 7버전
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		Iterator<Student> it = list.iterator();		
		Set<Integer> tmpYear = new HashSet<Integer>();
		
		while(it.hasNext()){
			tmpYear.add(it.next().getYear());
		}
		
		for(Integer i : tmpYear){
			Double avgScore = 0.0;
			int total = 0;
			int count = 0;
			for(Student student : list){
				if(student.getYear() == i ){
					total += student.getScore();
					count++;
				}
			}
			avgScore = (double)total/count;
			map.put(i, avgScore);
		}		
		return map;
//		return list.stream()
//				.collect(Collectors.groupingBy( s -> s.getYear() , // 학년별
//						Collectors.averagingDouble( t -> t.getHeight()))); // 키평균
	}
	
	
}



















