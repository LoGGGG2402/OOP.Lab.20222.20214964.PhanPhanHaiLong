package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media;

public abstract class Disc extends Media implements Playable {
    int length;
    String director;

    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public Disc() {
    }

    public Disc(String title) {
        setTitle(title);
    }

    public Disc(String category, String title) {
        setTitle(title);
        setCategory(category);
    }

    public Disc(String director, String category, String title) {
        setTitle(title);
        setCategory(category);
        this.director = director;
    }

    public Disc(String director, String category, String title, int length) {
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
    }

    public Disc(String director, String category, String title, int length, float cost) {
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
    }

    public Disc(String director, String category, String title, int length, float cost, int id) {
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
        setId(id);
    }

    @Override
    public String toString() {
        return "Disc{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                ", length=" + length +
                ", director='" + director + '\'' +
                '}';
    }


}
