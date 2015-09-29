<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<c:import var="xslt" url="cd2.xsl" />
<x:transform xslt="${xslt}">
<cd>
	<title>Some Title</title>
</cd>
</x:transform>