package TestServices;

import java.util.List;


import Delegates.CategoriesDelegate;
import Delegates.GuestBookEntryDelegate;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Guestbookentry;

public class Test {

	public static void main(String[] args) {
		List<Guestbookentry> l = GuestBookEntryDelegate.ListOfEntries();
		System.out.println(l.size());
	}

	
}
