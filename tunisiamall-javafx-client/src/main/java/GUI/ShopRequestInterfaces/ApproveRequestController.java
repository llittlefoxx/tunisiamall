package GUI.ShopRequestInterfaces;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.Stage;
public class ApproveRequestController implements Initializable{
	  
	
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
	
		}

	  
	  
	  
	  
	  
	  
	  

    @FXML
    void catAction(ActionEvent event) {
    	
    
	        
	        	 System.out.println("999991 ");
	  
          String s=selectCateg.getSelectionModel().getSelectedItem();
          System.out.println("99999 "+ s);
         Category cat= CategoryDelegate.doFindAllCategoryByLibelle(s);
         List<Store>l=StoreServicesDelegate.findAllSStoreByCategory(cat);
         System.out.println("99999222 "+ l.size());
         nbStore.setText(String.valueOf(l.size()));
	      
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
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
	    	alert.setTitle("Confirmation Dialog");
	    	alert.setHeaderText("Approve Shop Request");
	    	alert.setContentText("Are you ok with this?");

	    	Optional<ButtonType> result = alert.showAndWait();
	    	if (result.get() == ButtonType.OK){
	    	    // ... user chose OK

		    	Shopowner so1=new Shopowner();
		    
		    	so1.setFirstName(sr.getFirstName());
		    	so1.setAddress(sr.getAddress());
		    	so1.setLogin(sr.getFirstName());
		    	so1.setPassword(nextSessionId());
		    	UserDelagate.create(so1);
		    	System.out.println("55555 "+ nextSessionId());
		    
	             Stage stage = (Stage) cancelbutton.getScene().getWindow();
	             stage.close();

	    	} else {
	    	
	    		
	    	}
	    	
	    	
	    	
	    	
	    
	    
	    	
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


		  @FXML
		    private CategoryAxis x;
		  @FXML
		    private BarChart<String, Number> barchart;
		  
		 

	
	    void chart() {
	 
	    	CategoryAxis x =new CategoryAxis();
	    	NumberAxis y = new NumberAxis();
	    	x.setLabel("kenza");
	
	    	Map<String, Number> chartList = new HashMap<>();
	      barchart.setTitle("Stores By Category");

	      List<Category> l1=CategoryDelegate.doFindAllCategory();
	      
	      List<XYChart.Data<String, Integer>> liste = new ArrayList<>();
	      System.out.println("pppppp ");
	      for(Category c:l1)
	      { 
	    	  System.out.println("pppppp 1111");
	    	  List<Store> l2=StoreServicesDelegate.findAllSStoreByCategory(c);
	    	  System.out.println("pppppp 2222");
	    	 liste.add(new XYChart.Data<String, Integer>(c.getLibelle(),l2.size()));
	    	 System.out.println("pppppp 33333 ");
	    	 // chartList.put(c.getLibelle(), l2.size());
	      }
	     System.out.println("uuuu "+ liste.size());
	      
	      ObservableList<XYChart.Data> test = FXCollections.observableArrayList(  liste );
	 
	       XYChart.Series serie = new XYChart.Series("Number OF Store By Category",test);
	       barchart.getData().add(serie);
	        System.out.println("k<ldkl");
	    	
	    }
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			chart();
			
	    }
	

}
