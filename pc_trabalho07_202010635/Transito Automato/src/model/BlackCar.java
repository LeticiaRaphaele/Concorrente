package model;

import controll.TransitControll;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import variables.Variable;

//P05
public class BlackCar extends BaseCar{

  public BlackCar(ImageView image, TransitControll controll) {
    super(image, controll);
        
  }
  
  @Override
  public void run(){
    while(true){
      try{
        Variable.HBlacknPurpleGreen.acquire();
        Variable.VBlacknPurpleGreen.acquire();
        Variable.H1BlacknPurple.acquire();
        Variable.V1BlacknPurple.acquire();
        moveX(680);
        rotation(90);
        moveY(304);
        Variable.HBlacknPurpleGreen.release();
        Variable.VBlacknPurpleGreen.release();
        Variable.H1BlacknPurple.release();
        Variable.V1BlacknPurple.release();
        moveY(698);
        rotation(180);
        moveX(-5);
        rotation(270);
        moveY(304);
        Variable.HBlacknPurpleGreen.acquire();
        Variable.VBlacknPurpleGreen.acquire();
        Variable.H1BlacknPurple.acquire();
        Variable.V2BlacknPurple.acquire();
        moveY(0);
        rotation(180);
        Variable.HBlacknPurpleGreen.release();
        Variable.VBlacknPurpleGreen.release();
        Variable.V2BlacknPurple.release();
        Variable.H1BlacknPurple.release();
      }catch(Exception e){
        e.printStackTrace();
      }
  }

  }



  
}
