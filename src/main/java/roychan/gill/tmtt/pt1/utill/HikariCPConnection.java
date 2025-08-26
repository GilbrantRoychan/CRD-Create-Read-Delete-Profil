package roychan.gill.tmtt.pt1.utill;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPConnection {

    private  static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        // set JDBC
        config.setJdbcUrl("jdbc:mysql://localhost:3306/tamantirto");
        config.setUsername("test");
        config.setPassword("test");


        // set ConnectionPool
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(10);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(60_000 * 10);

        dataSource = new HikariDataSource(config);
    }

    public  static  HikariDataSource getDataSource(){
        return  dataSource;
    }
}
