<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 상세보기</title>
  <style>
    table * {margin:5px;}
    table {width:100%;}
  </style>
</head>
<body>
<jsp:include page="../common/header.jsp" />

<div class="content">
  <br><br>
  <div class="innerOuter">
    <h2>사진게시글 상세보기</h2>
    <br>

    <a class="btn btn-secondary" style="float:right;" href="list.th">목록으로</a>
    <br><br>

    <table id="contentArea" algin="center" class="table">
      <tr>
        <th width="100">제목</th>
        <td colspan="3">${b.boardTitle }</td>
      </tr>
      <tr>
        <th>작성자</th>
        <td>${b.boardWriter }</td>
        <th>작성일</th>
        <td>${b.createDate }</td>
      </tr>
      <tr>
        <th>대표이미지</th>
        <td colspan="3">
          <img id="tumbnail-img" width="250" height="170" src="${pageContext.request.contextPath}/${list[0].filePath}${list[0].changeName}">
        </td>
      </tr>
      <tr>
        <th>상세이미지</th>
        <c:forEach var="at" items="${list}">
          <c:if test="${at.fileLevel == 2}">
            <td><img id="content-img1" width="150" height="120" src="${pageContext.request.contextPath}/${at.filePath}${at.changeName}"></td>
          </c:if>
        </c:forEach>
      </tr>
    </table>
    <br>


    <!-- 수정하기, 삭제하기 버튼은 이 글이 본인이 작성한 글일 경우에만 보여져야 함 -->
    <div align="center">
      <c:if test="${loginUser.userId eq b.boardWriter}">
        <a class="btn btn-primary" onclick="postFormSubmit('edit')">수정하기</a>
        <a class="btn btn-danger" onclick="postFormSubmit('delete')">삭제하기</a>
      </c:if>
    </div>
    <br><br>

    <form action="" method="GET" id="postForm">
      <input type="hidden" name="bno" value="${b.boardNo}">
    </form>

    <script>
      function postFormSubmit(type){
        const formEl = document.querySelector("#postForm");
        switch(type){
          case "edit" : {
            //formEl.action = "updateForm.bo";
            $(formEl).attr("action", "updateForm.th");
          }break;
          case "delete":{
            //formEl.action = "delete.bo";
            $(formEl).attr("action", "delete.th")
          }break;
        }

        $(formEl).submit();
      }
    </script>


    <table id="replyArea" class="table" align="center">
      <thead>
      <c:choose>
        <c:when test="${empty loginUser }">
          <tr>
            <th colspan="2">
              <textarea class="form-control" readonly cols="55" rows="2" style="resize:none; width:100%;">로그인 후 이용 가능합니다.</textarea>
            </th>
            <th style="vertical-align:middle"><button class="btn btn-secondary disabled">등록하기</button></th>
          </tr>
        </c:when>
        <c:otherwise>
          <tr>
            <th colspan="2">
              <textarea class="form-control" id="content" cols="55" rows="2" style="resize:none; width:100%;"></textarea>
            </th>
            <th style="vertical-align:middle"><button class="btn btn-secondary" onclick="addReply();">등록하기</button></th>
          </tr>
        </c:otherwise>
      </c:choose>



      <tr>
        <td colspan="3">댓글(<span id="rcount">0</span>)</td>
      </tr>
      <tr>

      </tr>
      </thead>
      <tbody>
      </tbody>
    </table>
  </div>
  <br><br>

         <script>
            function addReply(){
                //댓글내용, 작성자, 게시글번호
                const boardNo = ${b.boardNo};
                const userId = "${loginUser.userId}";
                const content = document.querySelector("#content").value;

                insertReply({
                    refBno: boardNo,
                    replyWriter: userId,
                    replyContent: content
                }, function(){
                    location.reload();
                },drawReplyList)
            }

            function getReplyList(data, callback){
                //TODO 1 댓글목록 가져와서 그리기
                //data를 이용해서 댓글목록을 불러오고
                //화면에 맞게 그려주기
                $.ajax({
                    url: "/api/board/reply",
                    type: "GET",
                    data: {
                        refBno: data.refBno
                    },
                    success: function (res) {
                        callback(res);
                    }, error: function () {
                        console.error("댓글 목록을 불러오는 데 실패했습니다.");
                    }
                })
            }

            function drawReplyList(data) {
                let str = "";
                for (let i = 0; i < data.length; i++) {
                    str += "<tr>" +
                        "<td>" + data[i].replyWriter + "</td>" +
                        "<td>" + data[i].replyContent + "</td>" +
                        "</tr>";
                }
                const replyBody = document.querySelector("#replyArea tbody");
                replyBody.innerHTML = str;
                $("#rcount").html(data.length);
            }

            function insertReply(data, callback){
                $.ajax({
                    url: "/api/board/reply",
                    type: "POST",
                    data: data,
                    success: function (res){
                        callback(data)
                    }, error: function (){

                    }
                })
            }
            $(document).ready(function() {
                getReplyList({ refBno: ${b.boardNo} }, drawReplyList);
            });
        </script>
</div>

<jsp:include page="../common/footer.jsp" />
</body>
</html>