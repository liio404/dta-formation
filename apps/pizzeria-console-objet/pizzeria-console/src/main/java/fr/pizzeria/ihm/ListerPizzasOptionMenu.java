package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	private static final String LIBELLE = "Lister les pizzas";

	public ListerPizzasOptionMenu() {
		super(LIBELLE);
	}

	@Override
	public boolean excetute(IhmTools tools) {
		IPizzaDao<Pizza, String> pizzaDao = tools.getDao();
		
		for (Pizza pizza : pizzaDao.findAll()) {
			System.out.println(pizza.toString());
		}
		
		return false;
	}
	
}
