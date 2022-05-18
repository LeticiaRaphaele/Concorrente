package model;

import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class BaseCar extends Thread{
  private final ImageView FIRSTIMAGE;
  private ImageView image;
  private int Wimage;
  private double posX;
  private double posY;
  private double rotate;
  private int speed;

  public BaseCar(ImageView image, double posX, double posY){
    this.image = image;
    this.FIRSTIMAGE = image;
    this.posX = image.getX();
    this.posY = image.getY();;
    this.rotate = image.getRotate();
    this.speed = 1000;
    this.Wimage = 0;
  }

  public void run(){}

  //gets e sets

  public void setImage(ImageView image) {
      this.image = image;
  }

  public void changingImage(ImageView Reimage){
    if(Wimage != 0)
      setImage(Reimage);
    else
      setImage(FIRSTIMAGE);
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
        Platform.runLater(()->{
          image.setRotate(rotate);
        });
        rotate +=15;
        if(rotate == 360)
          rotate = 0;
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}