package model;

import java.util.concurrent.Semaphore;

import controll.TransitControll;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class BaseCar extends Thread{
  protected final ImageView FIRSTIMAGE;
  protected ImageView image;
  protected int Wimage;
  protected double posX;
  protected double posY;
  protected double rotate;
  protected int speed;

  public BaseCar(ImageView image, TransitControll controll){
    this.image = image;
    this.FIRSTIMAGE = image;
    this.posX = image.getX();
    this.posY = image.getY();
    System.out.println(posY);
    this.rotate = image.getRotate();
    this.speed = 3;
    this.Wimage = 0;
  }

  public void run(){}

  //gets e sets

  public void setImage(ImageView image) {
      this.image = image;
  }



  public void moveX(double X){
    while(posX != X){
      try{
        Platform.runLater(()-> {
          image.setX(posX);
        });//end of platform runlater
        Thread.sleep(speed);
        if(posX>X)
          posX--;
        else
          posX++;
      }catch(Exception e){
        e.printStackTrace();
      }//wnd of catch
    }//end of while
  }//end of method

  public void moveY(double Y){
    while(posY != Y){
      try{
        Thread.sleep(speed);
        Platform.runLater(()->{
          image.setY(posY);
        });
        if(posY > Y)
          posY--;
        else
          posY++;
      }catch(Exception e){
        e.printStackTrace();
      }//end of catch
    }//end of while
  }//end of method

  public void rotation(double rotat){
    while(rotate != rotat){
      try{
        Thread.sleep(speed);
        Platform.runLater(()->{
          image.setRotate(rotate);
        });
        if(rotate > rotat)
          rotate--;
          else
        rotate++;
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }

}