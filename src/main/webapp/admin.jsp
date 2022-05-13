<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    if (session.getAttribute("admin") == null)
        response.sendRedirect("/e-commerence-background/admin_login.jsp");
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <meta charset="utf-8">
    <title>background page</title>
    <style>
        
    </style>
</head>

<body>
    <div class="container h-100">
        <div class="row" style="height: 10%;">
            
        </div>
        <div class="row" style="height: 70%;">
            <div class="col-md-0.5 column">
            </div>
            <div class="col-md-11.5 column p-4 border bg-light" style="border-radius: 20px; height: 100%;">
                <div class="row" style="height: 100%;">
                    <div class="col-md-3 column" style="height: 100%; overflow: auto;">
                        <div class="flex-shrink-0 p-3 bg-white" style="width: 95%;" id="slide-pannel">
                            <a class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
                                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="24" fill="currentColor"
                                    class="bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                                    <path fill-rule="evenodd"
                                        d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
                                </svg>
                                &nbsp&nbsp&nbsp
                                <span id="adminName" class="fs-5 fw-semibold">Welcome</span>
                            </a>
                            <ul id="FnTree" class="list-unstyled ps-0">
                                
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-9 column border bg-light" style="height: 100%; border-radius: 20px;">
                        <iframe id="funcDetail" src="" frameborder="0" style="height: 100%; width: 100%; overflow: hidden !important;"></iframe>
                    </div>
                </div>
                
            </div>
            <div class="col-md-0.5 column">
            </div>
        </div>
    </div>
    <script>
        function buildTree(node) {
            let tree = "<li class=\"mb-1\">";
            tree += "<button class=\"btn btn-toggle align-items-center rounded collapsed\" data-bs-toggle=\"collapse\" data-bs-target=\"#collapse-" + node.id + "\" aria-expanded=\"false\">";
            tree += node.text + "</button>";
            if (node.children) {
                tree += "<div class=\"collapse\" id=\"collapse-" + node.id + "\">";
                tree += "<ul class=\"btn-toggle-nav list-unstyled fw-normal pb-1 small\">";
                for (let i = 0; i < node.children.length; ++i) {
                    tree += "<li><button class=\"btn subtree rounded\" id=\"collapse-" + node.children[i].id + "\">" + node.children[i].text + "</button></li>";
                }
                tree += "</ul></div>";
            }
            tree += "</li>";
            return tree;
        };
        $.ajax({
            type: 'POST',
            url: 'admininfo/getTree?adminid=${sessionScope.admin.id}',
            success: function(result) {
                if (result[0].children) {
                    let tree = "";
                    for (let i = 0; i < result[0].children.length; ++i) {
                        tree += buildTree(result[0].children[i]);
                    }
                    $('#FnTree').append(tree);
                }
                let exit = "<li class=\"border-top my-3\"></li><li class=\"mb-1\">" + 
                    "<button class=\"btn align-items-center rounded\">Account</button></li>";
                $('#FnTree').append(exit);
            }
        });
        $('#adminName').text('Welcome, ${sessionScope.admin.name}');
        $('#FnTree').on('click', '#collapse-3', () => {
            console.log('collapse-3 click run');
            $('#funcDetail').attr('src', 'productlist.jsp')
        });
    </script>
</body>

</html>