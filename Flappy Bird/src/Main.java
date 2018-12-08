import processing.core.PApplet;

public class Main extends PApplet{
	
	Sprite sprite;	
	Obstacle obstacle;
	Obstacle obstacle1;
	int score = 0;
	public static void main(String[] args) {
		PApplet.main("Main");
	}

	public void settings() {
		size(1000,500);
	}
	public void setup() {
		obstacle = new Obstacle(this, 1000);
		obstacle1 = new Obstacle(this, 1600);
		sprite = new Sprite(20, this, obstacle, obstacle1);
	}
	
	public void draw() {
		if(!sprite.done)
		{
		background(255);
		sprite.draw();
		obstacle.draw();
		obstacle1.draw();
		
		rect(0,0,1000,30);
		rect(0,470,1000,30);
		fill(255,0,0);
		textSize(30);
		text(score,500,26);
		if(obstacle.xPos == 100 || obstacle1.xPos == 100)
			score++;
		sprite.collide();
		}
		
		else
		{
			textSize(50);
			fill(255,0,0);
			text("Your Score was" + "\n" +"           " + score, 350, 240 ); 
			if(mousePressed)
			{
				background(255);
				sprite.yPos = 230;
				sprite.done = false;
				score =0;
				obstacle.xPos = 1000;
				obstacle1.xPos = 1600;
			}
		}
	}
}
