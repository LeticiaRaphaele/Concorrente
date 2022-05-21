package model;

import controll.TransitControll;
import javafx.scene.image.ImageView;
import variables.Variable;

//P16
public class GreenCar extends BaseCar{

  public GreenCar(ImageView image, TransitControll controll) {
    super(image, controll);

  }

  @Override
  public void run(){
    while(true){
      try{
        Variable.VRednGreen.acquire();
        
        moveY(411);
        rotation(0);
        
        Variable.VRednGreen.release();
        Variable.HRednGreen.acquire();
        
        moveX(410);
        rotation(90);
        
        Variable.H1BlacknGreen.acquire();
        Variable.HBlacknPurpleGreen.acquire();
        Variable.HPurpleGreenYellow.acquire();
        Variable.VBlacknPurpleGreen.acquire();
        
        moveX(420);
        
        Variable.HRednGreen.release();
        Variable.VGreenYellow.acquire();

        moveY(-18);
        rotation(0);
        
        Variable.VGreenYellow.release();
        
        moveX(150);

        Variable.H1BlacknGreen.release();
        Variable.HPurpleGreenYellow.release();
        
        moveX(0);
        rotation(90);
        moveY(0);

        Variable.HBlacknPurpleGreen.release();
        Variable.VBlacknPurpleGreen.release();
        
      }catch(Exception e){
        e.printStackTrace();
      }//end of catch
    }//end of while
  }//end of method run
}//end of class
