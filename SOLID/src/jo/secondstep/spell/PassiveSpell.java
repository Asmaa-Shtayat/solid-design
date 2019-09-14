package jo.secondstep.spell;

public class PassiveSpell extends Spell{

	@Override
	public void cast() {
		System.out.println(super.getEffect());
	}
}
