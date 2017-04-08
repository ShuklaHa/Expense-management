<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>
Expense Details for B3-704
</title>

<!-- Meta Tags -->
<meta charset="utf-8">
<meta name="generator" content="Wufoo">
<meta name="robots" content="index, follow">

<!-- CSS -->
<link href="css/structure.css" rel="stylesheet">
<link href="css/form.css" rel="stylesheet">

<!-- JavaScript -->
<script src="scripts/wufoo.js"></script>

<!--[if lt IE 10]>
<script src="https://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
</head>

<body id="public">
<div id="container" class="ltr">

<h1 id="logo">
</h1>

  
<header id="header" class="info">
<h2>Expense Details for B3-704</h2>
<div></div>
</header><ul>

<label class="desc notranslate" id="title1" for="Field1">
Mritunjnay's expense for this month : ${mritunjaySum}
</label>
 <div>
Harshit's expense for this month : ${harshitsum}
</div><div>
Total expense for this month : ${total}
</div><div>
Per head amount : ${perHeadAmt}
</div><div>
${finalMessage} ${amountTobeReceived}
</div>
</ul>
</div><!--container-->
</body>
</html>
