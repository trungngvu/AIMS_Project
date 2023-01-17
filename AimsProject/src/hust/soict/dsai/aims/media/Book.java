package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private static int nbBooks = 0;
    private List<String> authors = new ArrayList<String>();

    public Book() {
        this.setId(++nbBooks);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
        this.setId(++nbBooks);
    }

    public Book(String title, String category, float cost, String ...authors) {
        super(title, category, cost);
        for (String authorName: authors){
            this.addAuthor(authorName);
        }
        this.setId(++nbBooks);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!this.authors.contains(authorName)) {
            this.authors.add(authorName);
            System.out.println("Add author successful!");
        } else {
            System.out.println("This author has already existed!");
        }
    }

    public void removeAuthor(String authorName) {
        if (!this.authors.contains(authorName)) {
            System.out.println("The author is not existed!");
        } else {
            if (this.authors.remove(authorName)) {
                System.out.println("Delete successful!");
            } else {
                System.out.println("Delete failed!");
            }
        }
    }

    public String toString() {
        StringBuffer allAuthor = new StringBuffer(1000);
        for (int i = 0; i < authors.size(); ++i) {
            if (i != authors.size() - 1) {
                allAuthor.append(authors.get(i) + ", ");
            } else {
                allAuthor.append(authors.get(i));
            }
        }
        return "Book: " +
                this.getId() + " | " +
                "authors - " + allAuthor + " | " +
                "title - " + this.getTitle() + " | " +
                "category - " + this.getCategory() + " | " +
                "cost - " + this.getCost() +
                "$.";
    }
}