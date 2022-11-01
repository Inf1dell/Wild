package com.example.wild;

public class Product {

    String name;
    String price;
    int image;
    String href;
    Boolean box;


    Product(String _describe, String _price, int _image, String _href, Boolean _box) {
        name = _describe;
        price = _price;
        image = _image;
        href = _href;
        box = _box;
    }
}
