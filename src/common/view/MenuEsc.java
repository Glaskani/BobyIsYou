package common.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import common.model.Levels;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

/**
 *
 * @author Glaskani
 */
public class MenuEsc {

    private Stage primaryStage = MenuInit.getInstance().getStage();
    private Pane root = new Pane();
    private Display continuer;
    Scene scene;
    
    /**
     * 
     * @param continuer
     */
    MenuEsc(Display continuer) {
        this.scene = new Scene(root,JavaBobyIsYou.WIDTH,JavaBobyIsYou.HEIGHT);
        scene.getStylesheets().add(JavaBobyIsYou.THEME);
        this.continuer= continuer;
        root.setBackground(JavaFXMethode.addColoredBackGround(Color.BLACK));
        root.getChildren().add(JavaFXMethode.addTitle("ESC",Color.WHITE));
        addMenu();
    }

    private void addMenu() {
        VBox vbox = new VBox();

        Button buttonContinue = new Button("Continuer");
        Button buttonExit = new Button("Exit");
        Button buttonMenu = new Button("Menu");
	
        vbox.getChildren().addAll(
                buttonContinue,
                buttonMenu,
                buttonExit);
        vbox.getStyleClass().add("vbox");
        root.getChildren().addAll(vbox);
        vbox.setTranslateX((JavaBobyIsYou.WIDTH/2)-90);
	vbox.setTranslateY((JavaBobyIsYou.HEIGHT/2)-70);

        buttonContinue.setOnAction(event -> {
            this.primaryStage.setScene(continuer.scene);
        });
        buttonMenu.setOnAction(event -> {
           Levels.instance().stopGame();
        });
        buttonExit.setOnAction(event -> {
            Levels.instance().stopGame();
            primaryStage.close();
        });
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ESCAPE)
                this.primaryStage.setScene(continuer.scene);
            e.consume();
        });
    }                       
}
