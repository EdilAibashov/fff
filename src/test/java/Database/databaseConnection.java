package Database;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class databaseConnection {


    String dbURL = "jdbc:oracle:thin:@ec2-34-204-92-196.compute-1.amazonaws.com:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    /**
     * dbConnectionJDBC will set a connection to ORACLE DB
     * Connection takes dbUsername , dbPassword as parameters
     * Statement will allow us to scroll
     * ResultSet will execute query
     * Example in executeQuery : select * from employees
     *@throws SQLException
     * @Author Edil Aibashov
     *
     */
    @Test
    public void dbConnectionJDBC() throws SQLException {
        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees where department_id in (100)");
        resultSet.last();
//        int rowCount = resultSet.getRow();
//        System.out.println("Row count : " + rowCount);

        resultSet.first();
        while (resultSet.next()) {
            System.out.println(resultSet);
//                    " -- "+ resultSet.getString("first_name")+
//                    " "+resultSet.getString("last_name"));
//        }
//        resultSet.close();
//        statement.close();
//        con.close();
        }
    }
    @Test
    public void department100() throws SQLException {
        Connection con1 = DriverManager.getConnection(dbURL,dbUsername, dbPassword);
        Statement statement = con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees where department_id in (100)");

        resultSet.first();
        while (resultSet.next()) {
            System.out.println("Department id number : "+resultSet.getString("department_id")+
                    " -- "+ resultSet.getString("first_name")+
                   " "+resultSet.getString("last_name"));
        }
    }
    @Test
    public void firstFive() throws SQLException {
        Connection con1 = DriverManager.getConnection(dbURL,dbUsername, dbPassword);
        Statement statement = con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(" select * from employees where ROWNUM <= 5");
        resultSet.first();
        while (resultSet.next()) {
            System.out.println("Department id number : "+resultSet.getString("department_id")+
                    " -- "+ resultSet.getString("first_name")+
                    " "+resultSet.getString("last_name"));
        }
    }
@Test
    public void dbMetaData() throws SQLException {
    Connection con = DriverManager.getConnection(dbURL,dbUsername, dbPassword);
    Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    String query = "select office_name from departments";
    ResultSet resultSet = statement.executeQuery(query);
    DatabaseMetaData dbMetaData = con.getMetaData();
    System.out.println("User: "+dbMetaData.getUserName());
    System.out.println("DataBase type: "+dbMetaData.getDatabaseProductName());

    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
    System.out.println("Columns Count: "+resultSetMetaData.getColumnCount());
//    System.out.println(resultSetMetaData.getColumnName(4));
//    System.out.println(resultSetMetaData.getColumnName(3));

    for(int i = 1; i <= resultSetMetaData.getColumnCount();i++){
//        System.out.println(i+" ) "+resultSetMetaData.getColumnName(i));
    }

    List<Map<String, Object>> mapList = new ArrayList<>();
    ResultSetMetaData resultSetMetaData1 = resultSet.getMetaData();

    int colCount = resultSetMetaData1.getColumnCount();

    while (resultSet.next()){
        Map<String,Object> rowMap = new HashMap<>();
        for(int i = 1; i <=colCount;i++){
            rowMap.put(resultSetMetaData1.getColumnName(i),resultSet.getObject(i));
        }

        mapList.add(rowMap);
        }

    for(Map<String,Object>map : mapList){
//        System.out.println(map);
        System.out.println(map.get("SALARY"));

    }
    resultSet.close();
    statement.close();
    con.close();
       }
    }




