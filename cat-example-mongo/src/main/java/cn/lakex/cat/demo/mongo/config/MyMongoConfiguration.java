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

package cn.lakex.cat.demo.mongo.config;

import com.mongodb.reactivestreams.client.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Mongo autoconfiguration
 *
 * @author LarryKoo (larrykoo@126.com)
 * @slogon 站在巨人的肩膀上
 * @date 2020/12/7 16:09
 * @since 3.0.0
 */
@Slf4j
@Configuration
@EnableReactiveMongoRepositories(basePackages = "cn.lakex.cat.demo.mongo.repository")
public class MyMongoConfiguration {
    private final MongoClient mongoClient;

    public MyMongoConfiguration(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        log.info("========== Init ReactiveMongoTemplate =========");
        return new ReactiveMongoTemplate(mongoClient, "exam_ai");
    }
}
