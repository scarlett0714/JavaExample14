package tptty.example04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMain02 {

	public static void main(String[] args) {
		List<MyData> list = new ArrayList<>();
		//ArrayList도 직렬화 가능 & String도 직렬화 가능해야함
		list.add(new MyData("greenjoa1", 1));
		list.add(new MyData("greenjoa2", 2));
		list.add(new MyData("greenjoa3", 3));
		list.add(new MyData("greenjoa4", 10));
		
		try {
			//파일에 객체 출력
			FileOutputStream fout = new FileOutputStream("data/greenjoa1.dat");
			ObjectOutputStream out = new ObjectOutputStream(fout); //객체로 만들어 파일에 저장하기
			out.writeObject(list);
			out.flush();
			out.close();
			
			//파일에 있던 객체 읽어오기
			FileInputStream fin = new FileInputStream("data/greenjoa1.dat");
			ObjectInputStream ois = new ObjectInputStream(fin);		
			@SuppressWarnings("unchecked")
			List<MyData> list1 =(List<MyData>)ois.readObject();
			for(MyData str:list1) {
				System.out.println(str.name+ " : "+str.num);
			}
			ois.close();
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
