package Game.Code;

import java.awt.Graphics;
import java.util.ArrayList;

public class World {
	private int width,height;
	private int[][] tiles;
	private int[][]piege;
	public int spawnX,spawnY;
	protected World world;
	protected Game game;
	private EntityManager entityManager;
	
	public World(Game game,String path) {
		world=this;
		this.game=game;
        
		entityManager=new EntityManager(game,world,new hero(game,world,100,100));
		Entity piege=new Piege(game,world,100,200);
		entityManager.addEntity(piege);
		entityManager.generer_monstre(5);
		entityManager.generer_fantome(4);

		loadWorld(path);
		entityManager.getHero().setX(spawnX);
		entityManager.getHero().setY(spawnY);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		entityManager.tick();
	}
	public void render(Graphics g) {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				getTile(x,y).render(g, x*Tile.TILEWIDTH, y*Tile.TILEHEIGHT);
			}
		}
		entityManager.render(g);
		
	}
	public Tile getTile(int x,int y) {

		Tile t=Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.grassTile;
		return t;
	}
	public Boolean Bordure(int x,int y) {
		if(x==0 || y==0 || x==19 || y==29) {
			return true;
		}else {
			return false;
		}

	}
	
	public int getId(int x,int y) {

		Tile t=Tile.tiles[tiles[x][y]];
		if(t==null)
			return 0;
		return t.id;
	}
	public ArrayList<Integer> getpiege() {
		ArrayList<Integer> piege=new ArrayList<Integer>();
		for(int i=0;i<width;i++) {
			for(int j=0;j<height;j++) {
				if(tiles[i][j]==2) {
					piege.add(i);
					piege.add(j);
			
				}
			}
		}return piege;
		
	}
	private void loadWorld(String path) {
		String file =Utils.loadFileAsString("res/worlds/worlds.txt");
		String[] tokens=file.split("\\s+");
		width=Utils.parseInt(tokens[0]);
		height=Utils.parseInt(tokens[1]);
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		tiles=new int[width][height];
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
			}
		}

	}

}
