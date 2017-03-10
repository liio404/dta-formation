package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	private static final String LIBELLE = "Lister les pizzas";

	public ListerPizzasOptionMenu() {
		super(LIBELLE);
	}

	@Override
	public boolean excetute() {
		PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
		
		for (Pizza pizza : pizzaDao.findAllPizzas()) {
			pizza.toString();
		}
		
		return super.excetute();
	}
	
}
