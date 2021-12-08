import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button Hello;
	Button Howdy;
	Button Chinese;
	Button French;
	Button Clear;
	Button Exit;
	Label Feedback;
	TextField textField;
	//  declare two HBoxes
	HBox hbox1;
	HBox hbox2;
	
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();

		Hello = new Button("Hello");
		Howdy = new Button("Howdy");
		Chinese = new Button("Chinese");
		French = new Button("French");
		Clear = new Button("Clear");
		Exit = new Button("Exit");
		Feedback = new Label("Feedback");
		textField = new TextField();

		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(Hello, new Insets(20));
	    HBox.setMargin(Howdy, new Insets(20));
	    HBox.setMargin(Chinese, new Insets(20));
	    HBox.setMargin(French, new Insets(20));
	    HBox.setMargin(Clear, new Insets(20));
	    HBox.setMargin(Exit, new Insets(20));
	    hbox1.setAlignment(Pos.CENTER);
	    hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		hbox1.getChildren().addAll(Hello, Howdy, Chinese, French, Clear, Exit);
	    hbox2.getChildren().addAll(Feedback, textField);
	    getChildren().addAll(hbox1,hbox2);
	    
	    
	    
	    
	    
	    Hello.setOnAction(new ButtonHandler());
	    Howdy.setOnAction(new ButtonHandler());
	    Chinese.setOnAction(new ButtonHandler());
	    French.setOnAction(new ButtonHandler());
	    Clear.setOnAction(new ButtonHandler());
	    Exit.setOnAction(new ButtonHandler());
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event) {
			if (event.getTarget() == Hello) {
				textField.setText(dataManager.getHello());
			} else if (event.getTarget() == Howdy) {
				textField.setText(dataManager.getHowdy());
			} else if (event.getTarget() == Chinese) {
				textField.setText(dataManager.getChinese());
			} else if (event.getTarget() == French) {
				textField.setText(dataManager.getFrench());
			} else if(event.getTarget() == Clear) {
				textField.setText("");
			} else if (event.getTarget() == Exit) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
	
}
