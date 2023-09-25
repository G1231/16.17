/*16.17 Write a program that uses scroll bars or sliders to
select the color for a text, as shown in Figure 16.43b. Four
horizontal scroll bars are used for selecting the colors: 
red, green, blue, and opacity percentages. */
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Slider;


public class colorslide extends Application { 
	//preparing label and font. Preparing sliders outside of start in order to use variables outside scope
	  Font font = Font.font("Verdana", FontWeight.BOLD, 15);
	  Label label = new Label("This text will change color");
	  Slider redSlider = new Slider(0, 1, 1.0);
	  Slider blueSlider = new Slider(0, 1, 1.0);
	  Slider greenSlider  = new Slider(0, 1, 1.0);
	  Slider opacitySlider = new Slider(0, 1, 1.0);

	  @Override
	  public void start(Stage primaryStage) {
		  //setting label font to bold and color to black
		  Color c = Color.color(0, 0, 0, 1);
		  label.setFont(font);
		  label.setTextFill(c);
		  //Creating Vbox to place things vertically
		  VBox vbox = new VBox(20);
		  // preparing labels for each slider
		  Label redl = new Label("Red");
		  Label bluel = new Label("blue");
		  Label greenl = new Label("green");
		  Label opacityl = new Label("opacity");
		  //positioning everything in center
		  vbox.setAlignment(Pos.CENTER);
		  
		  //adding main label to vbox
		  vbox.getChildren().add(label);
		  //adding red slider and label
		  vbox.getChildren().add(redl);
		  vbox.getChildren().add(redSlider);
		  //adding blue slider and label
		  vbox.getChildren().add(bluel);
		  vbox.getChildren().add(blueSlider);
		  //adding green slider and label
		  vbox.getChildren().add(greenl);
		  vbox.getChildren().add(greenSlider);
		  //adding opacity slider and label
		  vbox.getChildren().add(opacityl);
		  vbox.getChildren().add(opacitySlider);
		  
		  //getting value of sliders and adding listener to check for scroll bar change
		  redSlider.valueProperty().addListener(ov -> colorChange());
		  blueSlider.valueProperty().addListener(ov -> colorChange());
		  greenSlider.valueProperty().addListener(ov -> colorChange());
		  opacitySlider.valueProperty().addListener(ov -> colorChange());
		  //creating scene and showing it
		  Scene scene = new Scene(vbox, 500, 350);
	      primaryStage.setTitle("Sliders");
	      primaryStage.setScene(scene);
	      primaryStage.show();
	      
	  } 
	  //method to change colors as slider value changes.
	  private void colorChange() {
		  label.setTextFill(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));
	  }
	  public static void main(String[] args) {
	    launch(args);
	  }
	  
	} 

