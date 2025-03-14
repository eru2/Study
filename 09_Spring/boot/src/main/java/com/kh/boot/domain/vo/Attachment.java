package com.kh.boot.domain.vo;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Attachment {
    private int fileNo;
    private int refBno;
    private String boardTitle;
    private String boardWriter;
    private String originName;
    private String changeName;
    private String filePath;
    private int count;
    private String uploadDate;
    private int fileLevel;
    private String status;
}
