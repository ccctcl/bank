package com.example.bank.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){

        try {
            Connection connection=threadLocal.get();
            if(connection==null){
                connection=dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;

        } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
        }

    }

    public void removeConnection(){
        threadLocal.remove();
    }


}
