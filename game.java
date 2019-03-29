
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
public class game extends Applet implements KeyListener {
	int refreshRate=20;
	int rect_x=240;
	int rect_x2=240;
	int ball_size=30;
	Timer timer;
	int [] ball= {140,140};
	int [] ball_vel= {2,5};
	int [] rect= {10,580,10,580};

	public void init() {
		setSize(1000,600);
		timer=new Timer();

		this.requestFocus();
		addKeyListener(this);
		timer.schedule(new TimerTask() {
			public void run() {
				move();
				repaint();
			}
		},0,refreshRate);
	}

	public void paint(Graphics g) {
		g.drawRect(rect[0],rect[2], rect[1],rect[1]);
	      
		g.setColor(Color.magenta);
		g.fillOval(ball[0],ball[1], ball_size, ball_size);
		
		g.setColor(Color.black);
		g.fillRect(rect_x,570,80,20);
		
		g.fillRect(rect_x2,10,80, 20);
	}
	public void move() {
		
		ball[0]+=ball_vel[0];
		ball[1]+=ball_vel[1];
		
		if(ball[0]<=rect[0] || ball[0]>=rect[1]-20)            // for left and right sides of rectangle
			ball_vel[0]= -ball_vel[0];
		
		if(ball[1] <= rect[2]+20)                               // for top
		{                                   
		 	if(ball[1]==30 && ball[0]>=rect_x2-20 && ball[0]<=rect_x2+80)
			ball_vel[1]= -ball_vel[1];
		}
		if(ball[1] >= rect[3]-40)                                // for bottom
		{
			if(ball[1]==540 && ball[0]>=rect_x-20 && ball[0]<= rect_x+80)
				ball_vel[1]= -ball_vel[1];
		}
	}
	public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==e.VK_LEFT) {
		if(rect_x>10)
		 rect_x-=10;
	}
		
	if(e.getKeyCode()==e.VK_RIGHT) {
		if(rect_x<510)
		rect_x+=10;
	}
		

	if(e.getKeyCode()==e.VK_A)
		if(rect_x2>10)
			rect_x2-=10;

	if(e.getKeyCode()==e.VK_D)
		if(rect_x2<510)
			rect_x2+=10;
	}
	}