<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.co.semat.TileItUp.Model.ServiceClass"%>
<%@page import="za.co.semat.TileItUp.Model.Customer"%>
<%@page import="org.bson.types.ObjectId"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tile It Up - Services</title>
    <link rel="stylesheet" href="css/selectService.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<body>

    <header class="header">
        <div class="header-left">
            <p>TileItUP</p>
            <div class="message2" id="messageContainer2"></div>
        </div>
       <a href="javascript:history.back()"> <button class="learn-more-button">Back</button></a>
    </header>

    <div class="services-page">
        <h1>Services</h1>
        <div class="services-container">
            <!-- Service items will be inserted here by JavaScript -->
        </div>

        <div class = "list_services_all container d-flex justify-content-center">
            <div>
            <%
                List<ServiceClass> list = (List<ServiceClass>)request.getAttribute("list");
                            Customer c = (Customer)session.getAttribute("obj");
                            String clientname = c.getName();
                            String clientsurname = c.getSurname();
                            ObjectId clientid = c.getId();

                for(ServiceClass s: list){
                    String name = s.getServiceName();
                    String description = s.getDescription();
                    ObjectId id = s.getId();
            %>


                                <div class="each_service_alone">
                                    <h3><%=name%></h3>

                                        <div class="container">

                                        <img src="/Assets/image_red.jpeg" alt="err" height="200">

                                        </div>
                                        <div class="container">

                                        <p><%=description%></p>

                                        </div>

                                        <form action="/interested" method="POST">
                                            <input type="hidden" value=<%=id%> name="serviceId">
                                            <input type="hidden" value=<%=clientid%> name="customerId">
                                            <input id="" class="btn btn-success" type="submit" value="Interested">
                                        </form>

                                </div>


            <%
                }
            %>
            </div>
        </div>

    </div>
    </body>
    </html>