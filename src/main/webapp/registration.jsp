<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Create your account</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                                placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="dob">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="date" name="begin" 
                    placeholder="dd-mm-yyyy" value=""
                    min="1997-01-01" max="2030-12-31" path="dob" class="form-control" ></form:input>
                    <form:errors path="dob"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="gender">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form>
                        <p>Please select your gender :</p>
                        <div>
                          <input type="radio" id="contactChoice1"
                           name="gender" value="female">
                          <label for="contactChoice1">female</label>
                      
                          <input type="radio" id="contactChoice2"
                           name="gender" value="male">
                          <label for="contactChoice2">male</label>
                        </div>
                        
                      </form>
                    <form:errors path="gender"></form:errors>
                </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit" style="width: 300px; margin: 0 auto">Submit</button>
        </form:form>

    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
