package tptty.example01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestMain02 {

	public static void main(String[] args) {
		
		try {
			//text파일이 아니라면 byte파일로 읽어내고 쓰기 : 어떤 파일이든 가능
			FileOutputStream fout = new FileOutputStream("data/copyBack2.jpg");
			//data폴더에 해당이름으로 복사파일이 생김
			FileInputStream fin = new FileInputStream("img/Back.jpg");
			
			
			//Q. 1byte씩 읽어내니까 너무 오래걸림
			// A. buffer를 만들어서 1024byte씩 읽고 쓰기
			byte[] buffer = new byte[1024];

			while (true) {
//				int data = fin.read(); //데이터를 읽고

//				if(data!=-1) {
//					fout.write(data); //데이터를 쓰고
//				}else //더 이상 읽어낼 게 없음
//					break;
				
				int len = fin.read(buffer); // buffer에 있는 걸 읽고 길이 반환

				if (len > 0) {
					fout.write(buffer, 0, len);
				} else
					break;
			}
			fout.flush();
			fout.close();
			fin.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
