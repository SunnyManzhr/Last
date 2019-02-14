<%--
  Created by IntelliJ IDEA.
  User: 郑华睿
  Date: 2018-11-25
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
  <head>
    <title>$Title$</title>
    <style type="text/css">
      td{
        text-align:center;
      }
    </style>
  </head>

  <body>
  <s:form action="DestineInfo_findAll" method="POST">
    <s:select id="room" label="会议室名称" list="roomMap" listKey="key" listValue="value" name="roomId" headerKey="0" headerValue="请选择会议室"></s:select>
    <s:textfield label="预定人名称（支持模糊查询）" name="destine_name"></s:textfield>
    <s:submit value="提交"></s:submit>
  </s:form>
  <table border="1" width="900px">
    <tr style="background-color: orange;">
      <th>编号</th>
      <th>会议室名称</th>
      <th>预定人</th>
      <th>日期</th>
    </tr>
    <s:iterator value="destineInfoList" status="i">
      <tr <s:if test="#i.index%2==1">style="background-color: orange;"</s:if>>
        <td><s:property value="id"/></td>
        <td><s:property value="room.room_name"/></td>
        <td><s:property value="destine_name"/></td>
        <td><s:date name="destine_time" format="yyyy-MM-dd"/></td>
      </tr>
    </s:iterator>
  </table>
  <font color="red">
    <s:if test="pageNo>1">
      <a href="DestineInfo_findAll.action?roomId=<s:property value='roomId'/>&destine_name=<s:property value='destine_name'/>&pageNo=<s:property value='pageNo-1'/>">上一页</a>
    </s:if>
    &nbsp;
    <s:iterator begin="1" end="pageNoCount" step="1"  var="i" >
      &nbsp;
      <a href="DestineInfo_findAll.action?roomId=<s:property value='roomId'/>&destine_name=<s:property value='destine_name'/>&pageNo=<s:property value='#i'/>"><s:property value="#i"/></a>
      &nbsp;
    </s:iterator>
    &nbsp;
    <s:if test="pageNo<pageNoCount">
      <a href="DestineInfo_findAll.action?roomId=<s:property value='roomId'/>&destine_name=<s:property value='destine_name'/>&pageNo=<s:property value='pageNo+1'/>">下一页</a>
    </s:if>
  </font>
  <h5 style="margin-left:770px"><font color="red"><a href="toAdd.action">预定</a></font></h5>
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
              return true;
          });
      });
  </script>
</html>
