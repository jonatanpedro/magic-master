package com.zeroquo.magicregister.handler;

import com.zeroquo.magicregister.domain.Expansion;
import com.zeroquo.magicregister.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpansionHandler extends BaseHandler<Expansion>{

    private ExpansionRepository expansionRepository;

    @Autowired
    public ExpansionHandler(ExpansionRepository expansionRepository) {
        super(expansionRepository);
        this.expansionRepository = expansionRepository;
    }
}
