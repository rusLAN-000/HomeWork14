package ru.netology.stats;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "Мясо", 150);
    Product product2 = new Product(2, "Хлеб", 15);
    Product product3 = new Product(3, "Молоко", 50);
    Product product4 = new Product(4, "Булка", 10);
    Product product5 = new Product(5, "Орехи", 5);

    @Test
    public void removeByIdPlus() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);

        repo.removeById(3);

        Product[] expected = {product1, product2, product4, product5};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdMinus() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

}