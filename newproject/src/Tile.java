

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles=new Tile[256];
	public static Tile grassTile=new Tile(Assets.grass,0);
	public static Tile murTile=new Tile(Assets.mur,1);
	public static Tile piegeTile=new Tile(Assets.piege,2);
	public static Tile magiqueTile=new Tile(Assets.magique,3);
	public static Tile tresorTile=new Tile(Assets.tresor,4);
	public static Tile teleeTile=new Tile(Assets.teleportation_entre,5);
	public static Tile telesTile=new Tile(Assets.teleportation_sortie,6);
	

	protected BufferedImage texture;
	protected final int id;
	public static final int TILEWIDTH=32, TILEHEIGHT=32;
	
	public Tile(BufferedImage texture,int id) {
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
	}
public void tick() {
	
}
public void render(Graphics g,int x, int y) {
	g.drawImage(texture, x, y, TILEWIDTH,TILEHEIGHT,null);
}
public boolean isSolid(int id) {
	if(id==1) {
		return true;
	}else {
		return false;
	}
}


public int getId() {
	return id;
}
}
