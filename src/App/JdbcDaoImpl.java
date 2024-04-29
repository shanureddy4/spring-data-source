package App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public Circle getCircle(int circleId){
        String sql = "SELECT * FROM CIRCLE WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());

    }

    public List<Circle> getAllCircles (){
        String sql = "SELECT * FROM CIRCLE";
        return jdbcTemplate.query(sql,new CircleMapper());
    }

    private static final class CircleMapper implements RowMapper<Circle>{

        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(rs.getInt("id"));
            circle.setName(rs.getString("name"));
            return circle;

        }
    }
}