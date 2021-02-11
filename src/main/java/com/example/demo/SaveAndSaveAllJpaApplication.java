package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SaveAndSaveAllJpaApplication {

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SaveAndSaveAllJpaApplication.class, args);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void executePerformanceSaveAndSaveAll() {

        int count = 10000;
        long start = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            repository.save(new Book("Book " + i, " Author " + i));
        }

        long finish = System.currentTimeMillis();
        repository.deleteAll();

        System.out.println("Elapsed time (for save method) = " + ((finish - start) / 1000.0));

        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bookList.add(new Book("Book " + i, "Author " + i));
        }

        start = System.currentTimeMillis();
        repository.saveAll(bookList);
        finish = System.currentTimeMillis();

        System.out.println("Elapsed time (for saveAll method) = " + ((finish - start) / 1000.0));
    }

}
