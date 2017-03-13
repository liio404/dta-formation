package fr.pizzeria.console;

import fr.pizzeria.ihm.MenuPrincipale;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO : généraliser le dao et le scanner dans une classe externe
		// ou utiliser try with ressources
		MenuPrincipale principale = new MenuPrincipale();
		principale.executer();
		// TODO : debug car fonctionne pas !
	}

}
