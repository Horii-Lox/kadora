import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// テスト対象の依存インターフェース
interface UserRepository {
    String getUsernameById(long id);
    boolean existsById(long id);
}

// テスト対象クラス
class UserService {
    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository; // コンストラクタでDI
    }

    public String buildGreeting(long userId) {
        if (!repository.existsById(userId)) {
            return "ユーザーが見つかりません";
        }
        String name = repository.getUsernameById(userId);
        return "ようこそ、" + name + " さん！";
    }
}

public class UserServiceTest {

    @Test
    void testBuildGreeting_ユーザーが存在する場合_歓迎メッセージが返る() {
        // 1. モック（ダミーオブジェクト）を作成
        UserRepository mockRepo = mock(UserRepository.class);

        // 2. スタブ定義：「existsById(100L) が呼ばれたら true を返す」
        when(mockRepo.existsById(100L)).thenReturn(true);
        // スタブ定義：「getUsernameById(100L) が呼ばれたら "ミリー" を返す」
        when(mockRepo.getUsernameById(100L)).thenReturn("ミリー");

        // 3. テスト対象を生成（モックを注入）
        UserService service = new UserService(mockRepo);

        // 4. テスト実行
        String result = service.buildGreeting(100L);

        // 5. 結果の検証
        assertEquals("ようこそ、ミリー さん！", result);

        // 6. モックのメソッドが正しく呼ばれたかを検証（verify）
        verify(mockRepo, times(1)).existsById(100L);     // existsById は1回呼ばれた？
        verify(mockRepo, times(1)).getUsernameById(100L); // getUsernameById は1回呼ばれた？
    }

    @Test
    void testBuildGreeting_ユーザーが存在しない場合_エラーメッセージが返る() {
        UserRepository mockRepo = mock(UserRepository.class);

        // 存在しないIDを想定
        when(mockRepo.existsById(999L)).thenReturn(false);

        UserService service = new UserService(mockRepo);
        String result = service.buildGreeting(999L);

        assertEquals("ユーザーが見つかりません", result);

        // ユーザーが存在しない場合、getUsernameById は呼ばれないはず
        verify(mockRepo, never()).getUsernameById(999L); // never() = 一度も呼ばれないことを検証
    }
}