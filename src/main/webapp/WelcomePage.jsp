<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link rel="stylesheet" href="css/HomePage.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="wrapper">
        <nav class="nav">
            <div class="nav-logo">
                <p>Tile It Up</p>
            </div>
            <div class="nav-menu" id="navMenu">
                <ul>
                    <li><a href="#" class="link active">Home</a></li>
                    <li><a href="/yu" class="link">Services</a></li>
                    <li><a href="/about" class="link">About</a></li>
                </ul>
            </div>
            <div class="nav-button">
                <button class="btn white-btn" id="loginBtn">Sign In</button>
                <button class="btn" id="registerBtn">Sign Up</button>
            </div>
            <div class="nav-menu-btn">
                <i class="bx bx-menu" onclick="toggleNavMenu()"></i>
            </div>
        </nav>

        <div class="carousel-container">
            <!-- Carousel items -->
        </div>

        <div class="form-box">
            <div class="login-container" id="login">
                <!-- Login form -->
            </div>
            <div class="register-container" id="register">
                <!-- Register form -->
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        // JavaScript logic
        function toggleNavMenu() {
            const navMenu = document.getElementById('navMenu');
            if (navMenu.classList.contains('responsive')) {
                navMenu.classList.remove('responsive');
            } else {
                navMenu.classList.add('responsive');
            }
        }

        // Handle login and register buttons click events
        const loginBtn = document.getElementById('loginBtn');
        const registerBtn = document.getElementById('registerBtn');
        const loginContainer = document.getElementById('login');
        const registerContainer = document.getElementById('register');

        loginBtn.addEventListener('click', function() {
            loginContainer.style.display = 'block';
            registerContainer.style.display = 'none';
        });

        registerBtn.addEventListener('click', function() {
            registerContainer.style.display = 'block';
            loginContainer.style.display = 'none';
        });
    </script>
</body>
</html>
