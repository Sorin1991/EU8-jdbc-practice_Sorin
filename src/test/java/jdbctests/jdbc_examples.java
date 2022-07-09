package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {


    String dbURL = "jdbc:oracle:thin:@52.91.79.87:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";


    @Test
    public void test1() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        //move to first row
        resultSet.next();


        System.out.println(resultSet.getString(2));
        //display departments table in 10 - Administration -200 -1700 format

        //code for iterating for each row
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" - " + resultSet.getString(2)
                    +" - " + resultSet.getString(3)+" - " + resultSet.getInt(4));
        }

        resultSet = statement.executeQuery("SELECT * FROM regions");


        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" - " + resultSet.getString(2));

        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();


    }


    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM departments");

        //how to find how manu rows we have for the query
        //move to last row
        resultSet.last();

        //get the row count
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);

        //to move before first row after we use .last method
        resultSet.beforeFirst();

        //print all second column information
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();

    }

    @Test
    public void test3() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");


        //get the database related data inside the dbMetedata object
        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());
        System.out.println("dbMetadata.getDatabaseProductVersion() = " + dbMetadata.getDatabaseProductVersion());
        System.out.println("dbMetadata.getDriverName() = " + dbMetadata.getDriverName());
        System.out.println("dbMetadata.getDriverVersion() = " + dbMetadata.getDriverVersion());

        //get the resultsetmetadata //rsmd
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //how many columns we have ?
        int colCount = rsMetadata.getColumnCount();
        System.out.println(colCount);

        //getting column names
//        System.out.println(rsMetadata.getColumnName(1));
//        System.out.println(rsMetadata.getColumnName(2));
//        System.out.println(rsMetadata.getColumnName(3));
//        System.out.println(rsMetadata.getColumnName(4));
//        System.out.println(rsMetadata.getColumnName(5));
//        System.out.println(rsMetadata.getColumnName(6));
//        System.out.println(rsMetadata.getColumnName(6));
//        System.out.println(rsMetadata.getColumnName(7));
//        System.out.println(rsMetadata.getColumnName(8));
//        System.out.println(rsMetadata.getColumnName(9));
//        System.out.println(rsMetadata.getColumnName(10));
//        System.out.println(rsMetadata.getColumnName(11));

        //print all the column names dynamically

        for (int i = 1; i <= colCount; i++) {
            System.out.println(rsMetadata.getColumnName(i));

        }


        //close connection
        resultSet.close();
        statement.close();
        connection.close();

    }





}
