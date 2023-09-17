package com.nhnacademy.thread;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

public class CouponGenerator implements Iterator<Coupon> {
    private static final int COUPON_MAX_SIZE = 50;
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    private static final CouponGenerator INSTANCE = new CouponGenerator();

    public static CouponGenerator getCouponGenerator() {
        return INSTANCE;
    }

    private CouponGenerator() {

    }

    public static Coupon getCoupon() {
        return Coupon.ofDiscount(ID_GENERATOR.incrementAndGet(), 10_000);
    }

    @Override
    public synchronized boolean hasNext() {
        return ID_GENERATOR.get() < COUPON_MAX_SIZE;
    }

    @Override
    public synchronized Coupon next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return Coupon.ofDiscount(ID_GENERATOR.incrementAndGet(), 10_000);
    }
}
