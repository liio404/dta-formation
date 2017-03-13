package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatPizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Mettre � jour une pizza";
	
	public ModifierPizzaOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute() {
		Scanner sc = new Scanner(System.in);
		PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
		
		System.out.println("Veuillez saisir le code de la pizza a modifier");
		String codePizza = sc.nextLine();
		Pizza pizza = pizzaDao.findPizza(codePizza);
		
		System.out.println("Veuillez saisir le code");
		pizza.setCode(sc.nextLine());
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		pizza.setNom(sc.nextLine().trim());
		
		System.out.println("Veuillez saisir le prix");
		pizza.setPrix(sc.nextDouble());
		
		try {
			pizzaDao.updatePizza(codePizza, pizza);
		} catch (StockageException e) {
			new UpdatPizzaException("Impossible de modifier la pizza", e);
		}
		
		
		return super.excetute();
	}
	
	
}
