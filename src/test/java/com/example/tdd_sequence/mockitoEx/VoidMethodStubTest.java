package com.example.tdd_sequence.mockitoEx;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.willThrow;

public class VoidMethodStubTest {
    @DisplayName("")
    @Test
    void voidMethodWillThrowTest(){
        List<String> mockList = Mockito.mock(List.class);

        willThrow(UnsupportedOperationException.class)   // BDDMockito.willThrow(발생할익셉션타입 또는 익셉션객체)
                .given(mockList)                         // 모의객체의 메서드 실행이 아닌 모의객체를 받아 --> 인자로전달받은 모의객체 자신을 리턴하면서 익셉션을 발생할 메서드를 호출한다.
                .clear();

        assertThrows(UnsupportedOperationException.class, () -> mockList.clear());
    }
}
