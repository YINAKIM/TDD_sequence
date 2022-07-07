package com.example.tdd_sequence.chap03;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {
    @Test
    void 만원_납부하면_한달뒤가_만료일이_됨(){

        // [step1] 쉬운것부터 테스트 - 상수를 리턴해서 테스트 통과
        LocalDate billingDate = LocalDate.of(2019,3,1);
        int payAmount = 10_000;

        ExpiryDateCalCulator cal = new ExpiryDateCalCulator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(LocalDate.of(2019,4,1), expiryDate);

        // [step2] 예를 추가하면서 구현을 일반화
        LocalDate billingDate2 = LocalDate.of(2019,5,5);
        int payAmount2 = 10_000;

        ExpiryDateCalCulator cal2 = new ExpiryDateCalCulator();
        LocalDate expiryDate2 = cal.calculateExpiryDate(billingDate2, payAmount2);

        assertEquals(LocalDate.of(2019,6,5), expiryDate2);
    }
}
