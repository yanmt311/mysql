import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动 —— 选择了乙方
        Class.forName("com.mysql.jdbc.Driver");

        /**
         * 完整的目标是执行 select * from student_0604;
         */

        // 建立数据库连接

        // 写明 MySQL 服务端所在地
        // 以后写项目，只需要修改默认数据库名称即可
        String defaultDatabaseName = "huojianban2_0601";    // 等于我们在 mysql 界面上用 use 库名称，指定默认库
        // 填写你自己的 MySQL 密码，每个同学都不太一样
        String password = "";

        // 下面这里，基本上不变
        String user = "root";
        String url = "jdbc:mysql://127.0.0.1:3306/" + defaultDatabaseName + "?useSSL=false&characterEncoding=utf8";

        Connection connection = DriverManager.getConnection(url, user, password);
        // 打印 connection 对象，验证是否连接成功
        System.out.println(connection);

        //queryDemo(connection);

        updateDemo(connection);


        // -1. 关闭刚才的连接
        connection.close();

    }

    private static void updateDemo(Connection connection) throws SQLException {
        // 获取 Statement 对象
        Statement statement = connection.createStatement();
        String sql = "insert into student_0604 (sn, name, sex) values ('20200605', '小陈', '女')";
        int affectedRows = statement.executeUpdate(sql);
        System.out.printf("Query OK, %d row affected%n", affectedRows);

        statement.close();
    }

    private static void queryDemo(Connection connection) throws SQLException {
        // 要真正的执行 sql 语言，并且获取数据库返回的结果
        // Statement 代表的是 “语句” 的抽象对象
        Statement statement = connection.createStatement();
        String sql = "select * from student_0604";  // 没有要求必须分号结尾了
        // 1. executeQuery 用在查询（query）场景下
        // 2. ResultSet 代表是 “结果集” 的抽象对象
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String sn = resultSet.getString(2);
            String name = resultSet.getString(3);
            String sex = resultSet.getString(4);
        }
        // -3. 关闭 resultSet 对象
        resultSet.close();
        // -2. 关闭 statement 对象
        statement.close();
    }
}
