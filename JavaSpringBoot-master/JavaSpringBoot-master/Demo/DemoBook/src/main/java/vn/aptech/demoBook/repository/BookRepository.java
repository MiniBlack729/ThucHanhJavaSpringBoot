/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.demoBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.aptech.demoBook.entity.Book;

/**
 * @author havy5
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

}
