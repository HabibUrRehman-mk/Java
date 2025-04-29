class Librarian {
    private String name;
    private int empid;

    public Librarian(String name, int empid) {
        this.name = name;
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public void display() {
        System.out.println("The details of the librarian are:\nName: " + name + "\nEmployee ID: " + empid);
    }
}

class Resource {
    private String title;
    private String author;
    private String publicationyear;
    private Boolean available = Boolean.FALSE;
    private Librarian librarian;

    public Resource(String title, String author, String publicationyear, Librarian librarian) {
        this.title = title;
        this.author = author;
        this.publicationyear = publicationyear;
        this.librarian = librarian;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(String publicationyear) {
        this.publicationyear = publicationyear;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable() {
        available = !available;
    }

    public Librarian getLibrarian() {
        return librarian;
    }
}

class Book extends Resource {
    private int ISBN;

    public Book(String title, String author, String publicationyear, Librarian librarian) {
        super(title, author, publicationyear, librarian);
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void display() {
        System.out.println("The details of the book are:\nTitle: " + getTitle() + "\nAuthor: " + getAuthor() +
                "\nPublication Year: " + getPublicationyear() + "\nISBN: " + getISBN());
        System.out.println("The librarian is: " + getLibrarian().getName() + " (Employee ID: " + getLibrarian().getEmpid() + ")");
    }
}

class Dvd extends Resource {
    public Dvd(String title, String author, String publicationyear, Librarian librarian) {
        super(title, author, publicationyear, librarian);
    }

    public void play() {
        System.out.println("The DVD is playing.");
    }

    public void display() {
        System.out.println("The details of the DVD are:\nTitle: " + getTitle() + "\nAuthor: " + getAuthor() +
                "\nPublication Year: " + getPublicationyear());
        System.out.println("The librarian is: " + getLibrarian().getName() + " (Employee ID: " + getLibrarian().getEmpid() + ")");
    }
}

class Magazine extends Book {
    private int pages;

    public Magazine(String title, String author, String publicationyear, Librarian librarian) {
        super(title, author, publicationyear, librarian);
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void display() {
        System.out.println("The details of the magazine are:\nTitle: " + getTitle() + "\nAuthor: " + getAuthor() +
                "\nPublication Year: " + getPublicationyear() + "\nPages: " + getPages());
        System.out.println("The librarian is: " + getLibrarian().getName() + " (Employee ID: " + getLibrarian().getEmpid() + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        Librarian ahmad = new Librarian("MUZAMMIL", 2346);
        Book b1 = new Book("Intro to OOP", "Mikey", "23/09/2003", ahmad);
        b1.setISBN(123456);
        b1.display();
        Dvd d1=new Dvd("Pasoori","Ali Sethi","2020",ahmad);
        d1.play();
        d1.display();
    }
}
