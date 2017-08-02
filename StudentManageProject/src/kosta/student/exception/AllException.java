package kosta.student.exception;

public class AllException extends RuntimeException {
	
	public AllException(String msg){
		super(msg);
	}
	
	// 쓰고 싶은 곳에 
	//throw new AllException(" 메시지 ")

}
