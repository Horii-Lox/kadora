package kadora;

public class Main {
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();
        
        library.addBook("羅生門","芥川龍之介");
        library.addBook("君死に給うことなかれ","与謝野晶子");
        library.addBook("それから","夏目漱石");
        library.addBook("銀河鉄道の夜","宮沢賢治");

        library.allBooks();
        library.saveToCsv("BookCsv");
    }
}
