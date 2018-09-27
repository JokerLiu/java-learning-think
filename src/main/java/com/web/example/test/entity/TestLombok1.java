package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @package com.example.test.entity
 * @auther joker
 * @date 2018/6/7 9:38
 */
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestLombok1 {
    private String id;
    private String name;
    private String comment;
}
