package com.hellokoding.jpa;

import com.hellokoding.jpa.model.*;
import com.hellokoding.jpa.repository.BookCategoryRepository;
import com.hellokoding.jpa.repository.ProdSubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class HelloJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    ProdSubscriptionRepository prodSubscriptionRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloJpaApplication.class, args);
    }

    public void doSubscriptionSaving(){

        DrfSubscriptionTrackId subscriptionTrackId = new DrfSubscriptionTrackId();
        subscriptionTrackId.setTrackId("DMS");
        subscriptionTrackId.setCountry("USA");

        ProdSubscriptionTypes prodSubscriptionTypes1 = new ProdSubscriptionTypes();
        prodSubscriptionTypes1.setDescription("This is a test subscription 1");
        //subscriptionTypeid is autoincremented

        //subscriptionTrackId.setSubscriptionTypeId(prodSubscriptionTypes1.getSubscriptionTypeId());//but deferred. does not help
        subscriptionTrackId.setSubscriptionTypeId(1);

        List<DrfSubscriptionTrack> drfSubscriptionTrackList1 = new ArrayList<DrfSubscriptionTrack>();
        DrfSubscriptionTrack drfSubscriptionTrack_A = new DrfSubscriptionTrack();
        drfSubscriptionTrack_A.setId(subscriptionTrackId);
        drfSubscriptionTrackList1.add(drfSubscriptionTrack_A);
        prodSubscriptionTypes1.setTracks(drfSubscriptionTrackList1);

        prodSubscriptionRepository.saveAndFlush(prodSubscriptionTypes1);
        prodSubscriptionRepository.flush();



        List<ProdSubscriptionTypes> prodSubscriptionTypesList = prodSubscriptionRepository.findAll();

        for (ProdSubscriptionTypes atype: prodSubscriptionTypesList ) {
            logger.info(atype.toString());
        }

        logger.info("exiting well . . .");
        System.exit(0);

    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        doSubscriptionSaving();

        // save a couple of categories
        BookCategory categoryA = new BookCategory("Category A");
        /*
        Set bookAs = new HashSet<Book>(){{
            add(new Book("Book A1", categoryA));
            add(new Book("Book A2", categoryA));
            add(new Book("Book A3", categoryA));
        }};
        */
        Set bookAs = new HashSet<Book>();
        bookAs.add( new Book("Book A1", categoryA));
        bookAs.add(new Book("Book A2", categoryA));
        bookAs.add(new Book("Book A3", categoryA));
        categoryA.setBooks(bookAs);

        BookCategory categoryB = new BookCategory("Category B");
        Set bookBs = new HashSet<Book>(){{
            add(new Book("Book B1", categoryB));
            add(new Book("Book B2", categoryB));
            add(new Book("Book B3", categoryB));
        }};
        categoryB.setBooks(bookBs);

        bookCategoryRepository.save(new HashSet<BookCategory>() {{
            add(categoryA);
            add(categoryB);
        }});

        // fetch all categories
        for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
            logger.info(bookCategory.toString());
        }
    }
}
