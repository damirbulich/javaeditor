package zad3;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Zad3 extends JFrame implements ChangeListener{
	
	JFrame win;
	JSlider rad;
	JSlider r;
	JSlider g;
	JSlider b;
	
	public static void main(String[] args) {
		Zad3 win = new Zad3();
		win.circle(null);
	}
	
	public Zad3() {
		this.setLayout(new BorderLayout());
		this.setSize(500, 400);
		rad = new JSlider(0,100,68);
		rad.addChangeListener(this);
		r = new JSlider(0,255,15);
		r.addChangeListener(this);
		g = new JSlider(0,255,15);
		g.addChangeListener(this);
		b = new JSlider(0,255,15);
		b.addChangeListener(this);
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		JPanel sub = new JPanel();
		sub.setLayout(new BorderLayout());
		JPanel red = new JPanel();
		red.setLayout(new BorderLayout());
		JPanel green = new JPanel();
		green.setLayout(new BorderLayout());
		JPanel blue = new JPanel();
		blue.setLayout(new BorderLayout());
		JPanel radius = new JPanel();
		radius.setLayout(new BorderLayout());
		
		//this.circle(null);
		
		radius.add(new JLabel("Radijus:"), BorderLayout.NORTH);
		radius.add(rad, BorderLayout.SOUTH);
		
		red.add(new JLabel("Crvena:"), BorderLayout.NORTH);
		red.add(r, BorderLayout.SOUTH);
		
		green.add(new JLabel("Zelena:"),BorderLayout.NORTH);
		green.add(g, BorderLayout.SOUTH);
		
		blue.add(new JLabel("Plava:"), BorderLayout.NORTH);
		blue.add(b, BorderLayout.SOUTH);
		
		sub.add(red, BorderLayout.NORTH);
		sub.add(green, BorderLayout.SOUTH);
		main.add(radius, BorderLayout.NORTH);
		main.add(sub, BorderLayout.CENTER);
		main.add(blue, BorderLayout.SOUTH);
		this.add(main, BorderLayout.WEST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void circle(Graphics gr) {
		int radius = rad.getValue();
		Color c = new Color(r.getValue(), g.getValue(), b.getValue());
		gr.setColor(c);
		gr.drawOval(300, 300, radius, radius);
		gr.fillOval(300, 300, radius, radius);
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		this.circle(null);
	}

}
