package Database;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import util.DBType;
import util.dataBaseUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UsingDBUtil {

    @BeforeClass
    public static void setUp() throws SQLException {
        dataBaseUtil.establishBDConnection(DBType.ORACLE);
    }

    @AfterClass
    public static void tierDownConnections(){
        dataBaseUtil.closeConnections();

    }
 @Test
    public void test1() throws SQLException {
       List<Map<String, Object>>result =  dataBaseUtil.runSQLQuery("select department_name from departments");
    System.out.println(result);
    System.out.println(result.get(1));
}
@Test
    public void test2() throws SQLException {
        List<Map<String, Object>>result = dataBaseUtil.runSQLQuery("select first_name,last_name from employees where employee_id = 105");

        Assert.assertEquals(result.get(0).get("FIRST_NAME"),"David");
        Assert.assertEquals(result.get(0).get("LAST_NAME"),"Austin");
        System.out.println(result.toString());
}
@Test
    public void test3() throws SQLException {
    List<Map<String, Object>>result = dataBaseUtil.runSQLQuery("select country_id from countries where country_id like 'BR'");

    Assert.assertEquals(result.get(0).get("COUNTRY_ID"),"BR");
    System.out.println(result.toString());
    }

}
