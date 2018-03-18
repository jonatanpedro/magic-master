package com.zeroquo.magicregister.repository;

import com.zeroquo.magicregister.domain.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CardRepository extends ReactiveMongoRepository<Card, String> {
}
