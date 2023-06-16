package OtherProjects.hust.soict.dsai.lab04.hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        // TODO Auto-generated constructor stub
    }

    public void addAuthor(String authorName) {
        authors.add(authorName);
    }

    public void removeAuthor(String authorName) {
        authors.remove(authorName);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                ", authors=" + authors +
                '}';
    }
}
