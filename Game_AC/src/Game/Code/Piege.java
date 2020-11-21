package Game.Code;

import java.awt.Graphics;

public class Piege extends StaticEntity {

	public Piege(Game game, World world, float x, float y) {
		super(game, world, x, y,Tile.TILEWIDTH,Tile.TILEHEIGHT);
		bounds.x=0;
		bounds.y=8;
		bounds.width=32;
		bounds.height=24;
		
	}

	@Override
	public void tick() {
		healthHero();
		
	}
public void healthHero() {
	if((world.getEntityManager().getHero().getCollisionBounds(0,0).intersects(bounds))) {
		world.getEntityManager().getHero().hurt(1);
	}
}
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.piege,(int)x,(int) y,null);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
	

}
