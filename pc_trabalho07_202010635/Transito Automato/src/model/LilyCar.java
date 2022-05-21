package model;

import controll.TransitControll;
import javafx.scene.image.ImageView;

//P19
public class LilyCar extends BaseCar {

  public LilyCar(ImageView image, TransitControll controll) {
    super(image, controll);

  }
  
  @Override
  public void run(){
    while(true){
      moveY(270);//1
      rotation(180);
      moveX(271);//2
      rotation(90);
      moveY(412);//3
      rotation(180);
      moveX(-1);//4
      rotation(90);
      moveY(670);//5
      rotation(180);
      moveX(-149);//6
      rotation(90);
      moveY(409);//7
      rotation(180);
      moveX(-409);//8
      rotation(90);
      moveY(265);//9
      rotation(180);
      moveX(-141);//10
      rotation(90);
      moveY(-12);//11
      rotation(180);
      moveX(0);//12
      rotation(90);
    }
  }
}
