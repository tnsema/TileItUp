<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="za.co.semat.TileItUp.Model.Admin"%>
<%@page import="org.bson.types.ObjectId"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="AdminHome.css">
</head>
<body>

            <%
                Admin a = (Admin)session.getAttribute("obj");
                String name = a.getName();
                String surname = a.getSurname();
                ObjectId id = a.getId();
            %>

    <div class="admin-home">
        <header class="bg-primary text-white text-center py-3">
            <img src="Assets/logo.jpg" alt="TileItUp Logo" class="logo mb-2" />
            <h1>Welcome to TileItUp</h1>
        </header>

            <div class="container d-flex justify-content-between">
            <p>Hi, <%=name%> <%=surname%>, <%=id%></p>
            <a href="/home"><button class="btn btn-danger">LogOut</button></a>
            </div>

        <div class="container my-5">
            <section id="intro" class="text-center mb-5">
                <h2>TileItUp</h2>
                <p class="lead">
                    Welcome to our platform! We provide a wide range of services to meet your needs. Whether you're looking for professional assistance or expert advice, we've got you covered. Explore our services and discover how we can help you achieve your goals.
                </p>
            </section>

            <section id="services" class="mb-5">
                <h2 class="text-center">Admin Platform</h2>
                <div class="row">
                    <div class="col-md-6 col-lg-3 mb-4">
                        <div class="card">
                            <div class="card-body text-center">
                                <h5 class="card-title">Add Details</h5>
                                <button class="btn btn-primary" onclick="addDetails()">Add Details</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 mb-4">
                        <div class="card">
                            <div class="card-body text-center">
                                <h5 class="card-title">Edit Details</h5>
                                <button class="btn btn-primary" onclick="editDetails()">Edit Details</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 mb-4">
                        <div class="card">
                            <div class="card-body text-center">
                                <h5 class="card-title">View Services</h5>
                                <button class="btn btn-primary" onclick="exploreServices()">Explore Services</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 mb-4">
                        <div class="card">
                            <div class="card-body text-center">
                                <h5 class="card-title">View Fascinations</h5>
                                <button class="btn btn-primary" onclick="exploreFascinations()">Explore Fascinations</button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section id="cta" class="text-center">
                <h2>Get Started</h2>
                <p>Ready to take the next step? Click below to explore our services.</p>
                <button class="btn btn-success mx-2" onclick="exploreServices()">Explore Services</button>
                <a href="/listfacination"><button class="btn btn-success mx-2" onclick="exploreFascinations()">Explore Fascinations</button></a>
            </section>
        </div>

        <footer class="bg-primary text-white text-center py-3">
            <p>&copy; 2024 TileItUp</p>
            <button class="btn btn-secondary" onclick="handleSignOut()">Sign Out</button>
        </footer>
    </div>

    <script>
        function handleSignOut() {
            console.log('Admin signed out');
        }

        function exploreServices() {
            console.log('Exploring services');
            // Implement redirection to service page
        }

        function exploreFascinations() {
            console.log('Exploring fascinations');
            // Implement redirection to fascination page
        }

        function addDetails() {
            console.log('Adding details');
            // Implement functionality to add details
        }

        function editDetails() {
            console.log('Editing details');
            // Implement functionality to edit details
        }
    </script>
</body>
</html>
