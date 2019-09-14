package jo.secondstep.hero;

public class RangeHero extends Hero {

	private int attackRange;
 
	@Override
	public void attack() {
		System.out.println("Range attack whith range = " + this.attackRange + "and damage = " + super.getDamage());
	}

	public int getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(int attackRange) {
		this.attackRange = attackRange;
	}
}
