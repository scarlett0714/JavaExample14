package tptty.example01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestMain {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("data/test.dat");
			FileInputStream fin = new FileInputStream("data/test.dat");
			//파일을 만들어놓지 않았더라도 파일이 생성됨
			
//			byte a = 100;
//			byte b = 110;
//			byte c = 120;
			//파일에 dnx라고 출력됨 : 실제 알파벳을 의미하는 것이 아님
			//-> 콘솔창에 출력된 걸 보면 100,110,120으로 출력됨
			
			//1byte(8 bit) : 0000 0000 ~ 1111 1111까지 표현 가능 : 0~255
			int a = 100; //0~255의 숫자들은 int를 쓰던 byte를 쓰던 문제 없음
			int b = 256; 
			// byte b = 256이라면, byte : 1 0000 0000 -> 0000 0000만 저장 가능(강제 형변환)
			// int b = 256이라면? 출력된 것을 보면 0이 나옴(위에 처럼)
			int c = 120;
			
			//byte데이터를 int형에 집어넣어 저장하고 int형의 맨 마지막 byte만 파일에 출력
			fout.write(a);
			fout.write(b);
			fout.write(c);
			
			fout.flush();
			fout.close();
			
			while(true) {
				int data = fin.read(); //1byte를 읽어 반환
				if(data!=-1) {
					System.out.println(data);
				}else //더 이상 읽어낼 게 없음
					break;
			}
			fin.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
