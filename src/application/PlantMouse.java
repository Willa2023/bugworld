

package application;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PlantMouse  implements EventHandler <MouseEvent>
{
	MyPlant b;
	Label l4;
	
	public PlantMouse(MyPlant  b, Label l4)
	{
		this.b = b;
		this.l4 = l4;
	}
	
	@Override
	public void handle(MouseEvent event) {
		l4.setText("Clicked on " + event.getSource());
	}

}
