package com.demo.library.app.enums;

public enum Stat {
    SOLD_OUT("매진"),
    ORDERED("주문 완료"),
    FULL_BOOKING("예약 불가능"),
    LOST("분실"),
    AVAILABLE("대여 가능");

    private final String description;

    Stat(String description){
        this.description = description;
    }
}
