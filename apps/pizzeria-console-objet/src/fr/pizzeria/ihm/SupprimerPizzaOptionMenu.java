package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Supprimer une pizza";
	
	public SupprimerPizzaOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute() {
		Scanner sc = new Scanner(System.in);
		PizzaDaoImpl pizzaDao = new PizzaDaoImpl();
		
		System.out.println("Veuillez saisir le code de la pizza � supprimer");
		try {
			pizzaDao.deletePizza(sc.nextLine());
		} catch (StockageException e) {
			new DeletePizzaException("Impossible de supprimer la pizza", e);
		}
		
		return super.excetute();
	}
	
	
}
