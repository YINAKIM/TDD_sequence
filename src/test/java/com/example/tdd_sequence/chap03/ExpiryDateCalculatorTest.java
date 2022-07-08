package com.example.tdd_sequence.chap03;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {
    @Test
    void 만원_납부하면_한달뒤가_만료일이_됨(){
        assertExpiryDate(
                LocalDate.of(2019,3,1),
                10_000,
                LocalDate.of(2019,4,1)
        );
        assertExpiryDate(
                LocalDate.of(2019,5,5),
                10_000,
                LocalDate.of(2019,6,5)
        );

    }

    // [step3] 리팩토링 - 테스트메서드가 검증하는 내용이 무엇인지 명확히 확인 가능한 선에서
    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalCulator cal = new ExpiryDateCalCulator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
