<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:template match="cd">
	<html>
	 <head>
	  <style>
	  	table.tracklist { border: solid 1px black; border-collapse: collapse; }
		table.tracklist td { border: solid 1px #999; }
		.artist { font-style: italic; margin-bottom: 20px; }
		.even { background: #fff; }
		.odd { background: #f2f2f2; }
	  </style>
	 </head>
	 <body>
	  <xsl:apply-templates />
	  <p>Total number of tracks: <xsl:value-of select="count(tracklist/track)"/></p>
	  <p>Average track rating: <xsl:value-of select="sum(tracklist/track/rating) div count(tracklist/track)"/></p>
	 </body>
	</html>
	</xsl:template>
	
	<xsl:template match="cd/title">
		<h1><xsl:apply-templates /></h1>
	</xsl:template>
	
	<xsl:template match="cd/artist">
		<div class="artist"><xsl:apply-templates /></div>
	</xsl:template>
	
	<xsl:template match="tracklist">
	<table class="tracklist">
	 <thead>
	  <tr><th>Track</th><th>Info</th><th>Rating</th></tr>
	 </thead>
	 <tbody>
	  <xsl:apply-templates />
	 </tbody>
	</table>
	</xsl:template>
	
	<xsl:template match="tracklist/track">
		<xsl:param name="thisID" select="count(preceding-sibling::track)+1"/>
		<xsl:param name="rating" select="rating * 20"/>
		<xsl:if test="$thisID mod 2 = 0">
			<tr class="even">
				<td>#<xsl:copy-of select="$thisID"/></td>
				<td><xsl:value-of select="time"/> - <xsl:value-of select="title"/></td>
				<td><div style="width: {$rating}px; height: 12px; background: blue;"></div></td>
			</tr>
		</xsl:if>
		<xsl:if test="$thisID mod 2 = 1">
			<tr class="odd">
				<td>#<xsl:copy-of select="$thisID"/></td>
				<td><xsl:value-of select="time"/> - <xsl:value-of select="title"/></td>
				<td><div style="width: {$rating}px; height: 12px; background: blue;"></div></td>
			</tr>
		</xsl:if>
	</xsl:template>
	
</xsl:stylesheet>