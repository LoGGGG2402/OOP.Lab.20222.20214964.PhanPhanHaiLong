package OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.media;

public abstract class Disc extends Media implements Playable{
    int length;
    String director;

    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public Disc() {
        super();
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
    }

    public Disc(String director, String category, String title, int length, float cost) {
        setTitle(title);
        setCategory(category);
        this.director = director;
        this.length = length;
        setCost(cost);
    }


}
