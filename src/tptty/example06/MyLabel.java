package tptty.example06;

import java.awt.Color;


import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyLabel extends JLabel {
		
	Color[] color = {Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.PINK, Color.YELLOW};		
	List<MyData> data = new ArrayList<>();
	Random rand = new Random();
	
	public MyLabel() {
		super();
		this.setOpaque(true);
		this.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				data.add(new MyData(e.getPoint(), color[rand.nextInt(color.length)]));
				//(마우스가 클릭된 곳의 위치, color배열에서 랜덤선택)
				repaint();
			}
			
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for(MyData o : data) {
			g.setColor(o.color);
			g.fillOval(o.pos.x-5, o.pos.y-5, 10, 10);
			//위의 색깔로 채워진 원을 그림
		}
	}
	
}
