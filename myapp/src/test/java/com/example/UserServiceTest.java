
package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void ユーザーが存在する場合_歓迎メッセージが返る() {
        // モックを作成(要件2)
        UserRepository mockRepo = mock(UserRepository.class);

        // スタブ定義(要件3)
        when(mockRepo.existsById(100L)).thenReturn(true);
        when(mockRepo.getUsernameById(100L)).thenReturn("ミリー");

        UserService service = new UserService(mockRepo);

        String result = service.buildGreeting(100L);

        // 結果の検証(要件4)
        assertEquals("ようこそ、ミリー さん！", result);

        // 呼び出しの検証
        verify(mockRepo, times(1)).existsById(100L);
        verify(mockRepo, times(1)).getUsernameById(100L);
    }

    @Test
    void ユーザーが存在しない場合_エラーメッセージが返る() {
        UserRepository mockRepo = mock(UserRepository.class);

        when(mockRepo.existsById(999L)).thenReturn(false);

        UserService service = new UserService(mockRepo);
        String result = service.buildGreeting(999L);

        assertEquals("ユーザーが見つかりません", result);

        verify(mockRepo, never()).getUsernameById(anyLong());
    }
}