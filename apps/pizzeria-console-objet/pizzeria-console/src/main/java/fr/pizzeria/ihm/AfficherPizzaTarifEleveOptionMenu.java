package fr.pizzeria.ihm;

import java.util.Comparator;

import fr.pizzeria.model.Pizza;

public class AfficherPizzaTarifEleveOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Afficher la pizza au tarif le plus élevé";

	public AfficherPizzaTarifEleveOptionMenu() {
		super(LIBELLE);
	}

	@Override
	public boolean excetute(IhmTools tools) {
		tools.getDao().findAll().stream().max(Comparator.comparing(Pizza::getPrix)).ifPresent(p -> System.out.println(p.getNom() + " est la pizza la plus chère " + p.getPrix()+ "€ "));
		
		return false;
	}
	
	
}
