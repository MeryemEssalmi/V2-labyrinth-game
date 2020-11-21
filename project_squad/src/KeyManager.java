

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] keys;
	public boolean up,down,left,right,attack_up,attack_down,attack_left,attack_right;
	
	public KeyManager() {
		keys=new boolean[256];
	}
	public void tick() {
		up=keys[KeyEvent.VK_Z];
		down=keys[KeyEvent.VK_S];
		left=keys[KeyEvent.VK_Q];
		right=keys[KeyEvent.VK_D];
		attack_up=keys[KeyEvent.VK_O];
		attack_down=keys[KeyEvent.VK_L];
		attack_left=keys[KeyEvent.VK_K];
		attack_right=keys[KeyEvent.VK_M];
		
	}

	@Override
	public void keyTyped(KeyEvent e) {


		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		keys[e.getKeyCode()]=true;
		System.out.println("Pressed!");
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		keys[e.getKeyCode()]=false;
	}

}
