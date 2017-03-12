package fr.pizzeria.ihm;

public class QuitterOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Quitter";
	
	public QuitterOptionMenu(){
		super(LIBELLE);
	}

	@Override
	public boolean excetute() {
		System.out.println("Au revoir et à bientôt :) ");
		return true;
	}
	
}
