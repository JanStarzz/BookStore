<%--
  Created by IntelliJ IDEA.
  User: 17672
  Date: 2020/3/11
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<script>

    $(function () {
        $("#goto").click(function () {
            var pn = $("#pn_input").val();
            window.location.href = "${page.url}&pn="+pn;
        })
    })
</script>
<div id="page_nav">
    <a href="${page.url}&pn=1">首页</a>
    <c:if test="${page.hasPrev}">
        <a href="${page.url}&pn=${page.pageNo-1}">上一页</a>
    </c:if>
    <c:if test="${page.totalPage<=5}">
        <c:set var="begin" value="1" scope="page"></c:set>
        <c:set var="end" value="${page.totalPage}" scope="page"></c:set>
    </c:if>
    <c:if test="${page.totalPage>5}">
        <c:if test="${page.pageNo<=3}">
            <c:set var="begin" value="1" scope="page"></c:set>
            <c:set var="end" value="5" scope="page"></c:set>
        </c:if>
        <c:if test="${page.pageNo>3}">
            <c:set var="begin" value="${page.pageNo-2}" scope="page"></c:set>
            <c:set var="end" value="${page.pageNo+2}" scope="page"></c:set>
        </c:if>
        <c:if test="${page.pageNo+2>=page.totalPage}">
            <c:set var="begin" value="${page.totalPage-4}" scope="page"></c:set>
            <c:set var="end" value="${page.totalPage}" scope="page"></c:set>
        </c:if>
    </c:if>
    <c:forEach begin="${begin}" end="${end}" var="pnum">
        <c:if test="${pnum==page.pageNo}">
					<span style="color: red">
						【${page.pageNo}】
					</span>

        </c:if>
        <c:if test="${pnum!=page.pageNo}">
            <a href="${page.url}&pn=${pnum}">${pnum}</a>
        </c:if>
    </c:forEach>

    <c:if test="${page.hasNext}">
        <a href="${page.url}&pn=${page.pageNo+1}">下一页</a>
    </c:if>
    <a href="${page.url}&pn=${page.totalPage}">末页</a>
    共${page.totalPage}页，${page.totalCount}条记录 到第<input value="" name="pn" id="pn_input"/>页
    <input type="button" id="goto" value="确定">
</div>

