package Controll;

//importacoes usadas em metodos
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//importacoes sobre FXML
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Controll_MainGame {

    //objetos usados na gui javafx
    @FXML
    private TextField Tam_TextField;

    @FXML
    private Button Animais_Button;

    @FXML
    private Button Cidade_Button;

    @FXML
    private Button ComeBack_Button;

    @FXML
    private Button Comida_Button;

    @FXML
    private Button Confirmar_Button;

    @FXML
    private TextField Tentativas_TextField;

    @FXML
    private TextField TryOut_TextField1;

    @FXML
    private Button Voltar_Button;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private ImageView corpo_Img;

    @FXML
    private ImageView perna_direita_img;

    @FXML
    private ImageView perna_esquerda_img;

    @FXML
    private ImageView braco_direito_Img;

    @FXML
    private ImageView braco_esquerdo_img;

    @FXML
    private ImageView cabeca_img;

    @FXML
    private Button Voltar_InicialPage;

    @FXML
    private AnchorPane anchorPane3;

    @FXML
    private Button TentarNovaemnte_Button;

    @FXML
    private TextField YouWin_TextField;

    @FXML
    private TextField GameOver_TextField;

    @FXML
    private TextField Palavra_TextField;

    @FXML
    private ArrayList<TextField> Char_TextField;

    private Scene scene;// usado na hora de trocar de tela
    private Stage palco;// usado na hora de trocar de tela
    private Parent root;// usado na hora de trocar de tela

    private int tentativas = 6;// usado para limitar a quantidade de vezes que o usuario erra palavras
    private String word;// palavra escolhida no random
    private int acertos = 0;

    private String[] cidades = new String[] { "praga", "montreal", "copenhague", "manchester", "madri", "lisboa",
            "itapetinga", "boston", "pequim", "budapeste", "roma", "istambul", "moscou", "recife", "natal" };
    // string de nomes de cidades

    private String[] animais = new String[] { "andorinha", "foca", "golfinho", "jaguar", "ovelha", "passaro",
            "vaca", "zebra", "cachorro", "hiena", "guaxinim", "lagarto", "sardinha", "urubu", "gato" };
    // string de nomes de animais

    private String[] comida = new String[] { "azeitona", "churrasco", "arroz", "mochi", "pamonha", "rapadura",
            "feijoada", "torta", "pitanga", "moqueca", "pudim", "tacos", "caldinho", "batata", "caipirinha" };
    // string de nomes de comida

    // inicializando o randorizador
    Random rand = new Random();

    /* ************************************************************
     * Metodo: animais_MainGame
     * Funcao: torna visivel o anchorpane2, torna todas as imagens usadas
     * para o boneco com a visibilidade(false), sortei a palavra pertencente
     * ao array cidades, incia os valores de tentativas e acertos, chama metodos 
     * para que se for chamada novamente, nao possua valores presentes ainda nele
     * Parametros: objeto do tipo ActionEvent  chamado event.
     * Retorno: void
     ************************************************************ */

    @FXML
    public void animais_MainGame(ActionEvent event) {
        // trocar de tela
        anchorPane2.setVisible(true);
        anchorPane1.setVisible(false);
        anchorPane3.setVisible(false);

        // manter o boneco invisivel
        cabeca_img.setVisible(false);
        braco_direito_Img.setVisible(false);
        braco_esquerdo_img.setVisible(false);
        corpo_Img.setVisible(false);
        perna_direita_img.setVisible(false);
        perna_esquerda_img.setVisible(false);

        // escolher a palavra
        word = animais[rand.nextInt(animais.length)];
        getWord();

        // dar valor aos textfields que nao precisam de imput do user e inciar acerto com 0
        tentativas = 6;
        acertos = 0;
        // caso a pessoa queria jogar de novo o numero de tentativas volta ao valor
        // inicial
        Tentativas_no_TextField();
        tamanho_Word();

        // esconder blocos nao usados
        esconder_quadrados();

        // limpar os elemntos dos blocos
        limpar_quadrados();
    }// fim do metodo


    /* ************************************************************
     * Metodo: cidades_MainGame
     * Funcao: torna visivel o anchorpane2, torna todas as imagens usadas
     * para o boneco com a visibilidade(false), sortei a palavra pertencente
     * ao array cidades, incia os valores de tentativas e acertos, chama metodos 
     * para que se for chamada novamente, nao possua valores presentes ainda nele
     * Parametros: objeto do tipo ActionEvent  chamado event.
     * Retorno: void
     ************************************************************ */

    @FXML
    public void cidades_MainGame(ActionEvent event) {
        // trocar de tela
        anchorPane2.setVisible(true);
        anchorPane1.setVisible(false);
        anchorPane3.setVisible(false);

        // manter o boneco invisivel
        cabeca_img.setVisible(false);
        braco_direito_Img.setVisible(false);
        braco_esquerdo_img.setVisible(false);
        corpo_Img.setVisible(false);
        perna_direita_img.setVisible(false);
        perna_esquerda_img.setVisible(false);

        // escolher a palavra
        word = cidades[rand.nextInt(cidades.length)];
        getWord();

        // dar valor aos textfields que nao precisam de imput do user
        tentativas = 6;
        acertos = 0;
        Tentativas_no_TextField();
        tamanho_Word();

        // esconder blocos nao usados
        esconder_quadrados();

        // limpar os elemntos dos blocos
        limpar_quadrados();
    }// fim do metodo


    /* ************************************************************
     * Metodo: comida_MainGame
     * Funcao: torna visivel o anchorpane2, torna todas as imagens usadas
     * para o boneco com a visibilidade(false), sortei a palavra pertencente
     * ao array comida, incia os valores de tentativas e acertos, chama metodos 
     * para que se for chamada novamente, nao possua valores presentes ainda nele
     * Parametros: objeto do tipo ActionEvent  chamado event.
     * Retorno: void
     ************************************************************ */
    
    @FXML
    public void comida_MainGame(ActionEvent event) {
        // trocar de tela
        anchorPane2.setVisible(true);
        anchorPane1.setVisible(false);
        anchorPane3.setVisible(false);

        // manter o boneco invisivel
        cabeca_img.setVisible(false);
        braco_direito_Img.setVisible(false);
        braco_esquerdo_img.setVisible(false);
        corpo_Img.setVisible(false);
        perna_direita_img.setVisible(false);
        perna_esquerda_img.setVisible(false);

        // escolher a palavra
        word = comida[rand.nextInt(comida.length)];
        getWord();

        // dar valor aos textfields que nao precisam de imput do user
        tentativas = 6;
        acertos = 0;
        Tentativas_no_TextField();
        tamanho_Word();

        // esconder blocos nao usados
        esconder_quadrados();

        // limpar os elemntos dos blocos
        limpar_quadrados();
    }// fim do metodo

    /* ************************************************************
     * Metodo: comeBack
     * Funcao: volta para a pagina especificada por meio da raiz escolhida
     * (/view/Inicial_Page.fxml)
     * Parametros: objeto do tipo ActionEvent  chamado event.
     * Retorno: void
     ************************************************************ */
    
    @FXML
    public void comeBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Inicial_Page.fxml"));
        palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }// fim do metodo


    /* ************************************************************
     * Metodo: backInicialPage
     * Funcao: volta para a pagina especificada por meio da raiz escolhida
     * (/view/Inicial_Page.fxml)
     * Parametros: objeto do tipo ActionEvent  chamado event.
     * Retorno: void
     ************************************************************ */

    @FXML
    public void backInicialPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/Inicial_Page.fxml"));
        palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        palco.setScene(scene);
        palco.show();
    }// fim do metodo

    /* ************************************************************
     * Metodo: TentarDenovo
     * Funcao: troca de tela tornado o anchorpane2, aonde o usuario joga
     * o jogo, para a area aonde se e escolhida a categoria
     * Parametros: objeto do tipo ActionEvent  chamado event.
     * Retorno: void
     ************************************************************ */

    public void TentarDenovo(ActionEvent event) {
        // troca de tela da forca para "Escolha sua Caracteristica"
        anchorPane2.setVisible(false);
        anchorPane1.setVisible(true);

        // permite que todos os TextField retorne para a visibilidade inicial
        aparecer_quadrados();
    }// fim do metodo

    /* ************************************************************
     * Metodo: voltar
     * Funcao: troca de tela tornado o anchorpane2, aonde o usuario joga
     * o jogo, para a area aonde se e escolhida a categoria
     * Parametros: objeto do tipo ActionEvent  chamado event.
     * Retorno: void
     ************************************************************ */

    @FXML
    public void voltar(ActionEvent event) {
        // troca de tela da forca para "Escolha sua Caracteristica"
        anchorPane2.setVisible(false);
        anchorPane1.setVisible(true);

        // permite que todos os TextField retorne para a visibilidade inicial
        aparecer_quadrados();
    }// fim do metodo

    /* ************************************************************
     * Metodo: getWord
     * Funcao: recebe qual a palavra sorteada e limpa a area aonde 
     * o usuario digita a palavra a ser adivinhada
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */
    
    public void getWord() {
        Palavra_TextField.setText(word);
        TryOut_TextField1.setText("");
    }// fim do metodo getWord

    /* ************************************************************
     * Metodo: Tentativas_no_TextField
     * Funcao: mostra o valor da variavel Tentativas no seu textField 
     * correspondente.
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */

    public void Tentativas_no_TextField() {
        Tentativas_TextField.setText("" + tentativas);
    }//fim do metodo Tentativas_no_TextField

    /* ************************************************************
     * Metodo: tamanho_Word
     * Funcao: expoem o tamanho da palavra sorteada
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */

    public void tamanho_Word() {
        Tam_TextField.setText("" + word.length());
    }// fim do metodo

    
    /* ************************************************************
     * Metodo: esconder_quadrados
     * Funcao: determina a quantidade de Char_TextFields visiveis
     * (o numero e correlacionado com o tamanho da palavra)
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */

    public void esconder_quadrados() {
        for (int i = word.length(); i < 12; i++) {
            Char_TextField.get(i).setVisible(false);
        } // fim do for
    }// fim do metodo

    /* ************************************************************
     * Metodo: aparecer_quadrados
     * Funcao: torna todos os Char_TextFields visiveis
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */
   
    public void aparecer_quadrados() {
        for (int i = 0; i < 12; i++) {
            Char_TextField.get(i).setVisible(true);
        } // fim do for
    }// fim do metodo

    /* ************************************************************
     * Metodo: limpar_quadrados
     * Funcao: a cada novo jogo se limpa o TextField onde as letras aparecem
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */

    public void limpar_quadrados() {
        for (int i = 0; i < 12; i++) {
            Char_TextField.get(i).setText(" ");
        } // fim do for
    }// fim do metodo

    // acoes que ocorrem no jogo

    /* ************************************************************
     * Metodo: imagem_Boneco
     * Funcao: A cada unidade que a variavel Tentativas perde,
     * se determina uma imagem que devera aparecer 
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */
    
    public void imagem_Boneco() {
        switch (tentativas) {
            case 6: {
                cabeca_img.setVisible(true);
                break;
            } // fim do case 6
            case 5: {
                corpo_Img.setVisible(true);
                break;
            } // fim do case 5
            case 4: {
                braco_esquerdo_img.setVisible(true);
                break;
            } // fim do case 4
            case 3: {
                braco_direito_Img.setVisible(true);
                break;
            } // fim do case 3
            case 2: {
                perna_direita_img.setVisible(true);
                break;
            } // fim do case 2
            case 1: {
                perna_esquerda_img.setVisible(true);
                break;
            } // fim do case 1
        }// fim do swtich
        tentativas--;
        Tentativas_no_TextField();
    }// fim do metodo imagem_Boneco

    /* ************************************************************
     * Metodo: setLetra
     * Funcao: relaciona a letra digitada pelo usuario com o TextField
     * correspondente
     * Parametros: Inteiro referente ao index em que a letra se encontra (index),
     * String correspondente a letra presente na palavra (letter)
     * Retorno: void
     ************************************************************ */

    public void setLetra(int index, String letter) {// inicia o metodo
        Char_TextField.get(index).setText(letter);
    }// fim do metodo setLetra


    /* ************************************************************
     * Metodo: Confirmar
     * Funcao:  recebe a letra digitada pelo usuario e se verifica 
     * se existe essa letra dentro da palavra que se deve encontrar no jogo
     * se sim, e verificado quantas vezes a letra aparece, adicionando um valor
     * para a variavel acerto a cada vez que ela aparecer, até que se ganhe o 
     * jogo se tentativas != 0. Caso não, a variavel tentativas perde 1 unidade
     * aparecendo uma parte do corpo do boneco. Quando tentativas chegar em 0
     * o anchorpane 3 fica visivel.
     * Parametros: ().
     * Retorno: void
     ************************************************************ */  

    public void Confirmar() {
        String letter = TryOut_TextField1.getText();
        if(repeated(letter)){
            TryOut_TextField1.setText("");
        }//fim do if
        else{
        if (word.contains(letter)) {
            int index = 0;// posicao inicial de um array
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (String.valueOf(c).equals(letter)) {
                    acertos++;
                    setLetra(index, Character.toString(c));
                } // fim do if
                index++;// letra em +d1 indice
            } // fim do for
        } // fim do if
        else {
            imagem_Boneco();
            if (tentativas == 0) {
                anchorPane3.setVisible(true);
            } // fim do if
        } // fim do else
        if (acertos == word.length() && tentativas != 0) {
            winOrLose();// mostra a mensagem de ganho,
        } // fim do if
        TryOut_TextField1.setText(""); 
        }//fim do else
    }// fim do metodo Confirmar

     /* ************************************************************
     * Metodo: winOrLose
     * Funcao: torna o anchorPane3 visivel e o textfield GameOver invisivel.
     * Parametros: vazio ().
     * Retorno: void
     ************************************************************ */

    public void winOrLose() {
        anchorPane3.setVisible(true);
        GameOver_TextField.setVisible(false);
    }// fim do metodo WinOrLose

    /* ************************************************************
     * Metodo: repeated
     * Funcao: verifica se a letra digitada pelo usuario ja foi adicionada
     * se sim retorna true e nao retorna false
     * Retorno: boolean
     ************************************************************ */

    public boolean repeated(String letter){
        for(int i = 0; i < word.length(); i++){
            if(Char_TextField.get(i).getText().equals(letter))
            return true;
        }
        return false;
    }//fim do metodo repeted

}// fim da classe
