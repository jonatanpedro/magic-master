package com.zeroquo.magicregister.router;

import com.zeroquo.magicregister.handler.CardHandler;
import com.zeroquo.magicregister.handler.ExpansionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class Router {

    private static final String PATH_CARDS = "/cards";
    private static final String PATH_EXPANSION = "/expansions";
    public static final String ID = "/{id}";
    public static final String ROOT = "/";

    @Bean
    public RouterFunction routerFunction(CardHandler cardHandler, ExpansionHandler expansionHandler) {
        return nest(path(PATH_CARDS),
                nest(accept(MediaType.APPLICATION_JSON),
                        route(GET(ID), cardHandler::findById)
                                .andRoute(POST(ROOT), cardHandler::save)
                                .andRoute(PUT(ID), cardHandler::update)
                                .andRoute(DELETE(ID), cardHandler::delete)
                                .andRoute(GET(ROOT), cardHandler::findAll)
                )
        ).andNest(path(PATH_EXPANSION),
                nest(accept(MediaType.APPLICATION_JSON),
                        route(GET(ID), expansionHandler::findById)
                        ));

    }


}
