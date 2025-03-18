<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class = "container card my-5">
		<h3 class ="card-header mb-3 alert alert-primary">FORM-SCORE</h3>
		<%
			int kor = Integer.parseInt(request.getParameter("kor"));
			int math = Integer.parseInt(request.getParameter("math"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int total = kor+math+eng;
			double avg = total/3.0;
			//String avg=String.format("%.2f",total/3.0);
			char korGrade, mathGrade, engGrade; String pass;
			if(90<=kor){korGrade='A';} else if(80<=kor){korGrade='B';}else if(70<=kor){korGrade='C';} else if(60<=kor){korGrade='D';} else{korGrade='E';}
			if(90<=math){mathGrade='A';} else if(80<=math){mathGrade='B';}else if(70<=math){mathGrade='C';} else if(60<=math){mathGrade='D';} else{mathGrade='E';}
			if(90<=eng){engGrade='A';} else if(80<=eng){engGrade='B';}else if(70<=eng){engGrade='C';} else if(60<=eng){engGrade='D';} else{engGrade='E';}
			if(60<=avg&&40<=kor&&40<=eng&&40<=math){pass="합격";}else{pass="불합격";}
		%>
		<div class="my-3">
			<p>국어 : <%=kor %> | <%=korGrade %></p>
			<p>수학 : <%=math %> | <%=mathGrade %></p>
			<p>영어 : <%=eng %> | <%=engGrade %></p>
			<p>총점 : <%=total %></p>
			<p>평균 : <%=avg %></p>
			<p>합격 : <%=pass %></p>
			
			<table class="table table-bordered table-striped table-hover my-5">
			<caption>성적처리</caption>
	          <thead>
	            <tr>
	              <th scope="col">KOR</th>
	              <th scope="col">ENG</th>
	              <th scope="col">MATH</th>
	              <th scope="col">TOTAL</th>
	              <th scope="col">AVG</th>
	              <th scope="col">PASS</th>
	            </tr>
	          </thead>
	          <tbody>
	          	<tr>
	          		<td><%=kor %></td>
	          		<td><%=math %></td>
	          		<td><%=eng %></td>
	          		<td><%=total %></td>
	          		<td><%=avg %></td>
	          		<td><%=pass %></td>
	          	</tr>
	          </tbody>
	        </table>
			
		</div>
		<p><a href="javascript:history.go(-1)" class = "btn btn-danger" title="입력창으로 돌아가기">처음으로</a></p>
		
	</div>
</body>
</html>