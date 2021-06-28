<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="a" name="title"/>
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
		
});

</script>
마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스마이바티스

<div class="list-group">
  <button type="button" id="btn-board-list" "list-group-item list-group-item-action active" >
    게시판 목록 조회
  </button>





  	
  <button type="button" class="list-group-item list-group-item-action">Dapibus ac facilisis in</button>
  <button type="button" class="list-group-item list-group-item-action">Morbi leo risus</button>
  <button type="button" class="list-group-item list-group-item-action">Porta ac consectetur ac</button>
  <button type="button" class="list-group-item list-group-item-action" disabled>Vestibulum at eros</button>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>