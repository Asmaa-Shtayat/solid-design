package jo.secondstep.spell;

public abstract class Spell {

	private String name;
	private String description;
	private String effect;

	public abstract void cast();

	public String getName() { 
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
}
