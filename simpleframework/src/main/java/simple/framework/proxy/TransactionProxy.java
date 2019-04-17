package simple.framework.proxy;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simple.framework.annotation.Transaction;
import simple.framework.helper.JdbcHelper;

public class TransactionProxy implements Proxy {

	private static final Logger LOG = LoggerFactory.getLogger(TransactionProxy.class);
	
	private static final ThreadLocal<Boolean> FLAG_HOLDER = new ThreadLocal<Boolean>() {

		@Override
		protected Boolean initialValue() {
			return false;
		} 
		
	};
	
	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result;
		 Boolean flag = FLAG_HOLDER.get();
		 Method method = proxyChain.getTargetMethod();
		 if (!flag && method.isAnnotationPresent(Transaction.class)) {
			 FLAG_HOLDER.set(true);
			 
			 try {
				JdbcHelper.beginTransaction();
				 LOG.debug("begin transaction");
				 result = proxyChain.doProxyChain();
				 JdbcHelper.commitTransaction();
				 LOG.debug("commit trasaction");
			} catch (Exception e) {
				JdbcHelper.rollbackTransaction();
				LOG.debug("rollback transaction");
				throw e;
			} finally {
				FLAG_HOLDER.remove();
			}
		 } else {
			 result = proxyChain.doProxyChain();
			 JdbcHelper.closeConnection();
		 }
		return result;
	}

}
