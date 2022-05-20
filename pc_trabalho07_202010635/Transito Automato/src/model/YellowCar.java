package model;

import controll.TransitControll;
import javafx.scene.image.ImageView;

//P14
public class YellowCar extends BaseCar{

  public YellowCar(ImageView image, TransitControll controll) {
    super(image, controll);
    //TODO Auto-generated constructor stub
  }
  
  @Override
  public void run(){
    while(true){
      moveY(667);
      rotation(180);
      moveX(-275);
      rotation(270);
      moveY(-20);
      rotation(180);
      moveX(0);
      rotation(90);
  }
  }
}
