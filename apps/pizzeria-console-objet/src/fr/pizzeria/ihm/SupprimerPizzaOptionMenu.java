package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Supprimer une pizza";
	
	public SupprimerPizzaOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute(IhmTools tools) {
		Scanner sc = tools.getSc();
		IPizzaDao pizzaDao = tools.getDao();
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		try {
			pizzaDao.deletePizza(sc.next());
		} catch (StockageException e) {
			new DeletePizzaException("Impossible de supprimer la pizza", e);
		}
		
		return super.excetute(tools);
	}
	
	
}
