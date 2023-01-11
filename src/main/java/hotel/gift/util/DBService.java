package hotel.gift.util;

public class DBService {
	public  static final String host = "127.0.0.1";
	public  static final String DB_MYSQL = "MYSQL";
	public  static final String DB_SQLSERVER = "SQLSERVER";

	public  static final String DB_TYPE = DB_SQLSERVER;

	private static final String DBURL_SQLServer = "jdbc:sqlserver://" + host + ":1433;databaseName=JSPDB";
	public  static final String USERID_SQLServer = "sa";
	public  static final String PSWD_SQLServer = "1234";

	public  static final String nameMs = "java:comp/env/jdbc/SOUVENIRDB";
	public  static final String nameMy = "java:comp/env/jdbc/BookDataMySQL";
	
	public  static String JNDI_DB_NAME = (DB_TYPE.equals(DB_MYSQL)? nameMy : nameMs);
	
	static {
		if (JNDI_DB_NAME.equals(DB_MYSQL)) {
			JNDI_DB_NAME = nameMy;
		} else if (JNDI_DB_NAME.equals(DB_SQLSERVER)) {
			JNDI_DB_NAME = nameMs;
		}
	}

}
