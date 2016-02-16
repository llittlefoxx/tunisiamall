package GUI.ShopRequestInterfaces;


import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import Delegates.ManageShopRequestDelegate;

import edu.tunisiamall.entities.ShopRequest;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


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
	private TableView<ShopRequest> tab4;
    @FXML
    private DatePicker datepickerid;
    @FXML
    private TextField checkedsrid;
    @FXML
    private TextField uncheckedsrid;
    @FXML
    private TextField totalshoprid;
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
    
    
    public int verifSelectedItem()
    {
    	if(isclickyes.isSelected())
    	{
    		
    		return 1;
    	}
    	else if(isclickno.isSelected())
    	{
    	
    		return 0;
    	}
    	else return 2;
    }
    @FXML
    void seachtoolsAction(ActionEvent event) {
    	tabpansearch.setVisible(true);
    	
    	System.out.println("kkkeenne " + emailField1.getText());
    	int var=verifSelectedItem();
    	List<ShopRequest> l= ManageShopRequestDelegate.doFindAllShopRequestSearchTools(emailField1.getText(), var); 
    			System.out.println("kkkeenne " + emailField1.getText()+ "varrr "+ var);
    			for(ShopRequest sr:l)
    			{
    				System.out.println(sr.toString());
    			
    			}
    			
    			final ObservableList<ShopRequest> data1=
    			        FXCollections.observableArrayList(l);
    		
    			tab3.setItems(data1);
    			
    }
	
    public void pieChart(){
    	
    }
    
    @FXML
    private PieChart piechartid;
    @FXML
    private TitledPane pietitledpanid;
    @FXML
    void datepickerAction(ActionEvent event) {
    	LocalDate localDate = datepickerid.getValue();
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		System.out.println(localDate + "\n" + instant + "\n" + date);
		List<ShopRequest> datelist=ManageShopRequestDelegate.findAllShopRequestByRcptDate(date);
		
		for(ShopRequest s1:datelist)
		{
			System.out.println("testt111 "+ s1.toString());
		}
		final ObservableList<ShopRequest> data3=
		        FXCollections.observableArrayList(datelist);

			tab4.setItems(data3);
			setTab4(tab4);
			
			totalshoprid.setText(String.valueOf(datelist.size()));
			int check=0;
			int uncheck=0;
			for(ShopRequest s1:datelist)
			{
				System.out.println("testt111 "+ s1.toString());
				if(s1.getStatus()==true)
					check++;
				else uncheck++;
				
			}
			uncheckedsrid.setText(String.valueOf(uncheck));
			checkedsrid.setText(String.valueOf(check));
			 ObservableList<PieChart.Data> x = FXCollections.observableArrayList(	
		                new PieChart.Data("Unchecked Shop Request", uncheck),
			 			new PieChart.Data("Approved Shop Request", check));
		      
		        piechartid.setTitle("Shop Request treatment");
		        piechartid.setData(x);
			
		
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Calendar c = Calendar.getInstance();
		Date date =  c.getTime();	
		List<ShopRequest> datelist2=ManageShopRequestDelegate.findAllShopRequestByRcptDate(date);
		
		int checki=0;
		int unchecki=0;
		for(ShopRequest s1:datelist2)
		{
			System.out.println("testt111 "+ s1.toString());
			if(s1.getStatus()==true)
				checki++;
			else unchecki++;
			
		}
		totalshoprid.setText(String.valueOf(datelist2.size()));
		uncheckedsrid.setText(String.valueOf(unchecki));
		checkedsrid.setText(String.valueOf(checki));
		
		 ObservableList<PieChart.Data> x = FXCollections.observableArrayList(	
	                new PieChart.Data("Unchecked Shop Request", unchecki),
		 			new PieChart.Data("Approved Shop Request", checki));
	      
	        piechartid.setTitle("Shop Request treatment");
	        piechartid.setData(x);
	        piechartid.setLegendSide(Side.BOTTOM);
	        piechartid.setClockwise(false);
		
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
	

	 public TableView<ShopRequest> getTab4() {
		return tab4;
	}
	public void setTab4(TableView<ShopRequest> tab4) {
		this.tab4 = tab4;
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
		 tab4.setOnMouseClicked(new EventHandler<MouseEvent>() {
		        @Override
		        public void handle(MouseEvent event) {
		        	System.out.println("888888");
			    	ShopRequest sr = getTab4().getSelectionModel().getSelectedItem();
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
