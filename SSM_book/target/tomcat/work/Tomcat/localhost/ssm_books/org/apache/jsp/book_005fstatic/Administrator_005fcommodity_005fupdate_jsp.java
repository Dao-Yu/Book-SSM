/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2022-09-17 07:19:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.book_005fstatic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Administrator_005fcommodity_005fupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <title>商品修改</title>\r\n");
      out.write("\r\n");
      out.write("    ");
 String path = request.getRequestURI();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + path;

    
      out.write("\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <link href=\"layui/css/layui.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<fieldset class=\"layui-elem-field layui-field-title\" style=\"margin-top: 20px;\">\r\n");
      out.write("    <legend>商品信息修改</legend>\r\n");
      out.write("</fieldset>\r\n");
      out.write("\r\n");
      out.write("<form class=\"layui-form\" action=\"\" lay-filter=\"bookForm\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-form-item\" hidden>\r\n");
      out.write("        <label class=\"layui-form-label\">商品id</label>\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <input type=\"text\" name=\"id\"  lay-verify=\"required\" lay-reqtext=\"不能为空\" placeholder=\"请输入\"\r\n");
      out.write("                   autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">作品名称</label>\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <input type=\"text\" name=\"bookname\" id=\"bookname\" lay-verify=\"required\" lay-reqtext=\"不能为空\" placeholder=\"请输入\"\r\n");
      out.write("                   autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <label class=\"layui-form-label\">作者</label>\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <input type=\"text\" name=\"bookauthor\" id=\"bookauthor\" lay-verify=\"required\" lay-reqtext=\"不能为空\"\r\n");
      out.write("                   placeholder=\"请输入\" autocomplete=\"off\" class=\"layui-input\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\">商品发布状态</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"text\" name=\"bookstate\" id=\"bookstate\"  class=\"layui-input demo-phone\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <div class=\"layui-inline\">\r\n");
      out.write("            <label class=\"layui-form-label\">被收藏数</label>\r\n");
      out.write("            <div class=\"layui-input-inline\">\r\n");
      out.write("                <input type=\"text\" name=\"bookCollection\" id=\"bookCollection\" class=\"layui-input demo-phone\">\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-form-item\">\r\n");
      out.write("        <div class=\"layui-input-block\">\r\n");
      out.write("            <button type=\"button\" class=\"layui-btn\" lay-submit=\"\" lay-filter=\"demo1\">\r\n");
      out.write("                立即提交\r\n");
      out.write("            </button>\r\n");
      out.write("            <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"layui/layui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    layui.use(['form', 'util', 'laydate','table'], function () {\r\n");
      out.write("        var form = layui.form;\r\n");
      out.write("        var layer = layui.layer;\r\n");
      out.write("        var table = layui.table;\r\n");
      out.write("        var util = layui.util;\r\n");
      out.write("        var laydate = layui.laydate;\r\n");
      out.write("\r\n");
      out.write("        var data = JSON.parse(localStorage.getItem(\"user\"));\r\n");
      out.write("        // console.log(data)\r\n");
      out.write("\r\n");
      out.write("        form.val(\"bookForm\",{\r\n");
      out.write("            \"id\":data.id,\r\n");
      out.write("            \"bookname\":data.bookname,\r\n");
      out.write("            \"bookauthor\":data.bookauthor,\r\n");
      out.write("            \"bookstate\":data.bookstate,\r\n");
      out.write("            \"bookCollection\":data.bookCollection\r\n");
      out.write("\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //提交事件\r\n");
      out.write("        form.on('submit(demo1)', function(data){\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/updatecommodity\",\r\n");
      out.write("                data: data.field,\r\n");
      out.write("                type:\"POST\",\r\n");
      out.write("                success: function (data) {\r\n");
      out.write("\r\n");
      out.write("                    if(data.code==200){\r\n");
      out.write("                        layer.msg(\"修改成功\");\r\n");
      out.write("\r\n");
      out.write("                    }else{\r\n");
      out.write("                        layer.msg(\"修改失败\")\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                error: function (data) {\r\n");
      out.write("                    alert(\"错误\")\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("            return false;\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}