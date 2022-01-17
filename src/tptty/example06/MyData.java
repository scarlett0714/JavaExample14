package tptty.example06;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

public class MyData implements Serializable{
	private static final long serialVersionUID = 1L;
	Point pos;
	Color color;			
	MyData(Point pos, Color color){
		this.pos = pos;
		this.color = color;
	}		
}
