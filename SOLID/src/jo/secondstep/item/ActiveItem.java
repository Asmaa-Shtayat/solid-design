package jo.secondstep.item;

import jo.secondstep.helper.CastHandler;
import jo.secondstep.helper.Castable;

public class ActiveItem extends Item implements Castable {
 
	private int cooldown;
	private double manaCost;
	private CastHandler castHandler;

	@Override
	public void cast() {
		if (castHandler == null) {
			return;
		}
		
		castHandler.cast();
	}

	@Override
	public void addCastHandler(CastHandler castHandler) {
		this.castHandler = castHandler;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public double getManaCost() {
		return manaCost;
	}

	public void setManaCost(double manaCost) {
		this.manaCost = manaCost;
	}
}
