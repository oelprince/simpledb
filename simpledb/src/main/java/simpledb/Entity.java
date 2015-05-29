package simpledb;

import java.io.Serializable;

public class Entity<T> implements Serializable {
	
	private static final long serialVersionUID = 491837604471698626L;
	
	private String id;
	private String name;
	private T object;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	

	
}
