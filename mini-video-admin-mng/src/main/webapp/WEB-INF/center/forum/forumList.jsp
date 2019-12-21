<%--
  Created by IntelliJ IDEA.
  User: kkbdv
  Date: 2019/12/10
  Time: 上午 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="<%=request.getContextPath() %>/static/pages/js/forumList.js"
        type="text/javascript"></script>
<!-- BEGIN PAGE HEADER-->
<!-- BEGIN PAGE BAR -->
<div class="page-bar">
    <ul class="page-breadcrumb">
        <li>
            <span>首页</span>
            <i class="fa fa-circle"></i>
        </li>
        <li>
            <span>讲座信息</span>
            <i class="fa fa-circle"></i>
        </li>
        <li>
            <span>讲座列表</span>
        </li>
    </ul>
</div>
<!-- END PAGE BAR -->
<!-- END PAGE HEADER-->

<!-- 列表 jqgrid start -->
<div class="row">

    <div class="col-md-12">
        <br/>
        <div class="usersReportsList_wrapper">
            <table id="usersForumList"></table>
            <div id="usersForumListPager"></div>
        </div>

    </div>
</div>
<!-- 列表 jqgrid end -->
</body>
</html>
