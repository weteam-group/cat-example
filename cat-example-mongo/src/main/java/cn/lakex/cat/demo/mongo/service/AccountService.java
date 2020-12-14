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

package cn.lakex.cat.demo.mongo.service;

import cn.lakex.cat.demo.mongo.io.entity.AccountDomain;
import cn.lakex.cat.demo.mongo.repository.AccountRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Account service
 *
 * @author LarryKoo (larrykoo@126.com)
 * @slogon 站在巨人的肩膀上
 * @date 2020/12/8 17:43
 * @since 3.0.0
 */
@Service
public class AccountService {
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    private final AccountRepository accountCurdRepository;

    public AccountService(ReactiveMongoTemplate reactiveMongoTemplate, AccountRepository accountCurdRepository) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
        this.accountCurdRepository = accountCurdRepository;
    }

    public Mono<AccountDomain> save(AccountDomain domain) {
        return accountCurdRepository.save(domain);
    }

    public Mono<AccountDomain> findByUid(String uid) {
        return accountCurdRepository.findOneByUid(uid);
    }
}
