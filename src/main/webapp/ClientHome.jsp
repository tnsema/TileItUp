<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="za.co.semat.TileItUp.Model.Customer"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Our Service Platform</title>
    <link rel="stylesheet" href="css/ClientHome.css">
    <link rel="stylesheet" href="bootstrap/dist/css/bootstrap.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

        <%
            Customer c = (Customer)session.getAttribute("obj");
            String name = c.getName();
            String surname = c.getSurname();
        %>

    <nav>
        <header class="heading">
            <h2>Welcome to Our Service Platform</h2>

        </header>
    </nav>

    <div class="container d-flex justify-content-between">
    <p>Hi, <%=name%> <%=surname%></p>
    <a href="/home"><button class="btn btn-danger">LogOut</button></a>
    </div>

    <div class="container">

        <h1>TileItUp</h1>

        <section id="intro">
            <h3>Welcome to our platform! We provide a wide range of services to meet your needs. Whether you're looking for professional assistance or expert advice, we've got you covered.</h3>
            <p>Explore our services and discover how we can help you achieve your goals.</p>
        </section>

        <section id="services">
            <h2>Our Services</h2>
            <ul>
                <li>Plumbing</li>
                <li>Tiling</li>
                <li>Brick Laying</li>
                <!-- Add more services here -->
            </ul>
        </section>

        <section id="cta">
            <h2>Get Started</h2>
            <p>Ready to take the next step? Click below to explore our services.</p>
            <a href="/getservice"><button class="button">Explore Services</button></a>
        </section>
    </div>

    <footer class="Foot">
        <p>&copy; 2024 TileItUp</p>
    </footer>

    <script>
        function exploreServices() {
            // Redirect the user to the About Us page
            window.location.href = '/AboutUs.jsp';
        }
    </script>
</body>
</html>
