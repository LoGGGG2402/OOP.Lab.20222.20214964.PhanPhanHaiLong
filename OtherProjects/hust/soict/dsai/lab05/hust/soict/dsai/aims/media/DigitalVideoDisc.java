package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
    private String director;
    private int length;

    public DigitalVideoDisc() {
    }

    public DigitalVideoDisc(String title) {
        setTitle(title);
    }

    public DigitalVideoDisc(String category, String title) {
        setTitle(title);
        setCategory(category);
    }

    public DigitalVideoDisc(String director, String category, String title) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
    }

    public DigitalVideoDisc(String director, String category, String title, int length) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
    }

    public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
        setTitle(title);
        setCategory(category);
        setDirector(director);
        setLength(length);
        setCost(cost);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean equals(Object o) {
        if (o instanceof DigitalVideoDisc dvd) {
            return this.getTitle().equals(dvd.getTitle()) && this.getCategory().equals(dvd.getCategory())
                    && this.getDirector().equals(dvd.getDirector()) && this.getLength() == dvd.getLength()
                    && this.getCost() == dvd.getCost();
        }
        return false;
    }
}
