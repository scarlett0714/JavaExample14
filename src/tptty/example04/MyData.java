package tptty.example04;

import java.io.Serializable;

public class MyData implements Serializable{ //직렬화기능추가
	private static final long serialVersionUID = 1L; //고유한 클래스UID를 가짐
	String name;
	int num;		
	int score; 
	//오류발생 : 원래 name과 num있던 상태에서 score를 추가하고 TestMain02를 실행하면 오류발생
	//오류원인 : 클래스정보가 변경됨
	//해결방안 : 클래스UID
	
	MyData(String name, int num){
		this.name = name;
		this.num = num;
	}	

}
