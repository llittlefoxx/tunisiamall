package Gategories;

import java.io.IOException;

import Delegates.CategoriesDelegate;
import edu.tunisiamall.entities.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ManageCategoriesController {
	
	@FXML
    private TextField TextLibelle;

    @FXML
    private Button CancelButton;

    @FXML
    private TextArea TextDescription;

    @FXML
    private Button AddButton;
   
    @FXML
    private Button EditButton;
    

    @FXML
    private Button SubCategoriesListed;

    @FXML
    private Button DeleteButton;
    
    @FXML
    private TableView<Category> tableCat;
    
    @FXML
    private TableColumn<Category, String> Description;

    @FXML
    private TableColumn<Category, Integer> IdCategory;
    
    @FXML
    private TableColumn<Category, String> Libelle;

    @FXML
    void AddCategory(ActionEvent event) {
    	CategoriesDelegate categorydelegate = new CategoriesDelegate();
    	Category c = new Category();
    	categorydelegate.create(c);
    	System.out.println("creation succed");
    	

    }
    @FXML
    void OnListOfSubCategoriesViwed(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Window SubCategories");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ListSubCategories.fxml"))));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();

    }
    
    @FXML
    void DeleteCategory(ActionEvent event) {
    	CategoriesDelegate categorydelegate = new CategoriesDelegate();
    	Category c = new Category();
    	categorydelegate.delete(c.getIdCategory());
    	//System.out.println("creation succed");

    }

    @FXML
    void UpdateCategory(ActionEvent event) {
    	CategoriesDelegate categorydelegate = new CategoriesDelegate();
    	Category c = new Category();
    	categorydelegate.update(c);
    }


    @FXML
    void CancelAdd(ActionEvent event) {
      event.consume();
    }
    
    @FXML
    void initialize() {
    	IdCategory.setCellValueFactory(new PropertyValueFactory("idCategory"));
    	Libelle.setCellValueFactory(new PropertyValueFactory("libelle"));
    	Description.setCellValueFactory(new PropertyValueFactory("description"));
    	// get data
    	ObservableList<Category> lesDonnees = FXCollections.observableArrayList();
    	Category c1 = new Category();
    	c1.setIdCategory(1);
    	c1.setLibelle("libelle cat");
    	c1.setDescription("description cat");
    	lesDonnees.add(c1);
    	tableCat.setItems(lesDonnees);
    }

}
