package tptty.example06;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	Container frame = this.getContentPane();	
	
	JButton btn1, btn2;
	JPanel btnPanel = new JPanel();
	MyLabel imgLabel= new MyLabel();	
	
	public MyFrame() {
		this("202110547 황윤선");
	}
	
	public MyFrame(String title) {
		super(title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	
	public void init() {
		btn1 = new JButton("불러오기");	
		btn1.addActionListener(e->{
			imgLabel.setIcon(new ImageIcon("data/Back.jpg"));
		});
		btn2 = new JButton("저장하기");
		btn2.addActionListener(e->{
			//이미지를 저장하기 위한 공간정보를 가진 객체 생성
			BufferedImage img = new BufferedImage(imgLabel.getWidth(), imgLabel.getHeight(), 
					BufferedImage.TYPE_INT_RGB); //이미지 유형 : RGB
			
			//빈공간인 img에 실제로 이미지를 출력하기 위해 Graphics객체 생성
			Graphics g = img.getGraphics();
			imgLabel.printAll(g); //imgLabel에 있는 모든것을 g에 출력 (g는 img와 연결됨)
			g.dispose();
			try {
				//이미지저장하는 클래스 : ImageIO
				ImageIO.write(img, "jpg", new File("data/Back.jpg"));
				//파일에 이미지를 저장하기 위한 메소드 ImageIO.write
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
		});
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		
		frame.add(btnPanel, BorderLayout.NORTH);
		frame.add(imgLabel, BorderLayout.CENTER);
				
	}
}


















