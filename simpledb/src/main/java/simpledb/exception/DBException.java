package simpledb.exception;

public class DBException extends RuntimeException{

	

	public DBException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DBException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DBException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

	@Override
	public synchronized Throwable getCause() {
		// TODO Auto-generated method stub
		return super.getCause();
	}
	
	

}
