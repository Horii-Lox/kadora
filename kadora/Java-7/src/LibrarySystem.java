package kadora;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;

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
