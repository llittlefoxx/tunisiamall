package Delegates;

import java.util.List;

import edu.tunisiamall.customerServices.customerServicesRemote;
import edu.tunisiamall.entities.Customer;



public class CustomerDelegate {
	private static customerServicesRemote remote;
	private final static String jndiName="tunisiamall.server-ear/tunisiamall.server-ejb/customerServices!edu.tunisiamall.customerServices.customerServicesRemote"; 
	
	private static customerServicesRemote getProxy() {
		return (customerServicesRemote) Locator.ServiceLocator.getInstance().getProxy(
				jndiName);

	}
	
	public static List<Customer> findAllCos(){
		return getProxy().findAllCos();
	}
	public static void create(Customer cust){
		getProxy().create(cust);
	}
	
	public static void delete(Customer cust){
		getProxy().delete(cust);
		
	}
	
	public static void updateCustomer(Customer cust){
		getProxy().updateCustomer(cust);
		
	}
	public static long count(){
		return getProxy().count();
	}
	public static  List<Customer> find(String chaine, String value){
		return getProxy().find(chaine, value);
	}

}
