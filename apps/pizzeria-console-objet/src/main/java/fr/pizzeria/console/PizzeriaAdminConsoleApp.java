package fr.pizzeria.console;

import fr.pizzeria.ihm.IhmTools;
import fr.pizzeria.ihm.MenuPrincipale;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		IhmTools outils = new IhmTools();
		// TODO : TP Maven 02 CONSTRUCTION AUTOMATISEE DU MENU
		MenuPrincipale principale = new MenuPrincipale(outils);
		principale.executer();
		
		outils.close();
	}

}
