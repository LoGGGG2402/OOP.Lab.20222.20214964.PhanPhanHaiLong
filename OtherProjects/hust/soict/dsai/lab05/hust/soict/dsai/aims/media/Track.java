package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media;

public class Track implements Playable {
    String title;
    int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Track track) {
            return track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength();
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
