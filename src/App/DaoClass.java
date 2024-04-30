package App;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class DaoClass extends JdbcDaoSupport {

    public int getCircleCount(){
        String sql = "SELECT COUNT(*) from circle";
        int result = this.getJdbcTemplate().queryForObject(sql,Integer.class);
        return result;
    }
}
