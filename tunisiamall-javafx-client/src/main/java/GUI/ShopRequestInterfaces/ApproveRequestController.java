package GUI.ShopRequestInterfaces;
import java.awt.Label;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.decorator.Delegate;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;

import Delegates.CategoryDelegate;
import Delegates.ManageShopRequestDelegate;
import Delegates.StoreServicesDelegate;
import Delegates.UserDelagate;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.ShopRequest;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class ApproveRequestController{
	  
	
	private ShopRequest sr;
	
	

	public void setSr(ShopRequest sr) {
		this.sr = sr;
		catfield.setText(sr.getCategory().getLibelle());
		System.out.println("oooooo ");
		List<Category> l= CategoryDelegate.doFindAllCategory();
		System.out.println("kkkeenne ");
		
		List<String> l1=new ArrayList<>();
		for(Category c:l)
		{System.out.println("kkkeenne " +c.toString());
			l1.add(c.getLibelle());
			System.out.println("kkkeenne " +c.getLibelle());
		
		}
		final ObservableList<String> data=
		        FXCollections.observableArrayList(l1);
		
		
		
		selectCateg.getItems().addAll(
            data
        );
		selectCateg.setPromptText("Categories Stores");
		selectCateg.setEditable(true);        
		chart();
	}


    @FXML
    void catAction(ActionEvent event) {
    	
    	  selectCateg.onMouseClickedProperty();
          String s=selectCateg.getSelectionModel().getSelectedItem();
         Category cat= CategoryDelegate.doFindAllCategoryByLibelle(s);
         List<Store>l=StoreServicesDelegate.findAllSStoreByCategory(cat);
        int nb=0;
         for(Store st:l)
         {
        	 nb++;
         }
         
    }
    
    
    @FXML
    private BarChart<String, Number> barchart;
    
    XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
    @FXML
    void chart() {
    	
    	final String austria = "Austria";
        final  String brazil = "Brazil";
        final  String france = "France";
        final  String italy = "Italy";
        final  String usa = "USA";
        
  
         CategoryAxis xAxis = new CategoryAxis();
         NumberAxis yAxis = new NumberAxis();
      
       
        xAxis.setLabel("Country");       
        yAxis.setLabel("Value");
       
        System.out.println("k<ldkl");
        BarChart<String,Number> barchart = 
                new BarChart<String,Number>(xAxis,yAxis);
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(austria, brazil)));
        
        series1.setName("2003");  
        series1.getData().add(new XYChart.Data<String,Number>(austria, 10));
        series1.getData().add(new XYChart.Data<String,Number>(brazil, 20));
        barchart.getData().addAll(series1);
 /*
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");       
        series1.getData().add(new XYChart.Data(austria, 25601.34));
        series1.getData().add(new XYChart.Data(brazil, 20148.82));
        series1.getData().add(new XYChart.Data(france, 10000));
        series1.getData().add(new XYChart.Data(italy, 35407.15));
        series1.getData().add(new XYChart.Data(usa, 12000));      
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(austria, 57401.85));
        series2.getData().add(new XYChart.Data(brazil, 41941.19));
        series2.getData().add(new XYChart.Data(france, 45263.37));
        series2.getData().add(new XYChart.Data(italy, 117320.16));
        series2.getData().add(new XYChart.Data(usa, 14845.27));  
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(austria, 45000.65));
        series3.getData().add(new XYChart.Data(brazil, 44835.76));
        series3.getData().add(new XYChart.Data(france, 18722.18));
        series3.getData().add(new XYChart.Data(italy, 17557.31));
        series3.getData().add(new XYChart.Data(usa, 92633.68)); 
        barchart.getData().addAll(series1, series2, series3);
        
    */
    }
		
		
	

    @FXML
    private ComboBox<String> selectCateg;
	@FXML
	    private Button approvebutton;

	    @FXML
	    private TextField catfield;

	    @FXML
	    private Button cancelbutton;

	    @FXML
	    private TextField nbfreestorefield;

	    @FXML
	    private TextField nbStore;
	    
	    @FXML
	    private Button backButton;
	    
	    private SecureRandom random = new SecureRandom();

	    public String nextSessionId() {
	      return new BigInteger(50, random).toString(32);}
	    
	   
	    
	    @FXML
	    void okbuttonAction(ActionEvent event) {
	    	Shopowner so1=new Shopowner();
	    
	    	so1.setFirstName(sr.getFirstName());
	    	so1.setAddress(sr.getAddress());
	    	so1.setLogin(sr.getFirstName());
	    	so1.setPassword(nextSessionId());
	    	UserDelagate.create(so1);
	    	System.out.println("55555 "+ nextSessionId());
	    	
	    	 Stage stage = (Stage) cancelbutton.getScene().getWindow();
             stage.close();
	    	
	    	
	    
	    
	    	
	    }
	    @FXML
	    void CancelAction(ActionEvent event) {
	    	 Stage stage = (Stage) cancelbutton.getScene().getWindow();
	    	 Pane myPane = null;
			    	   FXMLLoader fxmlLoader= new FXMLLoader();
			    	   fxmlLoader.setLocation(getClass().getResource("/GUI/ShopRequestInterfaces/ViewShopRequestAdmin.fxml"));     
			    	   System.out.println("000000888");
			    	   try {
						fxmlLoader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			    	   Parent p =fxmlLoader.getRoot();
			    	   myPane = (Pane) p; 
			    	   
			    	   Stage st=new Stage();
			    	   Scene scene = new Scene(myPane);
			    	   st.setScene(scene);
			    	   stage.close();
				       
				       st.show();
	    }

	    @FXML
	    void backAction(ActionEvent event) {
	    	 Stage stage = (Stage) cancelbutton.getScene().getWindow();
	    	 TitledPane myPane = null;
			    	   FXMLLoader fxmlLoader= new FXMLLoader();
			    	   fxmlLoader.setLocation(getClass().getResource("/GUI/ShopRequestInterfaces/ficheRequest.fxml"));     
			    	   System.out.println("000000888");
			    	   try {
						fxmlLoader.load();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			    	   Parent p =fxmlLoader.getRoot();
			    	   myPane = (TitledPane) p; 
			    	   ficheRequestController controller = fxmlLoader.getController();
			   		
					  	controller.setSr(sr);
			    	   Stage st=new Stage();
			    	   Scene scene = new Scene(myPane);
			    	   st.setScene(scene);
			    	   stage.close();
				       
				       st.show();

	    }

}
