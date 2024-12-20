<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation</title>
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card p-4 shadow">
            <h2 class="text-center mb-4">Make a Reservation</h2>

            <!-- Display success or error messages -->
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success">${successMessage}</div>
            </c:if>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>

            <!-- Reservation Form -->
            <form action="reserve" method="post">
                <div class="mb-3">
                    <label for="roomType" class="form-label">Room Type</label>
                    <select name="roomType" id="roomType" class="form-select" required>
                        <option value="" disabled selected>Select a room type</option>
                        <option value="Single">Single</option>
                        <option value="Double">Double</option>
                        <option value="Suite">Suite</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="checkInDate" class="form-label">Check-in Date</label>
                    <input type="date" name="checkInDate" id="checkInDate" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="checkOutDate" class="form-label">Check-out Date</label>
                    <input type="date" name="checkOutDate" id="checkOutDate" class="form-control" required>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-success">Reserve Now</button>
                </div>
            </form>
        </div>
    </div>
    <script src="validation.js"></script>
    
</body>
</html>
