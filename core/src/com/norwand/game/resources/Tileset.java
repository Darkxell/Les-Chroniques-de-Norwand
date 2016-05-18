package com.norwand.game.resources;

import com.badlogic.gdx.graphics.Pixmap;
import com.norwand.game.utility.objects.AnimatedSprite;

/** A tileset. holds tiles. */
public class Tileset extends PixmapSet {

    public Tileset(int tilesize, Pixmap source) {
	super(tilesize, source);
    }

    /**
     * Returns the annimated sprite of the wanted tile tileset. This is
     * unoptimized, and should not be used in the gameloop.
     */
    public AnimatedSprite getTileAnimation(int id) {
	if (id == -1)
	    return null;
	switch (id) {
	case 565:
	    return new AnimatedSprite(new Pixmap[] { tiles[565], tiles[1013] },
		    (byte) 45);
	case 566:
	    return new AnimatedSprite(new Pixmap[] { tiles[566], tiles[1014] },
		    (byte) 59);
	case 118:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[118], tiles[150] }, (byte) 35);
	case 119:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[119], tiles[151] }, (byte) 20);
	case 120:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[120], tiles[152] }, (byte) 20);
	case 121:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[121], tiles[153] }, (byte) 20);	
	case 122:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[122], tiles[154] }, (byte) 20);
	case 123:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[123], tiles[155] }, (byte) 35);	
	case 124:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[124], tiles[156] }, (byte) 25);		
	case 1013:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1013], tiles[565] }, (byte) 50);
	case 1013:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1013], tiles[565] }, (byte) 50);
	case 1013:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1014], tiles[566] }, (byte) 63);	
	case 1206:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1206], tiles[1238] }, (byte) 30);
	case 1208:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1208], tiles[1240] }, (byte) 30);
	case 1210:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1210], tiles[1242] }, (byte) 30);
	case 1212:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1212], tiles[1244] }, (byte) 30);
	// Water 1 : 1408 : 1472 : 1536 : 1600 : 1664 : 1728 : 1792 : 1856 : 1920 : 1984 : 2048
	case 1344:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1344], tiles[1352] }, (byte) 25);
	case 1345:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1345], tiles[1353] }, (byte) 25);
	case 1346:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1346], tiles[1354] }, (byte) 25);	
	case 1348:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1348], tiles[1356] }, (byte) 25);	
	case 1349:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1349], tiles[1357] }, (byte) 25);	
	case 1350:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1350], tiles[1358] }, (byte) 25);	
	case 1351:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1351], tiles[1359] }, (byte) 25);	
	case 1376:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1376], tiles[1384] }, (byte) 25);
	case 1377:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1377], tiles[1385] }, (byte) 25);
	case 1378:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1378], tiles[1386] }, (byte) 25);
	case 1380:
	    return new AnimatedSprite(
		    new Pixmap[] { tiles[1380], tiles[1388] }, (byte) 25);	
	case 1408:
