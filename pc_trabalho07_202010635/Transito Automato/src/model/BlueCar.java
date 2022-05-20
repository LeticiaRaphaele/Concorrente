package model;

import controll.TransitControll;
import javafx.scene.image.ImageView;

//P09
public class BlueCar extends BaseCar {

  private TransitControll controll;
  public BlueCar(ImageView image, TransitControll controll) {
    super(image, controll);
    //TODO Auto-generated constructor stub
  }
  @Override
  public void run(){
    while(true){
      moveX(655);
      rotation(-90);
      moveY(300);
      rotation(-180);
      moveX(20);
      rotation(-270);
      moveY(582);
      rotation(-180);
   }
  }
}
