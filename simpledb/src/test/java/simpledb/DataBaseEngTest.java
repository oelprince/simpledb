package simpledb;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import simpledb.sampledomain.Employee;

public class DataBaseEngTest {

	@Test
	public void testAdd() {
		
	}
	
	@Test
	public void testRemove() {
		
	}
	
	
	@Test
	public void testEntitySerialize() {
		Entity<Employee> entity = new Entity<Employee>();
		Employee emp = new Employee();
		
		emp.setId("2323424523434234234");
		emp.setFirstName("Magee");
		emp.setLastName("Anderson");
		
		entity.setId("3423213123123123213");
		entity.setObject(emp);
		
		//Storage storage = new Storage();
		Storage store = null;
		
		try {
			FileInputStream fileIn = new FileInputStream("Storage.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			store = (Storage) in.readObject();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		store.add(entity);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("Storage.ser");

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(store);
			out.close();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		assertTrue("size of database =",store.getSize() > 0);
	 
	}

}
