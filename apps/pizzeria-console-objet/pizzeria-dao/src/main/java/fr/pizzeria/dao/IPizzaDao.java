package fr.pizzeria.dao;

import java.util.List;

<<<<<<< HEAD
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatPizzaException;

public interface IPizzaDao<T,E> {
=======
import fr.pizzeria.exception.StockageException;

public interface IPizzaDao<T, E> {
>>>>>>> dvp1
	
	List<T> findAll();
	boolean save(T obj) throws StockageException;
	boolean update(E code, T obj) throws StockageException;
	boolean delete(E code) throws StockageException;
<<<<<<< HEAD
	T find(E code);
=======
	T find(String code);
>>>>>>> dvp1

}
