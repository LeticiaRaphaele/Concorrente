package model;

import controll.TransitControll;
import javafx.scene.image.ImageView;
import variables.Variable;

//P04
public class RedCar extends BaseCar {

  public RedCar(ImageView image, TransitControll controll) {
    super(image, controll);
  }

  @Override
  public void run(){
    while(true){
      try{
        Variable.HRednGreen.acquire();
        moveX(392);
        rotation(90);
        Variable.HRednGreen.release();
        moveY(260);
        rotation(180);
        moveX(-283);
        rotation(270);
        moveY(-430);
        rotation(180);
        moveX(-25);
        rotation(90);
        Variable.VRednGreen.acquire();
        moveY(0);
        rotation(0);
        Variable.VRednGreen.release();
      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
  
}
