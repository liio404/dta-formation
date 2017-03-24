package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	List<Pizza> pizzas;

	public PizzaDaoImpl() {
		super();
		pizzas = new ArrayList<>();
		pizzas.add(0, new Pizza(0, "PEP", "Peperoni", 12.50D));
		pizzas.add(1, new Pizza(1, "MAR", "Margherita", 14.00D));
		pizzas.add(2, new Pizza(2, "REI", "La Reine", 11.50D));
		pizzas.add(3, new Pizza(3, "FRO", "La 4 fromage", 12.00D));
		pizzas.add(4, new Pizza(4, "CAN", "La cannibale", 12.50D));
		pizzas.add(5, new Pizza(5, "SAV", "La savoyarde", 13.00D));
		pizzas.add(6, new Pizza(6, "ORI", "L'orientale", 13.50D));
		pizzas.add(7, new Pizza(7, "IND", "L'indienne", 14.00D));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException{
		if(pizza.getCode().length() == 3){
			//Arrays.copyOf(pizzas, pizzas.length +1);
			pizzas.add(pizza);
		}else{
			throw new SavePizzaException("Le code de la pizza ne doit pas dépacer 3 caractère");
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatPizzaException{
		if(codePizza.length() == 3 || pizza.getCode().length() == 3){
			for (int i = 0; i < pizzas.size(); i++) {
				if(pizzas.get(i).getCode().equals(codePizza)){
					pizzas.set(i, pizza);
				}
			}
		}else {
			throw new UpdatPizzaException("Le code de la pizza ne doit pas dépacer 3 caractère");
		}
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		if(codePizza.length() == 3){
			for (int i = 0; i < pizzas.size(); i++) {
				if(pizzas.get(i).getCode().equals(codePizza)){
					pizzas.remove(i);
				}
			}
		}else{
			throw new DeletePizzaException("Le code de la pizza est invalide");
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
