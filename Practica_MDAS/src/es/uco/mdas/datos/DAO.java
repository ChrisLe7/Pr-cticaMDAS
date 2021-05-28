package es.uco.mdas.datos;

import java.util.HashMap;

public interface DAO <T> {
	
	public HashMap <String, T> queryAll();
	
	public T queryById(String idItem);
	
	public boolean update(T item);
	
	public boolean insert(T item);
	
	public boolean delete(String idItem);
}
