package com.github.docastest.test_tools;

public interface SupplierWithException<T> {
    T run() throws Exception;
}
