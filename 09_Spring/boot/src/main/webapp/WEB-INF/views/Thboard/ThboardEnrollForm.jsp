<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>게시글 작성</title>
  <style>
    #enrollForm>table {width:100%;}
    #enrollForm>table * {margin:5px;}
  </style>
</head>
<body>

<jsp:include page="../common/header.jsp" />

<div class="content">
  <br><br>
  <div class="innerOuter">
    <h2>게시글 작성하기</h2>
    <br>

    <form id="enrollForm" method="post" action="insert.th" enctype="multipart/form-data">
      <table align="center">
        <tr>
          <th><label for="title">제목</label></th>
          <td><input type="text" id="title" class="form-control" name="boardTitle" required></td>
        </tr>
        <tr>
          <th><label for="writer">작성자</label></th>
          <td><input type="text" id="writer" class="form-control" value="${loginUser.userId }" name="boardWriter" readonly></td>
        </tr>
        <tr>
          <th><label for="content">내용</label></th>
          <td><textarea id="content" class="form-control" rows="10" style="width:100%; height:30px; resize:none;" name="boardContent" required></textarea></td>
        </tr>
        <tr>
          <th>이미지</th>
          <td colspan="3">
            <img id="tumbnail-img" width="250" height="170" onclick="chooseFile('#file1')">
          </td>
        </tr>
        <tr>
          <th>상세이미지</th>
          <td><img id="content-img1" width="150" height="120" onclick="chooseFile('#file2')"></td>
          <td><img id="content-img2" width="150" height="120" onclick="chooseFile('#file3')"></td>
          <td><img id="content-img3" width="150" height="120" onclick="chooseFile('#file4')"></td>
        </tr>
      </table>

      <div style="display: none;">
        <input type="file" name="file1" id="file1" required onchange="loadImg(this, '#tumbnail-img')">
        <input type="file" name="file2" id="file2" onchange="loadImg(this, '#content-img1')">
        <input type="file" name="file3" id="file3" onchange="loadImg(this, '#content-img2')">
        <input type="file" name="file4" id="file4" onchange="loadImg(this, '#content-img3')">
      </div>

      <br>
      <br>
      <div align="center">
        <button type="submit" class="btn btn-primary">등록하기</button>
        <button type="reset" class="btn btn-danger">취소하기</button>
      </div>

      <script>
        function loadImg(changeInput, targetImg){
          //파일객체 -> files -> 선택된파일들이 담겨있음
          console.log(changeInput.files[0])
          const img = document.querySelector(targetImg);
          console.log(img)
          if(changeInput.files.length > 0){ //파일은 선택했을 때
            //파일을 읽어들일 객체
            const reader = new FileReader();

            //해당 파일을 읽얻들여 해당파일만의 고유한 url을 부여
            //url : Base64로 인코딩된 데이터 url(파일을 실제로 표현하는 형식인 바이너리 코드를 텍스트문자열로 인코딩한 방식)
            reader.readAsDataURL(changeInput.files[0]);

            //파일읽어들이기를 완료 했을 때 이벤트핸들러를 실행시켜줘
            reader.onload = function(ev){
              img.src = ev.target.result //이미지 요소에 불러온 파일의 url을 넣어준다.
            }


          } else { //파일이 있었는데 선택 후 취소했을 때
            img.src = null;
          }
        }
        function chooseFile(selector){
          const fileInput = document.querySelector(selector);
          fileInput.click();
        }
      </script>

    </form>
  </div>
  <br><br>

</div>

<jsp:include page="../common/footer.jsp" />

</body>
</html>