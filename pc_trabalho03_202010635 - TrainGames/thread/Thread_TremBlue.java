package thread;

import control.ControlePrincipal;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Thread_TremBlue extends Thread {

    private ControlePrincipal controle;
    private ImageView image;
    private double EixoX = 686;
    private double EixoY = 341;
    private final double XO;
    private final double YO;
    private int speed = 30;
    private boolean loop = true;

    /* ***************************************************************
    * Metodo: Thread_TremBlue
    * Funcao: Construtor da thread TremBlue
    * Parametros: ImageView, ControlePrincipal
    * Retorno:  
    *************************************************************** */
    public Thread_TremBlue(ImageView image, ControlePrincipal controle) {
        this.image = image;
        this.controle = controle;
        this.XO = EixoX;
        this.YO = EixoY;
    }

    /* ***************************************************************
    * Metodo: run
    * Funcao: herdada da classe Thread ela roda a thread depois da mesma ser iniciada
    * Parametros: ()  
    * Retorno: void 
    *************************************************************** */
    @Override
    public void run() {
        while (loop) {
            try {
                moverEixoX(623d);
                verificarTunel2();
                passandoTunel2(563d, 283d);
                moverEixoX(277d);
                verificarTunel1();
                passandoTunel1(200d,283d);
                moverEixoX(0);
                reset();
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        } // fim do while
    }

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

    /* ***************************************************************
    * Metodo: verificarTunel1
    * Funcao: verifica se o tunel 1 esta livre e se nao estiver manda a thread dormir
    * Parametros: ()
    * Retorno:  void
    *************************************************************** */
    public void verificarTunel1() throws InterruptedException {
        while (controle.getLiberdadeTunel1() != 0) {
            Thread.sleep(1);
        }
    }

    /* ***************************************************************
    * Metodo: verificarTunel2
    * Funcao: verifica se o tunel 2 esta livre e se nao estiver manda a thread dormir
    * Parametros: ()
    * Retorno:  void
    *************************************************************** */
    public void verificarTunel2() throws InterruptedException {
        while (controle.getLiberdadeTunel2() != 0) {
            Thread.sleep(1);
        }
    }

    /* ***************************************************************
    * Metodo: moverEixoX
    * Funcao: altera o valor do eixoX movimentando o trem horizontalmente
    * Parametros: double
    * Retorno:  void
    *************************************************************** */
    public void moverEixoX(double posX) throws InterruptedException {
            while(EixoX != posX){
              Thread.sleep(speed);
              final double POSICAOX = EixoX;
              Platform.runLater( () -> image.setX(POSICAOX));
              EixoX--;
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
            EixoX--;

            if(posY < 0)//faz com que o trem suba uma curva
            EixoY++;

            else
            EixoY--;
            
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
        controle.getRedFlagBLUE2().setVisible(true);
        MoverDiagonal(stopX, stopY);
        controle.setLiberdadeTunel1(-1);
        stopX -= 100;
        moverEixoX(stopX);
        controle.getRedFlagBLUE2().setVisible(false);
        stopX -= 70;
        MoverDiagonal(stopX, -stopY);
        controle.setLiberdadeTunel1(0);
    }//fim do metodo passandoTunei1

    /* ***************************************************************
    * Metodo: passandoTunel2
    * Funcao: essa funcao determina o percurso feito pelo trem durante sua entrada na
              regiao critica2.
    * Parametros: double, double
    * Retorno:  void
    *************************************************************** */
    public void passandoTunel2(double stopX, double stopY) throws InterruptedException {
        controle.getRedFlagBLUE1().setVisible(true);
        MoverDiagonal(stopX, stopY);
        controle.setLiberdadeTunel2(-1);
        stopX -= 100;
        moverEixoX(stopX);
        controle.getRedFlagBLUE1().setVisible(false);
        stopX -= 70;
        MoverDiagonal(stopX, -stopY);
        controle.setLiberdadeTunel2(0);
    }

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
