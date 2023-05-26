package OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.store;

import AimsProject.hust.soict.dsai.aims.disc.DigitalVideoDisc;
import OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

}
