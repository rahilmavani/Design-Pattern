package Prototype.Deep;
//Deep CLone
import java.util.ArrayList;
import java.util.List;

public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.setShopName("Inkwell");
        bs.loadData();

        BookShop bs1 = bs.clone();
        bs1.setShopName("NewStore");
        bs1.loadData();
        bs.getBooks().remove(2);
        System.out.println(bs);
        System.out.println(bs1);
    }
}

class Book {
    private int bid;
    private String bname;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                '}';
    }
}

class BookShop implements  Cloneable{
    private String shopName;
    List<Book> books = new ArrayList<>();

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadData() {
        for(int i = 0; i <= 10; i++) {
            Book b = new Book();
            b.setBid(i);
            b.setBname("Book " + i);
            getBooks().add(b);
        }

    }
    @Override
    public String toString() {
        return "BookShop{" +
                "shopName='" + shopName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        BookShop shop = new BookShop();
        for(Book b: this.getBooks()) {
            shop.getBooks().add(b);
        }
        return shop;

    }
}