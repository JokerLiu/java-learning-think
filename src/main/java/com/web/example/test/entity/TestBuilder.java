package com.example.test.entity;

import lombok.Builder;
import lombok.Getter;

/**
 * @package com.example.test.entity
 * @auther joker
 * @date 2018/6/4 17:20
 */
@Builder
@Getter
public class TestBuilder {
    private String code;
    private String message;
}