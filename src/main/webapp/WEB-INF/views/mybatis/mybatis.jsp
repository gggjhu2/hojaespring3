<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="a" name="title" />
</jsp:include>

<script>
$(() => {

	$("#btn-board-list").click(() => {
		$.ajax({
			url: "${pageContext.request.contextPath}/board/selectBoardList.do",
			//method: "GET",
			//dataType: "text",
			success(data){
				console.log(data);
			},
			error(xhr, statusText, err){
				console.log(xhr, statusText, err);
			}
		});
		
	});
		
	$("#btn-selectOne").click(() => {
		$.ajax({
			url: "${pageContext.request.contextPath}/board/selectOne.do",
			data: {
			no : 50
			},
			//method: "GET",
			//dataType: "text",
			success(data){
				console.log(data);
			},
			error(xhr, statusText, err){
				console.log(xhr, statusText, err);
			}
		});	
	});
	
	$("#btn-insert").click(() => {
		$.ajax({
			url: "${pageContext.request.contextPath}/board/insertBoard.do",
			data: {
			
				title: '게시글 작성 테스트',
				content : 'abcdefghijklmnopqrstuvwxyz 1234567890 가나다라마바사',
				memberId:'qwerty'
			},
			method: "POST",  // 생략불가
			success(data){
				console.log(data);
			},
			error(xhr, statusText, err){
				console.log(xhr, statusText, err);
			}
		});	
	}); // end of $("#btn-insert").click
	
	$("#btn-update").click(() => {
		$.ajax({
			url: "${pageContext.request.contextPath}/board/updateBoard.do",
			data: {
				title: '바꾼후게시글 작성 테스트바꾼후',
				content : '바꾼후abcdefghijklmnopqrstuvwxyz 1234567890 가나다라마바사',
				no : 45  //pk꼭필요하다
				//50번게시글
			},
			method: "POST",  // 생략불가
			success(data){
				console.log(data);
			},
			error(xhr, statusText, err){
				console.log(xhr, statusText, err);
			}
		});	
	}); // $("#btn-update").click(() => {
	
	
	$("#btn-delete").click(() => {
		$.ajax({
			url: "${pageContext.request.contextPath}/board/deleteBoard.do",
			data: {
				
				no : 67  //pk꼭필요하다
				//50번게시글  몇번글을 지우는지 에대한 것이 필요하기에 pk값하나만넘겨주면된다.
			},
			method: "POST",  // 생략불가
			success(data){
				console.log(data);
			},
			error(xhr, statusText, err){
				console.log(xhr, statusText, err);
			}
		});	
	}); // $("#btn-delet").click(() => {
	
	
	
});

</script>
마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스

<div class="list-group">
	<button type="button" id="btn-board-list""list-group-itemlist-group-item-actionactive" >게시판
		목록 조회</button>


<button type="button" class="list-group-item list-group-item-action"
		id="btn-selectOne">60번게시글조회</button>


	<button type="button" class="list-group-item list-group-item-action"
		id="btn-insert">Insert게시글작성</button>
		
		
<button type="button" class="list-group-item list-group-item-action" id="btn-update">UPDATE업데이트</button>



	<button type="button" class="list-group-item list-group-item-action" id="btn-delete" >DELETE딜리트(삭제)</button>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>