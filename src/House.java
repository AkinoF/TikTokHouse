import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class House extends Application {
    private boolean isDay = true; // Переменная для отслеживания дня/ночи
    @Override
    public void start(Stage primaryStage) {

        // Создаем основной контейнер
        BorderPane root = new BorderPane();

        // Я проиграл крыше, крыши не будет.
        Text roofText = new Text("Представьте, что крыша есть");
        roofText.setFill(Color.DARKRED); // Устанавливаем цвет текста крыши
        roofText.setStyle("-fx-font-size: 20px;"); // Устанавливаем размер шрифта

        // Меняем позицию текста
        root.setTop(roofText);
        BorderPane.setAlignment(roofText, javafx.geometry.Pos.CENTER); // Центрируем текст

        // Создаем каркас
        Rectangle house = new Rectangle(200, 150);
        house.setFill(Color.WHITE);
        house.setStroke(Color.BLACK);
        house.setStrokeWidth(2);

        // Создаем окно
        Rectangle window = new Rectangle(70, 50);
        window.setFill(Color.BLUE);
        window.setStroke(Color.BLACK);
        window.setStrokeWidth(2);

        // Создаем кнопку на месте окна
        Button windowButton = new Button();
        windowButton.setGraphic(window);
        windowButton.setStyle("-fx-background-color: transparent;"); // Делаем фон кнопки прозрачным

        // Создаем стек для размещения дома и окна
        StackPane housePane = new StackPane();
        housePane.getChildren().addAll(house, windowButton);

        // Создаем сцену
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Дом с окном");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Создаем текст для отображения дня/ночи
        Text dayNightText = new Text("Сейчас день");
        dayNightText.setFill(Color.BLACK);

        // Нажатие на кнопку
        windowButton.setOnAction(event -> {
            if (isDay) {
                window.setFill(Color.YELLOW); // Меняем цвет окна на желтый
                root.setStyle("-fx-background-color: black;"); // Меняем фон на черный
                dayNightText.setText("Сейчас ночь"); // Меняем текст на "ночь"
                dayNightText.setFill(Color.WHITE); // Меняем цвет текста на белый
            } else {
                window.setFill(Color.BLUE); // Меняем цвет окна обратно на синий
                root.setStyle("-fx-background-color: white;"); // Меняем фон обратно на белый
                dayNightText.setText("Сейчас день"); // Меняем текст обратно на "день"
                dayNightText.setFill(Color.BLACK); // Меняем цвет текста обратно на черный
            }
            isDay = !isDay; // Переключаем состояние
        });

        // Добавляем элементы в основной контейнер
        root.setCenter(housePane);
        root.setBottom(dayNightText);
        BorderPane.setAlignment(dayNightText, javafx.geometry.Pos.CENTER);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


