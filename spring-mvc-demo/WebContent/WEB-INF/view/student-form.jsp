<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student registration</title>
</head>
<body>
<form:form action="processForm" modelAttribute ="student">

First name: <form:input path="firstName"/>
<br><br>

Last name: <form:input path="lastName"/>
<br><br>

<form:select path="country">
<form:options items="${student.countryOptions}" />
</form:select>

<br><br>
Favourite language:
Java <form:radiobutton path="favouriteLanguage" value="Java"/>
PHP <form:radiobutton path="favouriteLanguage" value="PHP"/>
C++ <form:radiobutton path="favouriteLanguage" value="C++"/>
C# <form:radiobutton path="favouriteLanguage" value="C#"/>

<br><br>
Operating Systems: 

Linux<form:checkbox path="operatingSystems" value="Linux" />

Windows<form:checkbox path="operatingSystems" value="Windows" />

Mac<form:checkbox path="operatingSystems" value="Mac" />


<br><br>
<input type="submit" value="Submit"/>

</form:form>
</body>


</html>