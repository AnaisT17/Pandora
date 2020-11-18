<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
	<head>
<title><h:outputText value="Impossible de vous identifier" /></title>
	</head>
	<body>
		<h:form>
			<h3>
				<h:outputText value="Impossible de vous identifiez" />
			</h3>
			<table>
				<tr>
					<td><h:commandButton value="réessayez" action="login" /></td>
				</tr>
			</table>
		</h:form>
	</body>
</f:view>
</html>