<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:d="http://www.uts.edu.au/31284/team2/wsd-hotels">

	<xsl:template match="d:hotels">
		<h1>HOTELS</h1>
		<xsl:apply-templates/>
	</xsl:template>
	
	<xsl:template match="d:hotel">
		<p>Hotel</p>
	</xsl:template>
	
</xsl:stylesheet>