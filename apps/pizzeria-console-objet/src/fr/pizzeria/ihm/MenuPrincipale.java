package fr.pizzeria.ihm;

import java.util.Map;
import java.util.TreeMap;

public class MenuPrincipale extends Menu {
	
	public MenuPrincipale(IhmTools tool){
		super(tool, "***** Pizzeria Administration *****", actions);
	}

	private static Map<Integer, OptionMenu> actions = new TreeMap<>();
	{
		actions.put(1, new ListerPizzasOptionMenu());
		actions.put(2, new NouvellePizzaOptionMenu());
		actions.put(3, new ModifierPizzaOptionMenu());
		actions.put(4, new SupprimerPizzaOptionMenu());
		actions.put(99, new QuitterOptionMenu());
	}
}
