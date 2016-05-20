package Gategories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.util.List;

import Delegates.SubCategoriesDelegate;
import edu.tunisiamall.entities.Subcategory;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Guestbookentry;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageSubCategoriesController {

    @FXML
    private TableColumn<Subcategory, String> libelle;

    @FXML
    private TableColumn<Subcategory, String> description;

    @FXML
    private TableView<Subcategory> TableSubCategories;

    @FXML
    private TableColumn<Subcategory, Integer> idSubCategory;
    
    @FXML
    void  initialize(){
    	List<Subcategory> SubCategoriesList = SubCategoriesDelegate.findAll();
        
    	libelle.setCellValueFactory(new PropertyValueFactory("libelle"));
        description.setCellValueFactory(new PropertyValueFactory ("description"));
        idSubCategory.setCellValueFactory(new PropertyValueFactory ("idSubCategory"));
        System.out.println(SubCategoriesList.size());
        ObservableList<Subcategory> lesDonnees = FXCollections.observableArrayList(SubCategoriesList);
		TableSubCategories.setItems(lesDonnees);
		}
     
}
