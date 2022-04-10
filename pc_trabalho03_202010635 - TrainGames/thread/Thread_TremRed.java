package thread;

import control.ControlePrincipal;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Thread_TremRed extends Thread {
    private ControlePrincipal controle;
    private ImageView image;
    private double EixoX;
    private double EixoY;
    private final double XO;
    private final double YO;
    private int speed = 30;
    private boolean loop = true;


    /* ***************************************************************
    * Metodo: Thread_TremRed
    * Funcao: Construtor da thread TremBlue
    * Parametros: ImageView, ControlePrincipal
    * Retorno:  
    *************************************************************** */

    public Thread_TremRed(ImageView image, ControlePrincipal controle) {
        this.image = image;
        this.controle = controle;
        this.XO = EixoX;
        this.YO = EixoY;
    }

    //gets e sets

    /* ***************************************************************
    * Metodo: setSpeed
    * Funcao: uma funcao que te permite alterar o valor guardado na variavel speed
    * Parametros: ()
    * Retorno:  inteiro
    *************************************************************** */

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /* ***************************************************************
    * Metodo: getSpeed
    * Funcao: uma funcao que te da o valor guardado na variavel speed
    * Parametros: ()
    * Retorno:  inteiro
    *************************************************************** */

    public int getSpeed() {
        return speed;
    }

    /* ***************************************************************
    * Metodo: setEixoX
    * Funcao: uma funcao que te permite alterar o valor guardado na variavel EixoX
    * Parametros: double
    * Retorno:  void
    *************************************************************** */

    public void setEixoX(double posicao) {
        this.EixoX = posicao;
    }

    //run

    /* ***************************************************************
    * Metodo: run
    * Funcao: herdada da classe Thread ela roda a thread depois da mesma ser iniciada
    * Parametros: ()  
    * Retorno: void 
    *************************************************************** */

    @Override
    public void run() {
        while(loop)
        try {
            moverEixoX(60d);
            verificarTunel1();
            passandoTunel1(105d, 235);
            moverEixoX(395);
            verificarTunel2();
            passandoTunel2(456d, 235d);
            moverEixoX(660);
            reset();
            Thread.sleep(100);
        }//fim do while
         catch (InterruptedException e) {
        }//fim do catch
    }//fim de run()

    //metodos

    /* ***************************************************************
    * Metodo: verificarTunel1
    * Funcao: verifica se o tunel 1 esta livre e se nao estiver manda a thread dormir
    * Parametros: ()
    * Retorno:  void
    *************************************************************** */

    public void verificarTunel1() throws InterruptedException {
        while (controle.getLiberdadeTunel1() != 0) {
            Thread.sleep(1);
        }//fim do while
    }//fim do verificarTunel1

    /* ***************************************************************
    * Metodo: verificarTunel2
    * Funcao: verifica se o tunel 2 esta livre e se nao estiver manda a thread dormir
    * Parametros: ()
    * Retorno:  void
    *************************************************************** */

    public void verificarTunel2() throws InterruptedException {
        while (controle.getLiberdadeTunel2() != 0) {
            Thread.sleep(1);
        }//fim do while
    }//fim do verificarTunel2

    /* ***************************************************************
    * Metodo: moverEixoX
    * Funcao: altera o valor do eixoX movimentando o trem horizontalmente
    * Parametros: double
    * Retorno:  void
    *************************************************************** */

    public void moverEixoX(double posX) throws InterruptedException {
        while (this.EixoX != posX) {
            Thread.sleep(speed);
            Platform.runLater(() -> {
                image.setX(EixoX);
            });
            EixoX++;
        }
    }// fim do metodo moverEixoX


    /* ***************************************************************
    * Metodo: MoverDiagonal
    * Funcao: altera o valor do eixoX e eixo Y movimentando o trem diagonalmente nas curvas
    * Parametros: double, double
    * Retorno:  void
    *************************************************************** */

    public void MoverDiagonal(double posX, double posY) throws InterruptedException {
        while(EixoX != posX && EixoY !=posY){
            Thread.sleep(speed);
            Platform.runLater(() -> {
                image.setX(EixoX);
                image.setY(EixoY);
            });
            EixoX++;

            if(posY < EixoY)
            EixoY--;

            else
            EixoY++;
            
        }//fim do While      
    }//fim do metodo MoverDiagonal

    //passando os tunels

    /* ***************************************************************
    * Metodo: passandoTunel1
    * Funcao: essa funcao determina o percurso feito pelo trem durante sua entrada na
              regiao critica1.
    * Parametros: double, double
    * Retorno:  void
    *************************************************************** */
    
    public void passandoTunel1(double stopX, double stopY) throws InterruptedException {
        controle.setLiberdadeTunel1(1);
        controle.getRedFlagRED1().setVisible(true);
        MoverDiagonal(stopX,stopY );
        stopX += 100;
        moverEixoX(stopX);
        controle.getRedFlagRED1().setVisible(false);
        stopX += 70;
        MoverDiagonal(stopX, -stopY);
        controle.setLiberdadeTunel1(0);
    }//fim do metodo passandoTunel1

    /* ***************************************************************
    * Metodo: passandoTunel2
    * Funcao: essa funcao determina o percurso feito pelo trem durante sua entrada na
              regiao critica2.
    * Parametros: double, double
    * Retorno:  void
    *************************************************************** */

    public void passandoTunel2(double stopX, double stopY) throws InterruptedException {
        controle.getRedFlagRED2().setVisible(true);
        MoverDiagonal(stopX, stopY);
        controle.setLiberdadeTunel2(1);
        stopX += 100;
        moverEixoX(stopX);
        controle.getRedFlagRED2().setVisible(false);
        stopX += 70;
        MoverDiagonal(stopX, -stopY);
        controle.setLiberdadeTunel2(0);
    }//fim do metodo passandoTunel2

    /* ***************************************************************
    * Metodo: reset
    * Funcao: uma funcao feita para o trem poder voltar para a posicao inicial dele apos percorrido oo trilho
    * Parametros: ()
    * Retorno:  void
    *************************************************************** */
    
    public void reset(){
        EixoX = XO;
        EixoY = YO;
        Platform.runLater(  () ->{
            image.setX(EixoX);
            image.setY(EixoY);
        });
    }
}
