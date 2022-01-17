package tptty.example02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestMain {

	public static void main(String[] args) {
		try {
			FileWriter fout = new FileWriter("data/copyQuiz.txt");
			FileReader fin = new FileReader("data/quiz.txt");
			
			while(true) {
				int data = fin.read(); //int형으로 문자를 저장
				if(data!=-1) {
					fout.write(data); //int형으로 출력하는게 아니라 문자로 출력
				}else //더 이상 읽어낼 게 없음
					break;
			}
			fout.flush();
			fout.close();
			fin.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
