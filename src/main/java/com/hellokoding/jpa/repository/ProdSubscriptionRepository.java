package com.hellokoding.jpa.repository;

import com.hellokoding.jpa.model.BookCategory;
import com.hellokoding.jpa.model.DrfSubscriptionTrackId;
import com.hellokoding.jpa.model.ProdSubscriptionTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdSubscriptionRepository extends JpaRepository<ProdSubscriptionTypes, DrfSubscriptionTrackId>{
}
