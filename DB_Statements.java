import java.sql.*;

public class DB_Statements {

    //    Declare a statement
    private static Statement stmt = null;
    //    Declare & create a connection
    private static Connection con = DB_Connector.connect();
    //    Declare a set of results
    private static ResultSet rs = null;


    public void useDB(String db) {

        String query = "use " + db;

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("\n--Statement executed--");
        } catch (SQLException ex) {
            System.out.println("Statement did not execute");
            ex.printStackTrace();
        }

    }

    public void createTable(String tableName) {

        String query = "create table if not exists " + tableName +
                "(id int auto_increment, " +
                "name varchar(28), " +
                "address varchar(28), " +
                "primary key(id))";

        statement(query);
        /*
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        }
        catch(SQLException ex) {
            System.out.println("Statement did not execute");
            ex.printStackTrace();
        }
        */
    }

    public void statement(String query) {

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
            System.out.println("\n--Statement executed--");
        }
        catch(SQLException ex) {
            System.out.println("Statement did not execute");
            ex.printStackTrace();
        }

    }

    public void insertPersonData() {

        String query = "insert into person " +
                "(name, address) " +
                "values('Jack Benny', 'Jacks Home')";
        statement(query);

    }

    public void insertEmployeeData() {

        String query = "insert into employee " +
                "(name, address) " +
                "values('Jack Benny', 'Jacks Home')";
        statement(query);

    }

    public void queryTable(String table) {

        String query = "select * from " + table;

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            System.out.println("\nid\t\tname\t\taddress\n________________________________________");

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(id + "\t\t" + name + "\t\t" + address);
            }

        }
        catch(SQLException ex) {

            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();

        }

    }

    public void queryTable(int number) {

        String query = "select * from person";

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            System.out.println("\nid\t\tname\t\taddress\n________________________________________");

            while(rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(id + "\t\t" + name + "\t\t" + address);
            }

        }
        catch(SQLException ex) {

            System.out.println("\n--Query did not execute--");
            ex.printStackTrace();

        }

    }

//    Method that checks login info
    public boolean checkLogin(String usrnme, String pswrd) {

        boolean check = false;

        /*String query = "select * from users where username = '" +
                        usrnme + "' and password = '" + pswrd + "'";*/
//        SQL -> check table where username matches and password matches
        String query = "select * from users where username = ? and password = ?";

        try{

            //stmt = con.createStatement();
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            pst.setString(1, usrnme);
            pst.setString(2, pswrd);
            //rs = stmt.executeQuery(query);
            rs = pst.executeQuery();
//          check table for matching username and password
            if(rs.next()) {
                check = true;
                System.out.println("\n--YooHoooo!!!--");
            }

            if(check == false) {
                System.out.println("\n--no worky--");
            }
        }

        catch(Exception ex) {
            System.out.println("\n--something went wrong--");
            ex.printStackTrace();
        }

        return check;
    }


}
