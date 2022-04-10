//pacote
package Controll;

//Importacoes java
import java.io.IOException;

//importacoes javaFX
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

//inicio da calsse
public class Controll_InicialPage {

    private Scene scene;//
    private Stage palco;// cria a janela no desktop
    private Parent root;// indica qual arquivo fxml

    @FXML
    private Button Iniciar_jogo_Button;

    @FXML
    private Button como_Jogar_Button;

    @FXML
    private Button sobreNos_Button;

    /* ************************************************************
    * Metodo: irPara_Iniciar_Jogo
    * Funcao: usa de um evento (ActionEvent) para trocar a pagina
    * (indo para /view/MainGame.fxml) do programa
    * Parametros: um ActionEvent chamado e
    * Retorno: vazio.
    *************************************************************** */

    public void irPara_Iniciar_Jogo(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Main_Game.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }// fim do metodo

    /* ************************************************************
    * Metodo: ir_Sobre_Nos
    * Funcao: usa de um evento (ActionEvent) para trocar a pagina 
    * (indo para /view/Sobre_Nos.fxml) do programa
    * Parametros: um ActionEvent chamado e
    * Retorno: vazio.
    *************************************************************** */

    public void ir_Sobre_Nos(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Sobre_Nos.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }// fim do metodo

    /* ************************************************************
    * Metodo: Para_Como_Jogar
    * Funcao: usa de um evento (ActionEvent) para trocar a pagina 
    * (indo para /view/Como_jogar.fxml) do programa
    * Parametros: um ActionEvent chamado e
    * Retorno: vazio.
    *************************************************************** */

    public void Para_Como_Jogar(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Como_Jogar.fxml"));
        palco = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }// fim do metodo

}// fim da classe
