<!DOCTYPE html>
<html>
<head>
    <title><c:out value="${user != null ? 'Edit User' : 'Add User'}" /></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center"><c:out value="${user != null ? 'Edit User' : 'Add User'}" /></h1>
        <form action="UserServlet" method="post" class="form-group">
            <input type="hidden" name="action" value="${user != null ? 'update' : 'insert'}">
            <input type="hidden" name="id" value="${user.id}">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" class="form-control" value="${user.name}" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" class="form-control" value="${user.email}" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="UserServlet?action=list" class="btn btn-secondary">Back to User List</a>
        </form>
    </div>
</body>
</html>