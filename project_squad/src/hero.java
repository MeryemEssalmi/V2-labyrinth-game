


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class hero extends Creature{

	private Animation animdown;
	private Animation animup;
	private Animation animright;
	private Animation animleft;
	private Animation animhealth;
	
	private long lastAttackTimer,attackCooldown=200,attackTimer=attackCooldown;
	


	public hero(Game game,World world,float x, float y) {
		super(game,world,x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
 
		bounds.x=8;
		bounds.y=0;
		bounds.width=15;
		bounds.height=29;
		animhealth=new Animation(500,Assets.health);
		animdown=new Animation(500,Assets.hero_down);
		animup=new Animation(500,Assets.hero_up);
		animright=new Animation(500,Assets.hero_right);
		animleft=new Animation(500,Assets.hero_left);
		

	}
	public void moveh(){
		if(!checkEntityCollisions(xMove,0f))
		    moveXh();
		if(!checkEntityCollisions(0f,yMove))
		    moveYh();
	}

	public void moveXh(){
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

	public void moveYh(){
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
		animdown.tick();
		animup.tick();
		animright.tick();
		animleft.tick();
		getInput();
		moveh();
		checkAttacks();
		
	}
	private void checkAttacks() {
		attackTimer+=System.currentTimeMillis()-lastAttackTimer;
		lastAttackTimer=System.currentTimeMillis();
		if(attackTimer<attackCooldown)
			return;
		Rectangle cb=getCollisionBounds(0,0);
		Rectangle ar=new Rectangle();
		int arSize=10;
		ar.width=arSize;
		ar.height=arSize;
		if(game.getKeyManger().attack_up) {
			ar.x=cb.x+cb.width/2 -arSize/2;
			ar.y=cb.y-arSize;
		}
		else if(game.getKeyManger().attack_down) {
			ar.x=cb.x+cb.width/2 -arSize/2;
			ar.y=cb.y+arSize;
		}
		else if(game.getKeyManger().attack_left) {
			ar.x=cb.x-arSize;
			ar.y=cb.y+cb.width/2 -arSize/2;
		}
		else if(game.getKeyManger().attack_right) {
			ar.x=cb.x+cb.width;
			ar.y=cb.y+cb.height/2 -arSize/2;
		}else{
			return;
		}
		attackTimer=0;
		for(Entity e:world.getEntityManager().getEntities()) {
			if(e.equals(this)) 
				continue;
			if(e.getCollisionBounds(0,0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
		
		
	}
	private void healthpiege() {
	
	}
	public void die() {
		
	}
	private void getInput() {
		xMove=0;
		yMove=0;
		if(game.getKeyManger().up) 
			yMove=-speed;
		if(game.getKeyManger().down) 
			yMove=+speed;
		if(game.getKeyManger().left) 
			xMove=-speed;
		if(game.getKeyManger().right) 
			xMove=+speed;		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(),(int) x,(int) y,width,height, null);
		g.drawImage(getCurrenthealth(),(int) x,(int) y-10,width,10, null);
		//g.setColor(Color.red);
	 	//g.fillRect((int)(x+bounds.x),(int)(y+bounds.y),bounds.width,bounds.height);
	}
private BufferedImage getCurrentAnimationFrame() {
	if(xMove<0) {
		return animleft.getCurrentFrame();
	}else if(xMove>0){
		return animright.getCurrentFrame();
	}else if(yMove<0) {
		return animup.getCurrentFrame();
	}else if(yMove>0) {
		return animdown.getCurrentFrame();
	}else if(game.getKeyManger().attack_right) {
		 return Assets.attack_right;
		
	}else if(game.getKeyManger().attack_left) {
		return Assets.attack_left;
	}else if(game.getKeyManger().attack_down) {
		return Assets.attack_down;
	}else if(game.getKeyManger().attack_up) {
		return Assets.attack_up;
	}else {
		return Assets.hero;
	}
		
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
}


