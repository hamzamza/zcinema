package compgc01;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import static compgc01.Main.getPath;

/**
 * The controller for the Login Scene.
 * 
 * @author Team 3: Filippos Zofakis and Lucio D'Alessandro
 * @since 12.12.2017
 */
public class MainController {

    @FXML
    TextField usernameBox;
    @FXML
    PasswordField passwordBox;
    @FXML
    Button logInButton, logOutButton;
    @FXML
    Text wrongCredentials;

    @FXML
    public void exitButton(MouseEvent event) {

        System.exit(0);
    }

    /**
	 * A method that handles the login procedure for all kinds of users
	 * @throws IOException, GeneralSecurityException
	 */
    @FXML
    public void loginClick(ActionEvent event) throws IOException, GeneralSecurityException {


        Main.readJSONFile("filmsJSON.txt");




                if (usernameBox.getText().equals("admin") && (passwordBox.getText().equals("admin")))
                    SceneCreator.launchScene("/scenes/Booking.fxml");


                // loading user scene
                else if(usernameBox.getText().equals("user") && (passwordBox.getText().equals("user")))
                {SceneCreator.launchScene("/scenes/viewFilmsScene.fxml");
                Main.setCurrentUser(new User("user","user" ,"user","user","email.com"));}
            else
                wrongCredentials.setVisible(true);
        }
    }
