package com.zeroquo.magicregister.repository;

import com.zeroquo.magicregister.domain.Expansion;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ExpansionRepository extends ReactiveMongoRepository<Expansion, String> {
}
