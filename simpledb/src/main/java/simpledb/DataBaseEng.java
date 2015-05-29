package simpledb;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import simpledb.exception.DBException;

public class DataBaseEng {
	
	
	public void add(Entity<?> entity) throws DBException {
		try {
			// load the database
			FileInputStream fileIn = new FileInputStream("Storage.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Storage store = (Storage) in.readObject();
			
			in.close();
			
			// add entry to collection
			store.add(entity);
			// store update to disk
			FileOutputStream fileOut = new FileOutputStream("Storage.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(store);
			out.close();
		} catch(IOException ioe) {
			throw new DBException(ioe);
		} catch (ClassNotFoundException cnfe) {
			throw new DBException(cnfe);
		}
	}
	
	public void remove(Entity<?> entity) throws DBException {
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
		} catch(IOException ioe) {
			throw new DBException(ioe);
		} catch (ClassNotFoundException cnfe) {
			throw new DBException(cnfe);
		}	
	}
}
