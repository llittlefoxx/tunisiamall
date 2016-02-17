package TestServices;

import java.util.List;


import Delegates.CategoriesDelegate;
import Delegates.GuestBookEntryDelegate;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Gestbookentry;

public class Test {

	public static void main(String[] args) {
		List<Gestbookentry> l = GuestBookEntryDelegate.ListOfEntries();
		System.out.println(l.size());
	}

	
}
