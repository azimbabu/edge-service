package com.polarbookshop.edgeservice.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class WebEndpoints {

  private static final Logger log = LoggerFactory.getLogger(WebEndpoints.class);

  @Bean
  public RouterFunction<ServerResponse> routerFunction() {
    return RouterFunctions.route()
        .GET("/catalog-fallback", request -> {
          log.info("Using GET catalog-fallback");
          return ServerResponse.ok().body(Mono.just(""), String.class);
        })
        .POST("/catalog-fallback",
            request -> {
              log.info("Using POST catalog-fallback");
              return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build();
            })
        .build();
  }
}
