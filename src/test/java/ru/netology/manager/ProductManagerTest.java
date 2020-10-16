package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "firstBook", 100, "firstAuthor");
    private Book secondBook = new Book(2, "secondBook", 100, "secondAuthor");
    private Book thirdBook = new Book(3, "entry", 100, "thirdAuthor");
    private Smartphone firstSmartphone = new Smartphone(4,"firstSmartphone", 200, "firstManufacturer");
    private Smartphone secondSmartphone = new Smartphone(5,"secondSmartphone", 200, "secondManufacturer");
    private Smartphone thirdSmartphone = new Smartphone(6,"thirdSmartphone", 200, "entry");

    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstSmartphone);
        manager.add(secondSmartphone);
        manager.add(thirdSmartphone);
    }

    @Test
    void shouldSearchBookByName() {
        Product[] expected = new Product[] {firstBook};
        Product[] actual = manager.searchBy("firstBook");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] expected = new Product[] {secondBook};
        Product[] actual = manager.searchBy("secondAuthor");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Product[] expected = new Product[] {firstSmartphone};
        Product[] actual = manager.searchBy("firstSmartphone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturer() {
        Product[] expected = new Product[] {secondSmartphone};
        Product[] actual = manager.searchBy("secondManufacturer");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIfSeveralEntries() {
        Product[] expected = new Product[] {thirdBook, thirdSmartphone};
        Product[] actual = manager.searchBy("entry");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotSearchIfNotExist() {
        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy("notExist");
        assertArrayEquals(expected, actual);
    }
}