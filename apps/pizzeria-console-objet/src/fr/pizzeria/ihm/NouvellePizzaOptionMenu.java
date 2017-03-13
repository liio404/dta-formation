package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {
	
	private static final String LIBELLE = "Ajouter une nouvelle pizza";
	
	public NouvellePizzaOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute() {
		Scanner sc = new Scanner(System.in);
		PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
		Pizza pizza = new Pizza();
		
		System.out.println("Veuillez saisir le code de la nouvelle pizza");
		pizza.setCode(sc.nextLine());
		
		System.out.println("Veuillez saisir le nom de la pizza (sans espace) ");
		pizza.setNom(sc.nextLine().trim());
		
		System.out.println("Veuillez saisir le prix de la pizza");
		pizza.setPrix(sc.nextDouble());
		
		try {
			pizzaDao.saveNewPizza(pizza);
		} catch (StockageException e) {
			new SavePizzaException("Impossible d'ajouter la pizza", e);
		}
		
		return super.excetute();
	}
	
}
