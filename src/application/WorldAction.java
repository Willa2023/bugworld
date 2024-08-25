package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class WorldAction implements EventHandler <ActionEvent> {
	
	ArrayList<MyBug> bugs;
	ArrayList<MyPlant> plants;
	Scene scene;
	BorderPane bpane;

	public WorldAction(ArrayList<MyBug> bugs, ArrayList<MyPlant> plants, Scene scene, BorderPane bpane) {
		this.bugs = bugs;
		this.plants = plants;
		this.scene = scene;
		this.bpane = bpane;
	}
	
	public void handle(ActionEvent t) {
		for(MyBug c : bugs)
		{
			if(c.getCenterX() < c.getRadius() + 150||
					c.getCenterX() + c.getRadius() > scene.getWidth()) {
				c.setDx(-c.getDx());
				c.setScaleX(-c.getScaleX());
			}
			
			if(c.getCenterY() < c.getRadius() + 50 ||
					c.getCenterY() + c.getRadius() > scene.getHeight() - 150) {
				c.setDy(-c.getDy());
			}
			
			c.setX(c.getX()+c.getDx());
			c.setCenterX(c.getX());
			
			c.setY(c.getY()+c.getDy());
			c.setCenterY(c.getY());
			
			
			
		}
		
		
		for(MyPlant p: plants) {
			// remove plant when been eaten until 5
			if(p.getR() <= 5) {
				bpane.getChildren().remove(p);
			}
			
			if(p.getSpecies().equalsIgnoreCase("tree")) {
				
				if(this.plantBeEat(p)) {
					p.setR(p.getR() - 0.08);
					p.setRadius(p.getR());
				}
				else {
					if(p.getR() >= 150) {
						p.setRadius(p.getR());
					}
					else {
						p.setR(p.getR() + 0.05);
						p.setRadius(p.getR());
					}
				}
			}
			else if(p.getSpecies().equalsIgnoreCase("grass") || p.getSpecies().equalsIgnoreCase("flower") ){
				if(this.plantBeEat(p)) {
					p.setR(p.getR() - 4);
					p.setRadius(p.getR());
				}
				
				else {
					if(p.getR() >= 50) {
						p.setRadius(p.getR());
					}
					else {
						p.setR(p.getR() + 0.05);
						p.setRadius(p.getR());
					}
				}
				
			}
		}
		
		//if bug meet plant and can eat plant, the plant size will decrease. (tree decrease slowly than grass and flower)
//		for(MyPlant p: plants) {
//			if(p.getSpecies().equalsIgnoreCase("tree")) {
//				if(this.plantBeEat(p)) {
//					p.setR(p.getR() - 0.08);
//					p.setRadius(p.getR());
//				}
//			}
//			else {
//				if(this.plantBeEat(p)) {
//					p.setR(p.getR() - 5);
//					p.setRadius(p.getR());
//				}
//				
//			}
//		}
		
		//if spider meet worm, will eat worm.
		for(MyBug b : bugs) {
			if(this.SpiderEatWorm(b)) {
				if(b.getR() >= 50) {
					b.setRadius(b.getR());
				}
				else {
					b.setR(b.getR() + 0.4);
					b.setRadius(b.getR());
				}
			}
			
			if(this.wormBeEat(b)) {
				
				bpane.getChildren().remove(b);
			}
			
			if(this.bugEatPlant(b)) {
				if(b.getR() >= 20) {
					b.setRadius(b.getR());
				}
				else {
					b.setR(b.getR() + 0.5);
					b.setRadius(b.getR());
				}
			}
			
		}
		
		
	}
	
	
	public boolean plantBeEat(MyPlant p) {
		
		double px = p.getCenterX();
		double py = p.getCenterY();
		double pr = p.getRadius();
		for(int i = 0; i< this.bugs.size(); i ++) {
			MyBug b = this.bugs.get(i);
			double bx = b.getCenterX();
			double by = b.getCenterY();
			double br = b.getRadius();
			
			double distance = Math.sqrt((px-bx)*(px-bx) + (py-by)*(py-by));
				
			if(distance < pr ) {
				
				if(p.getSpecies().equalsIgnoreCase("flower") &&
						b.getSpecies().equalsIgnoreCase("bee")
						) {
					return true;
				}
				if( (p.getSpecies().equalsIgnoreCase("grass") || p.getSpecies().equalsIgnoreCase("tree"))
						&&
						b.getSpecies().equalsIgnoreCase("worm")
						) {
					return true;
				}
				
			}
			
		}
		return false;
	}
	
	public boolean bugEatPlant(MyBug b) {
		
		double bx = b.getCenterX();
		double by = b.getCenterY();
		double br = b.getRadius();	
		
		for(int i = 0; i< this.plants.size(); i ++) {
			MyPlant p = this.plants.get(i);
			double px = p.getCenterX();
			double py = p.getCenterY();
			double pr = p.getRadius();
			
			double distance = Math.sqrt((px-bx)*(px-bx) + (py-by)*(py-by));
				
			if(distance < pr ) {
				if(p.getSpecies().equalsIgnoreCase("flower") &&
						b.getSpecies().equalsIgnoreCase("bee")
						) {
					return true;
				}
				if( (p.getSpecies().equalsIgnoreCase("grass") || p.getSpecies().equalsIgnoreCase("tree"))
						&&
						b.getSpecies().equalsIgnoreCase("worm")
						) {
					return true;
				}
			}
			
		}
		return false;
		}
	
	public boolean wormBeEat(MyBug b) {
		double bx = b.getCenterX();
		double by = b.getCenterY();
		double br = b.getRadius();
		for(int i = 0; i< this.bugs.size(); i ++) {
			MyBug b2 = this.bugs.get(i);
			double bx2 = b2.getCenterX();
			double by2 = b2.getCenterY();
			double br2 = b2.getRadius();
			
			double distance = Math.sqrt((bx-bx2)*(bx-bx2) + (by-by2)*(by-by2));
			
			if(distance < (br + br2)*2/3) {
							
				if(b2.getSpecies().equalsIgnoreCase("spider") &&
						b.getSpecies().equalsIgnoreCase("worm")
						) {
					return true;
				}
						
			}
		}
		return false;
	}
	
	public boolean SpiderEatWorm(MyBug b) {
		double bx = b.getCenterX();
		double by = b.getCenterY();
		double br = b.getRadius();
		for(int i = 0; i< this.bugs.size(); i ++) {
			MyBug b2 = this.bugs.get(i);
			double bx2 = b2.getCenterX();
			double by2 = b2.getCenterY();
			double br2 = b2.getRadius();
			
			double distance = Math.sqrt((bx-bx2)*(bx-bx2) + (by-by2)*(by-by2));
			
			if(distance < (br + br2)*2/3) {
							
				if(b.getSpecies().equalsIgnoreCase("spider") &&
						b2.getSpecies().equalsIgnoreCase("worm")
						) {
					return true;
				}
						
			}
		}
		return false;
	}



	
}
