package App;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
 ApplicationContext ctx = new ClassPathXmlApplicationContext("App/spring.xml");
 JdbcDaoImpl jdbcDao = ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
//        System.out.println(jdbcDao.getCircleCount());
//        System.out.println(jdbcDao.getCircleName(1));
//        System.out.println(jdbcDao.getCircle(1).name);
        jdbcDao.insertCircle(new Circle(6,"sixth circle"));
        System.out.println(jdbcDao.getAllCircles().size());
       // jdbcDao.createTriangle();
    }
}