package application;

import java.util.ArrayList;

import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ButtonMouse implements EventHandler <MouseEvent>{

	ArrayList<MyBug> bugs;
	ArrayList<MyPlant> plants;
	Button b;
	Timeline tl;
	
	public ButtonMouse(ArrayList<MyBug> bugs, ArrayList<MyPlant> plants, Button b, Timeline tl) {
		this.bugs = bugs;
		this.plants = plants;
		this.b = b;
		this.tl = tl;
	}
	
	@Override
	public void handle(MouseEvent e) {
		if(b.getText().equalsIgnoreCase("start")) {
			tl.playFromStart();
		}
		if(b.getText().equalsIgnoreCase("pause")) {
			tl.pause();
		}
		if(b.getText().equalsIgnoreCase("stop")) {
			tl.stop();
			
			for(MyBug b:bugs) {
				b.setCenterX(b.getOx());
				b.setCenterY(b.getOy());
			}
			
			for(MyPlant p: plants) {
				p.setRadius(p.getOr());
			}
			
		}
		
	}

}
