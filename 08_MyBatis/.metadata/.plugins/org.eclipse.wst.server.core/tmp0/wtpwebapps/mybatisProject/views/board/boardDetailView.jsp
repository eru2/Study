<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>

    <jsp:include page="../common/menubar.jsp" />

    <div class="outer" align="center">
        <br>
        <h1 align="center">게시판 상세조회</h1>
        <br>

        <table align="center" border="1">
            <tr>
                <th width="100">글번호</th>
                <td width="500">${board.boardNo }</td>
            </tr>
             <tr>
                <th>제목</th>
                <td>${board.boardTitle }</td>
            </tr>
            <tr>
                 <th>작성자</th>
                <td>${board.userId}</td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>${board.count }</td>
            </tr>
            <tr>
                 <th>작성일</th>
                <td>${board.createDate}</td>
            </tr>
            <tr>
                  <th>내용</th>
                <td colspan="3">
                   <p style="height: 200px;">
                        ${board.boardContent}
                   </p>
                </td>
            </tr>
        </table>

        <br>
          <div align="center">
            <a href="${pageContext.request.contextPath}/list.bo?cpage=1">목록가기</a>
            <c:if test="${loginUser != null && loginUser.userId == board.userId}">
	            <a href="${pageContext.request.contextPath}/updateForm.bo?bno=${board.boardNo}">수정하기</a>
	            <a >삭제하기</a>
            </c:if>
        </div>

        <br>

        <table align="center" border="1">
          <thead>
                    <tr>
                        <th>댓글작성</th>
                        <c:choose>
                            <c:when test="${loginUser == null}">
                                <td>
                                    <textarea cols="50" rows="3" style="resize: none;" readonly>댓글등록을 하시려면 로그인이 필요합니다.</textarea>
                                </td>
                                <td>
                                    <button disabled>댓글등록</button>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <textarea id="reply-content" cols="50" rows="3" style="resize: none;"></textarea>
                                </td>
                                <td>
                                    <button onclick="insertReply(${board.boardNo})">댓글등록</button>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </thead>
            </table>

            <script>
                function init(bno){
                    getReplyList(bno, function(data){
                        drawReplyList(data);
                    });
                }

                function insertReply(bno){
                   const contentArea = document.querySelector("#reply-content");

                   $.ajax({
                    url: "rinsert.bo",
                    type: "post",
                    data: {
                        boardNo: bno,
                        content: contentArea.value  
                    },
                    success: function(res){
                        contentArea.value = ""; //댓글 입력창 초기화
                        //댓글목록 다시 불러와서 그려주기
                        getReplyList(bno, function(data){
                            console.log(data)
                            drawReplyList(data);
                        });
                    },
                    error: function(error){
                        console.log("댓글 작성 ajax통신 실패");
                    }
                   })
                }

                function getReplyList(boardNo, callback){
                    $.ajax({
                        url : "rlist.bo",
                        // contextType: "application/json",
                        dataType: "json", //응답 데이터 타입(json, text, html, xml)
                        data : {
                            bno : boardNo
                        },
                        success: function(replyList){
                            callback(replyList);
                        }, 
                        error: function(){
                            console.log("댓글 조회 ajax통신 실패");
                        }
                    })
                }

                function drawReplyList(replyList){
                    let str = "";
                    for(let r of replyList) {
                        str += "<tr>" +
                                "<td>" + r.userId + "</td>" +
                                "<td>" + r.replyContent + "</td>" +
                                "<td>" + r.createDate + "</td>" +
                              "</tr>";
                    }

                    const replyBody = document.querySelector("#reply-area tbody");
                    replyBody.innerHTML = str;
                }


               
            </script>
        </table>
    </div>
</body>
</html>