<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fascination Page</title>
    <link rel="stylesheet" href="css/Fascination.css">
</head>
<body>
    <div class="fascination-container">
        <h1>Selected Fascinations</h1>
        <div class="items-container" id="itemsContainer">
            <p>Loading...</p>
        </div>
    </div>

    <form action="/red" method="GET">
        <input type="submit" value="submit">
    </form>

    <script>
        // Fetch fascination data from the server
        async function fetchData() {
            try {
                const response = await fetch('your-api-endpoint'); // Replace 'your-api-endpoint' with the actual API endpoint
                const data = await response.json();
                const itemsContainer = document.getElementById('itemsContainer');
                itemsContainer.innerHTML = '';

                if (data.length > 0) {
                    data.forEach(fascination => {
                        const itemElement = document.createElement('div');
                        itemElement.classList.add('item');
                        itemElement.innerHTML = `
                            <h2>${fascination.title}</h2>
                            <p>${fascination.description}</p>
                        `;
                        itemsContainer.appendChild(itemElement);
                    });
                } else {
                    itemsContainer.innerHTML = '<p>No data available</p>';
                }
            } catch (error) {
                console.error('Error fetching data:', error);
                const itemsContainer = document.getElementById('itemsContainer');
                itemsContainer.innerHTML = '<p>Error fetching data</p>';
            }
        }

        fetchData();
    </script>
</body>
</html>
