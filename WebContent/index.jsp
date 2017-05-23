<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://use.fontawesome.com/75789e144f.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/NTOUNews/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Ntou News</title>
</head>
<body>
<%@include file="NavgationBar.jsp" %>  
<table  id="history" ><tbody>
  
</tbody>
</table>
<div>
<c:choose>
<c:when test = "${empty param.type}">
      <c:forEach var = "i" begin = "0" end = "3">
         <div class="panel panel-primary"><div id="header" class="panel-body"><i class=${IconList[i]}></i>${TypeList[i]}</div><div id="title" class="panel panel-info"><div class="panel-body"><p><img src="${list[i][0].imageUrl}"></p><a href="${list[i][0].url}" class="url" target = _blank>${list[i][0].title}</a></div></div><div id="content" class="panel-footer">${list[i][0].content}</div></div>
      </c:forEach>
</c:when>
<c:otherwise>
      <c:forEach var = "i" begin = "${param.type}" end = "${param.type}">   
      	<c:forEach var="j" items="${list[i]}">        
         <div class="panel panel-primary"><div id="header" class="panel-body"><i class=${IconList[i]}></i></div><div id="title" class="panel panel-info"><div class="panel-body"><p><img src="${j.imageUrl}"></p><a href="${j.url}" target = _blank id="url" class="url">${j.title}</a></div></div><div id="content" class="panel-footer">${j.content}
         </div></div>
        </c:forEach>
      </c:forEach>
</c:otherwise>
</c:choose>
<script>
  $(document).ready(
    function() {
     $(".url").click(function(){
       var data=[];
       var dataURL = [];
      if(localStorage.getItem("history")&&localStorage.getItem("url")){
         data =JSON.parse(localStorage.getItem("history"))
         dataURL =JSON.parse(localStorage.getItem("url"))
      }
      data.push($(this).text())
      dataURL.push($(this).attr("href"))
      localStorage.setItem("history", JSON.stringify(data));
      localStorage.setItem("url", JSON.stringify(dataURL));

      console.log(localStorage.getItem("history"));
      console.log(localStorage.getItem("url"));
      //refresh();
     var data=JSON.parse(localStorage.getItem("history"))
     var dataURL = JSON.parse(localStorage.getItem("url"))
     $("#history").html($("#history").html()+"<tr><td><a href="+$(this).attr("href")+">"+$(this).text()+"</a></td></tr>")
    
     })
     var data=JSON.parse(localStorage.getItem("history"))
     var dataURL = JSON.parse(localStorage.getItem("history"))
     $("#history").html($("#history").html()+"<tr><th>瀏覽紀錄</th></tr>")
   for (i in data){
     $("#history").html($("#history").html()+"<tr><td><a href="+dataURL[dataURL.length-1]+">"+data[i]+"</a></td></tr>")
     console.log(data[i])
    }
   }
  );
</script>
</div>
</body>
</html>