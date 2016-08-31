package jdbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by zhuxinquan on 16-8-21.
 */
public class DatabaseBean implements Serializable {
    private DataSource dataSource;

    public DatabaseBean(){
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context)initContext.lookup("jdbc:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/demo");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnectedOK(){
        boolean ok = false;
        Connection conn = null;
        SQLException ex = null;
        try {
            if(dataSource == null){
                System.out.println("nullllll");
            }
            conn = dataSource.getConnection();
            if(!conn.isClosed()){
                ok = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null ){
                try {
                    conn.close();
                } catch (SQLException e) {
                    if(ex == null){
                        ex = e;
                    }
                }
            }
            if(ex != null){
                throw new RuntimeException(ex);
            }
        }
        return ok;
    }
}
