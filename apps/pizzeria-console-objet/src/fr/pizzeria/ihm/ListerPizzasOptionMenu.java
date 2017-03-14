package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	private static final String LIBELLE = "Lister les pizzas";

	public ListerPizzasOptionMenu() {
		super(LIBELLE);
	}

	@Override
	public boolean excetute(IhmTools tools) {
		PizzaDaoImpl pizzaDao = tools.getDao();
		
		for (Pizza pizza : pizzaDao.findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		
		return false;
	}
	
}
