/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoBook.service;

import java.util.List;
import java.util.Optional;

import vn.aptech.demoBook.entity.Book;

/**
 * @author havy5
 */
public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(int id);

    Book save(Book b);

    void deleteById(int id);
}
