<%--
  Created by IntelliJ IDEA.
  User: 郑华睿
  Date: 2018-11-25
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<s:form id="form" action="DestineInfo_add.action" method="post">
    <s:select id="room" label="会议室名称" list="roomMap" listKey="key" listValue="value" name="destineInfo_db.room.roomId" headerKey="0" headerValue="请选择会议室"></s:select>
    <s:textfield id="time" label="会议时间" name="destineInfo_db.destine_time"></s:textfield>
    <s:textfield id="name" label="预定人" name="destineInfo_db.destine_name"></s:textfield>
    <s:submit value="提交"></s:submit>
</s:form>
</body>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function(){
        $("#form").submit(function(){
            var room = $("#room").val();
            if(room == 0){
                alert("请选择会议室！");
                return false;
            }
            var time = $("#time").val();
            if(time == null || time == ""){
                alert("请填入会议时间！");
                return false;
            }
            var reg = /^\d{4}-(0[1-9]|1[0-2])-([0][1-9]|[1-2][0-9]|3[0-1])$/;
            if(reg.test(time)==false){
                alert("日期格式不对，必须是yyyy-MM-dd格式！");
                return false;
            }
            var name = $("#name").val();
            if(name == null || time == ""){
                alert("请填入预定人！");
                return false;
            }
            return true;
        });
    });
</script>
</html>
