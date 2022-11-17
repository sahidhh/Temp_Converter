package com.example.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args) {
		System.out.println("Main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("Init");
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

//		MenuBar menuBar = createMenu();
//		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter");
		primaryStage.setResizable(false);                        // to set fixed window size (or) disable resizability
		primaryStage.show();

		System.out.println("Start");

	}

	private MenuBar createMenu() {

//		File Menu
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");

		newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu item"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");

		quitMenuItem.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

//		Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");

		aboutApp.setOnAction(actionEvent -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

//		Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);


		return menuBar;

	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("desktop app");
		alertDialog.setHeaderText("About");
		alertDialog.setContentText("Hi!");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickBtn = alertDialog.showAndWait();

		if (clickBtn.isPresent() && clickBtn.get() == yesBtn) {

			System.out.println("Yes button is clicked");

		} else {

			System.out.println("No button is clicked");

		}

	}

	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("stop");
	}
}
