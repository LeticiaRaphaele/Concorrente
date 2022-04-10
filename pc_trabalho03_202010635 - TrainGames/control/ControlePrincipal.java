package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import thread.Thread_TremBlue;
import thread.Thread_TremRed;

public class ControlePrincipal implements Initializable {

    @FXML
    private ImageView RedTrain_Image;

    @FXML
    public ImageView BlueTrain_Image;

    @FXML
    private ImageView RedFlag_BlueTrain1;

    @FXML
    private ImageView RedFlag_BlueTrain2;

    @FXML
    private ImageView RedFlag_RedTrain1;

    @FXML
    private ImageView RedFlag_RedTrain2;

    @FXML
    private Button REDPlus_Button;

    @FXML
    private Button RedMinus_Button;

    @FXML
    private Button BLUEPlus_Button;

    @FXML
    private Button BLUEMinus_Button;
    // atributos

    private int tunelLivre1 = 0;
    private int tunelLivre2 = 0;
    private Thread_TremBlue tTB;
    private Thread_TremRed tTR;

    /* ***************************************************************
    * Metodo: initialize
    * Funcao: inicia as threads. 
    * Parametros: URL, ResourceBundle  
    * Retorno: void 
    *************************************************************** */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tTB = new Thread_TremBlue(BlueTrain_Image, this);
        tTR = new Thread_TremRed(RedTrain_Image, this);

        tTR.start();
        tTB.start();
    }

    // gets e sets

    /* ***************************************************************
    * Metodo: getLiberdadeTunel1
    * Funcao: retorna o valor em que a variavel tunelLivre1 se encontra
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */
    public int getLiberdadeTunel1() {
        return tunelLivre1;
    }
    /* ***************************************************************
    * Metodo: setLiberdadeTunel1
    * Funcao: altera o valor em que a variavel tunelLivre se encontra
    * Parametros: inteiro  
    * Retorno: void 
    *************************************************************** */
    public void setLiberdadeTunel1(int state) {
        this.tunelLivre1 = state;
    }
    /* ***************************************************************
    * Metodo: getLiberdadeTunel2
    * Funcao: retorna o valor em que a variavel tunelLivre2 se encontra
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */
    public int getLiberdadeTunel2() {
        return tunelLivre2;
    }

    /* ***************************************************************
    * Metodo: setLiberdadeTunel2
    * Funcao: altera o valor em que a variavel tunelLivre2 se encontra
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */

    public void setLiberdadeTunel2(int state) {
        this.tunelLivre2 = state;
    }
    /* ***************************************************************
    * Metodo: aumetarSpeedREDT
    * Funcao: aumenta a velocidade da variavel speed para o trem vermelho.
              isso ocorre ao diminuir o valor da variavel, diminuinido o
               tempo que a thread dorme
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */
    public void aumetarSpeedREDT() {
        int speed = tTR.getSpeed();
        speed = speed - 5;

        if (speed >= 10)
            tTR.setSpeed(speed);
    }
    /* ***************************************************************
    * Metodo: diminuirSpeedREDT
    * Funcao: dimui a velocidade da variavel speed para o trem vermelho.
            isso ocorre ao aumentando o valor da variavel, aumentando o
            tempo que a thread dorme
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */
    public void diminuirSpeedREDT() {
        int speed = tTR.getSpeed();
        speed = speed - 5;

        if (speed <= 30)
            tTR.setSpeed(speed);
    }
    /* ***************************************************************
    * Metodo: aumetarSpeedBLUET
    * Funcao: aumenta a velocidade da variavel speed para o trem azul.
              isso ocorre ao diminuir o valor da variavel, diminuinido o
              tempo que a thread dorme
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */
    public void aumetarSpeedBLUET() {
        int speed = tTB.getSpeed();
        speed = speed - 5;

        if (speed >= 5)
            tTB.setSpeed(speed);
    }
    /* ***************************************************************
    * Metodo: diminuirSpeedBLUET
    * Funcao: dimui a velocidade da variavel speed para o trem azul.
            isso ocorre ao aumentando o valor da variavel, aumentando o
            tempo que a thread dorme
    * Parametros: Stage  
    * Retorno: void 
    *************************************************************** */
    public void diminuirSpeedBLUET() {
        int speed = tTB.getSpeed();
        speed = speed + 5;

        if (speed <= 30)
            tTB.setSpeed(speed);
    }

    /* ***************************************************************
    * Metodo: getRedFlagRED1
    * Funcao: retorna a imagem da bandeira vermelha1
    * Parametros: ()  
    * Retorno: ImageView 
    *************************************************************** */

    public ImageView getRedFlagRED1() {
        return RedFlag_RedTrain1;
    }

    /* ***************************************************************
    * Metodo: getRedFlagRED2
    * Funcao: retorna a imagem da bandeira vermelha2
    * Parametros: ()  
    * Retorno: ImageView 
    *************************************************************** */
    public ImageView getRedFlagRED2() {
        return RedFlag_RedTrain2;
    }

    /* ***************************************************************
    * Metodo: getRedFlagBLUE1
    * Funcao: retorna a imagem da bandeira azul 1
    * Parametros: ()  
    * Retorno: ImageView 
    *************************************************************** */

    public ImageView getRedFlagBLUE1() {
        return RedFlag_BlueTrain1;
    }

    /* ***************************************************************
    * Metodo: getRedFlagBLUE2
    * Funcao: retorna a imagem da bandeira azul 2
    * Parametros: ()  
    * Retorno: ImageView 
    *************************************************************** */
    public ImageView getRedFlagBLUE2() {
        return RedFlag_BlueTrain2;
    }

}
