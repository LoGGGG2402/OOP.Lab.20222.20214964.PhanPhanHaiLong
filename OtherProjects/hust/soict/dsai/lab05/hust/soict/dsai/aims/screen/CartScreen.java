package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

public class CartScreen extends JFrame {

    public CartScreen(Cart cart, StoreScreen storeScreen) {
        super();

        JFXPanel panel = new JFXPanel();


        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));


                    loader.setController(new CartScreenController(cart,CartScreen.this, storeScreen));

                    Parent root = loader.load();


                    panel.setScene(new Scene(root));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        add(panel);

        setTitle("Cart");
        setVisible(true);
        pack();
    }
}
