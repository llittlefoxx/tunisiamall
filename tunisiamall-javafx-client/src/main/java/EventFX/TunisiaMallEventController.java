package EventFX;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import Delegates.EventDelegate;
import edu.tunisiamall.entities.Event;
import edu.tunisiamall.eventServices.GestionEventRemote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.lang.Integer;


public class TunisiaMallEventController {
	  @FXML
	    private DatePicker date;

	    @FXML
	    private ImageView searchButton;
	    
	    @FXML
	    private TableView<Event> tableEvent;
	    
	    @FXML
	    private TableColumn<Event, Date> tbldate;
	    
	    @FXML
	    private TableColumn<Event, String> tabldesc;
	    
	    @FXML
	    private TableColumn<Event, String> tbltype;
	    
	    @FXML
	    private TableColumn<Event, String> tabtitle;
	    
	    @FXML
	    private TableColumn<Event, Integer> tablperiod;

	    @FXML
	    private TextField period;

	    @FXML
	    private TextArea description;

	    @FXML
	    private TextField title1;

	    @FXML
	    private Button searchh;
	    
	    
	    @FXML
	    private TextField type;

	    @FXML
	    private TextField title;

	    @FXML
	    private DatePicker date1;

	    @FXML
	    private TextArea description1;

	    @FXML
	    private TextField search;

	    @FXML
	    private Button editButton;

	    @FXML
	    private Button createButton;

	    @FXML
	    private TextField period1;

	   

	 

	    
	    @FXML
	    void searchEvent(ActionEvent event) {
	    	System.out.println("jfjfjfj");
	        	String query = search.getText();
	        	List<Event> resultat = EventDelegate.SearchEvent(query);
	        
	        	tableEvent.getItems().clear();
	        	tableEvent.setItems(FXCollections.observableArrayList(resultat));
	        }

	    
	    @FXML
	    void type1(ActionEvent event) {

	    }
	    @FXML
	    void editEvent(ActionEvent event) {

	    }
	    @FXML
	    void deletEvent(ActionEvent event) {
	    	System.out.println("jfjfjfj");
	    		Event e = tableEvent.getSelectionModel().getSelectedItem();
	    		System.out.println(e.getDescription());
	    		EventDelegate.deleteEvent(e);
	    		tableEvent.getItems().remove(e);
	    		
	    	}

	    
	    
	 @FXML
	    void addEvent(MouseEvent event) throws NamingException {
		
			Event e =new Event();
			Instant instant = date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			Date res = Date.from(instant);
			e.setDateEvent(res);
			e.setDescription(description.getText());
			e.setTitleEvent(title.getText());
			e.setTypeEvent(type.getText());
			e.setPeriodEvent(Integer.parseInt(period.getText()));
			EventDelegate.addEvent(e);
			System.out.println(e.getIdEvent());
			description.clear();
			title.clear();
			type.clear();
			period.clear();
			
			tableEvent.getItems().add(e);
			
	

	    }
	 @FXML
	 void initialize(){
		 tabldesc.setCellValueFactory(new PropertyValueFactory("description"));
		 tabldesc.setCellFactory(TextFieldTableCell.forTableColumn());
		 tabldesc.setOnEditCommit(new EventHandler<CellEditEvent<Event, String>>() {

				@Override
				public void handle(CellEditEvent<Event, String> event1) {
					Event e = event1.getTableView().getItems().get(event1.getTablePosition().getRow());
					e.setDescription(event1.getNewValue());
					EventDelegate.updateEvent(e);
				}
			}); 
		 tablperiod.setCellValueFactory(new PropertyValueFactory("periodEvent"));
		 tablperiod.setCellFactory(TextFieldTableCell.<Event,Integer>forTableColumn(new IntegerStringConverter()));
		 tablperiod.setOnEditCommit(new EventHandler<CellEditEvent<Event, Integer>>() {

				@Override
				public void handle(CellEditEvent<Event, Integer> event1) {
					Event e = event1.getTableView().getItems().get(event1.getTablePosition().getRow());
					e.setPeriodEvent(event1.getNewValue());
					EventDelegate.updateEvent(e);
				}
			}); 
		 tabtitle.setCellValueFactory(new PropertyValueFactory("titleEvent"));
		 tabtitle.setCellFactory(TextFieldTableCell.forTableColumn());
		 tabtitle.setOnEditCommit(new EventHandler<CellEditEvent<Event, String>>() {

				@Override
				public void handle(CellEditEvent<Event, String> event1) {
					Event e = event1.getTableView().getItems().get(event1.getTablePosition().getRow());
					e.setTitleEvent(event1.getNewValue());
					EventDelegate.updateEvent(e);
				}
			}); 
		 tbldate.setCellValueFactory(new PropertyValueFactory("dateEvent"));
		 tbldate.setCellFactory(TextFieldTableCell.<Event,Date>forTableColumn(new DateStringConverter()));
		 tbldate.setOnEditCommit(new EventHandler<CellEditEvent<Event, Date>>() {

				@Override
				public void handle(CellEditEvent<Event, Date> event1) {
					Event e = event1.getTableView().getItems().get(event1.getTablePosition().getRow());
					e.setDateEvent(event1.getNewValue());
					EventDelegate.updateEvent(e);
				}
			}); 
		 tbltype.setCellValueFactory(new PropertyValueFactory("typeEvent"));
		 tbltype.setCellFactory(TextFieldTableCell.forTableColumn());
		 tbltype.setOnEditCommit(new EventHandler<CellEditEvent<Event, String>>() {

				@Override
				public void handle(CellEditEvent<Event, String> event1) {
					Event e = event1.getTableView().getItems().get(event1.getTablePosition().getRow());
					e.setTitleEvent(event1.getNewValue());
					EventDelegate.updateEvent(e);
				}
			}); 
		 tableEvent.setEditable(true);
		 
		 
		 
		 List<Event> findAllEvents = EventDelegate.findAllEvents();
	    	ObservableList<Event> lesDonnees = FXCollections.observableArrayList(findAllEvents);
	    	tableEvent.setItems(lesDonnees);
		 
		 
		 
	 }
	 
	 
	 

}
