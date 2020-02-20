/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pageflipper;


import java.net.URISyntaxException;
import java.util.stream.IntStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author there
 */
    public class PageFlipper extends Application {
    private static final double WIDTH = 1024;
    private static final double HEIGHT = 680;
    
    @Override
    public void start(Stage stage) {
        Group root = new Group();

        IntStream.range(0, 4)
                 .forEach(n -> {
                     try {
                         Image img = new Image(getClass().getResource("/resources/image.jpg").toURI().toString());
                         ImageView iv = new ImageView(img);
                         ImageView image = new ImageView
                            //   Image img = new Image("/br/com/casa/bluekepper/img.gif");
                       (new Image(getClass().getResource("/resources/image.jpg").toURI().toString()) {});
                         root.getChildren().add(image);
                     } catch (URISyntaxException ex) {
                         ex.printStackTrace();
                     }
                 });

        FlipTransition transition = new FlipTransition(WIDTH, HEIGHT);
        
        root.setOnMousePressed(e -> {
            transition.play(root);
        });
        
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
    
}

//    @Override
//    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    