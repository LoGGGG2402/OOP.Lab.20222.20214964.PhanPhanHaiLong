package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.Aims;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart.Cart;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Book;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.CompactDisc;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.DigitalVideoDisc;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Track;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.screen.StoreScreen;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.store.Store;

public class Aims {
//    public static void showMenu() {
//        System.out.println("AIMS: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. View store");
//        System.out.println("2. Update store");
//        System.out.println("3. See current cart");
//        System.out.println("0. Exit");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: ");
//    }
//
//    public static void storeMenu(){
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. See a media's details");
//        System.out.println("2. Add a media to cart");
//        System.out.println("3. Play a media");
//        System.out.println("4. See current cart");
//        System.out.println("0. Exit");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: ");
//    }
//
//    public static void mediaDetailsMenu(){
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. Play");
//        System.out.println("2. Add to cart");
//        System.out.println("0. Exit");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: ");
//    }
//
//    public static void cartMenu(){
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. Filter media in cart");
//        System.out.println("2. Sort media in cart");
//        System.out.println("3. Play a media");
//        System.out.println("4. Place order");
//        System.out.println("5. Remove a media");
//        System.out.println("0. Exit");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: ");
//    }
//
//    public static void oldMain() {
//        Store store = new Store();
//        Cart cart = new Cart();
//        Scanner scanner = new Scanner(System.in);
//        int choice = 0;
//        do {
//            showMenu();
//            try {
//                choice = scanner.nextInt();
//            } catch (Exception e) {
//                System.out.println("Invalid choice");
//                continue;
//            }
//            switch (choice) {
//                case 1:
//                    store.showStore();
//                    storeMenu();
//                    int storeChoice = 0;
//                    do {
//                        try {
//                            storeChoice = scanner.nextInt();
//                        } catch (Exception e) {
//                            System.out.println("Invalid choice");
//                            continue;
//                        }
//                        switch (storeChoice) {
//                            case 1 -> {
//                                System.out.print("Enter title: ");
//                                String title = scanner.nextLine();
//                                Media media = store.search(title);
//                                System.out.println(media.toString());
//                                mediaDetailsMenu();
//                                int mediaDetailsChoice = 0;
//                                do {
//                                    try {
//                                        mediaDetailsChoice = scanner.nextInt();
//                                    } catch (Exception e) {
//                                        System.out.println("Invalid choice");
//                                        continue;
//                                    }
//                                    switch (mediaDetailsChoice) {
//                                        case 1:
//                                            cart.addMedia(media);
//                                            break;
//                                        case 2:
//                                            if (media instanceof Playable)
//                                                ((Playable) media).play();
//                                            else
//                                                System.out.println("This media is not playable");
//                                            break;
//                                        case 0:
//                                            break;
//                                        default:
//                                            System.out.println("Invalid choice");
//                                            break;
//                                    }
//                                } while (mediaDetailsChoice != 0);
//                            }
//                            case 2 -> {
//                                System.out.print("Enter title: ");
//                                String title1 = scanner.nextLine();
//                                Media media1 = store.search(title1);
//                                cart.addMedia(media1);
//                            }
//                            case 3 -> {
//                                System.out.print("Enter title: ");
//                                String title2 = scanner.nextLine();
//                                Media media2 = store.search(title2);
//                                if (media2 instanceof Playable)
//                                    ((Playable) media2).play();
//                                else
//                                    System.out.println("This media is not playable");
//                            }
//                            case 4 -> cart.printCart();
//                        }
//                    } while (storeChoice != 0);
//                    break;
//                case 2:
//
//                case 3:
//                    cart.printCart();
//                    cartMenu();
//                    int cartChoice = 0;
//                    do {
//                        try {
//                            cartChoice = scanner.nextInt();
//                        } catch (Exception e) {
//                            System.out.println("Invalid choice");
//                            continue;
//                        }
//
//                        switch (cartChoice){
//                            case 1:
//                                System.out.println("Filter by: ");
//                                System.out.println("--------------------------------");
//                                System.out.println("1. Filter by title");
//                                System.out.println("2. Filter by Id");
//                                System.out.println("0. Exit");
//                                System.out.println("--------------------------------");
//                                System.out.print("Please choose a number: ");
//                                int filterChoice = 0;
//                                do {
//                                    try {
//                                        filterChoice = scanner.nextInt();
//                                    } catch (Exception e) {
//                                        System.out.println("Invalid choice");
//                                        continue;
//                                    }
//                                    switch (filterChoice){
//                                        case 1:
//                                            System.out.print("Enter title: ");
//                                            String title = scanner.nextLine();
//                                            cart.filterMediaByTitle(title);
//                                            break;
//                                        case 2:
//                                            System.out.print("Enter Id: ");
//                                            int Id = scanner.nextInt();
//                                            cart.filterMediaById(Id);
//                                            break;
//                                        case 0:
//                                            break;
//                                        default:
//                                            System.out.println("Invalid choice");
//                                            break;
//                                    }
//                                }while (filterChoice != 0);
//                                break;
//                            case 2:
//                                System.out.println("Sort by: ");
//                                System.out.println("--------------------------------");
//                                System.out.println("1. Sort by title");
//                                System.out.println("2. Sort by cost");
//                                System.out.println("0. Exit");
//                                System.out.println("--------------------------------");
//                                System.out.print("Please choose a number: ");
//                                int sortChoice = 0;
//                                do {
//                                    try {
//                                        sortChoice = scanner.nextInt();
//                                    } catch (Exception e) {
//                                        System.out.println("Invalid choice");
//                                        continue;
//                                    }
//                                    switch (sortChoice){
//                                        case 1:
//                                            cart.sortByTitle();
//                                            break;
//                                        case 2:
//                                            cart.sortByCost();
//                                            break;
//                                        case 0:
//                                            break;
//                                        default:
//                                            System.out.println("Invalid choice");
//                                            break;
//                                    }
//                                }while (sortChoice != 0);
//                                break;
//                            case 3:
//                                System.out.print("Enter title: ");
//                                String title = scanner.nextLine();
//
//                                Media media = cart.search(title);
//                                if (media != null)
//                                    ((Playable) media).play();
//                                else
//                                    System.out.println("This media is not playable");
//                                break;
//                            case 4:
//                                cart.placeOrder();
//                                break;
//                            case 5:
//                                System.out.print("Enter title: ");
//                                String title1 = scanner.nextLine();
//
//                                Media media1 = cart.search(title1);
//                                cart.removeMedia(media1);
//                                break;
//                            case 0:
//                                break;
//                            default:
//                                System.out.println("Invalid choice");
//                                break;
//                        }
//
//                    }while (cartChoice != 0);
//                    break;
//                case 0:
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//                    break;
//            }
//        } while (choice != 0);
//    }

    public static void main(String[] args) {
        Store store = new Store();


        Book book1 = new Book("The Lion King", "Animation", 19.95f, "Roger Allers");
        Book book2 = new Book("Star Wars", "Science Fiction", 24.95f, "George Lucas");
        Book book3 = new Book("Aladdin", "Animation", 18.99f, "John Musker");

        // directory/category/title/length/cost
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King1", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wa1rs", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alad11din", "Animation", "John Musker", 90, 18.99f);

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        CompactDisc cd2 = new CompactDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        CompactDisc cd3 = new CompactDisc("Aladdin", "Animation", "Jo111usker", 90, 18.99f);
        cd3.addTrack(new Track("Track 1", 4));
        cd3.addTrack(new Track("Track 2", 5));
        cd3.addTrack(new Track("Track 3", 6));
        cd3.addTrack(new Track("Track 4", 7));

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);

        new StoreScreen(store, new Cart());
    }
}