return new AnimatedSprite(
new Pixmap[] {tiles[1408], tiles[1416] }, (byte) 25);
case 1409:
return new AnimatedSprite(
new Pixmap[] {tiles[1409], tiles[1417] }, (byte) 25);
case 1410:
return new AnimatedSprite(
new Pixmap[] {tiles[1410], tiles[1418] }, (byte) 25);
case 1412:
return new AnimatedSprite(
new Pixmap[] {tiles[1412], tiles[1420] }, (byte) 25);
case 1413:
return new AnimatedSprite(
new Pixmap[] {tiles[1413], tiles[1421] }, (byte) 25);
case 1414:
return new AnimatedSprite(
new Pixmap[] {tiles[1414], tiles[1422] }, (byte) 25);
case 1415:
return new AnimatedSprite(
new Pixmap[] {tiles[1415], tiles[1423] }, (byte) 25);
case 1440:
return new AnimatedSprite(
new Pixmap[] {tiles[1440], tiles[1448] }, (byte) 25);
case 1441:
return new AnimatedSprite(
new Pixmap[] {tiles[1441], tiles[1449] }, (byte) 25);
case 1442:
return new AnimatedSprite(
new Pixmap[] {tiles[1442], tiles[1450] }, (byte) 25);
case 1444:
return new AnimatedSprite(
new Pixmap[] {tiles[1444], tiles[1452] }, (byte) 25);
case 1472:
return new AnimatedSprite(
new Pixmap[] {tiles[1472], tiles[1480] }, (byte) 25);
case 1473:
return new AnimatedSprite(
new Pixmap[] {tiles[1473], tiles[1481] }, (byte) 25);
case 1474:
return new AnimatedSprite(
new Pixmap[] {tiles[1474], tiles[1482] }, (byte) 25);
case 1476:
return new AnimatedSprite(
new Pixmap[] {tiles[1476], tiles[1484] }, (byte) 25);
case 1477:
return new AnimatedSprite(
new Pixmap[] {tiles[1477], tiles[1485] }, (byte) 25);
case 1478:
return new AnimatedSprite(
new Pixmap[] {tiles[1478], tiles[1486] }, (byte) 25);
case 1479:
return new AnimatedSprite(
new Pixmap[] {tiles[1479], tiles[1487] }, (byte) 25);
case 1504:
return new AnimatedSprite(
new Pixmap[] {tiles[1504], tiles[1512] }, (byte) 25);
case 1505:
return new AnimatedSprite(
new Pixmap[] {tiles[1505], tiles[1513] }, (byte) 25);
case 1506:
return new AnimatedSprite(
new Pixmap[] {tiles[1506], tiles[1514] }, (byte) 25);
case 1508:
return new AnimatedSprite(
new Pixmap[] {tiles[1508], tiles[1516] }, (byte) 25);
case 1536:
return new AnimatedSprite(
new Pixmap[] {tiles[1536], tiles[1544] }, (byte) 25);
case 1537:
return new AnimatedSprite(
new Pixmap[] {tiles[1537], tiles[1545] }, (byte) 25);
case 1538:
return new AnimatedSprite(
new Pixmap[] {tiles[1538], tiles[1546] }, (byte) 25);
case 1540:
return new AnimatedSprite(
new Pixmap[] {tiles[1540], tiles[1548] }, (byte) 25);
case 1541:
return new AnimatedSprite(
new Pixmap[] {tiles[1541], tiles[1549] }, (byte) 25);
case 1542:
return new AnimatedSprite(
new Pixmap[] {tiles[1542], tiles[1550] }, (byte) 25);
case 1543:
return new AnimatedSprite(
new Pixmap[] {tiles[1543], tiles[1551] }, (byte) 25);
case 1568:
return new AnimatedSprite(
new Pixmap[] {tiles[1568], tiles[1576] }, (byte) 25);
case 1569:
return new AnimatedSprite(
new Pixmap[] {tiles[1569], tiles[1577] }, (byte) 25);
case 1570:
return new AnimatedSprite(
new Pixmap[] {tiles[1570], tiles[1578] }, (byte) 25);
case 1572:
return new AnimatedSprite(
new Pixmap[] {tiles[1572], tiles[1580] }, (byte) 25);
case 1600:
return new AnimatedSprite(
new Pixmap[] {tiles[1600], tiles[1608] }, (byte) 25);
case 1601:
return new AnimatedSprite(
new Pixmap[] {tiles[1601], tiles[1609] }, (byte) 25);
case 1602:
return new AnimatedSprite(
new Pixmap[] {tiles[1602], tiles[1610] }, (byte) 25);
case 1604:
return new AnimatedSprite(
new Pixmap[] {tiles[1604], tiles[1612] }, (byte) 25);
case 1605:
return new AnimatedSprite(
new Pixmap[] {tiles[1605], tiles[1613] }, (byte) 25);
case 1606:
return new AnimatedSprite(
new Pixmap[] {tiles[1606], tiles[1614] }, (byte) 25);
case 1607:
return new AnimatedSprite(
new Pixmap[] {tiles[1607], tiles[1615] }, (byte) 25);
case 1632:
return new AnimatedSprite(
new Pixmap[] {tiles[1632], tiles[1640] }, (byte) 25);
case 1633:
return new AnimatedSprite(
new Pixmap[] {tiles[1633], tiles[1641] }, (byte) 25);
case 1634:
return new AnimatedSprite(
new Pixmap[] {tiles[1634], tiles[1642] }, (byte) 25);
case 1636:
return new AnimatedSprite(
new Pixmap[] {tiles[1636], tiles[1644] }, (byte) 25);
case 1664:
return new AnimatedSprite(
new Pixmap[] {tiles[1664], tiles[1672] }, (byte) 25);
case 1665:
return new AnimatedSprite(
new Pixmap[] {tiles[1665], tiles[1673] }, (byte) 25);
case 1666:
return new AnimatedSprite(
new Pixmap[] {tiles[1666], tiles[1674] }, (byte) 25);
case 1668:
return new AnimatedSprite(
new Pixmap[] {tiles[1668], tiles[1676] }, (byte) 25);
case 1669:
return new AnimatedSprite(
new Pixmap[] {tiles[1669], tiles[1677] }, (byte) 25);
case 1670:
return new AnimatedSprite(
new Pixmap[] {tiles[1670], tiles[1678] }, (byte) 25);
case 1671:
return new AnimatedSprite(
new Pixmap[] {tiles[1671], tiles[1679] }, (byte) 25);
case 1696:
return new AnimatedSprite(
new Pixmap[] {tiles[1696], tiles[1704] }, (byte) 25);
case 1697:
return new AnimatedSprite(
new Pixmap[] {tiles[1697], tiles[1705] }, (byte) 25);
case 1698:
return new AnimatedSprite(
new Pixmap[] {tiles[1698], tiles[1706] }, (byte) 25);
case 1700:
return new AnimatedSprite(
new Pixmap[] {tiles[1700], tiles[1708] }, (byte) 25);
case 1728:
return new AnimatedSprite(
new Pixmap[] {tiles[1728], tiles[1736] }, (byte) 25);
case 1729:
return new AnimatedSprite(
new Pixmap[] {tiles[1729], tiles[1737] }, (byte) 25);
case 1730:
return new AnimatedSprite(
new Pixmap[] {tiles[1730], tiles[1738] }, (byte) 25);
case 1732:
return new AnimatedSprite(
new Pixmap[] {tiles[1732], tiles[1740] }, (byte) 25);
case 1733:
return new AnimatedSprite(
new Pixmap[] {tiles[1733], tiles[1741] }, (byte) 25);
case 1734:
return new AnimatedSprite(
new Pixmap[] {tiles[1734], tiles[1742] }, (byte) 25);
case 1735:
return new AnimatedSprite(
new Pixmap[] {tiles[1735], tiles[1743] }, (byte) 25);
case 1760:
return new AnimatedSprite(
new Pixmap[] {tiles[1760], tiles[1768] }, (byte) 25);
case 1761:
return new AnimatedSprite(
new Pixmap[] {tiles[1761], tiles[1769] }, (byte) 25);
case 1762:
return new AnimatedSprite(
new Pixmap[] {tiles[1762], tiles[1770] }, (byte) 25);
case 1764:
return new AnimatedSprite(
new Pixmap[] {tiles[1764], tiles[1772] }, (byte) 25);
case 1792:
return new AnimatedSprite(
new Pixmap[] {tiles[1792], tiles[1800] }, (byte) 25);
case 1793:
return new AnimatedSprite(
new Pixmap[] {tiles[1793], tiles[1801] }, (byte) 25);
case 1794:
return new AnimatedSprite(
new Pixmap[] {tiles[1794], tiles[1802] }, (byte) 25);
case 1796:
return new AnimatedSprite(
new Pixmap[] {tiles[1796], tiles[1804] }, (byte) 25);
case 1797:
return new AnimatedSprite(
new Pixmap[] {tiles[1797], tiles[1805] }, (byte) 25);
case 1798:
return new AnimatedSprite(
new Pixmap[] {tiles[1798], tiles[1806] }, (byte) 25);
case 1799:
return new AnimatedSprite(
new Pixmap[] {tiles[1799], tiles[1807] }, (byte) 25);
case 1824:
return new AnimatedSprite(
new Pixmap[] {tiles[1824], tiles[1832] }, (byte) 25);
case 1825:
return new AnimatedSprite(
new Pixmap[] {tiles[1825], tiles[1833] }, (byte) 25);
case 1826:
return new AnimatedSprite(
new Pixmap[] {tiles[1826], tiles[1834] }, (byte) 25);
case 1828:
return new AnimatedSprite(
new Pixmap[] {tiles[1828], tiles[1836] }, (byte) 25);
case 1856:
return new AnimatedSprite(
new Pixmap[] {tiles[1856], tiles[1864] }, (byte) 25);
case 1857:
return new AnimatedSprite(
new Pixmap[] {tiles[1857], tiles[1865] }, (byte) 25);
case 1858:
return new AnimatedSprite(
new Pixmap[] {tiles[1858], tiles[1866] }, (byte) 25);
case 1860:
return new AnimatedSprite(
new Pixmap[] {tiles[1860], tiles[1868] }, (byte) 25);
case 1861:
return new AnimatedSprite(
new Pixmap[] {tiles[1861], tiles[1869] }, (byte) 25);
case 1862:
return new AnimatedSprite(
new Pixmap[] {tiles[1862], tiles[1870] }, (byte) 25);
case 1863:
return new AnimatedSprite(
new Pixmap[] {tiles[1863], tiles[1871] }, (byte) 25);
case 1888:
return new AnimatedSprite(
new Pixmap[] {tiles[1888], tiles[1896] }, (byte) 25);
case 1889:
return new AnimatedSprite(
new Pixmap[] {tiles[1889], tiles[1897] }, (byte) 25);
case 1890:
return new AnimatedSprite(
new Pixmap[] {tiles[1890], tiles[1898] }, (byte) 25);
case 1892:
return new AnimatedSprite(
new Pixmap[] {tiles[1892], tiles[1900] }, (byte) 25);
case 1920:
return new AnimatedSprite(
new Pixmap[] {tiles[1920], tiles[1928] }, (byte) 25);
case 1921:
return new AnimatedSprite(
new Pixmap[] {tiles[1921], tiles[1929] }, (byte) 25);
case 1922:
return new AnimatedSprite(
new Pixmap[] {tiles[1922], tiles[1930] }, (byte) 25);
case 1924:
return new AnimatedSprite(
new Pixmap[] {tiles[1924], tiles[1932] }, (byte) 25);
case 1925:
return new AnimatedSprite(
new Pixmap[] {tiles[1925], tiles[1933] }, (byte) 25);
case 1926:
return new AnimatedSprite(
new Pixmap[] {tiles[1926], tiles[1934] }, (byte) 25);
case 1927:
return new AnimatedSprite(
new Pixmap[] {tiles[1927], tiles[1935] }, (byte) 25);
case 1952:
return new AnimatedSprite(
new Pixmap[] {tiles[1952], tiles[1960] }, (byte) 25);
case 1953:
return new AnimatedSprite(
new Pixmap[] {tiles[1953], tiles[1961] }, (byte) 25);
case 1954:
return new AnimatedSprite(
new Pixmap[] {tiles[1954], tiles[1962] }, (byte) 25);
case 1956:
return new AnimatedSprite(
new Pixmap[] {tiles[1956], tiles[1964] }, (byte) 25);
case 1984:
return new AnimatedSprite(
new Pixmap[] {tiles[1984], tiles[1992] }, (byte) 25);
case 1985:
return new AnimatedSprite(
new Pixmap[] {tiles[1985], tiles[1993] }, (byte) 25);
case 1986:
return new AnimatedSprite(
new Pixmap[] {tiles[1986], tiles[1994] }, (byte) 25);
case 1988:
return new AnimatedSprite(
new Pixmap[] {tiles[1988], tiles[1996] }, (byte) 25);
case 1989:
return new AnimatedSprite(
new Pixmap[] {tiles[1989], tiles[1997] }, (byte) 25);
case 1990:
return new AnimatedSprite(
new Pixmap[] {tiles[1990], tiles[1998] }, (byte) 25);
case 1991:
return new AnimatedSprite(
new Pixmap[] {tiles[1991], tiles[1999] }, (byte) 25);
case 2016:
return new AnimatedSprite(
new Pixmap[] {tiles[2016], tiles[2024] }, (byte) 25);
case 2017:
return new AnimatedSprite(
new Pixmap[] {tiles[2017], tiles[2025] }, (byte) 25);
case 2018:
return new AnimatedSprite(
new Pixmap[] {tiles[2018], tiles[2026] }, (byte) 25);
case 2020:
return new AnimatedSprite(
new Pixmap[] {tiles[2020], tiles[2028] }, (byte) 25);
case 2048:
return new AnimatedSprite(
new Pixmap[] {tiles[2048], tiles[2056] }, (byte) 25);
case 2049:
return new AnimatedSprite(
new Pixmap[] {tiles[2049], tiles[2057] }, (byte) 25);
case 2050:
return new AnimatedSprite(
new Pixmap[] {tiles[2050], tiles[2058] }, (byte) 25);
case 2052:
return new AnimatedSprite(
new Pixmap[] {tiles[2052], tiles[2060] }, (byte) 25);
case 2053:
return new AnimatedSprite(
new Pixmap[] {tiles[2053], tiles[2061] }, (byte) 25);
case 2054:
return new AnimatedSprite(
new Pixmap[] {tiles[2054], tiles[2062] }, (byte) 25);
case 2055:
return new AnimatedSprite(
new Pixmap[] {tiles[2055], tiles[2063] }, (byte) 25);
case 2080:
return new AnimatedSprite(
new Pixmap[] {tiles[2080], tiles[2088] }, (byte) 25);
case 2081:
return new AnimatedSprite(
new Pixmap[] {tiles[2081], tiles[2089] }, (byte) 25);
case 2082:
return new AnimatedSprite(
new Pixmap[] {tiles[2082], tiles[2090] }, (byte) 25);
case 2084:
return new AnimatedSprite(
new Pixmap[] {tiles[2084], tiles[2092] }, (byte) 25);
		
			
			
	}
	try {
	    return new AnimatedSprite(tiles[id]);
	} catch (Exception e) {
	    return null;
	}
    }

}
