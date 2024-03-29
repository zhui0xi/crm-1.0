<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<html>
<head>
    <base href="<%=basePath%>"/>
    <link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

    <script type="text/javascript">

        $(function () {
            //window.top：顶层窗口
            //window：当前窗口
            if (window.top != window) {
                window.top.location = window.location;
            }

            //页面加载完毕后情况用户文本框的内容
            $("#loginAct").val("");

            //页面加载完毕后，让用户文本框自动获取光标
            $("#loginAct").focus();

            //为当前的登录窗口绑定敲键盘事件
            $(window).keydown(function (event) {
                //敲了回车键
                if (event.keyCode == 13) {
                    login();
                }
            })

            //按钮--登录
            $("#loginBtn").click(function () {
                login();
            })

        })

        function login() {
            var loginAct = $.trim($("#loginAct").val()); //去掉左右空格
            var loginPwd = $("#loginPwd").val();

            if (loginAct == "" || $.trim(loginPwd) == "") {
                $("#msg").html("账号密码不能为空");

                //终止函数
                return false;
            }

            $.ajax({
                url: "settings/user/login.do",
                data: {
                    "loginAct": loginAct,
                    "loginPwd": loginPwd
                },
                type: "post",
                dataType: "json",
                success: function (data) {
                    /*
                        data {"success":true/false,"msg":"哪里错了"}
                     */
                    if (data.success) {
                        //跳转页面
                        window.location.href = "workbench/index.jsp";
                    } else {
                        //提示错误信息
                        $("#msg").html(data.msg);
                    }
                }
            })

        }

    </script>
</head>
<body>
<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
    <img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
</div>
<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
    <div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">
        CRM &nbsp;<span style="font-size: 12px;">&copy;2022&nbsp;xxx</span></div>
</div>

<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
    <div style="position: absolute; top: 0px; right: 60px;">
        <div class="page-header">
            <h1>登录</h1>
        </div>
        <form action="workbench/index.jsp" class="form-horizontal" role="form">
            <div class="form-group form-group-lg">
                <div style="width: 350px;">
                    <input class="form-control" type="text" placeholder="用户名" id="loginAct">
                </div>
                <div style="width: 350px; position: relative;top: 20px;">
                    <input class="form-control" type="password" placeholder="密码" id="loginPwd">
                </div>
                <div class="checkbox" style="position: relative;top: 30px; left: 10px;">

                    <span id="msg" style="color:red"></span>

                </div>
                <button type="button" id="loginBtn" class="btn btn-primary btn-lg btn-block"
                        style="width: 350px; position: relative;top: 45px;">登录
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>