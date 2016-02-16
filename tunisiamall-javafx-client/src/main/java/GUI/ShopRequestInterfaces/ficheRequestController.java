package GUI.ShopRequestInterfaces;



import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import Delegates.ManageShopRequestDelegate;
import edu.tunisiamall.entities.ShopRequest;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.util.Duration;
import GUI.ShopRequestInterfaces.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
public class ficheRequestController implements Initializable{


private ShopRequest sr;

@FXML
private TextField jobfield;

@FXML
private TextField emailfield;

@FXML
private TextField phonefield;

@FXML
private TextField plfield;


@FXML
private TextField fnfield;

@FXML
private TextField addfield;

@FXML
private TextField shimfield;

@FXML
private TextField birthfield;

@FXML
private TextField catfield;

@FXML
private TextField rentpfield;

@FXML
private TextField statusfield;

@FXML
private TextField lnfield;

@FXML
private TextArea desfield;
  
@FXML
private Button verifButton;

@FXML
private Button deletebutton;
@FXML
private Button cancelbutton;

@FXML
void verifAction(ActionEvent event) {
	Stage stage = (Stage) verifButton.getScene().getWindow();
	 TitledPane myPane = null;
	    	   FXMLLoader fxmlLoader= new FXMLLoader();
	    	   fxmlLoader.setLocation(getClass().getResource("/GUI/ShopRequestInterfaces/ApproveRequest.fxml"));     
	    	  
	    	   try {
				fxmlLoader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    	   Parent p =fxmlLoader.getRoot();
	    	   myPane = (TitledPane) p; 
	    	   ApproveRequestController controller = fxmlLoader.getController();
	   		
			  	controller.setSr(sr);
	    	   Stage st=new Stage();
	    	   Scene scene = new Scene(myPane);
	    	   st.setScene(scene);
	    	   stage.close();
		       
		       st.show();
		       System.out.println("hiii");
}

public void setSr(ShopRequest sr) {
	this.sr = sr;
	System.out.println("2222 "+ sr.toString());
	 fnfield.setText(sr.getFirstName());
	lnfield.setText(sr.getLastName());
	if(sr.getStatus()==true)
	{statusfield.setText("Checked");}
	else 
		statusfield.setText("Unchecked");
	desfield.setText(sr.getDescription());
	phonefield.setText(sr.getPhone());
	emailfield.setText(sr.getEmail());
	jobfield.setText(sr.getJob());
	catfield.setText(sr.getCategory().getLibelle());
	rentpfield.setText(sr.getRentPeriod().toString());
	if(sr.isStoreInMall()==true)
	{shimfield.setText("Exist");}
	else 
		shimfield.setText("Dos not Exist");
	
	plfield.setText(sr.getPlannedOpeningDate().toString());
	rentpfield.setText(sr.getRentPeriod().toString());
	plfield.setText(sr.getPlannedOpeningDate().toString());
	birthfield.setText(sr.getBirthdate().toString());
	addfield.setText(sr.getAddress());
	
}
@FXML
void cancelAction(ActionEvent event) {
	 Stage stage = (Stage) verifButton.getScene().getWindow();
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
void deleteAction(ActionEvent event) {
	Alert alert = new Alert(AlertType.CONFIRMATION);
	alert.setTitle("Confirmation Dialog");
	alert.setHeaderText("Do you want delete this Shop Request?");
	//alert.setContentText("Are you ok with this?");

	Optional<ButtonType> result = alert.showAndWait();
	if (result.get() == ButtonType.OK){
	    // ... user chose OK
		ManageShopRequestDelegate.doDeleteShopRequest(sr);
	} else {
	    // ... user chose CANCEL or closed the dialog
		
	}

	

}

@Override
public void initialize(URL location, ResourceBundle resources) {


	
	
	// TODO Auto-generated method stub
	
}





	
		
		
	
		// TODO Auto-generated method stub
		
}


	
	

