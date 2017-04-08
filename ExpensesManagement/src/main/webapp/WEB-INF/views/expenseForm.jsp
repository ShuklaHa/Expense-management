<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body id="public">
	<div id="container" class="ltr">

		<form:form id="form10" name="form10" class="wufoo topLabel page"
			accept-charset="UTF-8" method="POST" action="/PutExpense.html" commandName="Expense">

			<header id="header" class="info">
				<h2>Expense Details for B3-704</h2>
				<div></div>
			</header>
			<ul>
				<li id="foli2" class="      "><label class="desc notranslate"
					id="title2" for="Field2"> Select a Name <span id="req_2"
						class="req">*</span>
				</label>
					<div>
						<form:select path="name" id="Field2" name="Field2" class="field select medium"
							tabindex="1">
							<option value="Harshit" selected="selected"><span
									class="notranslate">Harshit</span>
							</option>
							<option value="Mritunjay"><span class="notranslate">Mritunjay</span>
							</option>
						</form:select>
					</div></li>
				<li id="foli4" class="notranslate      "><label class="desc" 
					id="title4" for="Field4"> Item <span id="req_4" class="req">*</span>
				</label>
					<div>
						<form:input path="item" id="Field4" name="Field4" type="text"
							class="field text medium" />
					</div>
					<div>
						<form:errors path="item" />
					</div>
					</li>
				<li id="foli5" class="notranslate      "><label class="desc"
					id="title5" for="Field5"> Expense <span id="req_5"
						class="req">*</span>
				</label>
					<div>
						<form:input path="amount" id="Field5" name="Field5" type="text"
							class="field text small" />
					</div>
					<div>
						<form:errors path="amount" />
					</div>
					</li>
				<li class="buttons ">
					<div>

						<input type="submit" value="Submit"/>
					</div>
				</li>

			</ul>
		</form:form>
<c:if test="${not empty successMesasge}">
 <script type="text/javascript">
 alert("${successMesasge}");
 document.getElementById("item").reset;
 </script>
</c:if>

	</div>
	<!--container-->
</html>