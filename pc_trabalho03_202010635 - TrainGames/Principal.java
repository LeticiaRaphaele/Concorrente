
/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Autor....: Leticia Raphaele Silva
Matrícula: 202010635
Inicio...: 26/03/2021
Alteracao: 27/03/2021
Nome.....: Principal.java
Funcao...: Esse programa simulara dois trems que devem compartilhar duas regioes aonde apenas um pode passar,
           //eles devem parar assim que um outro trem esteja na regiao sem que os dois bates e independentemente
           // da velocidade. Para isso usaremos xplicita alternancia.
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

import control.ControlePrincipal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{

    ControlePrincipal cp;
    public static void main(String[] args) throws Exception{
        launch( args);
    }

    /* ***************************************************************
    * Metodo: start
    * Funcao: inicia a janela do programa principal do javafx 
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/Principal_Trilho.fxml"));
        Scene scene = new Scene(root);
        
        stage.setTitle("Problema dos Trens");
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }
}
