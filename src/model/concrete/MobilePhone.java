package model.concrete;

import model.Product;

public class MobilePhone extends Product {
    public MobilePhone() {
    }

    public MobilePhone(int id, String name, double price, String brand) {
        super(id, name, price, brand);
    }
}
