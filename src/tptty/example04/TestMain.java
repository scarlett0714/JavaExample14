package tptty.example04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//ArrayList도 직렬화 가능 & String도 직렬화 가능해야함
		list.add("greenjoa1");
		list.add("greenjoa2");
		list.add("greenjoa3");
		list.add("greenjoa4");
		
		try {
			//파일에 객체 출력
			FileOutputStream fout = new FileOutputStream("data/greenjoa.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout); //객체로 만들어 파일에 저장하기
			out.writeObject(list);
			out.flush();
			out.close();
			
			//파일에 있던 객체 읽어오기
			FileInputStream fin = new FileInputStream("data/greenjoa.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);
			@SuppressWarnings("unchecked")
			List<String> list1 = (List<String>) ois.readObject();
			for(String str : list1) {
				System.out.println(str);
			}
			ois.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
