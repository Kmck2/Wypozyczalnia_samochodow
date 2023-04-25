package org.example.Controllers.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.Controllers.AbstractController;
import org.example.Controllers.Register.RegisterController;

public class LoginController extends AbstractController {
    @FXML
    private Button loginButton;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button registerButton;

    @FXML
    private Label warningLabel;

    @FXML
    void onButtonLogin(ActionEvent event)
    {

    }

    @FXML
    void onButtonRegister(ActionEvent event)
    {
       AbstractController controller = new RegisterController();
       controller.show(event,"/fxml/RegisterView.fxml");

    }

}
