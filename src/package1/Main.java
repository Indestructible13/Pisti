package package1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private static Player player = new Player(0);
    private static Player cpu = new Player(1);

    private Pane root = new Pane();
    public static FlowPane cpuCards = new FlowPane();
    private static FlowPane playerCards = new FlowPane();
    public static StackPane pile = new StackPane();

    private Label cpuScoreLabel = new Label("CPU Score:\n" + cpu.getScore());
    private Label playerScoreLabel = new Label("Player Score:\n" + player.getScore());
    private Label cpuWinsLabel = new Label("CPU Wins!");
    private Label playerWinsLabel = new Label("You Win!");

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create deck
        Deck.randomizeDeck();

        // Window design
        ImageView ivBackground = new ImageView(new Image("table background.jpg"));
        ivBackground.fitWidthProperty().bind(root.widthProperty());
        ivBackground.fitHeightProperty().bind(root.heightProperty());
        Deck.backOfCard.setFitWidth(80);
        Deck.backOfCard.setFitHeight(100);

        playerCards.layoutXProperty().bind(root.widthProperty().subtract(playerCards.widthProperty()).divide(1.7));
        playerCards.layoutYProperty().bind(root.heightProperty().subtract(110));
        cpuCards.layoutXProperty().bind(root.widthProperty().subtract(cpuCards.widthProperty()).divide(1.7));
        cpuCards.setLayoutY(10);

        pile.layoutXProperty().bind(root.widthProperty().subtract(pile.widthProperty().multiply(2.4)).divide(1.7));
        pile.layoutYProperty().bind(root.heightProperty().divide(2.6));

        // Labels
        cpuScoreLabel.setFont(Font.font("Broadway", 24));
        cpuScoreLabel.setTextFill(Color.WHITE);
        cpuScoreLabel.layoutXProperty().bind(root.widthProperty().subtract(200));
        cpuScoreLabel.setLayoutY(10);
        playerScoreLabel.setFont(Font.font("Broadway", 24));
        playerScoreLabel.setTextFill(Color.WHITE);
        playerScoreLabel.setLayoutX(40);
        playerScoreLabel.layoutYProperty().bind(root.heightProperty().subtract(100));
        cpuWinsLabel.setFont(Font.font("Broadway", 72));
        cpuWinsLabel.setTextFill(Color.WHITE);
        cpuWinsLabel.layoutXProperty().bind(root.widthProperty().subtract(cpuWinsLabel.widthProperty()).divide(2));
        cpuWinsLabel.layoutYProperty().bind(root.heightProperty().subtract(cpuWinsLabel.heightProperty()).divide(2));
        playerWinsLabel.setFont(Font.font("Broadway", 72));
        playerWinsLabel.setTextFill(Color.WHITE);
        playerWinsLabel.layoutXProperty().bind(root.widthProperty().subtract(playerWinsLabel.widthProperty()).divide(2));
        playerWinsLabel.layoutYProperty().bind(root.heightProperty().subtract(playerWinsLabel.heightProperty()).divide(2));

        // Start game
        setupGame();

        // Card click functionality
        clickCardEvent(0);
        clickCardEvent(1);
        clickCardEvent(2);
        clickCardEvent(3);

        // Testing
        System.out.println("\nPile:\n");
        Pile.printPile();
        System.out.println("\nPlayer hand:\n");
        player.printHand();
        System.out.println("\nCPU hand:\n");
        cpu.printHand();

        // getChildren
        root.getChildren().addAll(ivBackground, playerCards, cpuCards, pile, cpuScoreLabel, playerScoreLabel);

        primaryStage.setTitle("Pisti");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show(); }

    public void setupGame() {
        if (Deck.randomDeck.get(Deck.randomDeck.size() - 4).value == 11) {
            Deck.randomizeDeck();
            setupGame(); }

        else {
            for (int i = Deck.randomDeck.size() - 1; i > 47; i--) {
                Pile.addCardToPile(i);
                Deck.randomDeck.remove(i); }

            dealHand();

            for (int i = 0; i < player.hand.size(); i++)
                playerCards.getChildren().add(Deck.returnImage(player.hand.get(i).toString()));
            for (int i = 0; i < cpu.hand.size(); i++)
                cpuCards.getChildren().addAll(new ImageView("back of card.png"));
            pile.getChildren().add(Deck.returnImage(Pile.cardsOnPile.get(Pile.cardsOnPile.size() - 1).toString())); }}

    public void dealHand() {
        int size = Deck.randomDeck.size();
        for (int i = size - 1; i > size - 9; i--) {
            if (i%2 == 0)
                player.addCardToHand(i);

            else
                cpu.addCardToHand(i);
            Deck.randomDeck.remove(i); }}

    public void cpuPlayTurn(){

        if(Pile.cardsOnPile.size() == 0)
            cpu.playCard(cpu.hand.get(0).toString(), 1);

        else if (Pile.cardsOnPile.size() > 0){
            for (int i = 0; i < cpu.hand.size(); i++) {
                if (cpu.hand.get(i).value != (Pile.cardsOnPile.get(Pile.cardsOnPile.size() - 1)).value){
                    cpu.playCard(cpu.hand.get(0).toString(),1);
                    break; }
                if (cpu.hand.get(i).value == (Pile.cardsOnPile.get(Pile.cardsOnPile.size() - 1)).value) {
                    cpu.playCard(cpu.hand.get(i).toString(),1);
                    i= cpu.hand.size(); } }}

        System.out.println("I am cpu"); }

    public void dealCardsUpdateVisual() {
        for (int i = 0; i < 4; i++) {
            playerCards.getChildren().add(Deck.returnImage(player.hand.get(i).toString()));
            cpuCards.getChildren().addAll(new ImageView("back of card.png")); }}

    public void clickCardEvent(int index) {
        Deck.returnImage(player.hand.get(index).toString()).setOnMouseClicked(e -> {
            try {
                player.playCard(player.getCardFromId(((ImageView) e.getSource()).getId()).toString(), 0);

                // CPU's turn
                cpuPlayTurn();

                // End Game
                if (Deck.randomDeck.isEmpty() && cpu.hand.isEmpty()) {
                    if (Player.getLastCapture()) {
                        player.addScore();
                    } else {
                        cpu.addScore();
                    }
                    Pile.cardsOnPile.clear();
                    pile.getChildren().clear();

                    // Compare cards won
                    if (player.getNumberOfCardsWon() > cpu.getNumberOfCardsWon())
                        player.setScore(player.getScore() + 3);
                    else
                        cpu.setScore(cpu.getScore() + 3);

                    // Compare scores
                    if (player.getScore() > cpu.getScore())
                        root.getChildren().add(playerWinsLabel);
                    else
                        root.getChildren().add(cpuWinsLabel); }

                // Deal new hand if hand is empty
                if (player.hand.isEmpty() && cpu.hand.isEmpty() && !Deck.randomDeck.isEmpty()) {
                    try {
                        dealHand();
                        dealCardsUpdateVisual();

                        clickCardEvent(0);
                        clickCardEvent(1);
                        clickCardEvent(2);
                        clickCardEvent(3); }

                    catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("There are no more cards in the deck!"); }}

                cpuScoreLabel.setText("CPU Score:\n" + cpu.getScore());
                playerScoreLabel.setText("Player Score:\n" + player.getScore());

                // Test
                System.out.println("\nPile:\n");
                Pile.printPile();
                System.out.println("\nPlayer hand:\n");
                player.printHand();
                System.out.println("\nCPU hand:\n");
                cpu.printHand();
                System.out.println("\nRemaining cards in deck: " + Deck.randomDeck.size()); }

            catch (NullPointerException n) {
                n.printStackTrace();
            }
        });
    }
}
