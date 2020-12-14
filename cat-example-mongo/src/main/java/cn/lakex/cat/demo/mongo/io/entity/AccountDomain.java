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

package cn.lakex.cat.demo.mongo.io.entity;

import cn.lakex.framework.core.entity.AbstractEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Demo Entity - Account
 *
 * @author LarryKoo (larrykoo@126.com)
 * @slogon 站在巨人的肩膀上
 * @date 2020/12/7 16:44
 * @since 3.0.0
 */

@Data
@Builder
@Document("account")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountDomain extends AbstractEntity {

    @Id
    private String id;

    @Indexed(name = "idx__uid", background = true)
    private String uid;

    private String name;

    private Double value;

    private Boolean hasJob;

    @Override
    public AbstractEntity init() {
        return this;
    }
}
