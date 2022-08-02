 /*
  * To change this license header, choose License Headers in Project Properties.
  * To change this template file, choose Tools | Templates
  * and open the template in the editor.
  */
 package vn.aptech.demoBook;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;
 import org.springframework.validation.Errors;
 import org.springframework.validation.ValidationUtils;
 import org.springframework.validation.Validator;
 import vn.aptech.demoBook.entity.Book;
 import vn.aptech.demoBook.service.BookService;

 /**
  * @author havy5
  */
 @Component
 public class BookValidator implements Validator {

     @Autowired
     private BookService service;

     @Override
     public boolean supports(Class<?> clazz) {
         return clazz == Book.class;
     }

     @Override
     public void validate(Object target, Errors errors) {
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "book.title");
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "book.price");
     }

 }
