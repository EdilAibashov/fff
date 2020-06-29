package Database;

import org.testng.annotations.Test;

import java.sql.*;

public class dbSet {
   static String url = "jdbc:mysql://db4free.net:3306/techleadacademy?user=techlead&password=students";
   @Test
            public static void connectDB() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from teachers");
        int rowCount = resultSet.getRow();
        System.out.println("Number of rows: "+rowCount);
        resultSet.first();
        while (resultSet.next()){

            System.out.println(resultSet.getString(0)+" "+
//                    resultSet.getString("name")+" "+
                    resultSet.getString(2));
        }

    }
}
