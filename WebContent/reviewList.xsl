<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:d="http://www.uts.edu.au/31284/team2/wsd">
	
	<xsl:template match="d:reviews">
		<h1>REVIEWS</h1>
		<ul>
			<xsl:apply-templates />
		</ul>
	</xsl:template>
	
	<xsl:template match="d:review">
		<li>
			<xsl:apply-templates />
		</li>
	</xsl:template>
	
</xsl:stylesheet>