<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tile It Up</title>
    <link rel="stylesheet" href="css/Welcome.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
                    <li><a href="" class="link active">Home</a></li>
                    <li><a href="/services" class="link">Services</a></li>
                    <li><a href="/about" class="link">About</a></li>
                </ul>
            </div>
            <div class="nav-button">
                <button class="btn white-btn" id="loginBtn" onclick="handleLoginClick()">Sign In</button>
                <button class="btn" id="registerBtn" onclick="handleRegisterClick()">Sign Up</button>
            </div>
            <div class="nav-menu-btn">
                <i class="bx bx-menu" onclick="toggleNavMenu()"></i>
            </div>
        </nav>

        <div id="carouselExample" class="carousel slide carousel-container" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="Assets/BrickLayers.jpg" class="d-block w-100" alt="BrickLayers">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>BrickLayers</h3>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="Assets/Capanter.jpeg" class="d-block w-100" alt="Carpenter">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Carpenter</h3>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="Assets/Plumbing.jpg" class="d-block w-100" alt="Plumbing">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Plumbing</h3>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="Assets/Electrician.jpg" class="d-block w-100" alt="Electrician">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>Electrician</h3>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="Assets/House Planer.jpg" class="d-block w-100" alt="House Planner">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>House Planner</h3>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExample" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExample" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>


        <div class="form-box" id="formContainer">
            <div class="login-container" id="login">
                <div class="top">
                    <span>Don't have an account? <a href="#" onclick="handleRegisterClick()">Sign Up</a></span>
                    <header>Login</header>

                </div>

                <form action="/login" method="POST">
                <div class="input-box">
                    <input type="text" class="input-field" placeholder="Username or Email" name="email">
                    <i class="bx bx-user"></i>
                </div>
                <div class="input-box">
                    <input type="password" class="input-field" placeholder="Password" name="password">
                    <i class="bx bx-lock-alt"></i>
                </div>
                <div class="input-box">
                    <input type="submit" class="submit" value="Sign In">
                </div>
                </form>
                <div class="two-col">
                    <div class="one">
                        <input type="checkbox" id="login-check">
                        <label for="login-check"> Remember Me</label>
                    </div>
                    <div class="two">
                        <label><a href="resetpassword.jsp">Forgot password?</a></label>
                    </div>
                </div>
            </div>
            <div class="register-container" id="register" style="display: none;">
                <div class="top">
                    <span>Have an account? <a href="#" onclick="handleLoginClick()">Login</a></span>
                    <header>Sign Up</header>
                </div>
                <form action="/signup" method="POST">
                <div class="two-forms">
                    <div class="input-box">
                        <input type="text" class="input-field" placeholder="Firstname" name="name">
                        <i class="bx bx-user"></i>
                    </div>
                    <div class="input-box">
                        <input type="text" class="input-field" placeholder="Lastname" name="surname">
                        <i class="bx bx-user"></i>
                    </div>
                </div>
                <div class="input-box">
                    <input type="text" class="input-field" placeholder="Email" name="email">
                    <i class="bx bx-envelope"></i>
                </div>
                <div class="input-box">
                    <input type="password" class="input-field" placeholder="Password" name="password">
                    <i class="bx bx-lock-alt"></i>
                </div>
                <div class="input-box">
                                    <input type="text" class="input-field" placeholder="Confirm Password" name="confirmpassword">
                                    <i class="bx bx-envelope"></i>
                                </div>

                <div class="input-box">

                    <select class="input-field" name = "gender">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </select>
                </div>

                <div class="input-box">
                                    <input type="text" class="input-field" placeholder="Province" name="province">
                                    <i class="bx bx-envelope"></i>
                                </div>
                <div class="input-box">
                                    <input type="text" class="input-field" placeholder="Town" name="town">
                                    <i class="bx bx-envelope"></i>
                                </div>
                <div class="input-box">
                    <input type="submit" class="submit" value="Register">
                </div>
                </form>
                <div class="two-col">

                    <div class="two">
                        <label><a href="#">Terms & conditions</a></label>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        function handleLoginClick() {
            document.getElementById('login').style.display = 'block';
            document.getElementById('register').style.display = 'none';
            document.getElementById('loginBtn').classList.add('white-btn');
            document.getElementById('registerBtn').classList.remove('white-btn');
        }

        function handleRegisterClick() {
            document.getElementById('login').style.display = 'none';
            document.getElementById('register').style.display = 'block';
            document.getElementById('loginBtn').classList.remove('white-btn');
            document.getElementById('registerBtn').classList.add('white-btn');
        }

        function toggleNavMenu() {
            var navMenu = document.getElementById('navMenu');
            if (navMenu.className === "nav-menu") {
                navMenu.className += " responsive";
            } else {
                navMenu.className = "nav-menu";
            }
        }
    </script>
</body>
</html>
