public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cls = Class.forName("com.mysql.jdbc.Driver");
        System.out.println(cls.getSimpleName());
    }
}
