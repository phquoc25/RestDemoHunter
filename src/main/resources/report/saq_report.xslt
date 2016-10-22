<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"  encoding="UTF-8"/>
    <xsl:variable name="table_header_bg_color">#2980BA</xsl:variable>
    <xsl:variable name="table_body_bg_color">#F5F5F5</xsl:variable>
    <xsl:variable name="front_color">#FFFFFF</xsl:variable>
    <xsl:template match="/Report">
        <xsl:variable name="contentFont"
                      select="contentFont"/>
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format" font-family="{$contentFont}">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4-portrait" page-height="29.7cm" page-width="24.0cm">
                    <fo:region-body margin="40pt 0"/>
                    <fo:region-after extent="1.0cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4-portrait">
                <fo:static-content flow-name="xsl-region-after"  margin="0 15pt">
                    <fo:block>
                        <fo:table width="100%" table-layout="fixed">
                            <fo:table-column column-width="34%"/>
                            <fo:table-column column-width="33%"/>
                            <fo:table-column column-width="33%"/>
                            <fo:table-body>
                                <fo:table-row display-align="center">
                                    <fo:table-cell>
                                        <fo:block>Exported: <xsl:value-of select="exportedDate"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell text-align="center">
                                        <fo:block>by: <xsl:value-of select="by"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell text-align="right">
                                        <fo:block>&#xA9;Sedex Technology Solutions.</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                </fo:static-content>
                <fo:flow flow-name="xsl-region-body"  font-size="10pt">
                    <fo:block margin-top="-40pt" margin-bottom="20pt">
                        <fo:external-graphic src="url('sedex_header.PNG')"
                                             width="100%"
                                             content-height="100pt"
                                             content-width="scale-to-fit"
                                             scaling="non-uniform"/>
                    </fo:block>
                    <fo:block font-size="15pt" margin="0 15pt">
                        Site Details
                    </fo:block>
                    <fo:table width="100%" table-layout="fixed">
                        <fo:table-column column-width="5%"/>
                        <fo:table-column column-width="90%"/>
                        <fo:table-column column-width="5%"/>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:table width="100%" margin-bottom="5pt" table-layout="fixed">
                                        <fo:table-column column-width="30%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="20%"/>
                                        <fo:table-column column-width="30%"/>
                                        <fo:table-body>
                                            <fo:table-row font-size="12pt" background-color="{$table_header_bg_color}" color="{$front_color}">
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>Site <xsl:value-of select="' &amp;'"/> Company name</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>Address</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>Sector Profile(s)</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>SAQ Details</fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                            <fo:table-row background-color="{$table_body_bg_color}">
                                                <fo:table-cell  padding="5pt">
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/company/name"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/company/code"/>
                                                    </fo:block>
                                                    <fo:block margin-top="5pt">
                                                        <xsl:value-of select="siteDetails/site/name"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/site/code"/>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="5pt">
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/address/addressLine1"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/address/addressLine2"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/address/city"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/address/postCode"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/address/countryName"/>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:value-of select="siteDetails/address/countryCode"/>
                                                    </fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="5pt">
                                                    <xsl:for-each select="siteDetails/sectorProfiles">
                                                        <fo:block>
                                                            <xsl:value-of select="."/>
                                                        </fo:block>
                                                    </xsl:for-each>
                                                </fo:table-cell>
                                                <fo:table-cell padding="5pt">
                                                    <fo:block>
                                                        <xsl:if test="siteDetails/lastUpdated !=''">
                                                            Last Updated: <xsl:value-of select="siteDetails/lastUpdated"/>
                                                        </xsl:if>
                                                    </fo:block>
                                                    <fo:block>
                                                        <xsl:if test="siteDetails/completion !=''">
                                                            Completion: <xsl:value-of select="siteDetails/completion"/>%
                                                        </xsl:if>
                                                    </fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                        </fo:table-body>
                                    </fo:table>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>                    
                    <fo:block border-bottom-width="2pt" width="100%" border-bottom-style="solid" border-bottom-color="#C7C7C7" margin="5"/>
                    <fo:block font-size="15pt" margin="0 15pt">Worker Numbers</fo:block>
                    <fo:table width="100%" table-layout="fixed">
                        <fo:table-column column-width="5%"/>
                        <fo:table-column column-width="90%"/>
                        <fo:table-column column-width="5%"/>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:table width="100%" margin-bottom="5pt" table-layout="fixed">
                                        <fo:table-column column-width="55%"/>
                                        <fo:table-column column-width="15%"/>
                                        <fo:table-column column-width="15%"/>
                                        <fo:table-column column-width="15%"/>
                                        <fo:table-body>
                                            <fo:table-row font-size="12pt" background-color="{$table_header_bg_color}" color="{$front_color}" font-weight="bold">
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>&#160;</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>Women</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>Men</fo:block>
                                                </fo:table-cell>
                                                <fo:table-cell padding="8pt">
                                                    <fo:block>Total</fo:block>
                                                </fo:table-cell>
                                            </fo:table-row>
                                            <xsl:for-each select="workerNumbers">
                                                <fo:table-row background-color="{$table_body_bg_color}">
                                                    <fo:table-cell  padding="5pt">
                                                        <fo:block>
                                                            <xsl:value-of select="workderType"/>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell padding="5pt">
                                                        <fo:block>
                                                            <xsl:value-of select="women"/>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell padding="5pt">
                                                        <fo:block>
                                                            <xsl:value-of select="men"/>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                    <fo:table-cell padding="5pt">
                                                        <fo:block>
                                                            <xsl:value-of select="total"/>
                                                        </fo:block>
                                                    </fo:table-cell>
                                                </fo:table-row>
                                            </xsl:for-each>
                                        </fo:table-body>
                                    </fo:table>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>&#160;</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:block border-bottom-width="2pt" width="100%" border-bottom-style="solid" border-bottom-color="#C7C7C7" margin="5"/>
                    <fo:block font-size="15pt" margin="0 15pt">SAQ Results</fo:block>
                    <xsl:for-each select="saqResultsList">
                        <fo:table width="100%" margin-bottom="20pt" table-layout="fixed">
                            <fo:table-column column-width="5%"/>
                            <fo:table-column column-width="90%"/>
                            <fo:table-column column-width="5%"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block>&#160;</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:table width="100%" margin-bottom="5pt" table-layout="fixed">
                                            <fo:table-column column-width="15%"/>
                                            <fo:table-column column-width="50%"/>
                                            <fo:table-column column-width="25%"/>
                                            <fo:table-column column-width="10%"/>
                                            <fo:table-header font-size="12pt">
                                                <fo:table-row keep-with-next="always" background-color="{$table_header_bg_color}" color="{$front_color}" font-weight="bold">
                                                    <xsl:for-each select="headers">                                                    
                                                        <fo:table-cell padding="8pt" margin-top="20pt">
                                                            <fo:block>
                                                                <xsl:value-of select="."/>
                                                            </fo:block>
                                                        </fo:table-cell>
                                                    </xsl:for-each>
                                                </fo:table-row>
                                            </fo:table-header>
                                            <fo:table-body>
                                                <xsl:for-each select="saqResults">
                                                    <xsl:variable name="odd_even_color">
                                                        <xsl:choose>
                                                            <xsl:when test="position() mod 2 = 0">#FFFFFF</xsl:when>
                                                            <xsl:otherwise>#F5F5F5</xsl:otherwise>
                                                        </xsl:choose>
                                                    </xsl:variable>
                                                    <fo:table-row background-color="{$odd_even_color}">
                                                        <fo:table-cell  padding="5pt">
                                                            <fo:block>
                                                                <xsl:value-of select="saqQuestionCode"/>
                                                            </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell padding="5pt">
                                                            <fo:block>
                                                                <xsl:value-of select="question"/>
                                                            </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell padding="5pt">
                                                            <fo:block>
                                                                <xsl:value-of select="answer"/>
                                                            </fo:block>
                                                        </fo:table-cell>
                                                        <fo:table-cell padding="5pt">
                                                            <fo:block>
                                                                <xsl:if test="global !=''">
                                                                    <fo:inline>[</fo:inline>
                                                                    <fo:inline padding="0 5pt">
                                                                        <xsl:value-of select="global"/>
                                                                    </fo:inline>
                                                                    <fo:inline>]</fo:inline>
                                                                </xsl:if>
                                                            </fo:block>
                                                        </fo:table-cell>
                                                    </fo:table-row>
                                                </xsl:for-each>
                                            </fo:table-body>
                                        </fo:table>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>&#160;</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>