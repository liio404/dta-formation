package fr.pizzeria.ihm;

public class MenuPrincipale extends Menu {
	
	public MenuPrincipale(){
		super("***** Pizzeria Administration *****", new OptionMenu[] {
			new ListerPizzasOptionMenu(),
			new NouvellePizzaOptionMenu(),
			new ModifierPizzaOptionMenu(),
			new SupprimerPizzaOptionMenu(),
			new QuitterOptionMenu()
		});
	}
	
}
