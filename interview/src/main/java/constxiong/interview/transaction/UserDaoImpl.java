package constxiong.interview.transaction;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	
	/**
	 * 查询用户
	 * @return
	 */
	public List<Map<String, Object>> getUsers() {
		String sql = "select * from user";
		return this.getJdbcTemplate().queryForList(sql);
	}
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
//	@Transactional(rollbackFor=RuntimeException.class)
	public int deleteUser(int id){
		String sql = "delete from user where id = " + id;
		int result = this.getJdbcTemplate().update(sql);
		if (id == 1) {
			throw new RuntimeException();
		}
		return result;
	}
}
