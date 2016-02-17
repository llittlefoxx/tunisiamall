package Gategories;

import javafx.fxml.FXML;
import edu.tunisiamall.entities.Subcategory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    	System.out.println("aa");
    }
     
}
