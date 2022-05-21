package model;

import controll.TransitControll;
import javafx.scene.image.ImageView;
import variables.Variable;

//P14
public class YellowCar extends BaseCar{

  public YellowCar(ImageView image, TransitControll controll) {
    super(image, controll);
    super.speed = 1;
  }
  
  @Override
  public void run(){
    while(true){
      try{
        Variable.VYellownPurple.acquire();
        Variable.VGreenYellow.acquire();
        Variable.V2YellownBlack.acquire();

        moveY(299);
        Variable.VYellownBlack.acquire();
        Variable.VYellownPurple.release();
        Variable.V2YellownBlack.release();

        moveY(433);

        Variable.VGreenYellow.release();
        
        Variable.VYellownnRed.acquire();


        moveY(667);
        rotation(180);
        Variable.HBlackRednYellow.acquire();
        Variable.VYellownBlack.release();
        Variable.VYellownnRed.release();

        moveX(-275);
        rotation(270);
        moveY(-10);

        Variable.HYellownBlack.acquire();
        Variable.HPurpleGreenYellow.acquire();
        Variable.HBlackRednYellow.release();

        moveY(-20);

        rotation(180);
        moveX(0);
        rotation(90);

        Variable.HPurpleGreenYellow.release();
        Variable.HYellownBlack.release();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  }
}
