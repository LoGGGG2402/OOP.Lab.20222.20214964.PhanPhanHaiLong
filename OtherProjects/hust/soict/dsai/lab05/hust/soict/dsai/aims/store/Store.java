package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.store;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private final ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media is already in the store");
            return;
        }
        itemsInStore.add(media);
        itemsInStore.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void removeMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            System.out.println("The media is not in the store");
            return;
        }
        itemsInStore.remove(media);
    }

    public void showStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(i + 1 + itemsInStore.get(i).getClass().getSimpleName() + " - " + itemsInStore.get(i).getTitle() + " - " + itemsInStore.get(i).getCategory() + " - " + itemsInStore.get(i).getCost());
        }
        System.out.println("***************************************************");
    }

    public Media search(String title) {
        for (Media item : itemsInStore) {
            if (item.getTitle().equals(title)) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
