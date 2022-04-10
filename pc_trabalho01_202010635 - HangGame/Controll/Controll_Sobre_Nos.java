package Controll;

//importacoes java
import java.io.IOException;

//importaoes do javafc
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

//inicio da classe
public class Controll_Sobre_Nos {

    private Scene scene;
    private Stage palco;
    private Parent root;

    @FXML
    private Button Voltar_Button;

    /* ************************************************************
    * Metodo: voltar 
    * Funcao: usa de um evento (ActionEvent) para retornar a um local designado
    * Parametros: um ActionEvent chamado e
    * Retorno: vazio.
    *************************************************************** */
    public void voltar(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Inicial_Page.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }// fim do metodo

}// fim da classe
