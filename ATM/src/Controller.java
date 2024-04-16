import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textView;
    @FXML
    private TextField balanta;
    @FXML
    private TextField textViewPanel;
    @FXML
    private TextArea mesajPanel;

    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    double c = 0;




    @FXML
    void delete(ActionEvent event) {
        String del = ((Button)event.getSource()).getText();
        textView.setText("");
    }

    @FXML
    void digitsHand(ActionEvent event) {
        String digitObj = ((Button)event.getSource()).getText();
        String oldText = textView.getText();
        String newText = oldText + digitObj;
        textView.setText(newText);
    }

    //change the scen if the pin is good (pre def pin)
    public void switchToPanel(ActionEvent event) throws IOException {

        try {
            int pin = Integer.parseInt(textView.getText());

            if (pin == 1234) {
                root = FXMLLoader.load(getClass().getResource("panel.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else textView.setText("Incorrect pin.");

        }catch(Exception n){
            textView.setText("Use the numbers");
        }
    }

    //sent you back to the first scene (pin)
    public void switchToPin(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("pin.fxml"));
           scene = new Scene(root);
           String css = this.getClass().getResource("app.css").toExternalForm();
           scene.getStylesheets().add(css);
           stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
           stage.setScene(scene);
           stage.show();
    }

    @FXML
    void depunereBani(ActionEvent event) {
        try {
            double bal = Double.parseDouble(balanta.getText());
            double dep = Double.parseDouble(textViewPanel.getText());
            if (dep > 0) {
                c = bal + dep;
                String result = decimalFormat.format(c);
                balanta.setText(result);
                String cont = "You have deposit the amount of " + dep + " lei!";
                mesajPanel.setText(cont);
            } else mesajPanel.setText("Incorrect amount.");

        }catch(Exception n){
            mesajPanel.setText("Incorrect input uses numbers!");
        }
    }

    @FXML
    void retragreBani(ActionEvent event) {
        try {
            double bal = Double.parseDouble(balanta.getText());
            double ret = Double.parseDouble(textViewPanel.getText());
            if (ret <= bal) {
                c = bal - ret;
                String result = decimalFormat.format(c);
                balanta.setText(result);
                String cont = "You have withdrawn the amount of " + ret + " lei!";
                mesajPanel.setText(cont);
            } else mesajPanel.setText("Insufficient funds!");

        }catch(Exception n){
            mesajPanel.setText("Incorrect input uses numbers!");
        }
    }

    @FXML
    void fastCash(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("accInfo.fxml"));
            scene = new Scene(root);
            String css = this.getClass().getResource("app.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void ajutor(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("ajutor.fxml"));
            scene = new Scene(root);
            String css = this.getClass().getResource("app.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void inapoiPanel(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("panel.fxml"));
            scene = new Scene(root);
            String css = this.getClass().getResource("app.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



