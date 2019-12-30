package asteroidgame;

/*
 * University Of Central Florida
 * COP3330 - Spring 2019
 * Author: Timothy Phillips
 */

import java.awt.Point;
import java.awt.Color;
import java.awt.event.KeyEvent;
import blobz.*;


public class Rocket extends PolyBlob implements BlobAction, BlobProximity
{
	private double angle = 0.0; 
	private final double delta = 0.15; 
	private final double speed = 5.0; 
	static SandBox sb;
	// Points for Player Ship
	Point[] rocketPoints =
		{
			new Point(10,0), new Point(-5, 5), new Point(-3, 0), new Point(-5, -5),
		};
	
	
	public Rocket(int x, int y, SandBox sandbox)
	{
		super(x, y, 0);
		this.setPolygon(rocketPoints);
		this.setColor(Color.CYAN);
		sb = sandbox;
	}
	 
	public void keyAction(KeyEvent e)
	 {		 
		 // Left
		 int key = e.getKeyCode();
		 if(key == 37)
		 {
			 angle = angle - delta;
			 if(angle < 0)
			 {
				 angle = angle +( 2 * (Math.PI));
			 }
			 this.setAngle(angle);
		 }
		 
		 // Right
		 else if(key == 39)
		 {
			 angle = angle + delta;
			 if(angle > (2 * (Math.PI)))
			 {
				 angle = angle - 2 * (Math.PI);
			 }
			 this.setAngle(angle);
		 }
		 
		 // Forward
		 else if(key == 38)
		 {
			 int xPos = this.getLoc().x;
			 int yPos = this.getLoc().y;
			 xPos = xPos + (int) Math.round(speed * Math.cos(angle));
			 yPos = yPos + (int) Math.round(speed * Math.sin(angle));
			 this.setLoc(xPos, yPos);
		 }
		 // Fire
		 else if(key == 32)
		 {
			 launch(sb);
		 }
	}
	
	public void launch(SandBox sb)
	{	
		int size = (getSize() / 2) + 5;
		Point pt = BlobUtils.rotatePoint(size, angle);
		Missile missile = new Missile(getLoc().x + pt.x, getLoc().y + pt.y, angle);
		sb.addBlob(missile);
	}
}
	