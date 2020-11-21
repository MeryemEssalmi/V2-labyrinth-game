package Game.Code;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Monstre extends Creature {

	private Animation animmonstre;
	private Animation attackmonstre;
	private int a=(int) (Math.random()*9);
	private int b=(int) (Math.random()*9);
	private int c=(int) (Math.random()*9);
	private Boolean Attack=false;
	private long lastTime=System.currentTimeMillis(),timer=0;
	private long lastAttackTimer,attackCooldown=1500,attackTimer=attackCooldown;
	private Animation animhealth;
	public Monstre(Game game,World world,float x, float y) {
		super(game,world,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x=1;
		bounds.y=0;
		bounds.width=30;
		bounds.height=31;

		animmonstre=new Animation(500,Assets.monstre);
		attackmonstre=new Animation(500,Assets.monstre_attack);
		animhealth=new Animation(500,Assets.health);

	}
	public void moveM(){
		if(!checkEntityCollisionsHero(xMove,0f))
		    moveXM();
		if(!checkEntityCollisionsHero(0f,yMove))
		    moveYM();
	}

	public void moveXM(){
		if(xMove > 0){//Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
		}else if(xMove < 0){//Moving left
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)){
				x += xMove;
			}
		}
	}

	public void moveYM(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}
		}
	}

	@Override
	public void tick() {
		animhealth.tick();
		animmonstre.tick();
		attackmonstre.tick();
		
		getInput();
		moveM();
		checkAttacks();
		
	}
	private void checkAttacks() {
		attackTimer+=System.currentTimeMillis()-lastAttackTimer;
		lastAttackTimer=System.currentTimeMillis();
		if(attackTimer<attackCooldown) {
			Attack=false;
			return;}
		Rectangle ar=getCollisionBounds(-20,-20);
		ar.width=bounds.width+40;
		ar.height=bounds.height+40;
		attackTimer=0;

		if(world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(ar)) {
			world.getEntityManager().getHero().hurt(1);
			Attack=true;
			return;
		
			}
}
		
		
	
public void die() {
		
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
		
			g.drawImage(animmonstre.getCurrentFrame(),(int) x,(int) y,width,height, null);
	}else {
		g.drawImage(attackmonstre.getCurrentFrame(),(int) x,(int) y,width,height, null);
		
	}
	}
}



