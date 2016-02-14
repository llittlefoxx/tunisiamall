package admin.dashboard;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.entities.Product;

public class TestIndicator {

	public static void main(String[] args) {
		IndicatorsServiceRemote indicatorsServiceRemote;
		try {
			Context ctx = new InitialContext();
			indicatorsServiceRemote = (IndicatorsServiceRemote) ctx
					.lookup("tunisiamall-server/IndicatorsService!edu.tunisiamall.biservices.IndicatorsServiceRemote");
			
			System.out.println(indicatorsServiceRemote.getAllProducts().size());
			for (Product p : indicatorsServiceRemote.getAllProducts()) {

				System.out.println( p.getLibelle());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
