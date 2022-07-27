package com.example.tdd_sequence.mockitoEx;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class GameGenMockTest {
    @DisplayName("BDDMockito.given() 을 이용한 스텁설정")
    @Test
    void mockTest(){
        GameNumGen genMock = mock(GameNumGen.class);

        given(genMock.generate(GameLevel.EASY))  // 스텁을 정의할 모의객체의 메서드 호출을 전달 : genMock.generate(GameLevel.EASY)가 호출되면
                .willReturn("123");              // 스텁을 정의 메서드가 리턴할 값을 지정     : "123"을 리턴

        /*
        String num = genMock.generate(GameLevel.NORMAL);
        assertEquals("123",num);

        ============================================
        expected: <123> but was: <null>
        Expected :123
        Actual   :null
        ============================================
        Mockito는 스텁설정이 없을 경우, 리턴타입의 기본값을 리턴
        primitive type은 기본값 (int : 0, boolean : false)
        reference type은 null을 리턴
        */

        String num = genMock.generate(GameLevel.EASY);
        assertEquals("123",num); // 위에서 "123"을 리턴하라고 지정했으므로 PASS
        //assertEquals("12",num);  // FAIL

    }

    @DisplayName("특정타입의 익셉션을 발생하도록 스텁설정")
    @Test
    void mockThrowTest(){
        GameNumGen genMock = mock(GameNumGen.class);

        given(genMock.generate(null))
                .willThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> genMock.generate(null));
    }
}
