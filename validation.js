/**
 * Validate the reservation form.
 */
function validateReservationForm() {
    const roomType = document.getElementById('roomType').value;
    const checkInDate = document.getElementById('checkInDate').value;
    const checkOutDate = document.getElementById('checkOutDate').value;

    // Validate room type
    if (!roomType) {
        alert("Please select a room type.");
        return false;
    }

    // Validate check-in date
    if (!checkInDate) {
        alert("Please select a check-in date.");
        return false;
    }

    // Validate check-out date
    if (!checkOutDate) {
        alert("Please select a check-out date.");
        return false;
    }

    // Check date logic
    const checkIn = new Date(checkInDate);
    const checkOut = new Date(checkOutDate);

    if (checkIn >= checkOut) {
        alert("Check-out date must be after the check-in date.");
        return false;
    }

    return true;
}

/**
 * Validate the registration form.
 */
function validateRegistrationForm() {
    const name = document.getElementById('name').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value;

    // Validate name
    if (!name) {
        alert("Name is required.");
        return false;
    }

    // Validate email
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }

    // Validate password
    if (password.length < 6) {
        alert("Password must be at least 6 characters long.");
        return false;
    }

    return true;
}
