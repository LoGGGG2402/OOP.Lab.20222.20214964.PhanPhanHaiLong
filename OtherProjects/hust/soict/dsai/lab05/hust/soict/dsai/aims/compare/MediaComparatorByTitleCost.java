package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.compare;

import OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int costCompare = Float.compare(o1.getCost(), o2.getCost());
        if(costCompare != 0) return costCompare;
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
