package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart.Cart;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;

import static javafx.application.Platform.runLater;

public class CartScreenController {

    private final Cart cart;
    private final JFrame cartScreen;
    private final StoreScreen storeScreen;

    @FXML
    private Label total;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private RadioButton btnFilterId;

    @FXML
    private RadioButton btnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, String> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    public CartScreenController(Cart cart, JFrame cartScreen, StoreScreen storeScreen) {
        this.cartScreen = cartScreen;
        this.storeScreen = storeScreen;
        this.cart = cart;
    }

    @FXML
    void viewStore(ActionEvent event) {
        cartScreen.setVisible(false);
        storeScreen.setVisible(true);
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        tblMedia.setItems(cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldMedia, newMedia) -> {
                    if (newMedia != null) {
                        btnPlay.setVisible(newMedia instanceof Playable);
                        btnRemove.setVisible(true);
                    } else {
                        btnPlay.setVisible(false);
                        btnRemove.setVisible(false);
                    }
                }
        );

        tfFilter.textProperty().addListener((observableValue, oldText, newText) -> {
            if (btnFilterId.isSelected()) {
                if (newText.isEmpty()) {
                    tblMedia.setItems(cart.getItemsOrdered());
                    return;
                }
                tblMedia.setItems(cart.filterById(newText));
            } else if (btnFilterTitle.isSelected()) {
                if (newText.isEmpty()) {
                    tblMedia.setItems(cart.getItemsOrdered());
                    return;
                }
                tblMedia.setItems(cart.filterByTitle(newText));
            }

        });

        total.setText(cart.totalCost() + " $");

        // update total cost when cart is changed
        cart.getItemsOrdered().addListener( (javafx.collections.ListChangeListener.Change<? extends Media> c) -> {
            runLater(() -> total.setText(cart.totalCost() + " $"));
        });


    }

    @FXML
    void btnRemovePressed(MouseEvent event) {
        cart.removeMedia(tblMedia.getSelectionModel().getSelectedItem());
    }

    @FXML
    void btnPlaceOrderMosePressed(MouseEvent event) {
        if (cart.getItemsOrdered().size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cart is empty");
            alert.setContentText("Please add some items to the cart");
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Order placed successfully");
        alert.showAndWait();
        cart.clear();
    }

    @FXML
    void btnPlayPressed(MouseEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof DigitalVideoDisc) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing DVD");
            alert.setHeaderText(media.getTitle());
            alert.setContentText("Length: " + ((DigitalVideoDisc) media).getLength());
            alert.showAndWait();
        } else if (media instanceof CompactDisc) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing CD");
            alert.setHeaderText(media.getTitle());
            alert.setContentText("Length: " + ((CompactDisc) media).getLength());
            for (Track track : ((CompactDisc) media).getTracks()) {
                alert.setContentText(alert.getContentText() + "\n" + track.getTitle() + ": " + track.getLength());
            }
            alert.showAndWait();
        }
    }


    @FXML
    void addDVD(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Add DVD");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label directorLabel = new Label("Director");
        TextField directorTextField = new TextField();

        Label categoryLabel = new Label("Category");
        TextField categoryTextField = new TextField();

        Label titleLabel = new Label("Title");
        TextField titleTextField = new TextField();

        Label lengthLabel = new Label("Length");
        TextField lengthTextField = new TextField();

        Label costLabel = new Label("Cost");
        TextField costTextField = new TextField();

        gridPane.addRow(0, directorLabel, directorTextField);
        gridPane.addRow(1, categoryLabel, categoryTextField);
        gridPane.addRow(2, titleLabel, titleTextField);
        gridPane.addRow(3, lengthLabel, lengthTextField);
        gridPane.addRow(4, costLabel, costTextField);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            storeScreen.addMedia(new DigitalVideoDisc(
                    directorTextField.getText(),
                    titleTextField.getText(),
                    categoryTextField.getText(),
                    Integer.parseInt(lengthTextField.getText()),
                    Float.parseFloat(costTextField.getText())
            ));
            stage.close();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(gridPane, addButton);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void addCD(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Add CD");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label directorLabel = new Label("Director");
        TextField directorTextField = new TextField();

        Label categoryLabel = new Label("Category");
        TextField categoryTextField = new TextField();

        Label titleLabel = new Label("Title");
        TextField titleTextField = new TextField();

        Label lengthLabel = new Label("Length");
        TextField lengthTextField = new TextField();

        Label costLabel = new Label("Cost");
        TextField costTextField = new TextField();

        Label artistsLabel = new Label("Artists");
        TextField artistsTextField = new TextField();

        gridPane.addRow(0, directorLabel, directorTextField);
        gridPane.addRow(1, categoryLabel, categoryTextField);
        gridPane.addRow(2, titleLabel, titleTextField);
        gridPane.addRow(3, lengthLabel, lengthTextField);
        gridPane.addRow(4, costLabel, costTextField);
        gridPane.addRow(5, artistsLabel, artistsTextField);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            CompactDisc cd;
            if (artistsTextField.getText().isEmpty()) {
                cd = new CompactDisc(
                        directorTextField.getText(),
                        titleTextField.getText(),
                        categoryTextField.getText(),
                        Integer.parseInt(lengthTextField.getText()),
                        Float.parseFloat(costTextField.getText())
                );
            } else {
                cd = new CompactDisc(
                        directorTextField.getText(),
                        titleTextField.getText(),
                        categoryTextField.getText(),
                        Integer.parseInt(lengthTextField.getText()),
                        Float.parseFloat(costTextField.getText()),
                        artistsTextField.getText()
                );
            }
            storeScreen.addMedia(cd);
            stage.close();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(gridPane, addButton);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void addBook(ActionEvent event) {
        Stage stage = new Stage();
        stage.setTitle("Add Book");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label titleLabel = new Label("Title");
        TextField titleTextField = new TextField();

        Label categoryLabel = new Label("Category");
        TextField categoryTextField = new TextField();

        Label costLabel = new Label("Cost");
        TextField costTextField = new TextField();

        Label authorsLabel = new Label("Authors (separated by comma)");
        TextField authorsTextField = new TextField();

        gridPane.addRow(0, titleLabel, titleTextField);
        gridPane.addRow(1, categoryLabel, categoryTextField);
        gridPane.addRow(2, costLabel, costTextField);
        gridPane.addRow(3, authorsLabel, authorsTextField);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            String[] authorsArray = authorsTextField.getText().split(",");
            Book book = new Book(titleTextField.getText(), categoryTextField.getText(), Float.parseFloat(costTextField.getText()), authorsArray[0]);
            for (int i = 1; i < authorsArray.length; i++) {
                book.addAuthor(authorsArray[i]);
            }
            storeScreen.addMedia(book);
            stage.close();
        });

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getChildren().addAll(gridPane, addButton);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }


}

