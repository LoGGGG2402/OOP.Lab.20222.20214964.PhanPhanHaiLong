package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart.Cart;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.*;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private final Store store;
    private final Cart cart;
    private final JFrame cartScreen;


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
        smUpdateStore.add(new JMenuItem("Add Book")
        {
            {
                addActionListener(e -> {
                    JFrame frame = new JFrame();
                    frame.setLayout(new GridLayout(4, 2));
                    frame.setSize(500, 300);
                    frame.setVisible(true);

                    frame.add(new JLabel("Title"));
                    JTextField title = new JTextField();
                    frame.add(title);

                    frame.add(new JLabel("Category"));
                    JTextField category = new JTextField();
                    frame.add(category);

                    frame.add(new JLabel("Cost"));
                    JTextField cost = new JTextField();
                    frame.add(cost);

                    frame.add(new JLabel("Authors (separated by comma)"));
                    JTextField authors = new JTextField();
                    frame.add(authors);

                    frame.add(new JButton("Add")
                    {
                        {
                            addActionListener(e -> {
                                String[] authorsArray = authors.getText().split(",");
                                Book book = new Book(title.getText(), category.getText(), Float.parseFloat(cost.getText()), authorsArray[0]);
                                for (int i = 1; i < authorsArray.length; i++) {
                                    book.addAuthor(authorsArray[i]);
                                }
                                store.addMedia(book);
                                frame.dispose();
                                reloadCenter();
                            });
                        }
                    });

                });
            }
        });
        smUpdateStore.add(new JMenuItem("Add CD")
        {
            {
                addActionListener(e -> {
                    JFrame frame = new JFrame();
                    frame.setLayout(new GridLayout(4, 2));
                    frame.setSize(500, 300);
                    frame.setVisible(true);

                    frame.add(new JLabel("Director"));
                    JTextField director = new JTextField();
                    frame.add(director);

                    frame.add(new JLabel("Category"));
                    JTextField category = new JTextField();
                    frame.add(category);

                    frame.add(new JLabel("Title"));
                    JTextField title = new JTextField();
                    frame.add(title);

                    frame.add(new JLabel("Length"));
                    JTextField length = new JTextField();
                    frame.add(length);

                    frame.add(new JLabel("Cost"));
                    JTextField cost = new JTextField();
                    frame.add(cost);

                    frame.add(new JLabel("Artists"));
                    JTextField artists = new JTextField();
                    frame.add(artists);

                    frame.add(new JButton("Add")
                    {
                        {
                            addActionListener(e -> {
                                if (artists.getText().isEmpty())
                                    store.addMedia(new CompactDisc(director.getText(), title.getText(), category.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText())));
                                else {
                                    store.addMedia(new CompactDisc(director.getText(), title.getText(), category.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText()), artists.getText()));
                                }
                                frame.dispose();
                                reloadCenter();
                            });
                        }
                    });

                });
            }
        });
        smUpdateStore.add(new JMenuItem("Add DVD")
        {
            {
                addActionListener(e -> {
                    JFrame frame = new JFrame();
                    frame.setLayout(new GridLayout(4, 2));
                    frame.setSize(500, 300);
                    frame.setVisible(true);

                    frame.add(new JLabel("Director"));
                    JTextField director = new JTextField();
                    frame.add(director);

                    frame.add(new JLabel("Category"));
                    JTextField category = new JTextField();
                    frame.add(category);

                    frame.add(new JLabel("Title"));
                    JTextField title = new JTextField();
                    frame.add(title);

                    frame.add(new JLabel("Length"));
                    JTextField length = new JTextField();
                    frame.add(length);

                    frame.add(new JLabel("Cost"));
                    JTextField cost = new JTextField();
                    frame.add(cost);

                    frame.add(new JButton("Add")
                    {
                        {
                            addActionListener(e -> {
                                store.addMedia(new DigitalVideoDisc(director.getText(), title.getText(), category.getText(), Integer.parseInt(length.getText()), Float.parseFloat(cost.getText())));
                                frame.dispose();
                                reloadCenter();
                            });
                        }
                    });

                });
            }
        });

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View Store"));
        menu.add(new JMenuItem("View Cart"){
            {
                addActionListener(e -> viewCart());
            }
        });

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

        JButton cart = new JButton("View cart")
        {
            {
                addActionListener(e -> viewCart());
            }
        };
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

            Container container = new Container();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));
            container.add(new Button("Add to cart"){
                {
                    addActionListener(e -> {
                        if (!cart.getItemsOrdered().contains(media))
                            cart.addMedia(media);
                        else {
                            JOptionPane.showMessageDialog(null, "Media already in cart");
                        }
                    });
                }

            });
            container.add(new Button("Remove from cart"){
                {
                    addActionListener(e -> {
                        if (cart.getItemsOrdered().contains(media))
                            cart.removeMedia(media);
                        else {
                            JOptionPane.showMessageDialog(null, "Media not in cart");
                        }
                    });
                }

            });

            if (media instanceof Playable){
                container.add(new Button("Play"){
                    {
                        addActionListener(e -> {
                            if (media instanceof DigitalVideoDisc) {
                                JFrame frame = new JFrame();
                                frame.setLayout(new BorderLayout());
                                frame.add(new JLabel("Playing DVD"), BorderLayout.NORTH);
                                frame.add(new JLabel(media.getTitle()), BorderLayout.CENTER);
                                frame.add(new JLabel("Length: " + ((DigitalVideoDisc) media).getLength()), BorderLayout.SOUTH);
                                frame.setVisible(true);
                                frame.pack();
                                frame.setLocationRelativeTo(null);
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            } else if (media instanceof CompactDisc) {
                                JFrame frame = new JFrame();
                                frame.setLayout(new BorderLayout());
                                frame.add(new JLabel("Playing CD"), BorderLayout.NORTH);
                                frame.add(new JLabel(media.getTitle()), BorderLayout.CENTER);
                                frame.add(new JLabel("Length: " + ((CompactDisc) media).getLength()), BorderLayout.SOUTH);
                                for (Track track : ((CompactDisc) media).getTracks()) {
                                    frame.add(new JLabel(track.getTitle() + " - " + track.getLength()), BorderLayout.SOUTH);
                                }
                                frame.setVisible(true);
                                frame.pack();
                                frame.setLocationRelativeTo(null);
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            }
                        });
                    }
                });
            }

            cell.add(container);
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
        cartScreen = new CartScreen(cart, StoreScreen.this);
        cartScreen.setSize(1024, 768);
        cartScreen.setLocationRelativeTo(null);
        cartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cartScreen.setVisible(false);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(crateCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    void reloadCenter() {
        getContentPane().removeAll();
        getContentPane().add(createNorth(), BorderLayout.NORTH);
        getContentPane().add(crateCenter(), BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void viewCart() {
        setVisible(false);
        cartScreen.setVisible(true);
    }



}
