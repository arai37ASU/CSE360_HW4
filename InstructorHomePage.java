package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import databasePart1.DatabaseHelper;

/**
 * The {@code InstructorHomePage} class provides the main dashboard for instructors.
 * <p>
 * From this screen, instructors can:
 * <ul>
 *   <li>Access the Review Page to manage and submit reviews</li>
 *   <li>Navigate to the Q&A page to view or manage questions and answers</li>
 *   <li>Approve or deny reviewer requests from students</li>
 *   <li>Log out or return to the welcome page</li>
 * </ul>
 * </p>
 */
public class InstructorHomePage {

    private final DatabaseHelper databaseHelper;
    private final User user;

    /**
     * Constructs an {@code InstructorHomePage} with a database connection and user context.
     *
     * @param databaseHelper the database helper for accessing application data
     * @param user the currently logged-in instructor
     */
    public InstructorHomePage(DatabaseHelper databaseHelper, User user) {
        this.databaseHelper = databaseHelper;
        this.user = user;
    }

    /**
     * Displays the instructor home page interface.
     *
     * @param primaryStage the main JavaFX stage for the application
     */
    public void show(Stage primaryStage) {
        VBox layout = new VBox(20);
        layout.setStyle("-fx-padding: 30;");
        layout.setAlignment(Pos.TOP_CENTER);

        // Greeting label
        Label userLabel = new Label("Hello, Instructor!");
        userLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Instructional subtitle
        Label descriptionLabel = new Label(
            "Access the review tools, browse Q&A content, or approve/deny reviewer requests"
        );
        descriptionLabel.setStyle("-fx-font-size: 14px; -fx-font-style: italic;");

        // Section for main navigation buttons
        VBox mainButtonsBox = new VBox(12);
        mainButtonsBox.setAlignment(Pos.CENTER);
        mainButtonsBox.setPadding(new Insets(20, 0, 20, 0));

        // Navigate to Review Page
        Button reviewPageButton = new Button("Review Page");
        reviewPageButton.setStyle("-fx-font-size: 14px;");
        reviewPageButton.setPrefWidth(250);
        reviewPageButton.setPrefHeight(40);
        reviewPageButton.setOnAction(e -> new ReviewPage(databaseHelper, user).show(primaryStage));

        // Navigate to Q&A Home Page
        Button qaButton = new Button("Q & A Page");
        qaButton.setStyle("-fx-font-size: 14px;");
        qaButton.setPrefWidth(250);
        qaButton.setPrefHeight(40);
        qaButton.setOnAction(e -> new QAHomePage(databaseHelper, user).show(primaryStage));

        // Navigate to Approve/Deny Reviewer Requests
        Button approveDenyButton = new Button("Approve/Deny Reviewer Requests");
        approveDenyButton.setStyle("-fx-font-size: 14px;");
        approveDenyButton.setPrefWidth(250);
        approveDenyButton.setPrefHeight(40);
        approveDenyButton.setOnAction(e -> new InstructorApproveDenyPage(databaseHelper, user).show(primaryStage));

        // Add navigation buttons to layout
        mainButtonsBox.getChildren().addAll(reviewPageButton, qaButton, approveDenyButton);

        // Logout and Back buttons
        HBox bottomButtonsBox = new HBox(15);
        bottomButtonsBox.setAlignment(Pos.CENTER);
        bottomButtonsBox.setPadding(new Insets(10, 0, 0, 0));

        Button logoutButton = new Button("Logout");
        logoutButton.setPrefWidth(120);
        logoutButton.setOnAction(e -> new UserLoginPage(databaseHelper).show(primaryStage));

        Button backButton = new Button("Back");
        backButton.setPrefWidth(120);
        backButton.setOnAction(e -> new WelcomeLoginPage(databaseHelper).show(primaryStage, user));

        bottomButtonsBox.getChildren().addAll(logoutButton, backButton);

        // Compose full page layout
        layout.getChildren().addAll(userLabel, descriptionLabel, mainButtonsBox, bottomButtonsBox);

        Scene instructorScene = new Scene(layout, 800, 500);
        primaryStage.setScene(instructorScene);
        primaryStage.setTitle("Instructor Home Page");
        primaryStage.show();
    }
}
