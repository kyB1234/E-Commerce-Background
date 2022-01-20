<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script href="js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <title>Login</title>

</head>

<body>
    <div id="adminLoginDlg" class="container">
        <div class="row" style="white-space: nowrap; overflow: hidden; height: 0px; padding-top: 20%;">
        </div>
        <div class="row">
            <div class="col-md-4 column">
            </div>
            <div class="col-md-4 column p-4 border bg-light" style="border-radius: 20px;">
                <div class="row mb-5">
                    <h1>Log in</h1>
                </div>
                <form id="adminForm">
                    <div class="mb-4">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username" name="name">
                    </div>
                    <div class="mb-4">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="pwd">
                    </div>
                    <div class="mb-4">
                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary btn-bloc">Sign in</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-4 column">
            </div>
        </div>
    </div>
    <script>
        $('#adminForm').submit(() => {
            $.ajax({
                type: 'POST',
                url: 'admininfo/login',
                dataType: 'json',
                data: {
                    name: $('#username').val(),
                    pwd: $('#password').val()
                },
                success: function(result) {
                    if (result.success == 'true') {
                        window.location.href = 'admin.jsp';
                        $("#adminLoginDlg").dialog("close");
                    } else {
                        alert(result.message);
                    }
                }
            });
            return false;
        })
    </script>
</body>

</html>