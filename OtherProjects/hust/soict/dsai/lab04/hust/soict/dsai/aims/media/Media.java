package OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.media;

import OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.compare.MediaComparatorByCostTitle;
import OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.compare.MediaComparatorByTitleCost;

import java.util.Comparator;

public abstract class Media{

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;
    public Media() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Media media) {
            return media.getTitle().equals(this.getTitle());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }
}
