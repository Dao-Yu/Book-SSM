/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2022-09-08 02:12:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.book_005fstatic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class user_005fdynamicissue_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>书圈</title>\r\n");
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
      out.write("    <link rel=\"stylesheet\" href=\"layui/css/layui.css\" media=\"all\">\r\n");
      out.write("    <link  rel=\"stylesheet\" type=\"text/css\" href=\"css/user_dynamicissue.css\">\r\n");
      out.write("\r\n");
      out.write("    <script src=\"js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <header>\r\n");
      out.write("        发布动态\r\n");
      out.write("    </header>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"layui-container\">\r\n");
      out.write("        <div class=\"layui-row\">\r\n");
      out.write("            <form class=\"layui-form\" action=\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/user/addDynamic\" method=\"post\">\r\n");
      out.write("                <div class=\"layui-form-item layui-form-text\">\r\n");
      out.write("                    <label class=\"layui-form-label\">发布内容</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <textarea  name=\"usertype\" placeholder=\"请输入内容(1000字以内)\" class=\"layui-textarea\"></textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <input type=\"hidden\" id=\"goodimage\" name=\"goodimage\" value=\"\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">图片上传</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <button type=\"button\" class=\"layui-btn\" id=\"upload\">\r\n");
      out.write("                            <i class=\"layui-icon\">&#xe67c;</i>上传图片(图片名字不要含中文)\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <label class=\"layui-form-label\">图片预览</label>\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <img id=\"image\" alt=\"\" style=\"width: 75%;min-height: 300px;height: auto\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <div class=\"layui-form-item\">\r\n");
      out.write("                    <div class=\"layui-input-block\">\r\n");
      out.write("                        <button type=\"submit\" class=\"layui-btn\" lay-submit=\"\" lay-filter=\"demo1\">立即提交</button>\r\n");
      out.write("                        <button type=\"reset\" class=\"layui-btn layui-btn-primary\">重置</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"layui/layui.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("\r\n");
      out.write("        //图片上传\r\n");
      out.write("        layui.use('upload', function(){\r\n");
      out.write("            var upload = layui.upload;\r\n");
      out.write("            var $ = layui.$;\r\n");
      out.write("            //执行实例\r\n");
      out.write("            var uploadInst = upload.render({\r\n");
      out.write("                elem: '#upload' //绑定元素\r\n");
      out.write("                ,url: '../user/upload' //上传接口\r\n");
      out.write("                ,done: function(res){\r\n");
      out.write("                    //上传完毕回调\r\n");
      out.write("                    if(res.code==1){\r\n");
      out.write("                        layer.msg(res.msg)\r\n");
      out.write("                        //首先要获得图片上传之后的图片访问路径\r\n");
      out.write("                        var imagePath = res.data.src;\r\n");
      out.write("                        $(\"#image\").attr(\"src\",imagePath);\r\n");
      out.write("                        $(\"#goodimage\").attr(\"value\",imagePath);\r\n");
      out.write("                    }else{\r\n");
      out.write("                        layer.msg(res.msg)\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                ,error: function(){\r\n");
      out.write("                    //请求异常回调\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
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
