import org.junit.jupiter.api.*;
import org.example.DVD;
import org.example.Item;
import org.example.Book;
import org.example.Library;
import org.example.Patron;
public class TestLibrary {
    private Library library;
    private Book book;
    private Patron patron;
    private DVD dvd;
    @BeforeEach
    public void setUp(){
        library = new Library();
        book = new Book("Black Arrow", "B00001", "Robert Lewis Stevenson");
        dvd = new DVD("Cars", "D00001", 117);
        patron = new Patron("Lee Parker", "P00001");
    }
    @Test
    public void testAddItem(){
        library.addItem(book);
        library.addItem(dvd);
        Assertions.assertEquals(2, library.listAvailable().size());
    }
    @Test
    public void testRegisterPatron(){
        library.registerPatron(patron);
        Assertions.assertTrue(library.getPatrons().contains(patron));
    }
    @Test
    public void testLendAndReturnItem(){
        library.addItem(book);
        library.addItem(dvd);
        library.registerPatron(patron);

        library.lendItem(patron, book);
        Assertions.assertTrue(patron.getBorrowedItems().contains(book));
        Assertions.assertTrue(book.getIsBorrowed());

        library.returnItem(patron, book);
        Assertions.assertFalse(patron.getBorrowedItems().contains(book));
        Assertions.assertFalse(book.getIsBorrowed());
    }
    @Test
    public void testListAvailableItems(){
        library.addItem(book);
        library.addItem(dvd);
        Assertions.assertEquals(2, library.listAvailable().size());
    }
    @Test
    public void testListBorrowedItems(){
        library.addItem(book);
        library.addItem(dvd);
        library.registerPatron(patron);

        library.lendItem(patron, book);
        library.lendItem(patron, dvd);
        Assertions.assertEquals(2, patron.getBorrowedItems().size());
    }
}
