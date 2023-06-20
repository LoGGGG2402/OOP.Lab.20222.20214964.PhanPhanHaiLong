package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Book;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.CompactDisc;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.DigitalVideoDisc;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Media;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.store.Store;

import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private final Store store;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"));

        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel crateCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (Media media : mediaInStore) {
            MediaStore cell = new MediaStore(media);
            center.add(cell);
        }

        return center;
    }


    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(crateCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        Store store = new Store();


        Book book1 = new Book("The Lion King", "Animation", 19.95f, "Roger Allers");
        Book book2 = new Book("Star Wars", "Science Fiction", 24.95f, "George Lucas");
        Book book3 = new Book("Aladdin", "Animation", 18.99f, "John Musker");

        // directory/category/title/length/cost
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        CompactDisc cd2 = new CompactDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        CompactDisc cd3 = new CompactDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);





        new StoreScreen(store);
    }


}
