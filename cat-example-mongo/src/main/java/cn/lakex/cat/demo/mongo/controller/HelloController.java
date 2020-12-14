/*
 * Copyright (c) 2020, WeTeam Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.lakex.cat.demo.mongo.controller;

import cn.lakex.cat.demo.mongo.io.entity.AccountDomain;
import cn.lakex.cat.demo.mongo.service.AccountService;
import cn.lakex.framework.core.result.R2;
import lombok.extern.slf4j.Slf4j;
import net.dreamlu.mica.core.result.R;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * HelloWorld
 *
 * @author LarryKoo (larrykoo@126.com)
 * @slogon 站在巨人的肩膀上
 * @date 2020/11/5 14:31
 * @since 3.0.0
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    private final AccountService accountService;

    public HelloController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/hi")
    public R<String> hello() {
        log.info("Enter method --> hello()");

        log.debug("I am a {} message", "debug");

        return R2.success("Hello World.");
    }


    @PostMapping("/save")
    public Mono<R<Object>> save() {
        AccountDomain domain = AccountDomain.builder()
                .id(null)
                .name("LarryKoo")
                .uid("123456")
                .value(3.14)
                .hasJob(true)
                .build();

        Mono<AccountDomain> adMono = accountService.save(domain);
        adMono.subscribe(c -> {
            log.info("subscribe:\n{}", c.toJsonPretty());
        });

        adMono.doOnSuccess(c -> {
            log.info("doOnSuccess:\n{}", c.toJsonPretty());
        });

        return Mono.just(R2.success());
    }

    @GetMapping("/find_by_uid")
    public Mono<ServerResponse> findAccount() {
        String uid = "123456";

        Mono<AccountDomain> result = accountService.findByUid(uid);

        result.doOnNext(d -> {
            log.info("doOnNext: {}", d.toJson());
        }).doOnSuccess(d -> {
            log.info("doOnSuccess: {}", d.toString());
        }).doOnSubscribe(d -> {
            log.info("doOnSubscribe: {}", d.toString());
        });

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result, AccountDomain.class);
    }

}