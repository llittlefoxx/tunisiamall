package fxSoufieneInterfaces;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class authentificatController {
	@FXML
	TextField hi;
	@FXML
	Button b1;
	@FXML
	public void hello (ActionEvent acEvent){
		hi.setText("3aslema");
	}

}
