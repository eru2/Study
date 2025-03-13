<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판-글목록</title>
    <style>
        #boardList>tbody>tr:hover {cursor:pointer;}
        #searchForm {
            width:80%;
            margin:auto;
        }
        .list-area{
            max-width: 850px;
            min-height: 500px;
            margin: auto;
        }

        #searchForm>* {
            float:left;
            margin:5px;
        }
        .select {width:20%;}
        .text {width:53%;}
        .searchBtn {width:20%;}
    </style>
</head>
<body>


<jsp:include page="../common/header.jsp" />

<div class="content">
    <br><br>
    <div class="innerOuter" style="padding:5% 10%;">
        <h2>게시판</h2>
        <br>
        <!-- 로그인 후 상태일 경우만 보여지는 글쓰기 버튼 -->
        <c:if test="${not empty loginUser}">
            <a class="btn btn-secondary" style="float:right;" href="enrollForm.th">글쓰기</a>
            <br>
        </c:if>

        <br>
        <div class="list-area">
            <c:choose>
                <c:when test="${not empty list}">
                    <c:forEach var="b" items="${list}">
                        <div class="thumbnail" align="center" onclick="location.href='${pageContext.request.contextPath}/detail.th?bno=${b.boardNo}'">
                            <img width="200px" height="150px" src="${pageContext.request.contextPath}/${b.thumbnailImg}" alt="썸네일이미지">
                            <p>

                                <span>No. ${b.boardNo} ${b.boardTitle}</span><br>
                                조회수 : ${b.count}
                            </p>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h1 align="center">게시글이 없습니다.</h1>
                    <c:if test="${loginUser != null}">
                        <div align="center">
                            <a href="${pageContext.request.contextPath}/enrollForm.th" class="btn btn-sm btn-primary">게시글 작성</a>
                        </div>
                    </c:if>
                </c:otherwise>
            </c:choose>


            <form id="searchForm" action="" method="get" align="center">
                <div class="select">
                    <select class="custom-select" name="condition">
                        <option value="writer">작성자</option>
                        <option value="title">제목</option>
                    </select>
                </div>
                <div class="text">
                    <input type="text" class="form-control" name="keyword">
                </div>
                <button type="submit" class="searchBtn btn btn-secondary">검색</button>
            </form>
            <br><br>
        </div>
        <br><br>

        </div>

<jsp:include page="../common/footer.jsp" />

</body>
</html>
