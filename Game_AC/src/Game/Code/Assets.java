package Game.Code;

import java.awt.image.BufferedImage;



public class Assets {
	private static final int width=32, height =32;
	
	public static BufferedImage hero,attack_down,attack_up,attack_right,attack_left,grass,mur,tresor,piege,passage,magique,teleportation_entre,teleportation_sortie;
	public static BufferedImage[] hero_down,hero_up,hero_right,hero_left,fantome,monstre,monstre_attack,fantome_attack,health;
	public static void init() {
		SpriteSheet sheet =new SpriteSheet(ImageLoader.loadImage("textures/element.png"));
		monstre_attack=new BufferedImage[2];
		monstre_attack[0]=sheet.crop(4*width, 4*height,width, height);
		monstre_attack[1]=sheet.crop(0, 5*height,width, height);
		fantome_attack=new BufferedImage[2];
		fantome_attack[0]=sheet.crop(width, 5*height,width, height);
		fantome_attack[1]=sheet.crop(2*width,5* height,width, height);
		health=new BufferedImage[16];
		health[0]=sheet.crop(3*width,5* height,width, height);
		health[1]=sheet.crop(4*width,5* height,width, height);
		health[2]=sheet.crop(0, 6*height,width, height);
		health[3]=sheet.crop(width,6* height,width, height);
		health[4]=sheet.crop(2*width,6* height,width, height);
		health[5]=sheet.crop(3*width,6* height,width, height);
		health[6]=sheet.crop(4*width,6* height,width, height);
		health[7]=sheet.crop(0,7*height,width, height);
		health[8]=sheet.crop(width,7* height,width, height);
		health[9]=sheet.crop(2*width,7* height,width, height);
		health[10]=sheet.crop(3*width,7* height,width, height);
		health[11]=sheet.crop(4*width,7* height,width, height);
		health[12]=sheet.crop(0,8* height,width, height);
		health[13]=sheet.crop(width,8* height,width, height);
		health[14]=sheet.crop(2*width,8* height,width, height);
		health[15]=sheet.crop(3*width,8* height,width, height);
		
		
		hero_down=new BufferedImage[2];
		hero_down[0]=sheet.crop(width, 0,width, height);
		hero_down[1]=sheet.crop(2*width, 0,width, height);
		attack_down=sheet.crop(4*width, height,width, height);
		hero_up=new BufferedImage[2];
		hero_up[0]=sheet.crop(3*width, 0,width, height);
		hero_up[1]=sheet.crop(4*width, 0,width, height);
		attack_up=sheet.crop(2*width, 2*height,width, height);
		hero_right=new BufferedImage[2];
		hero_right[0]=sheet.crop(0, height,width, height);
		hero_right[1]=sheet.crop(width, height,width, height);
		attack_right=sheet.crop(0, 2*height,width, height);
		hero_left=new BufferedImage[2];
		hero_left[0]=sheet.crop(2*width, height,width, height);
		hero_left[1]=sheet.crop(3*width, height,width, height);
		attack_left=sheet.crop(width, 2*height,width, height);
		monstre=new BufferedImage[2];
		monstre[0]=sheet.crop(2*width, 4*height,width, height);
		monstre[1]=sheet.crop(3*width, 4*height,width, height);
		fantome=new BufferedImage[2];
		fantome[0]=sheet.crop(0, 4*height,width, height);
		fantome[1]=sheet.crop(width, 4*height,width, height);
		
		hero=sheet.crop(0, 0, width, height);
		grass=sheet.crop(3*width, 2*height,width, height);
		mur=sheet.crop(4*width, 2*height,width, height);
		piege=sheet.crop(0, 3*height,width, height);
		teleportation_entre=sheet.crop(3*width, 3*height,width, height);
		teleportation_sortie=sheet.crop(4*width, 3*height,width, height);
		magique=sheet.crop(2*width, 3*height,width, height);
		tresor=sheet.crop(width, 3*height,width, height);
		
	}

}
