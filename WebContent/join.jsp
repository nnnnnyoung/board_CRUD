<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="top_nav.jsp" %>
	
	<h1>홈쇼핑 회원 등록</h1>
      <form id="inputForm" action="joinAction" method="post">
         <table border="1">
            <tr>
               <td>회원번호(자동발생)</td>
               <td><input type="text" id="custno" name="custno" value="${nowcnt}" readonly></td>
            </tr>
            <tr>
               <td>회원성명</td>
               <td><input type="text" id="custname" name="custname"></td>
            </tr>
            <tr>
               <td>회원전화</td>
               <td><input type="text" name="phone"></td>
            </tr>
            <tr>
               <td>회원주소</td>
               <td><input type="text" name="address"></td>
            </tr>
            <tr>
               <td>가입일자</td>
               <td><input type="text" name="joindate"></td>
            </tr>
            <tr>
               <td>고객등급</td>
               <td><input type="text" name="grade"></td>
            </tr>
            <tr>
               <td>도시코드</td>
               <td><input type="text" name="city"></td>
            </tr>
            <tr>
               <td colspan="2"><center><input type="button" value="등록" onclick="chk()"> <input
                  type="button" value="조회"></center></td>
            </tr>
         </table>
      </form>
		
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		chk=()=>{
			alert("유효성 검사")
			var inpufrm= documemt.quetySelector("#inputForm")
			alert(inpufrm.custname.value)
			var name= inpufrm.custname.value;
			
			//유효성 검사 코드 작성
			if(name==''){
				alert("이름은 필수 입력입니다.")
				return;
			}
			inpufrm.submit();
			alert('등록을 성공하였습니다.')
			
		}
	
	</script> 
</body>
</html>