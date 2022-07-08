package com.example.tdd_sequence.chap03;

import java.time.LocalDate;

public class ExpiryDateCalCulator {

    // 파라미터 2개를 받는 calculateExpiryDate
//    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
//
//        // [step1] 쉬운것부터 테스트 - 상수를 리턴해서 테스트 통과
//        // return LocalDate.of(2019,4,1);
//
//        // [step2] 예를 추가하면서 구현을 일반화
//        return billingDate.plusMonths(1);
//
//    }


    // 파라미터 개수가 3개 이상이 되면 객체로 만들어서 사용
    public LocalDate calculateExpiryDate(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }
}
