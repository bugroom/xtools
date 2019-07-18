package constxiong.interview.transaction;

import java.util.List;
import java.util.Map;

public interface UserDao {

	/**
	 * 查询用户
	 * @return
	 */
	public List<Map<String, Object>> getUsers();
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);
	
}
