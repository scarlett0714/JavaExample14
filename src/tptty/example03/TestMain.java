package tptty.example03;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

public class TestMain {

	public static void main(String[] args) {
		try {

			FileInputStream fin = new FileInputStream("data/quiz.txt");
			FileOutputStream fout = new FileOutputStream("data/copyQuiz3.txt");
//			FileInputStream fin = new FileInputStream("data/words-ansi.txt");
//			FileOutputStream fout = new FileOutputStream("data/copyQuiz4.txt");

			//ansi파일이지만 제대로 읽고싶은 경우 (인코딩모드 지정 가능 : 보조스트림에서만 /FileReader, FileWriter는 이런 기능x)
//			InputStreamReader reader = new InputStreamReader(fin, "euc-kr");
			InputStreamReader reader = new InputStreamReader(fin);
			OutputStreamWriter writer = new OutputStreamWriter(fout);

			char[] buffer = new char[1024];
			while (true) {
				int len = reader.read(buffer);
				if (len > 0) {
					writer.write(buffer, 0, len);
					// System.out.println(data);
				} else
					break;
			}
			writer.flush();
			writer.close();
			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
