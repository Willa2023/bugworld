package application;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class SliderMouse implements EventHandler <MouseEvent>{
	ArrayList<MyBug> bugs;
	Slider slider;
	
	
	public Slider getSlider() {
		return slider;
	}

	public void setSlider(Slider slider) {
		this.slider = slider;
	}
	
	public SliderMouse(ArrayList<MyBug> bugs, Slider slider) {
		super();
		this.bugs = bugs;
		this.slider = slider;
	}

	@Override
	public void handle(MouseEvent event) {
		double v = this.slider.getValue();
		for(MyBug b: bugs) {
			b.setDx(b.getSpeedNum()*v);
			b.setDy(b.getSpeedNum()*v);
		}
		
//		System.out.println("Clicked on " + event.getSource());
	}

}
