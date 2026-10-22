import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
            bw.write("こんにちわ");
            System.out.println("書き込み完了");
        }catch(IOException e){
            System.out.println("エラーが発生しました: " + e.getLocalizedMessage());
        }
    }
}
