package tptty.example02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestMain02 {

	public static void main(String[] args) {
		try {
			FileWriter fout = new FileWriter("data/copyQuiz2.txt");
			FileReader fin = new FileReader("data/quiz.txt");
			
			//문자를 1024개씩 읽어냄
			char[] buffer = new char[1024];

			while (true) {
				
				int len = fin.read(buffer); // buffer에 있는 걸 읽고 길이 반환

				if (len > 0) { 
					fout.write(buffer, 0, len); //1024까지 없을 수 있으니, 읽어낸 len까지 wrtie
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
