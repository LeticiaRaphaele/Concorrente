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
    super.speed = 1;
        
  }
  
  @Override
  public void run(){
    while(true){
      try{
        Variable.H1BlacknGreen.acquire();
        Variable.HBlacknPurpleGreen.acquire();
        Variable.VBlacknPurpleGreen.acquire();

        Variable.HYellownBlack.acquire();
        Variable.H1BlacknPurple.acquire();
        Variable.V1BlacknPurple.acquire();
        
        moveX(236);
        Variable.H1BlacknGreen.release();
  
        moveX(680); 
        rotation(90);
        Variable.V2YellownBlack.acquire();
        Variable.HYellownBlack.release();

        moveY(324);

        Variable.VYellownBlack.acquire();
        Variable.V2YellownBlack.release();

        Variable.H1BlacknPurple.release();
        Variable.V1BlacknPurple.release();

        moveY(431);

        Variable.HBlacknPurpleGreen.release();
        Variable.VBlacknPurpleGreen.release();

        Variable.VBlackRednYellow.acquire();

        moveY(698);
        rotation(180);
        
        Variable.VYellownBlack.release();

        Variable.HRednBlack.acquire();

        Variable.VBlackRednYellow.release();
        Variable.HBlackRednYellow.acquire();

        moveX(406);

        Variable.HBlackRednYellow.release();

        moveX(-5);
        rotation(270);
        Variable.VRednBlack.acquire();

        Variable.HRednBlack.release();
        moveY(304);

        Variable.HBlacknPurpleGreen.acquire();
        Variable.VBlacknPurpleGreen.acquire();

        Variable.H1BlacknPurple.acquire();
        Variable.V2BlacknPurple.acquire();

        moveY(0);
        rotation(180);

        Variable.VRednBlack.release();

        Variable.HBlacknPurpleGreen.release();
        Variable.VBlacknPurpleGreen.release();

        Variable.V2BlacknPurple.release();
        Variable.H1BlacknPurple.release();

      }catch(Exception e){
        e.printStackTrace();
      }//end fo catch
  }//end of while

  }//end of method



  
}//end of class
