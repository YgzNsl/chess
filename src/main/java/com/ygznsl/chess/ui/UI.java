package com.ygznsl.chess.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class UI extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
//        final ChessBoardUserInterfaceBuilder builder = new ChessBoardUserInterfaceBuilder();
//        final Scene scene = builder.build();

        final Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("layout.fxml"));
        final Scene scene = new Scene(root);

        final String css = getClass()
                .getClassLoader()
                .getResource("css/style.css")
                .toExternalForm();

        scene
                .getStylesheets()
                .add(css);

        primaryStage.setScene(scene);
        primaryStage.setTitle("CHESS");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
