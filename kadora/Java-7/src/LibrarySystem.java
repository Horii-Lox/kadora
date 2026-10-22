package kadora;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;



class Book {
    private String title;
    private String author;

    public Book(String title,String author){
        this.title = title;
        this.author = author;
    }
    
    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    @Override 
    public String toString(){
        return "タイトル: " + title + " / 著者: " + author;
    }
}

public class LibrarySystem {
    
    public List<Book> books = new ArrayList<>();

    public void addBook(String title,String author){
        books.add(new Book(title,author));
    }
    
    public void allBooks(){
        System.out.println("蔵書一覧");

        for(int i = 0; i < books.size(); i++){
            System.out.println(( i + 1 ) + ". " + books.get(i));
        }
    }

    public void saveToCsv(String filename){
        try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename),StandardCharsets.UTF_8)){
            writer.write("タイトル,著者");
            writer.newLine();
            for(Book book : books){
                writer.write(escape(book.getTitle()) + "," + escape(book.getAuthor()));

                writer.newLine();
            }
            System.out.println("CSVを保存しました: " + filename);
        }catch(IOException e){
            System.err.println("CSV保存に失敗しました: " + e.getMessage());
        }
    }
    private String escape(String value) {
    if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
    return value;
}
}


class Main {
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

