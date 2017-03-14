package fr.pizzeria.console;

import fr.pizzeria.ihm.IhmTools;
import fr.pizzeria.ihm.MenuPrincipale;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		IhmTools outils = new IhmTools();
		
		MenuPrincipale principale = new MenuPrincipale(outils);
		principale.executer();
		
		outils.close();
	}

}
