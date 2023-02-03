<%-- 
    Document   : index
    Created on : 3 февр. 2023 г., 19:01:22
    Author     : pahadaha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start page</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css" />
    </head>
    <body>
        <h1>CD list</h1>
        <table>
            <tr>
                <th>Description</th>
                <th class="center">Price</th>
                <th>&nbsp;</th>
            </tr>
            <tr>
                <td>86 (the band) - True Life Songs and Pictures</td>
                <td class="right">$14.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="8601">
                        <input type="submit" value="Add To Cart">
                    </form></td>
            </tr>
            <tr>
                <td>Paddlefoot - The first CD</td>
                <td class="right">$12.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="pf01">
                        <input type="submit" value="Add To Cart">
                    </form></td>
            </tr>
            <tr>
                <td>Paddlefoot - The second CD</td>
                <td class="right">$14.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="pf02">
                        <input type="submit" value="Add To Cart">
                    </form></td>
            </tr>
            <tr>
                <td>Joe Rut - Genuine Wood Grained Finish</td>
                <td class="right">$14.95</td>
                <td><form action="cart" method="post">
                        <input type="hidden" name="productCode" value="jr01">
                        <input type="submit" value="Add To Cart">
                    </form></td>
            </tr>
        </table>
    </body>
</html>
