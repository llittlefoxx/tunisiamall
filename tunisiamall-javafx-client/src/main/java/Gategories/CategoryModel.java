package Gategories;

import javafx.beans.property.SimpleStringProperty;

public class CategoryModel {
	private final SimpleStringProperty name = new SimpleStringProperty("") ;
	private final SimpleStringProperty edit = new SimpleStringProperty("");
	private final SimpleStringProperty delete = new SimpleStringProperty("");
	public CategoryModel() {
		//super();
		this("","","");
	}
	public CategoryModel(String  name, String edit, String delete) {
		//super();
		setName(name);
		setEdit(edit);
		setDelete(delete);
	}
	
	 public String getName() {
	        return name.get();
	    }
	    public void setName(String lname) {
	        name.set(lname);
	    }
	        
	    public String getEdit() {
	        return edit.get();
	    }
	    public void setEdit(String Ledit) {
	        edit.set(Ledit);
	    }
	    
	    public String getDelete() {
	        return delete.get();
	    }
	    public void setDelete(String Ldelete) {
	        delete.set(Ldelete);
	    }

	

}
