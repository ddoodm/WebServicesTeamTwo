<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:d="http://www.uts.edu.au/31284/team2/wsd">
	
	<xsl:template match="d:review">
		<p><xsl:call-template name="starLoop"/> (<xsl:value-of select="@rating"/> / 10)</p>
		<p><xsl:apply-templates/></p>
	</xsl:template>

	<xsl:template name="starLoop">
		<xsl:param name="index" select="1" />
		<xsl:param name="loopEnd" select="@rating" />

		<xsl:if test="$index &lt; $loopEnd">
			<xsl:call-template name="starLoop">
				<xsl:with-param name="index" select="$index + 1" />
			</xsl:call-template>
		</xsl:if>

		<img src="style/star.png" />

	</xsl:template>

</xsl:stylesheet>