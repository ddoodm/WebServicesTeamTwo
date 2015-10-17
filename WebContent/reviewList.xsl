<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:d="http://www.uts.edu.au/31284/team2/wsd">
	
	<xsl:template match="d:reviews">
		<h1>REVIEWS</h1>
		<xsl:choose>
			<xsl:when test="count(d:review) &gt; 0">
				<table id="reviewListTable">
					<tr>
						<td width="250">Title</td>
						<td width="250">Date</td>
						<td width="250">Rating</td>
					</tr>
					<xsl:apply-templates />
				</table>
			</xsl:when>
			<xsl:otherwise>
				There are no reviews for this hotel.
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	
	<xsl:template match="d:review">
		<xsl:param name="reviewId" select="@id"/>
	
		<tr>
			<td><a href="review.jsp?id={$reviewId}"><xsl:value-of select="@title"/></a></td>
			<td><xsl:value-of select="@date"/></td>
			<td><xsl:call-template name="starLoop"/></td>
		</tr>
	</xsl:template>
	
	<xsl:template name="starLoop">
		<xsl:param name="index" select="1"/>
		<xsl:param name="loopEnd" select="@rating"/>
		
		<xsl:if test="$index &lt; $loopEnd">
			<xsl:call-template name="starLoop">
				<xsl:with-param name="index" select="$index + 1" />
			</xsl:call-template>
		</xsl:if>
		
		<img src="style/star.png" />
		
	</xsl:template>
	
</xsl:stylesheet>