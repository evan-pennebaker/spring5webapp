package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

//import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//import org.hibernate.annotations.ManyToAny;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    //0-arg constructor
    public Author() {

    }

    //constructor
    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
    //json like output
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName=" + firstName + '\'' +
                ", lastName=" + lastName + '\'' + 
                ", books=" + books +
                '}';
        
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id != null ? id.equals(author.id) : author.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    


}
