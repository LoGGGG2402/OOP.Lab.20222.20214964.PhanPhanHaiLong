package OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable{
    String title;
    int length;

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
