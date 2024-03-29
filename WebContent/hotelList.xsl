<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:d="http://www.uts.edu.au/31284/team2/wsd">

	<xsl:template match="d:hotels">
		<h1>HOTEL LISTING</h1>
		
		<span id="searchSpan">
			<form method="GET" action="index.jsp">
				Hotel Search 
				<input type="text" name="search" />
				<input type="submit" value="Search" />
			</form>
		</span>
		
		<div id="hotelListing">
			<xsl:apply-templates />
		</div>
	</xsl:template>
	
	<xsl:template match="d:hotel">
		<xsl:param name="hotelId" select="@id"/>
		<xsl:param name="image" select="d:image-url"/>
	
		<div class="hotelListItem">
			<img class="hotelListIcon" src="images/hotels/{$image}" />
			<h2><a href='hotel.jsp?id={$hotelId}'><xsl:value-of select="d:name"/></a></h2>
			<p><xsl:value-of select="d:city"/>, <xsl:value-of select="d:country"/></p>
			<p><xsl:value-of select="d:description"/></p>
		</div>
	</xsl:template>
	
</xsl:stylesheet>
