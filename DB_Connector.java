
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {

//    declare a connection
    private static Connection connect = null;
//    declare JDBC driver
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    declare database
    private static String db = "company";
//    declare url = jdbc:dbms//host:port#/database
    private static String url = "jdbc:mysql://localhost:3306/" + db;
//    declare a username
    private static String user = "root";
//    declare a password
    private static String pswrd = "12345678";

//    Create a connection method
    public static Connection connect() {

        System.out.println("--Connecting to MySQL JDBC--");

        try {
            Class.forName(DRIVER); // locates the JDBC Driver
            System.out.println("\n--MySQL JDBC Driver is registered--");

        }
        catch(ClassNotFoundException ex) { //Catch Class not found exception
            System.out.println("\n--MySQL JDBC Driver is missing--");
            ex.printStackTrace();
        }

        System.out.println("\n--Connecting to MySQL DBMS--");

        try{
            connect = DriverManager.getConnection(url, user, pswrd); //Connect to the MySQL DBMS + company DB
            System.out.println("\n--Connection successfulllll--");
        }
        catch(SQLException ex){ //Catch SQL exception
            System.out.println("\n--Did not connect - try again--");
            ex.printStackTrace();
        }
        /*
        if(connect != null) {
            System.out.println("\n--Connection successfull--");
        }

        else {
            System.out.println("\n--Connection failed--");
        }*/

        return connect;

    }


}


