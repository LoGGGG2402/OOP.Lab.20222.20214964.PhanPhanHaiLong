package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart.Cart;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.*;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;

import static javafx.application.Platform.runLater;

public class CartScreenController {

    private final Cart cart;
    private final JFrame cartScreen;
    private final JFrame storeScreen;

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

    public CartScreenController(Cart cart, JFrame cartScreen, JFrame storeScreen) {
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

}

