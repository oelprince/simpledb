package simpledb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import simpledb.exception.DBException;
//import simpledb.sampledomain.Employee;

public class DataBaseEng {
	
	
	public DataBaseEng() {
		Storage store = new Storage();
		try {
			FileOutputStream fileOut = new FileOutputStream("Storage.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(store);
			out.close();
		} catch(IOException ioe) {
			throw new DBException(ioe);
		}
	}
	
	
	public synchronized void add(Entity<?> entity) throws DBException {
		
		try {
			// load the database
			FileInputStream fileIn = new FileInputStream("Storage.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Storage store = (Storage) in.readObject();
			
			in.close();
			fileIn.close();
			// add entry to collection
			store.add(entity);
			// store update to disk
			FileOutputStream fileOut = new FileOutputStream("Storage.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(store);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException fne) {
			throw new DBException(fne);
		} catch(IOException ioe) {
			throw new DBException(ioe);
		} catch (ClassNotFoundException cnfe) {
			throw new DBException(cnfe);
		}
	}
	
	public synchronized void remove(Entity<?> entity) throws DBException {
		try {
			// load the database
			FileInputStream fileIn = new FileInputStream("Storage.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			Storage store = (Storage) in.readObject();
			in.close();
			fileIn.close();
			
			store.remove(entity.getId());
			
			FileOutputStream fileOut = new FileOutputStream("Storage.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(store);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException fne) {
			throw new DBException(fne);
		} catch(IOException ioe) {
			throw new DBException(ioe);
		} catch (ClassNotFoundException cnfe) {
			throw new DBException(cnfe);
		}
	}
	
	
	public synchronized Entity<?> getEntityById(String id) {
		Entity<?> entity = null;
		try {
			FileInputStream fileIn = new FileInputStream("Storage.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Storage store = (Storage) in.readObject();
			entity = store.getEntity(id);
			in.close();
			fileIn.close();
		} catch (FileNotFoundException fne) {
			throw new DBException(fne);
		} catch (IOException ioe) {
			throw new DBException(ioe);
		} catch (ClassNotFoundException cnfe) {
			throw new DBException(cnfe);
		}
		
		return entity;
	}
	
	
	public synchronized int getCount() {
		Storage store = null;
		try {
			FileInputStream fileIn = new FileInputStream("Storage.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			store = (Storage) in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException fne) {
			throw new DBException(fne);
		} catch (IOException ioe) {
			throw new DBException(ioe);
		} catch (ClassNotFoundException cnfe) {
			throw new DBException(cnfe);
		}
		
		return store.getSize();
	}
	
}
