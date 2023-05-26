package OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.media;

public abstract class Media implements Playable{
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
        return super.toString();
    }
}
