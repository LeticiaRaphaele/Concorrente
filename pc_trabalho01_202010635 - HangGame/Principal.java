
/* ***************************************************************
* Autor............: Leticia Raphaele Silva
* Matricula........: 202010635
* Inicio...........: 09/01/2022
* Ultima alteracao.: 03/02/2022
* Nome.............: Jogo da Forca
* Funcao...........: Iniciamos o jogo em uma pagina que possui tres opcoes de botoes para escolher:
 O de iniciar o jogo, Como jogar e Sobre nos. Ao clicar no iniciar jogo e levado a uma pagina que 
 permite o usuario escolher quais categorias de palavras ele(a) quer adivinhar, ao clicar na categoria
 escolhida o usuario comeca o jogo com uma palavra aleatoria da qual ele tem 6 chances de adivinhar 
 para vencer o jogo. Se clicar em Como jogar somos levados para uma pagina que explica como funciona 
 o processo do jogo da velha e qual objetivo. E no sobre nos ocorre uma breve explicacoes sobre o motivo
 da criacao do aplicativo e informacoes sobre o programador do aplicativo.
 
*************************************************************** */
//import javafx
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//import dos arquivos da pasta Controle
import Controll.Controll_InicialPage;
import Controll.Controll_MainGame;
import Controll.Controll_Sobre_Nos;
import Controll.Controll_Como_Jogar;

/* ***************************************************************
* Metodo: Principal.
* Funcao: possui o metodo padrao que execulta o programa (main).
* Parametros: um vetor de String denominado como args.
* Retorno: vazio.
*************************************************************** */

public class Principal extends Application {//inicio da classe Principal
    public static void main(String[] args) throws Exception {
        launch(args);
    }// fim do metodo

    @Override

    /* ************************************************************
    * Metodo: start 
    * Funcao: usa da importacao Aplicattion para carregar o "palco".
    aonde podemos acessar a GUI que forma o programa.
    * Parametros: um objeto (palco) do tipo Stage.
    * Retorno: vazio.
    *************************************************************** */
    public void start(Stage palco) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("/view/Inicial_Page.fxml"));
        Scene scene = new Scene(raiz);
        palco.setTitle("Jogo da Forca");
        palco.setResizable(false);
        palco.sizeToScene();
        palco.setScene(scene);
        palco.show();
    }// fim do metodo

}// fim da classe Principal