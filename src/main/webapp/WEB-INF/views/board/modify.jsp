<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@include file="../includes/header.jsp" %>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
 	<div class="board register">
      <form action="/board/modify" method="post">
      	<input type="hidden" name="bno" value='<c:out value="${board.bno }" />' />
      	<input type="hidden" name="writer" value='<c:out value="${board.writer }" />' />
        <div class="input-group">
          <div class="input-group-prepend">
            <span class="input-group-text">제목</span>
          </div>
          <input type="text" class="form-control" name="title" value='<c:out value="${board.title }" />' />
        </div>
        <button
          type="button"
          class="btn btn-link"
          data-toggle="tooltip"
          data-placement="bottom"
          title="사진 추가"
        >
          <i class="fas fa-image"></i>
        </button>
        <textarea class="form-control" name="content" rows="15"><c:out value="${board.content }" /></textarea>
        <div class="register-box">
          <input type="submit" class="btn btn-info" value="수정" />
          <input type="button" class="btn btn-outline-info" id="cancel" value="취소" />
        </div>
      </form>
    </div>
    <script>
      $(function() {
        $('[data-toggle="tooltip"]').tooltip();
      });
      
      $(document).ready(function() {
    	  $('#cancel').on("click", function(e){
    		  location.href='/board/get?bno=<c:out value="${board.bno }"/>';
    	  });
      });
    </script>
  </body>
</html>