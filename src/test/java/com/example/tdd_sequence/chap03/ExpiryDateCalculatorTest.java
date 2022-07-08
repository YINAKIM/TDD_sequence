package com.example.tdd_sequence.chap03;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {
    @Test
    void 만원_납부하면_한달뒤가_만료일이_됨(){
        // case 1
        assertExpiryDate(
                LocalDate.of(2019,3,1),
                10_000,
                LocalDate.of(2019,4,1)
        );

        // case 2
        assertExpiryDate(
                LocalDate.of(2019,5,5),
                10_000,
                LocalDate.of(2019,6,5)
        );

        // case 3 : 납부일자 != 한달뒤일자 (불일치하는 경우)
        assertExpiryDate(
                LocalDate.of(2019,1,31),
                10_000,
                LocalDate.of(2019,2,28)
        );

    }

    // [step3] 리팩토링 - 테스트메서드가 검증하는 내용이 무엇인지 명확히 확인 가능한 선에서
    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalCulator cal = new ExpiryDateCalCulator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }

    @Test
    void 납부일과_한달뒤_일자가_같지않은_예외상황(){
        assertExpiryDate(
                LocalDate.of(2019,1,31),
                10_000,
                LocalDate.of(2019,2,28)
        );
        // pass : LocalDate.plusMonths(1); 로 알아서 한달추가 처리를 해줬음
    }
}
