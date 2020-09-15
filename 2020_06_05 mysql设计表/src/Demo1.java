import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //建立数据库的连接
        //只需要修改默认库
        String defaultDatabaseName = "mysql_0601";
        String password = "311000MT";

        //不需要修改
        String user = "root";
        String ur1 = "jdbc:mysql://127.0.0.1:3306/" + defaultDatabaseName + "?useSSL=false&characterEncoding=utf8";
        Connection connection = DriverManager.getConnection(ur1,user,password);
        System.out.println(connection);


        //关闭当前的数据库
        connection.close();
    }
}
