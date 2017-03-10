package fr.pizzeria.ihm;

public abstract class Menu {
	OptionMenu[] actions;
	
	public Menu(){
		super();
	}
	
	void Afficher(){
		for (OptionMenu optionMenu : actions) {
			// TODO Afficher le numero de l'option !
			System.out.println(optionMenu.getLibelle());
		}
	}
}
