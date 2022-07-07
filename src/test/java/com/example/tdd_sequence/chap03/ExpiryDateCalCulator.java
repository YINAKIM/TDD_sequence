package com.example.tdd_sequence.chap03;

import java.time.LocalDate;

public class ExpiryDateCalCulator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {

        // [step1] 쉬운것부터 테스트 - 상수를 리턴해서 테스트 통과
        // return LocalDate.of(2019,4,1);

        // [step2] 예를 추가하면서 구현을 일반화
        return billingDate.plusMonths(1);

    }
}
