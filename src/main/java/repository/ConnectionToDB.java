package repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionToDB {
    public Connection getConnectionFromDB() throws IOException, SQLException {
        FileInputStream fis = new FileInputStream("/home/gormak/BSUIR/ПБЗ/2 лаб/HouseOfCreativity/src/main/resources/application.properties");
        Properties p = new Properties();
        p.load(fis);
        String url = (String) p.get("url");
        String username = (String) p.get("username");
        String password = (String) p.get("password");
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
}
