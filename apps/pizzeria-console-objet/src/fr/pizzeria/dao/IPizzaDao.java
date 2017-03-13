package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatPizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	Pizza[] findAllPizzas();
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatPizzaException;
	boolean deletePizza(String codePizza) throws DeletePizzaException;

}
