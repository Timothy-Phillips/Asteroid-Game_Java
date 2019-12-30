package asteroidgame;

/*
 * University Of Central Florida
 * COP3330 - Spring 2019
 * Author: Timothy Phillips
 */

import blobz.PolyBlob;
import blobz.BlobUtils;
import java.util.Random;
import java.awt.Point;

public class Asteroid extends PolyBlob 
{
	private static final Random random = new Random();
	
	public Asteroid(int x, int y, double rot)
	{
		super(-100, -100, rot);
		super.setDelta(x, y);
		
		// Random (5-9)
		int numsides = random.nextInt(5) + 5;
		double regsize = (2 * Math.PI) / (numsides);
		
		double[] angle = new double[numsides];
		int[] distance = new int[numsides];
		Point[] p = new Point[numsides];
		
		for(int i = 0; i < numsides; i++)
		{
			// Random (5-15)
			distance[i] = random.nextInt(11) + 5;
			angle[i] = (i * regsize) + (Math.random() * regsize);
			p[i] = BlobUtils.rotatePoint(distance[i], angle[i]);
		}
		super.setPolygon(p);
	}
}
