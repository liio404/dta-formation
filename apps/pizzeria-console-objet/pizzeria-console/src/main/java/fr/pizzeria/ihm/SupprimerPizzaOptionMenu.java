package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Supprimer une pizza";
	
	public SupprimerPizzaOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute(IhmTools tools) {
		Scanner sc = tools.getSc();
		IPizzaDao<Pizza, String> pizzaDao = tools.getDao();
		
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		try {
			pizzaDao.delete(sc.next());
		} catch (StockageException e) {
			new DeletePizzaException("Impossible de supprimer la pizza", e);
		}
		
		return super.excetute(tools);
	}
	
	
}
