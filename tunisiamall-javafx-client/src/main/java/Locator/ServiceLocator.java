package Locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class ServiceLocator {
	private Context context;
	private Map<String, Object> cache;
	private static ServiceLocator instance;

	private ServiceLocator() {
		cache = new HashMap<>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			throw new ServiceLocatorException(e);
		}
	}

	public synchronized static ServiceLocator getInstance() {

		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	public Object getProxy(String jndiName) {
		Object proxy = cache.get(jndiName);
		if (proxy == null) {

			try {
				proxy = context.lookup(jndiName);

			} catch (NamingException e) {
				throw new ServiceLocatorException(e);
			}
			cache.put(jndiName, proxy);
		}
		return proxy;
	}


}
