package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart.Cart;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.swing.*;

public class CartScreen extends JFrame {

    public CartScreen(Cart cart, JFrame storeScreen) {
        super();

        JFXPanel panel = new JFXPanel();


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
                try {
                    System.out.println("load");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));

                    System.out.println(loader);

                    loader.setController(new CartScreenController(cart,CartScreen.this, storeScreen));

                    Parent root = loader.load();

                    System.out.println(root);

                    panel.setScene(new Scene(root));

                    System.out.println(panel);
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
