package jo.secondstep.hero;

public class MeleeHero extends Hero {

	@Override 
	public void attack() {
		System.out.println("Melee Attack with " + super.getDamage() + " Damage!");
	}
}
