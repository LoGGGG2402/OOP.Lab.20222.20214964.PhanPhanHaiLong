package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.Aims;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart.Cart;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Media;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Playable;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void storeMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void mediaDetailsMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Play");
        System.out.println("2. Add to cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void cartMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Play a media");
        System.out.println("4. Place order");
        System.out.println("5. Remove a media");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            showMenu();
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice");
                continue;
            }
            switch (choice) {
                case 1:
                    store.showStore();
                    storeMenu();
                    int storeChoice = 0;
                    do {
                        try {
                            storeChoice = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid choice");
                            continue;
                        }
                        switch (storeChoice) {
                            case 1 -> {
                                System.out.print("Enter title: ");
                                String title = scanner.nextLine();
                                Media media = store.search(title);
                                System.out.println(media.toString());
                                mediaDetailsMenu();
                                int mediaDetailsChoice = 0;
                                do {
                                    try {
                                        mediaDetailsChoice = scanner.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Invalid choice");
                                        continue;
                                    }
                                    switch (mediaDetailsChoice) {
                                        case 1:
                                            cart.addMedia(media);
                                            break;
                                        case 2:
                                            if (media instanceof Playable)
                                                ((Playable) media).play();
                                            else
                                                System.out.println("This media is not playable");
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                } while (mediaDetailsChoice != 0);
                            }
                            case 2 -> {
                                System.out.print("Enter title: ");
                                String title1 = scanner.nextLine();
                                Media media1 = store.search(title1);
                                cart.addMedia(media1);
                            }
                            case 3 -> {
                                System.out.print("Enter title: ");
                                String title2 = scanner.nextLine();
                                Media media2 = store.search(title2);
                                if (media2 instanceof Playable)
                                    ((Playable) media2).play();
                                else
                                    System.out.println("This media is not playable");
                            }
                            case 4 -> cart.printCart();
                        }
                    } while (storeChoice != 0);
                    break;
                case 2:

                case 3:
                    cart.printCart();
                    cartMenu();
                    int cartChoice = 0;
                    do {
                        try {
                            cartChoice = scanner.nextInt();
                        } catch (Exception e) {
                            System.out.println("Invalid choice");
                            continue;
                        }

                        switch (cartChoice){
                            case 1:
                                System.out.println("Filter by: ");
                                System.out.println("--------------------------------");
                                System.out.println("1. Filter by title");
                                System.out.println("2. Filter by Id");
                                System.out.println("0. Exit");
                                System.out.println("--------------------------------");
                                System.out.print("Please choose a number: ");
                                int filterChoice = 0;
                                do {
                                    try {
                                        filterChoice = scanner.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Invalid choice");
                                        continue;
                                    }
                                    switch (filterChoice){
                                        case 1:
                                            System.out.print("Enter title: ");
                                            String title = scanner.nextLine();
                                            cart.filterMediaByTitle(title);
                                            break;
                                        case 2:
                                            System.out.print("Enter Id: ");
                                            int Id = scanner.nextInt();
                                            cart.filterMediaById(Id);
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }while (filterChoice != 0);
                                break;
                            case 2:
                                System.out.println("Sort by: ");
                                System.out.println("--------------------------------");
                                System.out.println("1. Sort by title");
                                System.out.println("2. Sort by cost");
                                System.out.println("0. Exit");
                                System.out.println("--------------------------------");
                                System.out.print("Please choose a number: ");
                                int sortChoice = 0;
                                do {
                                    try {
                                        sortChoice = scanner.nextInt();
                                    } catch (Exception e) {
                                        System.out.println("Invalid choice");
                                        continue;
                                    }
                                    switch (sortChoice){
                                        case 1:
                                            cart.sortByTitle();
                                            break;
                                        case 2:
                                            cart.sortByCost();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }while (sortChoice != 0);
                                break;
                            case 3:
                                System.out.print("Enter title: ");
                                String title = scanner.nextLine();

                                Media media = cart.search(title);
                                if (media instanceof Playable)
                                    ((Playable) media).play();
                                else
                                    System.out.println("This media is not playable");
                                break;
                            case 4:
                                cart.placeOrder();
                                break;
                            case 5:
                                System.out.print("Enter title: ");
                                String title1 = scanner.nextLine();

                                Media media1 = cart.search(title1);
                                cart.removeMedia(media1);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }

                    }while (cartChoice != 0);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
    }
}
