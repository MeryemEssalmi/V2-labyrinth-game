

import java.awt.Graphics;
import java.util.ArrayList;

public class EntityManager {
	
	
	protected Game game;
	protected World world;
	private hero Hero;

	
	private ArrayList<Entity> entities;

	public EntityManager(Game game,World world,hero Hero){
		this.game=game;
		this.world=world;
		this.Hero=Hero;

		entities = new ArrayList<Entity>();
		addEntity(Hero);
	}
	public void generer_monstre(int i) {
		if(i==1) {
			addEntity(new Monstre(game,world,480,320));
		}else {
			int[] positionx= {160,320,480,640,800};		
			int[] positiony= {160,320,480};
			int j=0;

		  
				for(int c=0;c<positionx.length;c++) {
					for(int b=0;b<positiony.length;b++) {
						if(j<i) {
							addEntity(new Monstre(game,world,positionx[c],positiony[b]));
						j++;}
					}
				}
						
	}
	}
	public void generer_fantome(int i) {
		if(i==1) {
			addEntity(new Fantome(game,world,480,320));
		}else {
			int[] positionx= {240,400,560,720,880};		
			int[] positiony= {240,400,560};
			int j=0;

		  
				for(int c=0;c<positionx.length;c++) {
					for(int b=0;b<positiony.length;b++) {
						if(j<i) {
							addEntity(new Fantome(game,world,positionx[c],positiony[b]));
						j++;}
					}
				}
				


		
	}
	}
	

	public hero getHero() {
		return Hero;
	}
	public void setHero(hero hero) {
		Hero = hero;
	}
	public void tick(){
		for(int i = 0;i < entities.size();i++){
			Entity e = entities.get(i);
			e.tick();
			if(!e.isActive())
				entities.remove(e);
					
		}
		
	
	}

	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
		
		
	}

	public void addEntity(Entity e){
		entities.add(e);
	}


	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}


	
}
