package com.example.volvo.controller;

public interface CRUDController<T, U> {

    T create(U dto);

    T update(U dto);

    T delete(U dto);
}
