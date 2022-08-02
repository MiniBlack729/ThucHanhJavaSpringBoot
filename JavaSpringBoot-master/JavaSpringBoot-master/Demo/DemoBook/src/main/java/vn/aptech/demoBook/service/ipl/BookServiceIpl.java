/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoBook.service.ipl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.aptech.demoBook.entity.Book;
import vn.aptech.demoBook.repository.BookRepository;
import vn.aptech.demoBook.service.BookService;

/**
 * @author havy5
 */
@Service
public class BookServiceIpl implements BookService {

    @Autowired
    private BookRepository repo;

    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Book save(Book b) {
        return repo.save(b);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
