package Game.Code;

public abstract class Creature extends Entity{

	
	
	public static final float DEFAULT_SPEED = 0.5f;
	public static final int DEFAULT_CREATURE_WIDTH = 32,
							DEFAULT_CREATURE_HEIGHT = 32;


	protected float speed;
	protected float xMove, yMove;

	public Creature(Game game,World world,float x, float y, int width, int height) {
		super(game,world,x, y, width, height);
	
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	protected boolean collisionWithTile(int x, int y){
		return world.getTile(x, y).isSolid(world.getId(x, y));
	}


	//GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}
