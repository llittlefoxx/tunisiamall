package GUI.ShopRequestInterfaces;


import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

import Delegates.ManageShopRequestDelegate;

import edu.tunisiamall.entities.ShopRequest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;

import javafx.scene.control.RadioButton;

import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;


public class ViewShopRequestAdminController implements Initializable{

	//// declaration variable
	@FXML
	private ShopRequest sr=new ShopRequest();
	

	@FXML
    private Button verifyButon;

    @FXML
    private Button searchbutton;
    @FXML
    private TextField searchfield;	
    

    @FXML
    private Accordion searchPane;
    
    @FXML
	private TableView<ShopRequest> tableView;
    @FXML
	private TableView<ShopRequest> tableView2;
	@FXML
	private TableView<ShopRequest> tab3;
	
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField emailField;
	
	@FXML
	private TableColumn<ShopRequest, String> firstNamecol;
	@FXML
	private TableColumn<ShopRequest, String> lastNamecol;
	@FXML
	private TableColumn<ShopRequest, String> emailcol;
	@FXML
	private TableColumn<ShopRequest, String> statuscol;
	@FXML
	private TableColumn<ShopRequest, String> receptionDateColumn;
	
    @FXML
    private Button search2button;
    @FXML
    private RadioButton isclickyes;
    @FXML
    private RadioButton isclickno;
    @FXML
    private TextField emailField1;
    @FXML
    private Button st;
    @FXML
    private TabPane tabpansearch;

    @FXML
    private TabPane shoptab;
    
    /////// getters setters
	
    public ShopRequest getSr() {
		return sr;
	}
	public void setSr(ShopRequest sr) {
		this.sr = sr;
	}
	
	

	Stage prevStage;
	 public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }

    
    
	public TableView<ShopRequest> getTableView() {
		return tableView;
	}
	public void setTableView(TableView<ShopRequest> tableView) {
		this.tableView = tableView;
	}
	
	
	public TableView<ShopRequest> getTab3() {
		return tab3;
	}
	public void setTab3(TableView<ShopRequest> tab3) {
		this.tab3 = tab3;
	}
	public TableView<ShopRequest> getTableView2() {
		return tableView2;
	}
	public void setTableView2(TableView<ShopRequest> tableView2) {
		this.tableView2 = tableView2;
	}

///// methods
    
    @FXML
    void stdisplay(ActionEvent event) {
    	searchPane.setVisible(true);
    	/* st.setOnMousePressed(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        
			    	searchPane.setVisible(true);
		        }
		    });*/

    }
   
    @FXML
    void isyesAction(ActionEvent event) {
		
    }
    
    @FXML
    void innoAction(ActionEvent event) {
    	isclickyes.isDisable();
    }
    
    
    public boolean verifSelectedItem()
    {
    	if(isclickyes.isSelected())
    	{
    		
    		return true;
    	}
    	else 
    	{
    	
    		return false;
    	}
    		
    }
    @FXML
    void seachtoolsAction(ActionEvent event) {
    	tabpansearch.setVisible(true);
    	boolean var=verifSelectedItem();
    	List<ShopRequest> l= ManageShopRequestDelegate.doFindAllShopRequestSearchTools(emailField1.getText(), var); 
    			System.out.println("kkkeenne");
    			for(ShopRequest sr:l)
    			{
    				System.out.println(sr.toString());
    			
    			}
    			
    			final ObservableList<ShopRequest> data1=
    			        FXCollections.observableArrayList(l);
    		
    			tab3.setItems(data1);
    			
    }
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tabpansearch.setVisible(false);
		searchPane.setVisible(false);
		System.out.println("kkkkk");
		List<ShopRequest> lists = ManageShopRequestDelegate.doFindAllShopRequest();
		final ObservableList<ShopRequest> data=
		        FXCollections.observableArrayList(lists);

			tableView.setItems(data);
			
			List<ShopRequest> lists1 = ManageShopRequestDelegate.doFindAllShopRequestUnchecked();
			
			final ObservableList<ShopRequest> data1=
			        FXCollections.observableArrayList(lists1);
		
			tableView2.setItems(data1);
			
	
	
	}
	
	
	 @FXML
	    void searchFunction(ActionEvent event) {
	    	tabpansearch.setVisible(true);
	    	System.out.println("test "+searchfield.getText());
	    	List<ShopRequest> l =ManageShopRequestDelegate.doFindAllShopRequestByWord(searchfield.getText());
	    	for(ShopRequest sr:l)
			{
	    	
				System.out.println(sr.toString());
			}
	    	
			
			final ObservableList<ShopRequest> data1=
			        FXCollections.observableArrayList(l);
		
			tab3.setItems(data1);
			
	}
	

	 @FXML
	    void tbFunction() {
		 tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	System.out.println("888888");
			    	ShopRequest sr = getTableView().getSelectionModel().getSelectedItem();
			    	System.out.println("fffff" + sr.toString());
		            System.out.println("mouse click detected! "+event.getSource());
		            setSr(sr);
		        }
		    });
		 tableView2.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	System.out.println("888888");
			    	ShopRequest sr = getTableView().getSelectionModel().getSelectedItem();
			    	System.out.println("fffff" + sr.toString());
		            System.out.println("mouse click detected! "+event.getSource());
		            setSr(sr);
		        }
		    });
		 tab3.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	System.out.println("888888");
			    	ShopRequest sr = getTableView().getSelectionModel().getSelectedItem();
			    	System.out.println("fffff" + sr.toString());
		            System.out.println("mouse click detected! "+event.getSource());
		            setSr(sr);
		        }
		    });
	    }
	 @FXML
	    void ficheFunction(ActionEvent event) {
		 System.out.println("9999999  "+getSr().toString() );
	
		 Stage stage = (Stage) verifyButon.getScene().getWindow();
		 setPrevStage(stage);
		 Stage st=new Stage();
		       stage.setTitle("ficheRequest");
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
		    	  
		    
				//myPane = FXMLLoader.load(getClass().getResource("/GUI/ShopRequestInterfaces/ficheRequest.fxml"));
				 System.out.println("000000");
			
			
		       Scene scene = new Scene(myPane);
		       st.setScene(scene);
		   	ficheRequestController controller = fxmlLoader.getController();
		
		  	controller.setSr(getSr());
		
			System.out.println("11111111");
		       stage.close();
		       
		       st.show();
		    }
	 
	 
			
				


	    
	    
	    	

	    
}
