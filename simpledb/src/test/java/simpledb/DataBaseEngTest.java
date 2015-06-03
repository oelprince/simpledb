package simpledb;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import simpledb.sampledomain.Employee;

public class DataBaseEngTest {

	@Test
	public void testAdd() {
		DataBaseEng databaseEng = new DataBaseEng();
		Entity<Employee> entity = new Entity<Employee>();
		Employee emp = new Employee();
		
		emp.setId("2323424523434234234");
		emp.setFirstName("Magee");
		emp.setLastName("Anderson");
		entity.setId("3423213123123123213");
		entity.setObject(emp);
		
		databaseEng.add(entity);
		Entity<?> resultEntity =  databaseEng.getEntityById(entity.getId());
		Employee employeeResult = (Employee) resultEntity.getObject();
		assertNotNull("employeeResult not equal null " + employeeResult);
		assertTrue("Magee".equals(employeeResult.getFirstName()));
		assertTrue("Anderson".equals(employeeResult.getLastName()));
	}
	
	@Test
	public void testRemove() {
		DataBaseEng databaseEng = new DataBaseEng();
		Entity<Employee> entity = new Entity<Employee>();
		Employee emp = new Employee();
		
		emp.setId("2323424523434234234");
		emp.setFirstName("Magee");
		emp.setLastName("Anderson");
		entity.setId("3423213123123123213");
		entity.setObject(emp);
		
		databaseEng.add(entity);
		Entity<?> resultEntity = databaseEng.getEntityById(entity.getId());
		Employee employeeResult = (Employee) resultEntity.getObject();
		assertNotNull("employeeResult not equal null " + employeeResult);
		assertTrue("Magee".equals(employeeResult.getFirstName()));
		assertTrue("Anderson".equals(employeeResult.getLastName()));
		
		databaseEng.remove(entity);
		
		assertTrue("databaseEng.getCount() == 0", databaseEng.getCount() == 0);
	}

}
