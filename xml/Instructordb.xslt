<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/Instructor">
	<html>
    <!-- First we are going to put a title to our database -->
    <head>
    <title><b></b>DataBase for a Surf Camp</title></head></html>
	
	<body>
	<h3> Instructor DataBase</h3>
	<p>Instructor with id = <xsl:value-of select = "@id"/> has the following data: </p>
	<p>-Name: <xsl:value-of select = "@name"/> </p>
	<p>-Phone Number: <xsl:value-of select = "phone_number"/> </p>
	<p>-Date of Birth: <xsl:value-of select = "dob"/> </p>
	<p>-NIF: <xsl:value-of select = "NIF"/> </p>
	<p>-Nationality: <xsl:value-of select = "nationality"/> </p>
	<p>-Salary: <xsl:value-of select = "salary"/> </p>
	<p>This instructor contains the following activities: </p>
     <table border="1">
      <th>id</th>
      <th>name</th>
      <th>price</th>
      <th>availability</th>
      <xsl:for-each select="activities/activity">
      		<tr>
            <td><i><xsl:value-of select="@id" /></i></td>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="price" /></td>
            <td><xsl:value-of select="availability" /></td>
            </tr>
	  </xsl:for-each>
	  </table>
	
	</body>
	
	
</xsl:template>

</xsl:stylesheet>