package Gategories;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CategoriesController {
    @FXML
    private Button buttonsearch;

    @FXML
    private TableColumn<CategoryModel, String> edit;

    @FXML
    private TableColumn<CategoryModel, String> name;

    @FXML
    private Button AddButton;

    @FXML
    private TextField textfieldsearch;

    @FXML
    private TextField textfieldAdd;

    @FXML
    private TableColumn<CategoryModel, String> delete;

    @FXML
    private TableView<CategoryModel> table;

}
