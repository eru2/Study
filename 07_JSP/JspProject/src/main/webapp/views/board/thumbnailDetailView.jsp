<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사진 게시글 상세보기</title>
    <style>
        .outer {
            background: blanchedalmond;
            color: black;
            width: 1000px;
            margin: auto;
            margin-top: 50px;
            padding: 10px 0px 50px;
            text-align: center;
        }

        /* .outer table {
            border: 1px solid black;
            width: 80%;
            margin: auto;
        }

        .outer table th, .outer table td {
            border: 1px solid black;
            padding: 10px;
        }

        .thumbnail-img {
            width: 250px;
            height: 170px;
        }

        .detail-images {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 10px;
        }

        .detail-images img {
            width: 150px;
            height: 120px;
            cursor: pointer;
        } */
        .outer table{
            border: 1px solid white;
        }

        .outer table th,
        .outer table td{
            border: 1px solid white; 
        }

        .outer > form input,
        .outer > form textarea{
            width: 100%;
            height: 100%;
            box-sizing: border-box;
        }

        .outer img:hover{
            cursor: pointer;
            background: #83aeff;
        }
    </style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

    <div class="outer">
        <br>
        <h2 align="center">사진게시글 상세보기</h2>
        <br>
        
        <table border="1" align="center">
            <tr>
                <th>제목</th>
                <td colspan="3">
                    ${b.boardTitle}
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td colspan="3">
                    ${b.boardTitle}
                </td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${b.userId}</td>
                <th>작성일</th>
                <td>${b.createDate}</td>
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

        <div align="center">
            <a href="${pageContext.request.contextPath}/list.th" class="btn btn-sm">목록가기</a>
        </div>
    </div>

    <!-- <div class="outer">
        <h2>${board.boardTitle}</h2>
        <p>작성자: ${board.userId}</p>
        <p>작성일: ${board.createDate}</p>
        <p>${board.boardContent}</p>

        <table border="1">
            <tr>
                <th>대표이미지</th>
                <td>
                    <c:forEach var="attachment" items="${board.attachmentList}">
                        <c:if test="${attachment.fileLevel == 1}">
                            <img class="thumbnail-img" src="${pageContext.request.contextPath}/${attachment.filePath}${attachment.changeName}">
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <th>상세이미지</th>
                <td>
                    <div class="detail-images">
                        <c:forEach var="attachment" items="${board.attachmentList}">
                            <c:if test="${attachment.fileLevel == 2}">
                                <img src="${pageContext.request.contextPath}/${attachment.filePath}${attachment.changeName}">
                            </c:if>
                        </c:forEach>
                    </div>
                </td>
            </tr>
        </table>

        <br>
        <div>
            <a href="${pageContext.request.contextPath}/list.th">목록으로</a>
            <a>수정하기</a>
        </div>
    </div> -->
</body>
</html>