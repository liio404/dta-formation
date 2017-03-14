package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatPizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Mettre à jour une pizza";
	
	public ModifierPizzaOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute(IhmTools tools) {
		Scanner sc = tools.getSc();
		PizzaDaoImpl pizzaDao = tools.getDao();
		
		System.out.println("Veuillez saisir le code de la pizza a modifier");
		String codePizza = sc.next();
		Pizza pizza = pizzaDao.findPizza(codePizza);
		
		System.out.println("Veuillez saisir le code");
		pizza.setCode(sc.next());
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		pizza.setNom(sc.next().trim());
		
		System.out.println("Veuillez saisir le prix");
		pizza.setPrix(sc.nextDouble());
		
		try {
			pizzaDao.updatePizza(codePizza, pizza);
		} catch (StockageException e) {
			new UpdatPizzaException("Impossible de modifier la pizza", e);
		}
		
		
		return super.excetute(tools);
	}
	
	
}
