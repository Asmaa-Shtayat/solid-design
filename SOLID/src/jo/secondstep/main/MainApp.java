package jo.secondstep.main;

import java.util.HashMap;
import java.util.Map;

import jo.secondstep.helper.CastHandler;
import jo.secondstep.helper.SpellKey;
import jo.secondstep.helper.WrongKeyExeption;
import jo.secondstep.hero.Hero;
import jo.secondstep.hero.MeleeHero;
import jo.secondstep.item.ActiveItem;
import jo.secondstep.item.Item;
import jo.secondstep.item.PassiveItem;
import jo.secondstep.spell.ActiveSpell;
import jo.secondstep.spell.PassiveSpell;
import jo.secondstep.spell.Spell;

public class MainApp {

	public static void main(String[] args) {

		Hero axe = new MeleeHero();
		axe.setName("Axe");
		axe.setHealth(200);
		axe.setMana(75);
		axe.setDamage(27);
		axe.setArmor(-1);
		axe.setSpells(getSpells());
		axe.setItems(getItems());
		
		try {
			axe.castSpell(SpellKey.Q);
			axe.castItemSpell(SpellKey.X);
		} catch (WrongKeyExeption e) {
			System.out.println(e.getMessage());
		}
	}

	private static Map<SpellKey, Spell> getSpells() {
		final Map<SpellKey, Spell> spells = new HashMap<>();

		ActiveSpell berserker = new ActiveSpell();
		berserker.setName("Berserker's Call");
		berserker.setDescription(
				"Axe taunts nearby enemy units, forcing them to attack him, while he gains bonus armor during the duration.");
		berserker.setEffect("Armor Bonus: 30");
		berserker.setManaCost(80);
		berserker.setCooldown(16);
		berserker.addCastHandler(new CastHandler() {

			@Override
			public void cast() {
				System.out.println("No target unit or point needed to be selected!");
				System.out.println(berserker.getEffect());
				System.out.println("Start Cooldown: " + berserker.getCooldown());
			}
		});

		PassiveSpell counterHelix = new PassiveSpell();
		counterHelix.setName("Counter Helix");
		counterHelix.setDescription(
				"When attacked, Axe has a chance to perform a helix counter attack, dealing pure damage to all nearby enemies.");
		counterHelix.setEffect("Damage: 60");

		spells.put(SpellKey.Q, berserker);
		spells.put(SpellKey.W, counterHelix);

		return spells;
	}

	private static Map<SpellKey, Item> getItems() {
		final Map<SpellKey, Item> items = new HashMap<>();

		ActiveItem blinkDagger = new ActiveItem();
		blinkDagger.setName("Blink Dagger");
		blinkDagger.setDescription("Teleport to a target point up to 1200 units away.");
		blinkDagger.setEffect("Blink Distance: 1200");
		blinkDagger.setManaCost(0);
		blinkDagger.setCooldown(15);
		blinkDagger.addCastHandler(new CastHandler() {

			@Override
			public void cast() {
				System.out.println("Select point the blink point!");
				System.out.println(blinkDagger.getEffect());
				System.out.println("Start Cooldown: " + blinkDagger.getCooldown());
			}
		});

		PassiveItem morbidMask = new PassiveItem();
		morbidMask.setName("Morbid Mask");
		morbidMask.setDescription("Heals the attacker for 15% of attack damage dealt");
		morbidMask.setEffect("Lifesteal: 15%");

		items.put(SpellKey.Z, blinkDagger);
		items.put(SpellKey.X, morbidMask);

		return items;
	}
}
