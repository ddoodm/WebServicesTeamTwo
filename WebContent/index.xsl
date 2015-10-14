<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:d="http://www.uts.edu.au/31284/team2/wsd-hotels">

	<xsl:template match="d:hotels">
		<h1>HOTEL LISTING</h1>
		<div id="hotelListing">
			<xsl:apply-templates />
		</div>
	</xsl:template>
	
	<xsl:template match="d:hotel">
		<xsl:param name="image" select="d:image-url"/>
	
		<div class="hotelListItem">
			<img class="hotelListIcon" src="images/hotels/{$image}" />
			<h2><xsl:value-of select="d:name"/></h2>
			<p><xsl:value-of select="d:city"/>, <xsl:value-of select="d:country"/></p>
			<p>Average Rating: TEST / 10</p>
			<p><xsl:value-of select="d:description"/></p>
			<p>Reviews: TEST</p>
		</div>
	</xsl:template>
	
</xsl:stylesheet>
