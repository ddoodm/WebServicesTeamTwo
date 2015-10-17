<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:d="http://www.uts.edu.au/31284/team2/wsd">
	
	<xsl:template match="d:hotel">
		<xsl:param name="image" select="d:image-url"/>
		<xsl:param name="email" select="d:email"/>
	
		<h1><xsl:value-of select="d:name"/></h1>
		<div id="hotelDetailDiv">
			<img id="bigHotelImage" src="images/hotels/{$image}" />
			<p>
				<xsl:value-of select="d:address"/>,<br />
				<xsl:value-of select="d:city"/>, <xsl:value-of select="d:country"/><br />
				PH: <xsl:value-of select="d:telephone"/><br />
				<a href="mailto:{$email}"><xsl:value-of select="$email"/></a>
			</p>
			<p><xsl:value-of select="d:description"/></p>
		</div>
	</xsl:template>
	
</xsl:stylesheet>