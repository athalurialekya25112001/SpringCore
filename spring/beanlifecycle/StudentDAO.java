package spring.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class StudentDAO {

    private String driver;
    private String url;
    private String userName;
    private String password;

    //My connection obj
    Connection con;

    public void setDriver(String driver) {
        System.out.println("setting driver ... ");
        this.driver = driver;
    }

    public void setUrl(String url) {
        System.out.println("setting url ... ");
        this.url = url;
    }

    public void setUserName(String userName) {
        System.out.println("setting userName ... ");
        this.userName = userName;
    }

    public void setPassword(String password) {
        System.out.println("setting password ... ");
        this.password = password;
    }

   // @PostConstruct
    public void init() throws SQLException, ClassNotFoundException {
        System.out.println("inside the custom init method");
        createDBConnection();
    }

    public void createDBConnection() throws ClassNotFoundException, SQLException {
        System.out.println("Creating connection for DB ");

        //load Driver
        Class.forName(driver);

        //get a connection
        con = DriverManager.getConnection(url, userName, password);
    }

    public void selectAllRows() throws SQLException {
        System.out.println("Retrieving all student data..");
        //execute query
        Statement statement = con.createStatement();

        ResultSet rs = statement.executeQuery("select * from sys_config");
        while (rs.next()) {
            String variable = rs.getString(1);
            String value = rs.getString(2);
            Timestamp setTime = rs.getTimestamp(3);
            String setBy = rs.getString(4);

            System.out.println(variable + " " + value + " " + setTime + " " + setBy);
        }
    }


    public void deleteRow(String var) throws SQLException {

        //execute query
        Statement statement = con.createStatement();

        int result = statement.executeUpdate("delete from sys_config where variable =  '" + var + "'");
        if (result > 0) {
            System.out.println("Deleted " + result + " records successfully.");
        } else {
            System.out.println("Deletion operation Failed");
        }
    }

    public void closeConnection() throws SQLException {
        //close the connection
        con.close();
    }

   // @PreDestroy
    public void destroy() throws SQLException {
        //clean up job
        System.out.println("Inside destroy method");
        closeConnection();

    }


}
