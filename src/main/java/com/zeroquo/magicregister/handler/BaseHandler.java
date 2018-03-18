package com.zeroquo.magicregister.handler;

import com.zeroquo.magicregister.domain.Card;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class BaseHandler <T extends Serializable>{

    protected static final String ID = "id";

    private ReactiveMongoRepository repository;

    private final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
    private Class<T> classType = (Class<T>) (type).getActualTypeArguments()[0];

    public BaseHandler(ReactiveMongoRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest){
        return ServerResponse.ok().body(this.repository.findById(serverRequest.pathVariable(ID)), classType);
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest){
        return ServerResponse.ok().body(this.repository.findAll(), classType);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest){
        Mono<Card> userMono = serverRequest.bodyToMono(Card.class);
        return ServerResponse.ok().body(this.repository.insert(userMono), classType);
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest){
        return ServerResponse.ok().body(this.repository.save(serverRequest.bodyToMono(classType).block()), classType);
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        return ServerResponse.ok().body(this.repository.deleteById(serverRequest.pathVariable(ID)), Void.class);
    }
}
