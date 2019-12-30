package asteroidgame;

/*
 * University Of Central Florida
 * COP3330 - Spring 2019
 * Author: Timothy Phillips
 */

import java.util.Random;

/*
 * University Of Central Florida
 * COP3330 - Spring 2019
 * Author: Timothy Phillips
 */

import blobz.BlobGUI;
import blobz.SandBox;
import blobz.SandBoxMode;

public class AsteroidGame implements BlobGUI
{
	static int asteroidCount;
	SandBox sb;
	
	// To ensure independent random generation for x and y values.
	private static final Random randomOne = new Random();
	private static final Random randomTwo = new Random();
	
	public static void main(String[] args) 
	{
		new AsteroidGame(Integer.parseInt(args[0]));
	}
	
	public AsteroidGame(int x)
	{
		asteroidCount = x;
		sb = new SandBox();
		sb.setSandBoxMode(SandBoxMode.FLOW);
		sb.setFrameRate(15);
		sb.init(this);
	}
	
	public void generate()
	{
		// Rocket
		int width = sb.getPanelBounds().width / 2;
		int height = sb.getPanelBounds().height / 2;
		
		Rocket rocket = new Rocket(width, height, sb);
		sb.addBlob(rocket);
		
		// Asteroids
		for(int k = 0; k < asteroidCount; k++)
		{
			int p = 0;
			while(p == 0)
			{
				p = randomOne.nextInt(7) - 3;
			}
			int x = p;
			p = 0;
			while(p == 0)
			{
				p = randomTwo.nextInt(7) - 3;
			}
			int y = p;
			
			double rotation;
			if (randomOne.nextInt(2) == 0)
			{
				rotation = -.1;
			}
			else
			{
				rotation = .1;
			}
			Asteroid asteroid = new Asteroid(x, y, rotation);
			sb.addBlob(asteroid);
	
		}
	}
}
