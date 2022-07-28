package com.example.tdd_sequence.mockitoEx;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

public class AnyMatcherTest {

    @DisplayName("org.mockito.ArgumentMatchers.any() 메서드로 인자값 매칭 정리")
    @Test
    void anyMatchTest(){
        GameNumGen genMock = Mockito.mock(GameNumGen.class);
        given(genMock.generate(any())) // any()로 무슨 값이 들어오던 willReturn()에 지정한 값을 리턴하도록 함
                .willReturn("456");

        String num = genMock.generate(GameLevel.EASY); // EASY가 들어오던
        assertEquals("456",num);

        String num2 = genMock.generate(GameLevel.NORMAL); // NORMAL이 들어오던 똑같이 "456"을 리턴하는 mock객체를 리턴하는 것이다.
        assertEquals("456",num2);

    }

}
