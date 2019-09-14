package jo.secondstep.hero;

import java.util.Map;

import jo.secondstep.helper.SpellKey;
import jo.secondstep.helper.WrongKeyExeption;
import jo.secondstep.item.Item;
import jo.secondstep.spell.Spell;

public abstract class Hero { 

	private String name;
	private double damage;
	private double armor;
	private double health;
	private double mana;
	private Map<SpellKey, Spell> spells;
	private Map<SpellKey, Item> items;

	public abstract void attack();

	public void castSpell(SpellKey spellKey) throws WrongKeyExeption {
		Spell spell = spells.get(spellKey);
		if (spell == null) {
			throw new WrongKeyExeption("Wrong Spell Key Pressed");
		}
		spell.cast();
	}

	public void castItemSpell(SpellKey spellKey) throws WrongKeyExeption {
		Item item = items.get(spellKey);
		if (item == null) {
			throw new WrongKeyExeption("Wrong Item Key Pressed");
		}
		item.cast();
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final double getDamage() {
		return damage;
	}

	public final void setDamage(double damage) {
		this.damage = damage;
	}

	public final double getArmor() {
		return armor;
	}

	public final void setArmor(double armor) {
		this.armor = armor;
	}

	public final double getHealth() {
		return health;
	}

	public final void setHealth(double health) {
		this.health = health;
	}

	public final double getMana() {
		return mana;
	}

	public final void setMana(double mana) {
		this.mana = mana;
	}

	public final Map<SpellKey, Spell> getSpells() {
		return spells;
	}

	public final void setSpells(Map<SpellKey, Spell> spells) {
		this.spells = spells;
	}

	public final Map<SpellKey, Item> getItems() {
		return items;
	}

	public final void setItems(Map<SpellKey, Item> items) {
		this.items = items;
	}
}
