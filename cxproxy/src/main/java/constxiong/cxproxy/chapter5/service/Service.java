package constxiong.cxproxy.chapter5.service;

import java.util.Map;

/**
 * 服务接口
 * @author ConstXiong
 * @date 2019-05-29 11:02:02
 */
public interface Service {

	boolean login(String username, String password);

	Map<String, Object> getUserInfo(String username);

}
