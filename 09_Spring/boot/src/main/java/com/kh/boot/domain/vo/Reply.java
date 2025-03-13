package com.kh.boot.domain.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reply {
//    @JsonProperty("reply_no") //json에서 사용할때 이 key값을 사용하겠다.
    private int replyNo;

//    @JsonProperty("reply_content")
    private String replyContent;

//    @JsonIgnore //이 필드는 json으로 변활할 때 포함 x
    private int refBno;

//    @JsonProperty("reply_writer")
    private String replyWriter;

//    @JsonProperty("create_date")
    private String createDate;

//    @JsonIgnore
    private String status;


}