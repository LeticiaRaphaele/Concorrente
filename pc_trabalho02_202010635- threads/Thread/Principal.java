/*+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Autor....: Leticia Raphaele Silva
Matrícula: 202010635
Inicio...: 08/03/2021
Alteracao: 12/03/2021
Nome.....: Principal.java
Funcao...: Inicia o nosso programa em que 7 threads operaram juntas( por ser concorrente nao eh simultanea), mostrando o processo
           de envelhecimento da familia e o decorrer das idades, do seu nascimento a sua morte;
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/



//importacoes do javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

//importando threads e controles
import controll.arvoreMain_Controll;



public class Principal extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/arvoreMain.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Arvore Geneologica");
        stage.getIcons().add(new Image("/images/icon.jpg"));
        stage.setResizable(false);
        stage.setToScene();
        stage.setScene(scene);
        stage.show();

    }
}

