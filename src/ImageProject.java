import GUI.Grid;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class ImageProject extends Application{
    @Override
    public void start (Stage stage) throws Exception{
        GridPane mainGrid = Grid.createGrid(stage);

        Scene scene = new Scene(mainGrid);
        stage.setScene(scene);
        stage.setWidth(900);
        stage.setMinWidth(800);
        stage.setHeight(600);
        stage.setMinHeight(500);
        stage.show();
        stage.setTitle("Bildprojekt");
    }

}
