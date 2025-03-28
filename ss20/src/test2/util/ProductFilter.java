package test2.util;


import test2.entity.Product;

@FunctionalInterface
public interface ProductFilter {
    boolean filter(Product product);
}