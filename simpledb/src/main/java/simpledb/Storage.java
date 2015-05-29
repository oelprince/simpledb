package simpledb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Storage implements Serializable {
	
	private static final long serialVersionUID = -2179839153423352813L;
	
	private Map<String,Entity<?>> store;

	public Storage() {
		store = new HashMap<String,Entity<?>>();
	}
	
	/**
	 * 
	 * @param entity
	 */
	public void add(Entity<?> entity) {
		store.put(entity.getId(), entity);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSize() {
		return store.size();
	}
	
	/**
	 * 
	 * @param entityId
	 */
	public void remove(String entityId) {
		store.remove(entityId);
	}
	
}
