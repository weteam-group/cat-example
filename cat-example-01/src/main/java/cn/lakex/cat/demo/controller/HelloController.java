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

package cn.lakex.cat.demo.controller;

import cn.lakex.framework.core.result.R2;
import lombok.extern.log4j.Log4j2;
import net.dreamlu.mica.annotation.ApiVersion;
import net.dreamlu.mica.core.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld
 *
 * @author LarryKoo (larrykoo@126.com)
 * @slogon 站在巨人的肩膀上
 * @date 2020/11/5 14:31
 * @since 3.0.0
 */
@Log4j2
@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiVersion("v1")
    @GetMapping("/hi")
    public R<String> hello() {
        log.info("Enter method --> hello()");

        log.debug("I am a {} message", "debug");

        return R2.success("Hello World.");
    }

}
