package OtherProjects.hust.soict.dsai.lab05.hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    String artist;

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(){
        super();
    }
    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title) {
        super(title);
    }

    public CompactDisc(String category, String title) {
        super(category, title);
    }

    public CompactDisc(String director, String category, String title) {
        super(director, category, title);
    }

    public CompactDisc(String director, String category, String title, int length) {
        super(director, category, title, length);
    }

    public CompactDisc(String director, String category, String title, int length, float cost) {
        super(director, category, title, length, cost);
    }

    public CompactDisc(String director, String category, String title, int length, float cost, String artist) {
        super(director, category, title, length, cost);
        this.artist = artist;
    }

    public void addTrack(Track track){
        if(tracks.contains(track)){
            System.out.println("Track is already in the list");
        }
        else{
            tracks.add(track);
            System.out.println("Track added");
        }
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Track removed");
        }
        else{
            System.out.println("Track is not in the list");
        }
    }

    public int getLength(){
        return tracks.size();
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for(Track track : tracks){
            track.play();
        }
    }

    public boolean equals(Object obj){
        if(obj instanceof CompactDisc cd){
            if(cd.getLength() != this.getLength()){
                return false;
            }
            for (Track track : tracks) {
                if(!cd.tracks.contains(track)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CompactDisc{" +
                "artist='" + artist + '\'' +
                ", tracks=" + tracks +
                ", director='" + director + '\'' +
                ", category='" + getCategory() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", length=" + length +
                ", cost=" + getCost() +
                '}';
    }
}
