/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2022-09-09 05:04:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.book_005fstatic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Administrator_005fusermanagement_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>用户管理</title>\r\n");
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
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"css/Administrator_usermanag.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"layui/css/layui.css\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("    <script src=\"js/Administrator_usermanagement.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"layui/layui.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table class=\"layui-hide\" id=\"test\" lay-filter=\"test\"></table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/html\" id=\"barDemo\">\r\n");
      out.write("    <a class=\"layui-btn layui-btn-xs\" lay-event=\"edit\" >编辑</a>\r\n");
      out.write("    <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    layui.use(['table', 'dropdown'], function(){\r\n");
      out.write("        var table = layui.table;\r\n");
      out.write("        var dropdown = layui.dropdown;\r\n");
      out.write("\r\n");
      out.write("        // 创建渲染实例\r\n");
      out.write("        table.render({\r\n");
      out.write("            elem: '#test'\r\n");
      out.write("            ,url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/user' // 此处为静态模拟数据，实际使用时需换成真实接口\r\n");
      out.write("            ,height: 'full-30' // 最大高度减去其他容器已占有的高度差\r\n");
      out.write("            ,cellMinWidth: 80\r\n");
      out.write("            ,totalRow: false // 开启合计行\r\n");
      out.write("            ,page: false\r\n");
      out.write("            ,cols: [[\r\n");
      out.write("                {type: 'checkbox', fixed: 'left'}\r\n");
      out.write("                ,{field:'id', fixed: 'left', width:80, title: 'ID', sort: true, totalRowText: '合计：'}\r\n");
      out.write("                ,{field:'user', width:120, title: '账号'}\r\n");
      out.write("                ,{field:'username', width:280, title: '用户名'}\r\n");
      out.write("                ,{field:'email', title:'邮箱 <i class=\"layui-icon layui-icon-email\"></i>', hide: 0, width:280, edit: 'text'}\r\n");
      out.write("                ,{field:'creationtime', title:'加入时间', width: 200}\r\n");
      out.write("                ,{field:'userjurisdiction', title:'权限', width: 80}\r\n");
      out.write("                ,{fixed: 'right', title:'操作', width: 280, minWidth: 125, toolbar: '#barDemo'}\r\n");
      out.write("            ]]\r\n");
      out.write("            ,error: function(res, msg){\r\n");
      out.write("                console.log(res, msg)\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 触发单元格工具事件\r\n");
      out.write("        table.on('tool(test)', function(obj){ // 双击 toolDouble\r\n");
      out.write("            var data = obj.data;\r\n");
      out.write("            //console.log(obj)\r\n");
      out.write("            if(obj.event === 'del'){\r\n");
      out.write("                layer.confirm('真的删除行么', function(index){\r\n");
      out.write("                    var userid = data.id;\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/admin/deleteuser\",\r\n");
      out.write("                        type: \"post\",\r\n");
      out.write("                        data: {\r\n");
      out.write("                            userid:userid\r\n");
      out.write("                        },\r\n");
      out.write("                        success: function (data) {\r\n");
      out.write("\r\n");
      out.write("                            if(data.code==200){\r\n");
      out.write("                                obj.del();\r\n");
      out.write("                                layer.msg(\"删除成功\");\r\n");
      out.write("                                table.reload(\"test\");//重新加载\r\n");
      out.write("                            }else{\r\n");
      out.write("                                layer.msg(\"删除失败\")\r\n");
      out.write("                            }\r\n");
      out.write("                        },\r\n");
      out.write("                        error: function (data) {\r\n");
      out.write("                            alert(\"错误\")\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                    layer.close(index);\r\n");
      out.write("                });\r\n");
      out.write("            } else if(obj.event === 'edit'){\r\n");
      out.write("                //把要修改的数据存到localStorage,跳转到修改页面，再取出来展示要修改的数据\r\n");
      out.write("                localStorage.setItem(\"user\",JSON.stringify(data));\r\n");
      out.write("\r\n");
      out.write("                layer.open({\r\n");
      out.write("                    title: '编辑',\r\n");
      out.write("                    type: 2,\r\n");
      out.write("                    area: ['50%','30%'],\r\n");
      out.write("                    shadeClose:true,//点别的地方则关闭当前layer\r\n");
      out.write("                    fixed:false,\r\n");
      out.write("                    content: './Administrator_usermanagement_update.jsp',\r\n");
      out.write("                    end:function (index) {\r\n");
      out.write("                        table.reload(\"test\")\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //触发表格复选框选择\r\n");
      out.write("        table.on('checkbox(test)', function(obj){\r\n");
      out.write("            console.log(obj)\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        //触发表格单选框选择\r\n");
      out.write("        table.on('radio(test)', function(obj){\r\n");
      out.write("            console.log(obj)\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // 行单击事件\r\n");
      out.write("        table.on('row(test)', function(obj){\r\n");
      out.write("            //console.log(obj);\r\n");
      out.write("            //layer.closeAll('tips');\r\n");
      out.write("        });\r\n");
      out.write("        // 行双击事件\r\n");
      out.write("        table.on('rowDouble(test)', function(obj){\r\n");
      out.write("            console.log(obj);\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 单元格编辑事件\r\n");
      out.write("        // table.on('edit(test)', function(obj){\r\n");
      out.write("        //     var field = obj.field //得到字段\r\n");
      out.write("        //         ,value = obj.value //得到修改后的值\r\n");
      out.write("        //         ,data = obj.data; //得到所在行所有键值\r\n");
      out.write("        //\r\n");
      out.write("        //     var update = {};\r\n");
      out.write("        //     update[field] = value;\r\n");
      out.write("        //     obj.update(update);\r\n");
      out.write("        // });\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
