import java.util.Random;

import processing.core.PApplet;

public class Obstacle {
	PApplet p;
	int xPos;
	int size;
	int obstacleWidth = 75;
	int lowerLength;
	int upperLength;
	int yPosLow;
	int yPosUp=0;
	Random random;
	public Obstacle(PApplet p, int xPos) {
		this.p = p;
		this.xPos= xPos;
		random = new Random();
		size = random.nextInt(320);
		lowerLength =size+50;
		upperLength = 500-size-150;
		yPosLow =450 - size;
	}
	
	
	public void draw() {
		p.noStroke();
		p.fill(0);
		p.rect(xPos-=3, yPosLow, obstacleWidth, lowerLength);
		p.rect(xPos-=3, yPosUp, obstacleWidth, upperLength);
		if(xPos < -80)
		{
			xPos = 1000;
			size = random.nextInt(300);
			lowerLength =size+50;
			upperLength = 500-size-150;
			yPosLow =450 - size;
		}
	}

}
