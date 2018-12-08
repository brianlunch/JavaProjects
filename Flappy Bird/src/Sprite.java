import processing.core.PApplet;

public class Sprite {
	int spriteSize;
	PApplet p;
	int xPos = 100;
	float yPos = 235;
	float speed =(float) 4;
	int tap= 10;
	char key = ' ';
	Obstacle obstacle;
	Obstacle obstacle1;
	Boolean done=false ;
	
	public Sprite(int spriteSize, PApplet p, Obstacle obstacle, Obstacle obstacle1) {
		this.spriteSize = spriteSize;
		this.p = p;
		this.obstacle = obstacle;
		this.obstacle1 = obstacle1;
	}
	
	public void draw() {
		p.fill(255,0,0);
		p.noStroke();
		
		p.rect(xPos, yPos, spriteSize, spriteSize);
		yPos+=speed;
		
		if(p.keyPressed)
			yPos -= tap;
	}
	
	public void collide() {
		if(120 >= obstacle.xPos &&   120 <= obstacle.xPos + 75 && yPos <= obstacle.upperLength - 5 || yPos <= 25)
		done =true;
		if(120 >= obstacle1.xPos && 120 <= obstacle1.xPos + 75 && yPos <= obstacle1.upperLength - 5 || yPos <= 25)
		done =true;
		if(120 >= obstacle1.xPos && 120 <= obstacle1.xPos + 75 && yPos + 20 >= obstacle1.yPosLow + 5|| yPos >= 455)
			done =true;
		if(120 >= obstacle.xPos && 120 <= obstacle.xPos + 75 && yPos + 20 >= obstacle.yPosLow + 5|| yPos >= 455)
			done =true;
	}
}
