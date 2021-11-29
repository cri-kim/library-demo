package com.demo.library.app.dto.request;

import com.demo.library.app.enums.Stat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class BookSearchCondition {
    private String name;
    private List<Stat> stat = new ArrayList<>();
}
