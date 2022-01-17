package tptty.example05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		File file = new File("data/words-ansi.txt");				
		try {
			Scanner scan = new Scanner(file, "euc-kr"); //"utf-8"	
			
			FileOutputStream fout = new FileOutputStream("data/copyQuiz5.txt");
			PrintWriter out = new PrintWriter(fout);
			while(scan.hasNext()) {
				String str = scan.nextLine();
//				System.out.println(str);
				out.println(str); //파일에 한줄씩 출력
			}
			scan.close();
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
