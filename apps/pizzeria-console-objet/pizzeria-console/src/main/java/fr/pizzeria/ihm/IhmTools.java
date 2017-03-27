package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoImplFichier;

public class IhmTools {
	
	private final static Scanner SC = new Scanner(System.in);;
	//private IPizzaDao dao = new PizzaDaoImpl();
	private final static IPizzaDao DAO = new PizzaDaoImplFichier();

	public Scanner getSc() {
		return SC;
	}

	public IPizzaDao getDao() {
		return DAO;
	}

	public void close() {
		SC.close();
	}
	
}
