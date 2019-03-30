
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
public class test extends Applet implements KeyListener 
{
int refreshRate=100;
int rect_x=240;
int rect_x2=240;
int rect_l=260;
int rect_r=260;
int ball_size=30;
Timer timer;
int [] ball= {140,140};
int [] ball_vel= {2,5};
int [] rect= {10,580,10,580};

public void init() 
{
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

public void paint(Graphics g) 
{
	g.drawRect(rect[0],rect[2], rect[1],rect[1]);
      
	g.setColor(Color.magenta);
	g.fillOval(ball[0],ball[1], ball_size, ball_size);
	
	g.setColor(Color.black);
	g.fillRect(rect_x,570,90,20); // bottom rectangle
    g.fillRect(10,rect_l,20,90);  // left rectangle
    g.fillRect(570,rect_r,20,90); // right rectangle
	g.fillRect(rect_x2,10,90, 20); // top rectangle
}
public void move() 
{
	
	ball[0]+=ball_vel[0];
	ball[1]+=ball_vel[1];
	
	if(ball[0]<=rect[0]+20)            // for left 
	{
	   if(ball[0]==rect[0]+20 && ball[1]>=rect_l && ball[1]<=rect_l+90)
		   ball_vel[0]= -ball_vel[0];
	}
	if(ball[0]>=rect[1]-40)
	{
		if(ball[0]==rect[1]-40 && ball[1]>=rect_r && ball[1]<=rect_r+90) 
		  ball_vel[0]= -ball_vel[0];
	}
	if(ball[1] <= rect[2]+20)                               // for top
	{                                   
	 	if(ball[1]==rect[2]+20 && ball[0]>=rect_x2-20 && ball[0]<=rect_x2+90)
		ball_vel[1]= -ball_vel[1];
	}
	if(ball[1] >= rect[3]-40)                                // for bottom
	{
		if(ball[1]==rect[3]-40 && ball[0]>=rect_x-20 && ball[0]<= rect_x+90)
			ball_vel[1]= -ball_vel[1];
	}
}
public void keyPressed(KeyEvent e)
{
if(e.getKeyCode()==e.VK_LEFT)
 {
	if(rect_x>10)
	 rect_x-=10;
 } 
	
if(e.getKeyCode()==e.VK_RIGHT) 
 {
	if(rect_x<500)
    	rect_x+=10;
 }
if(e.getKeyCode()==e.VK_UP) 
 {
	if(rect_l>10)
		rect_l-=10;
 }
if(e.getKeyCode()==e.VK_DOWN) 
 {
	if(rect_l<480)
		rect_l+=10;
 }

if(e.getKeyCode()==e.VK_A) 
 {
	if(rect_x2>10)
		rect_x2-=10;
 }
if(e.getKeyCode()==e.VK_D)
 {
	if(rect_x2<500)
		rect_x2+=10;
 }
if(e.getKeyCode()== e.VK_W)
 {
  if(rect_r>10)
	  rect_r-=10;
 }
if(e.getKeyCode()== e.VK_S)
{
	if(rect_r<480)
		rect_r+=10;
}
}

}