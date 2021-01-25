package org.example.book.controllers;

import org.example.book.models.BookModels;
import org.example.book.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v2/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //set book
    @RequestMapping(method = RequestMethod.PUT)
    public void setBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    //get book
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable long bookId){
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if(bookOpt.isPresent()){
            log.info("Get book by id");
            return bookOpt.get();
        }else{
            log.warn("book not found");
            return null;
        }
    }

    //edit book
    @RequestMapping(value = "/{bookId}", method = RequestMethod.POST)
    public Book editBook(@RequestBody Book book, @PathVariable long bookId){
        log.info("book saved");
        return bookRepository.save(book);
    }
}