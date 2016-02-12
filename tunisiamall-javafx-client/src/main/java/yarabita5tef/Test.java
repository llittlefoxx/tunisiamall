package yarabita5tef;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Delegates.UserDelagate;
import edu.tunisiamall.entities.Administrator;
import edu.tunisiamall.userServices.userServicesRemote;

public class Test {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		userServicesRemote userServiceRemote = null;

		try {
			Context ctx = new InitialContext();
			userServiceRemote = (userServicesRemote) ctx
					.lookup("tunisiamall-server/userServices!edu.tunisiamall.userServices.userServicesRemote");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
		UserDelagate delguser=new UserDelagate();
		
		
		Administrator admin = new Administrator();
		
		
		//admin.setFirstName("soufiene");
		//admin.setLogin("soufiene");
		//admin.setPassword("soufiene");
		
		//userServiceRemote.create(admin);
		
		//admin.setFirstName("ilyes");
			//	admin.setLogin("ilyes");
			//	admin.setPassword("ilyes");
		//delguser.create(admin);
		admin=(Administrator) delguser.authentificate("soufiene", "soufiene");
		System.out.println(admin.getLogin());
	}

}
