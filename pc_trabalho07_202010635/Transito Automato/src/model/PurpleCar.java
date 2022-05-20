package model;

import controll.TransitControll;
import javafx.scene.image.ImageView;
import variables.Variable;

//P07
public class PurpleCar extends BaseCar {

  public PurpleCar(ImageView image, TransitControll controll) {
    super(image, controll);
    super.speed = 1;
  }
  
  @Override
  public void run(){
    while(true){
      try{
      moveX(640);

      Variable.HBlacknPurpleGreen.acquire();
      Variable.VBlacknPurpleGreen.acquire();
      Variable.H1BlacknPurple.acquire();
      Variable.V1BlacknPurple.acquire();
      moveX(655);
      
      rotation(90);
      moveY(-295);
      rotation(180);
      Variable.VBlacknPurpleGreen.release();
      Variable.V2BlacknPurple.acquire();
      Variable.V1BlacknPurple.release();
      moveX(263);

      Variable.HBlacknPurpleGreen.release();
      moveX(-20);

      rotation(90);
      moveY(0);
      rotation(0);
      moveX(20);
      Variable.V2BlacknPurple.release();
      Variable.H1BlacknPurple.release();


      }catch(Exception e){
        e.printStackTrace();
      }
    }
  }
}
