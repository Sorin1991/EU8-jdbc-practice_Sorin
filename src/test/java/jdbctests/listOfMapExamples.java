package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class listOfMapExamples {

    String dbURL = "jdbc:oracle:thin:@52.91.79.87:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1(){

        //creating list of keeping all the rows map

        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1 = new HashMap<>();

        row1.put("first_name","Steven");
        row1.put("last_name","King");
        row1.put("salary",24000);
        row1.put("job_id","AD_PRES");

        System.out.println(row1.toString());

        Map<String,Object> row2= new HashMap<>();

        row2.put("first_name","Neena");
        row2.put("last_name","Kochhar");
        row2.put("salary",17000);
        row2.put("job_id","AD_VP");

        System.out.println(row1.toString());

        //adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);


        //get the steven lastname directly from the list
        System.out.println(queryData.get(0).get("last_name"));

        //Neena salary
        System.out.println(queryData.get(1).get("salary"));








    }

    @Test
    public void test2() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions");

        //creating list of keeping all the rows map

        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1 = new HashMap<>();

        row1.put("first_name","Steven");
        row1.put("last_name","King");
        row1.put("salary",24000);
        row1.put("job_id","AD_PRES");

        System.out.println(row1.toString());

        Map<String,Object> row2= new HashMap<>();

        row2.put("first_name","Neena");
        row2.put("last_name","Kochhar");
        row2.put("salary",17000);
        row2.put("job_id","AD_VP");

        System.out.println(row1.toString());

        //adding rows one by one to my list
        queryData.add(row1);
        queryData.add(row2);





        //close connection
        resultSet.close();
        statement.close();
        connection.close();



    }






}
