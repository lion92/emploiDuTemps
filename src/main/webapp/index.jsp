<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h2>Emploi du temps</h2>
<h1><%= "Hello World!" %>
</h1>
<h1> Student Registration Page</h1>
<h1> Student Registration Page</h1>
<form action="<%= request.getContextPath() %>/StudentServlet" method="post">

    Horraire: <input type="text" name="scheduled">
    <br> <br>
Professeur :<input type="text" name="prof">
    <br> <br>

    Matiere: <input type="text" name="matiereProf">
    <br> <br>

    jour: <input type="text" name="jour">
    <br> <br>

    <input type="submit" value="register">
</form>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<div>
    <h2>Emploi du temps</h2>

    <div id="m1">

        Voir les matières :
        <div>
            <em>ajouter le bouton eps ici</em>
            <input value='EPS' type="button" onclick=showEPS
        </div>
        <div>
            <em>ajouter le bouton math ici</em>
        </div>
        <div>
            <em>ajouter le bouton projet ici</em>
        </div>
    </div>

    <div id="t1">
        <table>
            <tr>
                <th> Heure </th>
                <th> Lundi </th>
                <th> Mardi </th>
                <th> Mercredi </th>
                <th> Jeudi </th>
                <th> Vendredi </th>
                <th> Samedi </th>
                <th> Dimanche </th>
            </tr>
            <tr>
                <td> </td>
                <td class="français"></td>
                <td class="EPS"> </td>
                <td> </td>
                <td> </td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td> </td>
                <td>  </td>
                <td>  </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td> </td>
                <td>  </td>
                <td> </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td> </td>
                <td class="pause"> </td>
                <td class="pause"> </td>
                <td class="pause">  </td>
                <td class="pause"></td>
                <td class="pause"> </td>
                <td class="pause"></td>
                <td class="pause"></td>
            </tr>
            <tr>
                <td>  </td>
                <td> </td>
                <td> </td>
                <td> </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td> </td>
                <td> </td>
                <td> </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
    <style>
        body {
            background-color: Azure;
            font-family: sans-serif;
            font-size: 90%
        }

        h2{
            color: DarkSlateGray;
        }

        #m1, #t1 {
            display: inline-block;
            vertical-align: top;
        }

        table{
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid Gray;
            padding: 7px;
            text-align: left;
        }

        th {
            color: White;
            background-color: MediumSeaGreen;
        }

        .pause {
            background-color: Wheat;
            font-style: italic;
        }


        tr th:first-child, tr td:first-child {
            background-color: SlateBlue;
            color: white;
            font-weight: bold;
            text-align: right;
        }

        tr td:nth-last-child(2){
            background-color: LightSteelBlue;
        }

        tr td:last-child{
            background-color: Silver;
        }

        button{
            background-color: PaleTurquoise;
            border-radius: 5px;
            margin: 3px
        }

        .français {
            background-color: silver;
        }
    </style>
</div>
</body>
</html>