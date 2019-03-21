
package com.example.finaldemo.mysql_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author Nguyen Duc Nhat Anh
 * @email nhatanh2996@gmail.com
 */
public class MysqlCon {
 public static final String SERVER_HOST = "localhost:3306";
    public static final String DB_BASIC_DEMO = "finaldemo";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + SERVER_HOST + "/" + DB_BASIC_DEMO + "?useServerPrepStmts=false&rewriteBatchedStatements=true&user=" + USERNAME + "&password=" + PASSWORD);
        } catch (SQLException e ) {
            e.printStackTrace();
        }catch(ClassNotFoundException ce){
            ce.printStackTrace();
        }
        return connect;
    }
}
