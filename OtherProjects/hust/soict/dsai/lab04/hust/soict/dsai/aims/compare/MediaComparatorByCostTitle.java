package OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.compare;

import OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int titleCompare = o1.getTitle().compareTo(o2.getTitle());
        if(titleCompare != 0) return titleCompare;
        return Float.compare(o1.getCost(), o2.getCost());
    }
}
