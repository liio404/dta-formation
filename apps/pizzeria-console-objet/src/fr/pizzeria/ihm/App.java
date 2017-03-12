package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoImpl;

public class App {

	public static void main(String[] args) {
		PizzaDaoImpl daoTableau = new PizzaDaoImpl();
		MenuPrincipale principale = new MenuPrincipale();
		
		principale.Afficher();
	}

}
