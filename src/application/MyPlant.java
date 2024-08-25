package application;


import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MyPlant extends Circle {
	double x = 100, y = 100, r = 20, or = 20;
	String species;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	

	public double getOr() {
		return or;
	}

	public void setOr(double or) {
		this.or = or;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public MyPlant(double x, double y, double r, String species, Color c) {
		super(x, y, r);
		this.x = x;
		this.y = y;
		this.r = r;
		this.species = species;
		this.setFill(c);
		this.or = r;
	}
	
	public MyPlant(double x, double y, double r, String species, String s) {
		super(x, y, r);
		this.x = x;
		this.y = y;
		this.r = r;
		this.species = species;
		this.setFill(new ImagePattern(new Image(s)));
		this.or = r;
	}

	@Override
	public String toString() {
		return "Speices : "+ this.getSpecies() + "\nPosition X : " + this.getX() + "\nPosition Y : " + this.getY() + "\nRadius : " + this.getR();
	}
	
	
	
}
