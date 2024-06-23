<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.co.semat.TileItUp.Model.ServiceClass"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tile It Up - Services</title>
    <link rel="stylesheet" href="css/Services.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<body>

    <header class="header">
        <div class="header-left">
            <p>TileItUP</p>
            <div class="message2" id="messageContainer2"></div>
        </div>
       <a href="/home"> <button class="learn-more-button">Home</button></a>
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

                for(ServiceClass s: list){
                    String name = s.getServiceName();
                    String description = s.getDescription();
            %>


                                <div class="each_service_alone">
                                                                    <h3><%=name%></h3>

                                                                        <div class="container">

                                                                        <img src="/Assets/logo.jpg" alt="err" height="200">

                                                                        </div>
                                                                        <div class="container">

                                                                        <p><%=description%></p>

                                                                        </div>



                                                                </div>


            <%
                }
            %>
            </div>
        </div>

    </div>

    <script>

                const customerList = [{ id: 1, name: 'BrickLaying', img: 'assets/BrickLayers.jpg', description: 'Professional bricklaying services for residential and commercial projects.' }]

               fetch('/api/services')
                   .then(response => {
                       if (!response.ok) {
                           throw new Error('Network response was not ok ' + response.statusText);
                       }
                       return response.json(); // Parse the JSON response
                   })
                   .then(data => {
                       // Convert the received data into a JavaScript list
                       customerList = data;
                       console.log(customerList); // This will log the list of customers

                       // Optionally, display the data on the web page
                       displayCustomers(customerList);
                   })
                   .catch(error => {
                       console.error('There has been a problem with your fetch operation:', error);
                   });
           });

        const services = [
            { id: 1, name: 'BrickLaying', img: 'assets/BrickLayers.jpg', description: 'Professional bricklaying services for residential and commercial projects.' },
            { id: 2, name: 'Carpentry', img: 'assets/Capanter.jpeg', description: 'Expert carpentry for custom furniture, cabinetry, and home renovations.' },
            { id: 3, name: 'House Planning', img: 'assets/House Planer.jpg', description: 'Comprehensive house planning and architectural design services.' },
            { id: 4, name: 'Painting', img: 'assets/Painter.jpg', description: 'High-quality painting services for interior and exterior surfaces.' },
            { id: 5, name: 'Plumbing', img: 'assets/Plumbing.jpg', description: 'Reliable plumbing services for installation, repair, and maintenance.' },
            { id: 6, name: 'Tiling', img: 'assets/Tiling.jpg', description: 'Professional tiling services for kitchens, bathrooms, and flooring.' },
            { id: 7, name: 'Electrician', img: 'assets/Electrician.jpg', description: 'Certified electricians for all your electrical installation and repair needs.' }
        ];

        let interests = {};

        function goHome() {
            window.location.href = "DummyHome.html";
        }

        function handleInterestToggle(id) {
            interests[id] = !interests[id];
            renderServices();
        }

        function renderServices() {
            const container = document.querySelector('.services-container');
            container.innerHTML = '';
            customerList.forEach(service => {
                const serviceElement = document.createElement('div');
                serviceElement.className = 'service';
                serviceElement.innerHTML = `
                    <a href="MoreAboutService.html">
                        <img src="${service.img}" alt="${service.name}" class="service-image">
                    </a>
                    <div class="service-details">
                        <h2>${service.name}</h2>
                        <p>${service.description}</p>
                        <div class="buttons">
                            <button
                                onclick="handleInterestToggle(${service.id})"
                                class="${interests[service.id] ? 'interested' : 'not-interested'}"
                            >
                                ${interests[service.id] ? 'Not Interested' : 'Interested'}
                            </button>
                        </div>
                    </div>
                `;
                container.appendChild(serviceElement);
            });
        }

        window.onload = () => {
            renderServices();
        }
    </script>
</body>
</html>