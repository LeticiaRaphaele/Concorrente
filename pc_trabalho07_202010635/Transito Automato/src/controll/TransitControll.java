package controll;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.BlackCar;
import model.BlueCar;
import model.GreenCar;
import model.LilyCar;
import model.PurpleCar;
import model.RedCar;
import model.YellowCar;


public class TransitControll implements Initializable{

  @FXML
  private ImageView blackCar_5;

  @FXML
  private ImageView greenCar16;

  @FXML
  private ImageView purpleCar_7;

  @FXML
  private ImageView blueCar_9;

  @FXML
  private ImageView yellowCar_14;

  @FXML
  private ImageView redCar_4;

  @FXML
  private ImageView lilyCar_19;

  
  @FXML
  private ImageView ReverseBlackC;




  @Override
  public void initialize(URL location, ResourceBundle resources) {
    BlackCar blackCar = new BlackCar(blackCar_5, this);
    blackCar.start();
    BlueCar blueCar = new BlueCar(blueCar_9, this);
    //blueCar.start();
    LilyCar lilycar = new LilyCar(lilyCar_19, this);
    //lilycar.start();
    GreenCar greenCar = new GreenCar(greenCar16, this);
    greenCar.start();
    PurpleCar purpleCar = new PurpleCar(purpleCar_7, this);
    purpleCar.start();  

    YellowCar yellowCar = new YellowCar(yellowCar_14, this);

    yellowCar.start();
    RedCar redCar = new RedCar(redCar_4, this);
    //redCar.start();

  }




}
