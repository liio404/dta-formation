package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.StockageException;

public interface IPizzaDao<T, E> {
	
	List<T> findAll();
	boolean save(T obj) throws StockageException;
	boolean update(E code, T obj) throws StockageException;
	boolean delete(E code) throws StockageException;
	T find(String code);

}
