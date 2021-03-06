package ships;

import java.util.LinkedList;
import java.util.List;

import core.Point;
import core.Point.Dir;

class Ship implements IShip {

	private List<Extension> parts;
	private Integer id;
	private Point position;
	private Point.Dir dir;
	private String imgURL;
	private String name;
	private int maxLife;
	private int life;

	public Ship(Integer id, Point position, Point.Dir dir, String name, String imgURL, int maxLife, Extension...parts) {
		this.id = id;
		this.parts = new LinkedList<Extension>();
		this.position = position;
		this.dir = dir;
		this.imgURL = imgURL;
		this.maxLife = maxLife;
		this.life = maxLife;
		this.name = name;
		for(Extension e : parts) 
			this.parts.add(e);
			
	}

	@Override
	public void setDisplacement(Point position, Point.Dir dir) {
		this.position = position;
		this.dir = dir;
	}
	
	@Override
	public void update() {
		for (Extension sp : parts)
			sp.update(this);
	}

	@Override
	public String imgURL() {
		String ddir;
		switch (dir) {
		case E:
		case NE:
		case SE:
			ddir = "d";
			break;
		default:
			ddir = "";
		}
		return imgURL + ddir + ".png";
	}

	@Override
	public Integer id() {
		return id;
	}

	@Override
	public Point position() {
		return position;
	}

	@Override
	public boolean isDestroyed() {
		return (life == 0);
	}

	@Override
	public void hit() {
		if (life > 0)
			life--;
	}

	@Override
	public void repair() {
		if (life > 0)
			life = maxLife;
	}

	@Override
	public Dir dir() {
		return dir;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean isDisplayable() {
		return !isDestroyed();
	}

}
