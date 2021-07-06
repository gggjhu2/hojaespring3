<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시판 상세보기" name="title" />
</jsp:include>
<style>
div#board-container {
	width: 400px;
}

input, button, textarea {
	margin-bottom: 15px;
}

/* 부트스트랩 : 파일라벨명 정렬*/
div#board-container label.custom-file-label {
	text-align: left;
}

div.foot {
	margin-left: 400px;
	margin-top: 0px;
	padding-top: 0px;
}
</style>

<script>
function boardValidate(){
	var $content = $("[name=content]");
	if(/^(.|\n)+$/.test($content.val()) == false){
		alert("내용을 입력하세요");
		return false;
	}
	return true;
}
$(() => {
	$("[name=upFile]").change(e => {
		//파일명 가져오기
		var file = $(e.target).prop('files')[0];
		console.log(file);
		var $label  = $(e.target).next();
		
		//label 적용
		$label.html(file ? file.name : "파일을 선택하세요.");
		
	});
});



	
</script>


<div id="board-container" class="mx-auto text-center">
	<form name="board"
		action="${pageContext.request.contextPath}/board/updateBoard.do"
		method="post" onsubmit="return boardValidate();">
		<input type="text" class="form-control" placeholder="글번호" name="no"
			id="no" readonly value="${board.no}" required> <input
			type="text" class="form-control" placeholder="제목" name="title"
			id="title" value="${board.title}" required> <input
			type="text" class="form-control" name="memberId"
			value="${board.memberId}" readonly required>


		<c:forEach items="${attachList}" var="attach">

			<button class="btn btn-success btn-block" type="button"
				onclick="location.href='${pageContext.request.contextPath}/board/fileDownload.do?no=${attach.no}';">${attach.originalFilename}</button>
		</c:forEach>

		<button class="btn btn-primary btn-lg btn-block" type="button">부트스트랩버튼
			연습이다.</button>




		<textarea class="form-control" name="content" placeholder="내용"
			required>${board.content}</textarea>

		<input type="number" class="form-control" name="readCount" title="조회수"
			value="${board.readCount}" readonly> <input
			type="datetime-local" class="form-control" readonly
			value='<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd'T'HH:mm" />'>


		<button value="${board.no}"
			class="btn btn-outline-success my-2 my-sm-0" id="btn-update"
			type="submit">수정</button>

		<button value="${board.no}"
			class="btn btn-outline-success my-2 my-sm-0" id="btn-delete"
			onclick="location.href='${pageContext.request.contextPath}/board/deleteBoard.do?no=${board.no}';"
			type="button">삭제</button>
	
	</form>
</div>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
