package GUI.ShopRequestInterfaces;

import edu.tunisiamall.entities.*;
import edu.tunisiamall.entities.ShopRequest;
import Locator.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Delegates.CategoryDelegate;
import Delegates.ManageShopRequestDelegate;

public class JTableModelViewRequest extends DefaultTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String entete[]={"First Name","Last Name","Category","Description","Status","ReceptionDate"};
	List<ShopRequest> listRequests=new ArrayList<ShopRequest>();
	List<Category> listCategorys=new ArrayList<Category>();
	
	
	public  JTableModelViewRequest(){
		listCategorys=CategoryDelegate.doFindAllCategory();
		listRequests=ManageShopRequestDelegate.doFindAllShopRequest();
		System.out.println("hhhhhhhhhh");
		for (ShopRequest r:listRequests)
		{
			System.out.println("mmmm"+r.toString());
		}
		
	}
	
	public JTableModelViewRequest(List<ShopRequest> listRequests){
		this.listRequests=listRequests;
		
	}
		
	@Override
	public int getRowCount() {
		if (listRequests!=null)
			return listRequests.size()+1;
			else 
				return 0;
		//return listRequests.size();
	}

	@Override
	public int getColumnCount() {
		return entete.length;
	}

	  @Override
	    public String getColumnName(int column){
	        return entete[column];
	    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	if(rowIndex==0)
	{
		switch(columnIndex)
	        {
	            case 0:
	            	return getColumnName(columnIndex);
	               
	            case 1:
	            return getColumnName(columnIndex);
	               
	            case 2:
	            	return getColumnName(columnIndex);
	               
	            case 3:
	            	return getColumnName(columnIndex);
	                
	            case 4:
	            	return getColumnName(columnIndex);
	            case 5:
	            	return getColumnName(columnIndex);
	                
	          
	            default:
	                return null;
	         }
	}
	else 
	{
		switch(columnIndex)
        {
            case 0:
            
                return listRequests.get(rowIndex-1).getFirstName();
            case 1:
            	
                return listRequests.get(rowIndex-1).getLastName();
            case 2:
          
                return listRequests.get(rowIndex-1).getCategory().getLibelle();
            case 3:
            
                return listRequests.get(rowIndex-1).getDescription();
            case 4:
         
                return listRequests.get(rowIndex-1).getStatus();
            case 5:
            	return listRequests.get(rowIndex-1).getRcptDate();
          
            default:
                return null;
         }
	}
	}
	
	public List<ShopRequest> getShopRequest() {
		return listRequests;
	}
	public void setShopRequest(List<ShopRequest> listRequests) {
		
		this.listRequests=listRequests;
	}
	

}
