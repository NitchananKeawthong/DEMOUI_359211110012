package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    private loginModel loginModel=new loginModel();
    @FXML
    private Label dbStatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button btnLOgin;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (this.loginModel.isDatabaseConnection()){
            this.dbStatus.setText("Connected to DB");
        }else {
            this.dbStatus.setText("Not Connected to DB");
        }
    }//initialize
}
@FXML
public void Login(ActionEvent event){
    try {

        if (this.loginModel.isLogin(this.username.getText(),
                this.password.getText())){
            Stage stage=this.btnLogin.getScene().getWindow();
            stage.close();

            adminLogin();
        }else {
            JOptionPane.showMessageDialog(null,"Your username or"+
                    "password is not corrected.");
        }
    }catch (Exception localException){
        localException.printStackTrace();
    }
}//login


private void adminLogin(){
    try {
        Stage adminStage = new Stage();
        FXMLLoader adminLoader=new FXMLLoader();
        Pane adminRoot=adminLoader.load(getClass().getResource
                ("/Admin/AdminDashBoard.fxml").openStream());
    }catch (IOException ex){
        ex.printStackTrace();
    }
}
