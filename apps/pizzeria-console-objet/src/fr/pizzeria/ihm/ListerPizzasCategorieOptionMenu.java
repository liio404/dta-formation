package fr.pizzeria.ihm;

import java.util.stream.Collectors;

import fr.pizzeria.model.Pizza;

public class ListerPizzasCategorieOptionMenu extends OptionMenu {
	private static final String LIBELLE = "Lister les pizzas groupées par categorie";

	public ListerPizzasCategorieOptionMenu() {
		super(LIBELLE);
	}

	@Override
	public boolean excetute(IhmTools tools) {
		tools.getDao().findAllPizzas().stream().collect(Collectors.groupingBy(Pizza::getCategorie))
			.forEach((key, value) -> System.out.println(key + ":" + value));
		
		return false;
	}
	
	
}
