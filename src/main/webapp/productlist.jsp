<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
    if (session.getAttribute("admin") == null)
        response.sendRedirect("/e-commerence-background/admin_login.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
        <meta charset="utf-8">
        <title>Hello Bootstrap</title>
        <style>
            body,
            html {
                height: 100%;
            }

            .btn-control button:hover,
            .btn-control button:focus {
                background-color: #d2f4ea;
            }
        </style>
    </head>
    <body>
        <div class="container-fiuled bg-light h-100 px-4">
            <div class="row py-3 mb-3 border-bottom fw-bold" style="height: 50px;">
                <a>Productlist</a>
            </div>
            <div class="row mb-3">
                <div class="row">
                    <div class="col-7">
                        <div class="btn-group btn-group-justified btn-control">                
                            <button class="btn btn-light d-flex align-items-center" type="button" data-bs-toggle="offcanvas" data-bs-target="#search_offcanvasTop" aria-controls="offcanvasTop" style="margin-right: 3px; font-size: small;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                                  </svg>
                                &nbspSearch
                            </button>
                            <button class="btn btn-light d-flex align-items-center" type="button" data-bs-toggle="modal" data-bs-target="#addModal" style="margin-right: 3px; font-size: small;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-plus" viewBox="0 0 16 16">
                                    <path d="M8 6.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V11a.5.5 0 0 1-1 0V9.5H6a.5.5 0 0 1 0-1h1.5V7a.5.5 0 0 1 .5-.5z"/>
                                    <path d="M14 4.5V14a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h5.5L14 4.5zm-3 0A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V4.5h-2z"/>
                                  </svg>
                                &nbspAdd
                            </button>
                            <button class="btn btn-light d-flex align-items-center" type="button" style="margin-right: 3px; font-size: small;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
                                    <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
                                  </svg>
                                &nbspEdit
                            </button>
                            <button class="btn btn-light d-flex align-items-center" type="button" style="margin-right: 3px; font-size: small;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-earmark-x" viewBox="0 0 16 16">
                                    <path d="M6.854 7.146a.5.5 0 1 0-.708.708L7.293 9l-1.147 1.146a.5.5 0 0 0 .708.708L8 9.707l1.146 1.147a.5.5 0 0 0 .708-.708L8.707 9l1.147-1.146a.5.5 0 0 0-.708-.708L8 8.293 6.854 7.146z"/>
                                    <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2zM9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5v2z"/>
                                </svg>
                                &nbspDelete
                            </button>
                        </div>
                    </div>
                </div>     
            </div>
            <div class="row">
                <div>
                    <table id="productTable" data-toogle="table" class="table table-responsive table-borderless bg-white" style="font-size: 13px;">
                        
                    </table>
                </div>
            </div>
            <div class="offcanvas offcanvas-top" tabindex="-1" id="search_offcanvasTop" aria-labelledby="offcanvasTopLabel">
                <div class="offcanvas-body">
                    <div class="row mb-1">
                        <div class="col-2">
                            <h5 id="offcanvasTopLabel">Search</h5>
                        </div>
                        <div class="col"></div>
                        <div class="col-1">
                            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                        </div>
                    </div>
                    <div class="row mb-1">
                        <form>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text">Code</span>
                                <input type="text" class="form-control" id="prod_code" style="margin-right: 10px;">
                                <span class="input-group-text">Name</span>
                                <input type="text" class="form-control" id="prod_name" style="margin-right: 10px;">
                                <span class="input-group-text">Type</span>
                                <select class="form-select" id="prod_type">
                                    
                                </select>
                            </div>
                            <div class="input-group input-group-sm mb-3">
                                <span class="input-group-text">Band</span>
                                <input type="text" class="form-control" id="prod_brand" style="margin-right: 10px;">
                                <span class="input-group-text">Price</span>
                                <input type="text" class="form-control" id="prod_priceFrom" style="margin-right: 10px;">
                                <a>~&nbsp&nbsp</a>
                                <input type="text" class="form-control" id="prod_priceTo" style="margin-right: 10px;">
                            </div>
                            <button id="searchProduct" type="button" class="btn btn-success btn-sm" data-bs-dismiss="offcanvas">Search</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="addModal" data-bs-backdrop="static" data-bs-keyboard="false">
                <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Add product</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <div class="modal-body">
                            <form id="addForm">
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span >status</span>
                                    </div>
                                    <div class="col-6">
                                        <select class="form-select" name="status" id="add_status">
                                            <option value="1">on sale</option>
                                            <option value="0">sold out</option>
                                        </select>
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span >type</span>
                                    </div>
                                    <div class="col-6">
                                        <select class="form-select" name="type.id" id="add_type">
                                            
                                        </select>
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span>name</span>
                                    </div>
                                    <div class="col-6">
                                        <input type="text" name="name" class="form-control" id="add_name">
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span>code</span>
                                    </div>
                                    <div class="col-6">
                                        <input type="text" name="code" class="form-control" id="add_code">
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span>brand</span>
                                    </div>
                                    <div class="col-6">
                                        <input type="text" name="code" class="form-control" id="add_brand">
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span>number</span>
                                    </div>
                                    <div class="col-6">
                                        <input type="text" name="num" class="form-control" id="add_num">
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span>price</span>
                                    </div>
                                    <div class="col-6">
                                        <input type="text" name="price" class="form-control" id="add_price">
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="row mb-2">
                                    <div class="col-2"></div>
                                    <div class="col-2" style="display: flex; flex-direction:column;justify-content: center;text-align: center;">
                                        <span>intro</span>
                                    </div>
                                    <div class="col-6">
                                        <textarea class="form-control" name="intro" id="add_intro" rows="2"></textarea>
                                    </div>
                                    <div class="col-2"></div>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal" style="font-size: 13px;">Save</button>
                                    <button type="button" class="btn btn-outline-secondary" style="font-size: 13px;">Clear</button>
                                </div>
                            </form>
                        </div>
                    </div>    
                </div>
            </div>
        </div>
        <script>
            $(function() {
                $.ajax({
                    type: 'get',
                    url: 'type/getType/1',
                    dataType: 'json',
                    success: function(result) {
                        let typeSelect = "";
                        for (let i = 0; i < result.length; ++i) {
                            typeSelect += "<option value=\"" + result[i].id + "\">" + result[i].name + "</option>";
                        }
                        $('#prod_type').append(typeSelect);
                        $('#add_type').append(typeSelect)
                        
                    }
                });
                loadTable("", "", '0', "", '0', '0');
            });
            function loadTable(code, name, tid, brand, priceFrom, priceTo) {
                $('#productTable').bootstrapTable({
                    url: 'productinfo/list',
                    method: 'post',
                    contentType: 'application/x-www-form-urlencoded',
                    dataType: 'json',
                    pagination: true,
                    pageSize: 10,
                    pageNumber: 1,
                    singleSelect: false,
                    queryParamsType: false,
                    queryParams: function queryParams(params){
                        var param = {
                            page: params.pageNumber,
                            rows: params.pageSize,
                            code: code,
                            name: name,
                            'type.id': tid,
                            brand: brand,
                            priceFrom: priceFrom,
                            priceTo: priceTo
                        };
                        return param;
                    },
                    cache: false,
                    sidePagination: 'server',
                    columns: [
                        {
                            checkbox: true
                        },
                        {
                            title: 'id',
                            field: 'id',
                            valign: 'middle'
                        },
                        {
                            title: 'name',
                            field: 'name',
                            valign: 'middle'
                        },
                        {
                            title: 'type',
                            field: 'type',
                            valign: 'middle',
                            formatter: function(value, row, index) {
                                if (row.type) return row.type.name;
                                else return value;
                            }
                        },
                        {
                            title: 'status',
                            field: 'status',
                            valign: 'middle',
                            formatter: function(value, row, index) {
                                if (row.status == 1) return "on sale";
                                else return "sold out";
                            }
                        },
                        {
                            title: 'code',
                            field: 'code',
                            valign: 'middle'
                        },
                        {
                            title: 'brand',
                            field: 'brand',
                            valign: 'middle'
                        },
                        {
                            title: 'price',
                            field: 'price',
                            valign: 'middle'
                        },
                        {
                            title: 'number',
                            field: 'num',
                            valign: 'middle'
                        },
                        {
                            title: 'introduction',
                            field: 'intro',
                            valign: 'middle'
                        }
                    ],

                });
            };
            $('#searchProduct').click(() => {
                let prod_code = $('#prod_code').val();
                let prod_name = $('#prod_name').val();
                let prod_tid = $('#prod_type').children('option:selected').val();
                let prod_brand = $('#prod_brand').val();
                let prod_priceFrom;
                if ($('#prod_priceFrom').val() != null && $('#prod_priceFrom').val() != "") {
                    prod_priceFrom = $('#prod_priceFrom').val();
                } else {
                    prod_priceFrom = "0";
                }
                let prod_priceTo;
                if ($('#prod_priceTo').val() != null && $('#prod_priceTo').val() != "") {
                    prod_priceTo = $('#prod_priceTo').val();
                } else {
                    prod_priceTo = "0";
                }
                $('#productTable').bootstrapTable('destroy');
                loadTable(prod_code, prod_name, prod_tid, prod_brand, prod_priceFrom, prod_priceTo);
            });
            $('#addForm').submit(() => {
                console.log("add submit run")
                $.ajax({
                    type: "post",
                    url: "productinfo/addProduct",
                    dataType: "json",
                    data: {
                        status: $('#add_status').children('option:selected').val(),
                        "type.id": $('#add_type').children('option:selected').val(),
                        name: $('#add_name').val(),
                        code: $('#add_code').val(),
                        brand: $('#add_brand').val(),
                        num: $('#add_num').val(),
                        intro: $('#add_intro').val(),
                        price: $('#add_price').val()
                    },
                    success: (result) => {
                        if (result.success == true) {
                            $('#productTable').bootstrapTable('refresh');
                        }
                        alert(result.message);
                    }
                });
            });
        </script>
    </body>
</html>