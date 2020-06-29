package Database;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class columnDBTest {
    String dbURL = "jdbc:oracle:thin:@ec2-34-204-92-196.compute-1.amazonaws.com:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void taskEmpl_id() throws SQLException {


        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees where employee_id in (150,160)");
        resultSet.last();
        resultSet.first();
        String query = "select * from employees where employee_id in (150,160)";
        //String query = "select employee_id,last_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id from employees";
        ResultSet resultSet1 = statement.executeQuery(query);

        List<Map<String, Object>> mapList = new ArrayList<>();
        ResultSetMetaData resultSetMetaData1 = resultSet.getMetaData();

        int colCount = resultSetMetaData1.getColumnCount();

        while (resultSet.next()){
            Map<String,Object> rowMap = new HashMap<>();
            for(int col = 1; col <=colCount;col++){
                rowMap.put(resultSetMetaData1.getColumnName(col),resultSet.getObject(col));
            }

            mapList.add(rowMap);
        }

        for(Map<String,Object>map : mapList){
        System.out.println(map);
//            System.out.println(map.get("SALARY"));

        }
        }
    }
