package GuestBookEntries;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Delegates.CategoriesDelegate;
import Delegates.GuestBookEntryDelegate;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Guestbookentry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageGuestBookEntryController {
	

    @FXML
    private TableColumn<Guestbookentry, String> Comment;

   /* @FXML
    private TableColumn<Gestbookentry, Use> UserName;
*/
    @FXML
    private TableColumn<Guestbookentry, Integer> Rate;

    @FXML
    private Button buttonDelete;

    @FXML
    private TableView<Guestbookentry> TableGuestbook;

    @FXML
    private TableColumn<Guestbookentry, Integer> IdEntry;

    @FXML
    private TableColumn<Guestbookentry, Date> Date;

    
   

    @FXML
    void DeleteEntries(ActionEvent event) {
    	Guestbookentry g = TableGuestbook.getSelectionModel().getSelectedItem();
    	GuestBookEntryDelegate.deleteEntry(g);
    	TableGuestbook.getItems().remove(g);

    }
    
	@FXML    
    void initialize(){
    	List<Guestbookentry> entriesList = GuestBookEntryDelegate.ListOfEntries();
    	IdEntry.setCellValueFactory(new PropertyValueFactory("IdEntries"));
    	Comment.setCellValueFactory(new PropertyValueFactory("text"));
    	Rate.setCellValueFactory(new PropertyValueFactory("rating"));
    	Date.setCellValueFactory(new PropertyValueFactory("dateEntrie"));
    	//TableGuestbook.getItems().clear();
		System.out.println(entriesList.size());
		ObservableList<Guestbookentry> lesDonnees = FXCollections.observableArrayList(entriesList);
		TableGuestbook.setItems(lesDonnees);
    }
}
