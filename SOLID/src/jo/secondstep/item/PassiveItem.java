package jo.secondstep.item;

public class PassiveItem extends Item {

	@Override
	public void cast() {
		System.out.println(super.getEffect());
	}
}
