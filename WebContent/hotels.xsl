<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="d:hotels">
	<html>
	 <head>
	  <style>
	  
	  </style>
	 </head>
	 <body>
	  <h1>Hotels</h1>
	  <xsl:apply-templates />
	 </body>
	</html>
	</xsl:template>
	
	<xsl:template match="d:hotel">
		<p>Hotel</p>
	</xsl:template>
	
</xsl:stylesheet>