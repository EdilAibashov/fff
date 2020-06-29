package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataBaseUtil {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void establishBDConnection(DBType dbType) throws SQLException {
        switch (dbType){
            case ORACLE:
                connection = DriverManager.getConnection(ConfigReader.readProperty("dbURL"),ConfigReader.readProperty("dbUsername"),ConfigReader.readProperty("dbPassword"));
                break;
            case MYSQL:
                connection = null;
            case MARIADB:
                connection = null;
            case CASSANDRA:
                connection = null;
            case POSTGRESQL:
                connection = null;
            case MONGODB:
                connection = null;
            default:
                connection = null;
        }
    }
    public static int getRowsCount(String sql) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(sql);
        resultSet.last();

        return resultSet.getRow();
    }

    public static List<Map<String,Object>> runSQLQuery(String query) throws SQLException {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(query);

        List<Map<String,Object>> list = new ArrayList<>();
        ResultSetMetaData rsMData = resultSet.getMetaData();

        int colCount = rsMData.getColumnCount();
        while (resultSet.next()){
            Map<String,Object> rowMap = new HashMap<>();
            for(int col = 1;col <= colCount;col++){
                rowMap.put(rsMData.getColumnName(col),resultSet.getObject(col));
            }
            list.add(rowMap);
        }
        return list;
    }
    public static void closeConnections(){
        try {
            if (resultSet != null){
                resultSet.close();;
            }
            if(statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

