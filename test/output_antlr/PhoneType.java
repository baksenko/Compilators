package com.example;

public enum PhoneType {
    PHONE_TYPE_UNSPECIFIED(0),
    MOBILE(1),
    HOME(2),
    WORK(3);

    private final int number;

    PhoneType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static PhoneType forNumber(int value) {
        for (PhoneType e : values()) {
            if (e.number == value) return e;
        }
        return null;
    }
}
