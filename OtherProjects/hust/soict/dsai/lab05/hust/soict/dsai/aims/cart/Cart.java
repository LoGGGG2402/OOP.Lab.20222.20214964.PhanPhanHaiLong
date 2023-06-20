package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.cart;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.DigitalVideoDisc;
import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final ArrayList<Media> itemsOrdered = new ArrayList<>(MAX_NUMBERS_ORDERED);


    public float totalCost() {
        float total = 0;
        for (Media item : itemsOrdered) total += item.getCost();
        return total;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (itemsOrdered.contains(media)) {
                System.out.println("The media is already in the cart");
                return;
            }
            itemsOrdered.add(media);
            itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.size() > 0) {
            if (!itemsOrdered.contains(media)) {
                System.out.println("The media is not in the cart");
                return;
            }
            itemsOrdered.remove(media);
        } else {
            System.out.println("The cart is empty");
        }
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println(i + 1 + itemsOrdered.get(i).getClass().getSimpleName() + " - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCategory() + " - " + itemsOrdered.get(i).getCost());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public DigitalVideoDisc search(String title) {
        for (Media item : itemsOrdered) {
            if (item instanceof DigitalVideoDisc dvd) {
                if (dvd.getTitle().equals(title)) {
                    return dvd;
                }
            }
        }
        return null;
    }

    public void filterMediaByTitle(String title) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getTitle().contains(title)) {
                System.out.println(item.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found");
        }
    }

    public void filterMediaById(int id) {
        boolean found = false;
        for (Media item : itemsOrdered) {
            if (item.getId() == id) {
                System.out.println(item.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media found");
        }
    }

    public void sortByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void placeOrder() {
        if (itemsOrdered.size() > 0) {
            System.out.println("Order placed");
            itemsOrdered.clear();
        } else {
            System.out.println("The cart is empty");
        }
    }

}
