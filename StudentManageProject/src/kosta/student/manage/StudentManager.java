
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
 * Student ���� ������ ó��
 *  - ����� �Ұ�
 */

public class StudentManager {
	
	private static List<Student> list = new LinkedList<>();
	
	
//	static{
//		list.add(new Student());
//	}
//	public static void studentAdd(){	
//		
//		list.add(new Student(101, "�ϱ浿", "����", "��", "A", 180, 21, 89, 1));
//		list.add(new Student(102, "�̱浿", "����", "��", "B", 170, 20, 85, 2));
//		list.add(new Student(103, "��浿", "�뱸", "��", "C", 170, 22, 95, 2));
//		list.add(new Student(104, "��浿", "�λ�", "��", "D", 171, 21, 85, 2));
//		list.add(new Student(105, "���浿", "��õ", "��", "D", 165, 26, 98, 4));
//		list.add(new Student(106, "���浿", "�泲", "��", "C", 166, 23, 86, 3));
//		list.add(new Student(107, "ĥ�浿", "����", "��", "B", 182, 25, 77, 3));
//		list.add(new Student(108, "�ȱ浿", "����", "��", "A", 176, 24, 99, 2));
//		list.add(new Student(109, "���浿", "���", "��", "B", 169, 30, 80, 4));
//		list.add(new Student(110, "ȫ�浿", "�泲", "��", "C", 166, 19, 92, 1));
//		
//		//list.add(s);	
//	}
		
	public static void studentAdd(Student s){	
		list.add(new Student(101, "�ϱ浿", "����", "��", "A", 180, 21, 89, 1));
		list.add(new Student(102, "�̱浿", "����", "��", "B", 170, 20, 85, 2));
		list.add(new Student(103, "��浿", "�뱸", "��", "C", 170, 22, 95, 2));
		list.add(new Student(104, "��浿", "�λ�", "��", "D", 171, 21, 85, 2));
		list.add(new Student(105, "���浿", "��õ", "��", "D", 165, 26, 98, 4));
		list.add(new Student(106, "���浿", "�泲", "��", "C", 166, 23, 86, 3));
		list.add(new Student(107, "ĥ�浿", "����", "��", "B", 182, 25, 77, 3));
		list.add(new Student(108, "�ȱ浿", "����", "��", "A", 176, 24, 99, 2));
		list.add(new Student(109, "���浿", "���", "��", "B", 169, 30, 80, 4));
		list.add(new Student(110, "ȫ�浿", "�泲", "��", "C", 166, 19, 92, 1));
		list.add(s);	
	}
	
	public static void scoreAdd(int num, int score){
		// �ڹ� 7����
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
	
	public static List<Student> nameSort(){ // �̸� �������� ����
		// �ڹ� 7����
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
	
	public static List<Student> scoreSort(){ // ���� �������� ����
		// �ڹ� 7����
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
		// �ڹ� 7����
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
				.collect( Collectors.groupingBy( s -> s.getBan() , // �ݺ� �׷���
								Collectors.toList())); // �ݺ� ����Ʈ
	}
	
	public static List<Student> addrSearch (String addr){
		// �ڹ� 7����
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
		//�ڹ� 7����
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
	
	// 5. ���
	//   5-1. ������ �׷���
	//   5-2. �ݺ� ���� ���
	//   5-3. �ּҺ� ���� ���
	//   5-4. �г⺰ Ű ���
	
	public static Map<String, List<Student>> genderGroup(){
		// �ڹ� 7����
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
		// �ڹ� 7����
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
//				.collect(Collectors.groupingBy( s -> s.getBan() , // �ݺ�
//						Collectors.averagingDouble( t -> (double)t.getScore()))); // �������
	}
	
	public static Map<String, Double> addrAverageScore(){
		// �ڹ� 7����
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
//				.collect(Collectors.groupingBy( s -> s.getAddr() , // �ּҺ�
//						Collectors.averagingDouble( t -> (double)t.getScore()))); // �������
	}
	
	public static Map<Integer, Double> yearAverageHeight(){
		// �ڹ� 7����
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
//				.collect(Collectors.groupingBy( s -> s.getYear() , // �г⺰
//						Collectors.averagingDouble( t -> t.getHeight()))); // Ű���
	}
	
	
}



















