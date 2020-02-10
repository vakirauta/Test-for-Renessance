package Test1;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;

public class DataBase {

    public void writeDateAndTimeToDataBase(String name, String start, String finish) {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:sqlserver://localhost:1576;databasename=Test";

        final String USER = "alexandr";
        final String PASS = "1Ybrjkfc89";

        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating statement...");

            stmt = conn.createStatement();

            String sql1 = ("INSERT INTO renessance(Название_шага,Дата_и_время_начала_шага,Дата_и_время_окончания_шага) VALUES('"+name+"', (?),(?));");
            PreparedStatement statementSql1 = conn.prepareStatement(sql1);

            statementSql1.setString(1, start);
            statementSql1.setString(2, finish);
            statementSql1.executeUpdate();

            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}
