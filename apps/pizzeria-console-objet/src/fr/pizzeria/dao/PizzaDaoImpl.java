package fr.pizzeria.dao;

import java.util.Arrays;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	Pizza pepe = new Pizza(0, "PEP", "Peperoni", 12.50D);
	Pizza mar = new Pizza(1, "MAR", "Margherita", 14.00D);
	Pizza frei = new Pizza(2, "REI", "La Reine", 11.50D);
	Pizza fro = new Pizza(3, "FRO", "La 4 fromage", 12.00D);
	Pizza can = new Pizza(4, "CAN", "La cannibale", 12.50D);
	Pizza sav = new Pizza(5, "SAV", "La savoyarde", 13.00D);
	Pizza ori = new Pizza(6, "ORI", "L'orientale", 13.50D);
	Pizza ind = new Pizza(7, "IND", "L'indienne", 14.00D);
	
	Pizza[] pizzas = { pepe, mar, frei, fro, can, sav, ori, ind};

	public PizzaDaoImpl() {
		super();
	}

	@Override
	public Pizza[] findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		Arrays.copyOf(pizzas, pizzas.length +1);
		pizzas[pizzas.length] = pizza;
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		
		for (Pizza p : pizzas) {
			if (p.getCode().equals(codePizza)) {
				p.setCode(pizza.getCode());
				p.setNom(pizza.getNom());
				p.setPrix(pizza.getPrix());
			}
		}
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		for (Pizza pizza : pizzas) {
			if (pizza.getCode().equals(codePizza)) {
				// TODO : supprimer la pizza et redimensionner le tableau !
			}
		}
		return false;
	}

	public Pizza findPizza(String codePizza) {
		for (Pizza pizza : pizzas) {
			if (pizza.getCode().equals(codePizza)) {
				return pizza;
			}
		}
		return null;
	}

}
