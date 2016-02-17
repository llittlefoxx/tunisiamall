package Gategories;

import java.io.IOException;

import java.util.List;

import Delegates.CategoriesDelegate;
import application.MainControler;
import edu.tunisiamall.entities.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
	    private Button SearchButton;
	  
	  @FXML
	    private TextField textSearch;

	@FXML
	private TableView<Category> tableCat;

	@FXML
	private TableColumn<Category, String> Description;

	@FXML
	private TableColumn<Category, Integer> IdCategory;

	@FXML
	private TableColumn<Category, String> Libelle;

    @FXML
    private Label labelsize;
    
	@FXML
	void AddCategory(ActionEvent event) {
		Category c = new Category();
		c.setLibelle(TextLibelle.getText());
		c.setDescription(TextDescription.getText());
		CategoriesDelegate.create(c);
		//System.out.println(c.getIdCategory());
		TextLibelle.clear();
		TextDescription.clear();
		afficherTable();
	}

	@FXML
	void OnListOfSubCategoriesViwed(ActionEvent event) throws IOException {
		//Category c = tableCat.getSelectionModel().getSelectedItem();
		try {
			Stage window = new Stage();
			AnchorPane root = FXMLLoader.load(ManageSubCategoriesController.class.getResource("ListSubCategories.fxml"));
			Scene scene = new Scene(root);
			window.setScene(scene);
			window.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void DeleteCategory(ActionEvent event) {
		Category c = tableCat.getSelectionModel().getSelectedItem();
		CategoriesDelegate.delete(c);
		tableCat.getItems().remove(c);
		labelsize.setText(String.valueOf(Integer.parseInt(labelsize.getText())-1));
	
	}

	@FXML
	void CancelAdd(ActionEvent event) {
		TextLibelle.clear();
		TextDescription.clear();
	}

	@FXML
	void initialize() {
		IdCategory.setCellValueFactory(new PropertyValueFactory("idCategory"));
		Libelle.setCellValueFactory(new PropertyValueFactory("libelle"));
		Libelle.setCellFactory(TextFieldTableCell.forTableColumn());
		Libelle.setOnEditCommit(new EventHandler<CellEditEvent<Category, String>>() {

			@Override
			public void handle(CellEditEvent<Category, String> event) {
				Category c = event.getTableView().getItems().get(event.getTablePosition().getRow());
				c.setLibelle(event.getNewValue());
				CategoriesDelegate.update(c);
			}
		});
		Description.setCellValueFactory(new PropertyValueFactory("description"));
		Description.setCellFactory(TextFieldTableCell.forTableColumn());
		Description.setOnEditCommit(new EventHandler<CellEditEvent<Category, String>>() {

			@Override
			public void handle(CellEditEvent<Category, String> event) {
				Category c = (Category) event.getTableView().getItems().get(event.getTablePosition().getRow());
				c.setDescription(event.getNewValue());
				CategoriesDelegate.update(c);
			}
		});

		// CategoriesDelegate.update(c);
		tableCat.setEditable(true);
		// Description.edita
		// get data
		afficherTable();
	}

	public void afficherTable(){
		tableCat.getItems().clear();
		List<Category> categoriesList = CategoriesDelegate.findAll();
		ObservableList<Category> lesDonnees = FXCollections.observableArrayList(categoriesList);
		tableCat.setItems(lesDonnees);
		labelsize.setText(String.valueOf(lesDonnees.size()));
	}
	/*public void size(){
		List<Category> categoriesList = CategoriesDelegate.findAll();
		ObservableList<Category> lesDonnees = FXCollections.observableArrayList(categoriesList);
		tableCat.setItems(lesDonnees);
		System.out.println(lesDonnees.size());
	}*/

    @FXML
    void SearchCategory(ActionEvent event) {
    	String query = textSearch.getText();
    	List<Category> resultat = CategoriesDelegate.SearchCategory(query);
    	System.out.println("size: " + resultat.size());
    	tableCat.getItems().clear();
    	tableCat.setItems(FXCollections.observableArrayList(resultat));
    }
    

    @FXML
    void RefrechTab(ActionEvent event) {
    	afficherTable();

    }
   /* @FXML
    void size(ActionEvent event) {
    	size();
    }*/
    
}
