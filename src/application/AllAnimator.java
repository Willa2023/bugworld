package application;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AllAnimator extends Application {
	int width = 800, height = 800;
	float x = 200, y = 100;
	String informationForEach;
	
	ArrayList<MyBug> bugs = new ArrayList<MyBug>(); 
	ArrayList<MyPlant> plants = new ArrayList<MyPlant>();
	ArrayList<Button> buttons = new ArrayList<Button>();
	
	Timeline tl = new Timeline();
	BorderPane bpane = new BorderPane();
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//create label TopLabel to put top title
		//put label to topBox, put topBox to bpane
		VBox topBox = new VBox();
		topBox.setAlignment(Pos.CENTER);
		topBox.setPadding(new Insets(25,25,25,25));
		topBox.setBackground(Background.fill(Color.LIGHTCYAN));
		topBox.setMinHeight(50);
		topBox.setMaxHeight(50);
		
		Label l1 = new Label();
		l1.setText("Bee eats flower, Worm eats grass and tree, Spider eats worm");
		l1.setAlignment(Pos.TOP_CENTER);
		l1.setTextFill(Color.CHOCOLATE);
		l1.setFont(new Font("Palatino",15));
		
		Label TopLabel = new Label();
		TopLabel.setText("WELCOME TO ANIMATION WORLD!");
		TopLabel.setTextFill(Color.CHOCOLATE);
		TopLabel.setFont(new Font("Palatino",23));
		
		topBox.getChildren().add(TopLabel);
		topBox.getChildren().add(l1);
		bpane.setTop(topBox);
		
		//create label bottomLabel to put bug or plant information and Label l1 for the details
		//put labels to bottomBox, put bottomBox to bpane
		//when click on bug or plant, the information will come out 
		VBox bottomBox = new VBox();
		bottomBox.setAlignment(Pos.TOP_CENTER);
		bottomBox.setPadding(new Insets(25,25,25,25));
		bottomBox.setBackground(Background.fill(Color.LIGHTCYAN));
		bottomBox.setMinHeight(150);
		bottomBox.setMaxHeight(150);
		
		Label l3 = new Label();
		l3.setText("Click on the bug or plant , you will get the information about it");
		l3.setAlignment(Pos.TOP_CENTER);
		l3.setTextFill(Color.CHOCOLATE);
		l3.setFont(new Font("Palatino",12));
		
		Label l4 = new Label();
		
//		l4.setText("Bee eats flower, Worm eats grass and tree, Spider eats worm");
		l4.setAlignment(Pos.CENTER);
		l4.setTextFill(Color.CHOCOLATE);
		l4.setFont(new Font("Palatino",12));
		
		bottomBox.getChildren().add(l3);
		bottomBox.getChildren().add(l4);
		bpane.setBottom(bottomBox);
		
		//create three buttons to control the timeline
		Button startButton = new Button();
		startButton.setText("Start");
		startButton.setPrefWidth(90);
		startButton.setPadding(new Insets(10,10,10,10));
		buttons.add(startButton);
		
		Button pauseButton = new Button();
		pauseButton.setText("Pause");
		pauseButton.setPrefWidth(90);
		pauseButton.setPadding(new Insets(10,10,10,10));
		buttons.add(pauseButton);
		
		Button stopButton = new Button();
		stopButton.setText("Stop");
		stopButton.setPrefWidth(90);
		stopButton.setPadding(new Insets(10,10,10,10));
		buttons.add(stopButton);
		
		//create one slider to control the speed of bugs
		Slider slider1 = new Slider(0,5,1);
		slider1.setShowTickLabels(true);
		slider1.setShowTickMarks(false);
		slider1.setMajorTickUnit(1);
		slider1.setBlockIncrement(1f);
		slider1.setPrefWidth(60);
		slider1.setPadding(new Insets(100,0,0,0));
		
		//create an name for the slider
		Label l2 = new Label();
		l2.setText("Speed Adjuster");
		l2.setAlignment(Pos.BASELINE_LEFT);
		l2.setTextFill(Color.BLACK);
		l2.setOpacity(0.5);
		
		//create a vbox for buttons and slider
		//bugs and plants will not move to this vbox.
		VBox leftBox = new VBox();
		leftBox.setAlignment(Pos.CENTER);
		leftBox.setPadding(new Insets(25,25,25,25));
		leftBox.setBackground(Background.fill(Color.ALICEBLUE));
		leftBox.setMinWidth(150);
		leftBox.setMaxWidth(150);
		leftBox.setSpacing(5);
		
		//set the vbox to borderpane
		leftBox.getChildren().addAll(buttons);
		leftBox.getChildren().addAll(slider1);
		leftBox.getChildren().addAll(l2);
		bpane.setLeft(leftBox);
		
		for(Button b: buttons) {
			ButtonMouse st1 = new ButtonMouse(bugs, plants, b, tl);
			b.setOnMouseClicked(st1);
		}
		
		//create bug, add into list
		MyBug bee1 = new MyBug ("bee",250, 500, 10, 2, 2, 2, "bee2.png");
		MyBug bee2 = new MyBug ("bee",650, 300, 10, 2, 2, 2, "bee2.png");
		
		MyBug worm1 = new MyBug ("worm",560, 130, 10, -1, -1, -1,"worm3.png");
		MyBug worm2 = new MyBug ("worm",200, 100, 10, 1, 1, 1,"worm4.png");
		MyBug worm3 = new MyBug ("worm",360, 150, 10, 0.5, 0.5, 0.5, "worm2.png");
		MyBug worm4 = new MyBug ("worm",460, 400, 10, -1, -1, -1,"worm3.png");
		MyBug worm5 = new MyBug ("worm",500, 450, 10, 1, 1, 1,"worm4.png");
		MyBug worm6 = new MyBug ("worm",560, 480, 10, 1, 1, 1,"worm4.png");
		MyBug worm7 = new MyBug ("worm",600, 340, 10, 1, 1, 1,"worm4.png");
		MyBug worm8 = new MyBug ("worm",660, 200, 10, -1, -1, -1,"worm3.png");
		MyBug worm9 = new MyBug ("worm",530, 270, 10, -1, -1, -1,"worm3.png");
		MyBug worm10 = new MyBug ("worm",690, 180, 10, -1, -1, -1,"worm3.png");
		
		MyBug spider1 = new MyBug ("spider",300, 200, 15, 4, 4, 4,"spider.png");
		
		bugs.add(bee1);  //bee eat flower
		bugs.add(bee2);  
		 
		bugs.add(worm1);  //worm eat grass and tree
		bugs.add(worm2);
		bugs.add(worm3);
		bugs.add(worm4); 
		bugs.add(worm5);
		bugs.add(worm6);
		bugs.add(worm7);
		bugs.add(worm8);
		bugs.add(worm9);
		bugs.add(worm10);
		
		bugs.add(spider1);  //spider eat worm
		
		SliderMouse sm = new SliderMouse(bugs,slider1);
		slider1.setOnMouseReleased(sm);
		
		//create plant, add into list
		MyPlant tree1 = new MyPlant(700,520,100, "Tree","tree1.png");
		
		MyPlant grass1 = new MyPlant(200,200,40, "Grass","grass1.png");
		MyPlant grass2 = new MyPlant(300,440,60, "Grass","grass1.png");
		MyPlant grass3 = new MyPlant(350,500,20, "Grass","grass1.png");
		MyPlant grass4 = new MyPlant(400,430,30, "Grass","grass1.png");
		MyPlant grass5 = new MyPlant(500,150,30, "Grass","grass1.png");
		MyPlant grass6 = new MyPlant(600,200,30, "Grass","grass1.png");
		MyPlant grass7 = new MyPlant(700,350,40, "Grass","grass1.png");
		
		MyPlant flower1 = new MyPlant(250,300,15,"Flower","flower1.png");
		MyPlant flower2 = new MyPlant(320,260,15,"Flower","sunflower.png");
		MyPlant flower3 = new MyPlant(430,360,15,"Flower","sunflower.png");
		MyPlant flower4 = new MyPlant(700,100,15,"Flower","flower1.png");
		
		plants.add(tree1);
		plants.add(grass1);
		plants.add(grass2);
		plants.add(grass3);
		plants.add(grass4);
		plants.add(grass5);
		plants.add(grass6);
		plants.add(grass7);
		
		plants.add(flower1);
		plants.add(flower2);
		plants.add(flower3);
		plants.add(flower4);
		
		//add each plant to pane1 and set Mouse click
		for(MyPlant p : plants)
		{
			bpane.getChildren().add(p);
			PlantMouse v = new PlantMouse(p,l4);
			p.setOnMouseClicked(v);
		}
		
		//add each bug to pane1 and set Mouse click
		for(MyBug c : bugs)
		{
			bpane.getChildren().add(c);
			BugMouse v = new BugMouse(c, l4);
			c.setOnMouseClicked(v);
		}

		final Scene scene = new Scene(bpane, width, height);
		
		// pass World Action for each bug and each plant to new frame
		WorldAction wac = new WorldAction(bugs, plants, scene,bpane);
		KeyFrame frame = new KeyFrame(Duration.millis(16), wac);
		tl.setCycleCount(javafx.animation.Animation.INDEFINITE);
		tl.getKeyFrames().add(frame);
		
		primaryStage.setTitle("Hello Animation");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}

















