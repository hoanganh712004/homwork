<%-- 
    Document   : index
    Created on : Dec 20, 2024, 9:47:25 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>CACULATE</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        <div class="div1">
            <h1>QUADRATIC EQUATION</h1> <br>
            <h1>y = Ax<sup>2</sup> + Bx + C</h1>
            <form action="quadratic" method="POST">
                <table border="1" style="border-collapse: collapse">
                    <tbody>
                        <tr>
                            <td for="a">Number a: </td>
                            <td>
                                <input type="text" name="a" id="a">
                            </td>
                        </tr>
                        <tr>
                            <td for="b">Number b: </td>
                            <td>
                                <input type="text" name="b" id="b">
                            </td>
                        </tr>
                        <tr>
                            <td for="c">Number c: </td>
                            <td>
                                <input type="text" name="c" id="c">
                            </td>
                        </tr>

                    </tbody>
                </table>
                <input type="submit" value="CACULATE" class="caculate">


                <p>${requestScope.message}</p>

            </form>

        </div>

    </body>

</html>

