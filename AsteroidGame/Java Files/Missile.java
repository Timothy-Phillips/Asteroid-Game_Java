package asteroidgame;

/*
 * University Of Central Florida
 * COP3330 - Spring 2019
 * Author: Timothy Phillips
 */

import blobz.*;

import java.awt.Color;

public class Missile extends Blob implements BlobProximity
{
	public Missile(int x, int y, double angle)
	{
		super(x, y, Color.RED);
		double speed = 5;
		
		int dx = (int) Math.round(speed * Math.cos(angle));
		int dy = (int) Math.round(speed * Math.sin(angle));
		
		setDelta(dx, dy);
	}
}
