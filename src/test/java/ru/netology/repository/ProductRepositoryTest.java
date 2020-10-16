package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(1, "firstBook", 100, "firstAuthor");
    private Book secondBook = new Book(2, "secondBook", 100, "secondAuthor");
    private Book thirdBook = new Book(3, "entry", 100, "thirdAuthor");

    @BeforeEach
    public void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Product[] expected = new Product[] {secondBook, thirdBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundExceptionIfNotExist() {
        assertThrows(NotFoundException.class, () -> repository.removeById(4));
    }

}