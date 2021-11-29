package com.demo.library.app.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
public class BookPaginationResponse {

    private List<BookResponse> books;

    private Integer pageCnt;
}
