package tptty.example03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestMain02 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("bgm/01.mp3");
			FileOutputStream fout = new FileOutputStream("data/copy01.mp3");
			
			//성능향상 보조스트림
			BufferedInputStream bin = new BufferedInputStream(fin);
			BufferedOutputStream bout = new BufferedOutputStream(fout);			
						
			while(true) {
				int data = bin.read(); 
				if(data != -1) {
					bout.write(data);
				}else
					break;
			}
			bout.flush();
			bout.close();
			bin.close();
						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
