<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"  %>

<f:form commandName="administrator">
<f:input path="username"/>
<f:errors path="username"></f:errors>
<f:input path="password"/>
<f:errors path="password"></f:errors>
<f:input path="repeatedPassword"/>
<input type="submit" />
</f:form>