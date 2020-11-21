

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Fantome extends Creature {

	private Animation animfantome;
	private long lastTime=System.currentTimeMillis(),timer=0;
	private int a=(int) (Math.random()*9);
	private int b=(int) (Math.random()*9);
	private int c=(int) (Math.random()*9);
	private long lastAttackTimer,attackCooldown=800,attackTimer=attackCooldown;
	private Animation attackfantome;
	private Boolean Attack=false;
	private Animation animhealth;
	
	


	public Fantome(Game game,World world,float x, float y) {
		super(game,world,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		animfantome=new Animation(500,Assets.fantome);
		attackfantome=new Animation(500,Assets.fantome_attack);
		animhealth=new Animation(500,Assets.health);
		bounds.x=4;
		bounds.y=0;
		bounds.width=23;
		bounds.height=30;

	}
	protected void move(){
		if(!checkEntityCollisionsHero(xMove,0f))
		    moveX();
		if(!checkEntityCollisionsHero(0f,yMove))
		    moveY();
	}
	public void moveX(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

			if(tx==29){
				x -= xMove;
			}else {
				x+=xMove;
			}
			
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			if(tx==0){
				x -= xMove;
			}else {
				x+=xMove;
			}
		}
	}

	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if(ty==0){
				y -= yMove;
			}else {
				y += yMove;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if(ty==19){
				y -= yMove;
			}else {
				y += yMove;
			}
		}
	}
	@Override
	public void tick() {
		animhealth.tick();
		animfantome.tick();
		attackfantome.tick();
		getInput();
		move();
		checkAttacks();
		
	}
public void die() {
		
	}
private void checkAttacks() {
	attackTimer+=System.currentTimeMillis()-lastAttackTimer;
	lastAttackTimer=System.currentTimeMillis();
	if(attackTimer<attackCooldown) {
		Attack=false;
		return;}
	Rectangle ar=getCollisionBounds(-10,-10);
	ar.width=bounds.width+20;
	ar.height=bounds.height+10;
	attackTimer=0;

	if(world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(ar)) {
		world.getEntityManager().getHero().hurt(1);
		
		Attack=true;
		return;
	
		}
}
	private void getInput() {
		xMove=0;
		yMove=0;
		int[] L={-1,1,-1,-1,1,0,-1,1,0};
		timer+=System.currentTimeMillis() - lastTime;
		int[] T= {1000,2000,3000,4000,5000,1500,3500,4500,2500};
		
		if(timer>T[c]) {
		a=(int) (Math.random()*9);
		b=(int) (Math.random()*9);
		c=(int) (Math.random()*9);
		timer=0;
		}
		xMove=L[a]*speed;
		
		yMove=L[b]*speed;
		
		

		
		
		lastTime=System.currentTimeMillis();
	}
	private BufferedImage getCurrenthealth() {
		if(health==15) {
			return animhealth.getFrames(0);
		}else if(health==14){
			return animhealth.getFrames(1);
		}else if(health==13){
			return animhealth.getFrames(2);
		}else if(health==12){
			return animhealth.getFrames(3);
		}else if(health==11){
			return animhealth.getFrames(4);	
		}else if(health==10){
			return animhealth.getFrames(5);
		}else if(health==9){
			return animhealth.getFrames(6);
		}else if(health==8){
			return animhealth.getFrames(7);
		}else if(health==7){
			return animhealth.getFrames(8);
		}else if(health==6){
			return animhealth.getFrames(9);
		}else if(health==5){
			return animhealth.getFrames(10);
		}else if(health==4){
			return animhealth.getFrames(11);
		}else if(health==3){
			return animhealth.getFrames(12);
		}else if(health==2){
			return animhealth.getFrames(13);
		}else if(health==1){
			return animhealth.getFrames(14);
		}else {
			return animhealth.getFrames(15);	
		}
		
	    
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrenthealth(),(int) x,(int) y-10,width,10, null);
		if(!Attack) {
			
			g.drawImage(animfantome.getCurrentFrame(),(int) x,(int) y,width,height, null);
	}else {
		
		g.drawImage(attackfantome.getCurrentFrame(),(int) x,(int) y,width,height, null);
	}
	}
		
}



