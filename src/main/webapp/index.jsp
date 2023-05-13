<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
        <H1>Lire l'emploi du temps</H1>
        <form action="<%= request.getContextPath() %>/read" method="post">
            <br> <br>
            <input type="submit" value="lire">
        </form>
<div class="container">
    <div class="main">
        <div class="first">
            <H1>Creer un cour dans l'emploi du temps</H1>
            <form action="<%= request.getContextPath() %>/StudentServlet" method="post">

                Horraire: <input type="text" placeholder="Double" name="scheduled">
                <br> <br>
                Professeur :<input type="text" name="prof">
                <br> <br>

                Matiere: <input type="text" name="matiereProf">
                <br> <br>

                jour: <input type="text" placeholder="Lundi Mardi Mercrdi Jeudi Vendredi Samedi Dimanche" name="jour">
                <br> <br>

                <input type="submit" value="Creer">
            </form>
        </div>
    </div>
    <div class="main">
        <div class="first">
            <H1>Changer un cour dans l'emploi du temps</H1>
            <form action="<%= request.getContextPath() %>/UpdateServelet" method="post">
                Id: <input type="text" placeholder="Nomber entier" name="id">
                <br> <br>
                Horraire: <input type="text" placeholder="Double" name="scheduled">
                <br> <br>
                Professeur :<input type="text" name="prof">
                <br> <br>

                Matiere: <input type="text" name="matiereProf">
                <br> <br>

                jour: <input type="text" placeholder="Lundi Mardi Mercrdi Jeudi Vendredi Samedi Dimanche"name="jour">
                <br> <br>

                <input type="submit" value="Changer">
            </form>
        </div>
    </div>
    <div class="main">
        <div class="first">
            <H1>Supprimer un cour dans l'emploi du temps</H1>
            <form action="<%= request.getContextPath() %>/DeleteServelet" method="post">
                Id: <input type="text" placeholder= "Nombre entier" name="id">
                <br> <br>
                <input type="submit" value="Supprimer">
            </form>
        </div>
    </div>

    <style>
        /* Below line is used for online Google font */
        @import "http://fonts.googleapis.com/css?family=Ubuntu";

        body {
            margin: 0;
            padding: 0;
            font-family: 'Ubuntu', sans-serif
        }

        .main {
            width: 710px;
            height: 100%;
            margin: 30px auto
        }

        .first {
            width: 400px;
            height: 100%;
            box-shadow: 0 0 0 1px rgba(14, 41, 57, 0.12), 0 2px 5px rgba(14, 41, 57, 0.44), inset 0 -1px 2px rgba(14, 41, 57, 0.15);
            float: left;
            padding:10px 50px 0;
            background: linear-gradient(#fff, #f2f6f9)
        }

        hr {
            border: 0;
            border-top: 1px solid #ccc;
            margin-bottom: 30px
        }

        label {
            font-size: 17px
        }

        input {
            width: 400px;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 35px;
            border-radius: 5px;
            border: 1px solid #cbcbcb;
            box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.18);
            font-size: 16px
        }

        textarea {
            width: 400px;
            height: 100px;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 35px;
            border-radius: 5px;
            border: 1px solid #cbcbcb;
            box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.18);
            font-size: 16px
        }

        input[type=submit] {
            background: linear-gradient(to bottom, #22abe9 5%, #36caf0 100%);
            box-shadow: inset 0 1px 0 0 #7bdcf4;
            border: 1px solid #0F799E;
            color: #fff;
            font-size: 19px;
            font-weight: 700;
            cursor: pointer;
            text-shadow: 0 1px 0 #13506D
        }

        input[type=submit]:hover {
            background: linear-gradient(to bottom, #36caf0 5%, #22abe9 100%)
        }

        .container {
            margin: 5px;
            padding: 1px;
            display: grid;
            grid-template-columns: repeat(5, 1fr);
        }
    </style>

</div>
</body>
</html>