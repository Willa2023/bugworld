package application;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class MyBug extends Circle {
	double x = 100, y = 100, dx = -1.5f, dy = -1.5f, r = 10f, speedNum = -1.5, ox = 10, oy = 100;
	String species;
	String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getSpeedNum() {
		return speedNum;
	}

	public void setSpeedNum(double speedNum) {
		this.speedNum = speedNum;
	}

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

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	
	public double getOx() {
		return ox;
	}

	public void setOx(double ox) {
		this.ox = ox;
	}

	public double getOy() {
		return oy;
	}

	public void setOy(double oy) {
		this.oy = oy;
	}
	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public MyBug(String species, double x, double y, double r, double dx, double dy, double speedNum, String s) {
		super(x, y, r);
		this.species = species;
		this.x = x;
		this.y = y;
		this.r = r;
		this.dx = dx;
		this.dy = dy;
		this.speedNum = speedNum;
		this.setFill(new ImagePattern(new Image(s)));
		this.ox = x;
		this.oy = y;
		this.filename = s;
	}

	public MyBug(double x, double y, double r, double dx, double dy,  Color c) {
		super(x, y, r);
		this.x = x;
		this.y = y;
		this.r = r;
		this.dx = dx;
		this.dy = dy;
		this.setFill(c);
		this.ox = x;
		this.oy = y;
	}

	@Override
	public String toString() {
		return "Speices: "+ species + "\nPosition X : " + this.getX() + "\nPosition Y : " + this.getY() + "\nRadius: " + this.getR()+ "\nSpeed: " + Math.abs(this.getDx());
				
	}

	

}
