package App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class JdbcDaoImpl{

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


  private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;


    public int getCircleCount(){
        String sql = "SELECT COUNT(*) from circle";
        int result = jdbcTemplate.queryForObject(sql,Integer.class);
        return result;
    }

    public String getCircleName(int circleId){
        String sql = "SELECT NAME FROM CIRCLE WHERE id = ?";
        String result = jdbcTemplate.queryForObject(sql,new Object[] {circleId}, String.class);
        return result;
    }
}