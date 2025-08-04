import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Smoke {
	
	public int x,y;
	public static BufferedImage[] smokeSprite;
	
	public int curFrames = 0, maxFrames = 10, maxAnim = 2, curAnim = 0;
	
	public Smoke(int x, int y) {
		this.x = x;
		this.y = y;
		smokeSprite = new BufferedImage[2];
		smokeSprite[0] = Game.spritesheet.getSprite(32, 0);
		smokeSprite[1] = Game.spritesheet.getSprite(48, 0);
	}
	
	public void tick() {
		curFrames++;
		if(curFrames == maxFrames) {
			curFrames = 0;
			curAnim++;
			if(curAnim == maxAnim) {
				curAnim = 0;
				Game.smoke.remove(this);
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(smokeSprite[curAnim],(int)x, (int)y, 40, 40, null);
	}
}
