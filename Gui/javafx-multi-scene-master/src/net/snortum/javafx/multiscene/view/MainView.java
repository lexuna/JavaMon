package net.snortum.javafx.multiscene.view;


import java.io.FileInputStream;
import java.io.InputStream;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  

import net.snortum.javafx.multiscene.Main;
import net.snortum.javafx.multiscene.controller.MainController;
import net.snortum.javafx.multiscene.controller.ViewController;

//import javafx.scene.image.ImageView;  yea no ?
import java.io.InputStream;
 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;




/** 
 * Creates and returns the scene for {@link Main}.
 * 
 */
@SuppressWarnings("restriction") // JA GEHT DOCH...... :0
public class MainView implements ViewMaker {
	
	private Stage stage;
	
	/** Must inject a stage */
	public MainView(Stage stage) {
		this.stage = stage;
	}

	@Override
	public Scene getScene() {
		
		// Inject stage from Main into controller
		MainController controller = new MainController(stage);
		
		// Switch between scenes
		Button button1 = new Button("Scene 1");
		button1.setOnMousePressed(e -> controller.handleOnPressButton1(e));
		Button button2 = new Button("Scene 2");
		button2.setOnMousePressed(e -> controller.handleOnPressButton2(e));
		Button button3 = new Button("Scene 3");
		button3.setOnMousePressed(e -> controller.handleOnPressButton3(e));
		
		//Monster select
		Button m1 = new Button("Monster 1");
		m1.setPrefSize(100, 100);
		//m1.setOnMousePressed(e -> controller.handleOnPressButton1(e)); //// START  HERE
		//m1.setOnMousePressed() //TODO: WHEN MONSTER BUTTON PRESSED SHOW <this> MONSTER ON SCENE 2 aka pass value
		
		Button m2 = new Button("Monster 2");
		m2.setPrefSize(100, 100);
		
		Button m3 = new Button("Monster 3");
		m3.setPrefSize(100, 100);
		
		Button play = new Button("Play"); //Optional oder direkt über m1,m2,m3
		play.setPrefSize(100, 100);
		
		play.setOnMousePressed(e -> controller.handleOnPressButton1(e)); //// START  HERE
		
		
		
		//play.setOnMousePressed(e -> controller.handleOnPressButton1TEST(e));
		
		
		// Build scene
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));
		vbox.getChildren().addAll(button1, button2, button3);
		
		HBox hbox = new HBox(1); // spacing = 8
		hbox.setPadding(new Insets(1));
		hbox.getChildren().addAll(m1, m2, m3, play);
		
		
			// EIN IMAGE EINBINDEN DAS test PNG
		  	Class<?> clazz = this.getClass();
	        InputStream input = clazz.getResourceAsStream("test.png");
	        Image image = new Image(input);
	        ImageView imageView = new ImageView(image);
	        imageView.setX(500); 
	        imageView.setY(25); 
	        
	        
	        
	        	
		
		
		
		BorderPane root = new BorderPane();
		root.setLeft(vbox);
		root.setCenter(hbox);
		Label label = new Label("         MAIN SCENE                     Wähle Monster");
		label.setFont(new Font(32));
		root.setTop(label); //Label Wähle Monster
		
		Button closeButton = new Button("Close");
		closeButton.setOnMousePressed(e -> stage.close());
		ButtonBar bbar = new ButtonBar();
		bbar.setPadding(new Insets(10));
		bbar.getButtons().add(closeButton);
		root.setBottom(bbar);
		root.getChildren().addAll(imageView);
		
						
		
		//A button with the specified text caption and icon.
		Image imageOk = new Image(getClass().getResourceAsStream("idle.gif"));
		Button monster1 = new Button("Accept", new ImageView(imageOk));
		monster1.setLayoutX(250);
		monster1.setLayoutY(320);
		root.getChildren().addAll(monster1);
		Scene scene = new Scene(root, 800, 460);
		
		root.getStylesheets().add("mainClass.css");
		root.getStyleClass().add("main-class");

		scene.getStylesheets().add(
			  getClass().getResource("mainClass.css").toExternalForm()
		);
		
		// HIER BUTTON LISTENER ? Oder neue klasse?public class ?
		m1.setOnMousePressed(event -> {
			Image img = new Image(getClass().getResourceAsStream("idle.gif"));
			monster1.setGraphic(new ImageView(img));
			//Main.setPlayer(new Player("Name", img));
			ViewController.chooseMonsterOne(1);
	    });
		
		m2.setOnMousePressed(event -> {
			Image img = new Image(getClass().getResourceAsStream("test.png"));
			monster1.setGraphic(new ImageView(img));
			//TODO:Replace monster with selection
		//	ViewController.chooseMonsterTwo();
	    });
		
		
		
		return scene;
	}

}
