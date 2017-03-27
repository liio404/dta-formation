package fr.pizzeria.ihm;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class IhmTools {
	
	private final static Scanner SC = new Scanner(System.in);
	//private final static IPizzaDao<Pizza, String> DAO = new PizzaDaoImplFichier();
	private IPizzaDao<Pizza, String> daoImpl;
	
	public IhmTools(){
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String daoImpl = bundle.getString("dao.impl");
		
		try {
			this.daoImpl = (IPizzaDao<Pizza, String>) Class.forName(daoImpl).newInstance();
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// implémentation mémoire par défaut au cas ou
			this.daoImpl = new PizzaDaoImpl();
			//throw new StockageException("Impossible d'avoir les données de l'application",e);
		}
	}

	public Scanner getSc() {
		return SC;
	}
	
	public void close() {
		SC.close();
	}

	public IPizzaDao<Pizza, String> getDao() {
		return this.daoImpl;
	}
	
}
