####JSP语法

Page指令:

JSP2.0规范定义的page指令的完整语法：<br/>
```
<%@page
	[ language="java" ]
	[ extends="page class" ]
	[ import="{package.class | package.*}" ]
	[ session="true | false" ]
	[ buffer="none | 8 Kb | sizekb" ]
	[ autoFlush="true | false" ]
	[ isThreadSafe="true | false" ]
	[ info="text" ]
	[ errorPage="relative_url" ]
	[ isErrorPage="true | false" ]
	[ contentType="mimeType [;chartset=characterSet]" | "text/html ; charset=UTF-8" ]
	[ pageEncoding="characterSet | UTF-8" ]
	[ isELIgnored="true | false" ]
```

9大隐式对象:

1. Request
2. Response
3. Session
4. Application
5. Config
6. Page
7. Out
8. Exception
9. pageContext

JSP中使用JavaBen：<br/>
　　JSP技术提供了三个关于JavaBean组件的动作元素，即JSP标签，他们分别为:

1. `<jsp:useBean>` 标签：用于在JSP页面中查找或实例化一个  JavaBean 组件。<br/>
2. `<jsp:setProperty>` 标签：用于在JSP页面中设置一个 JavaBean 组件的属性。<br/>
3. `<jsp:getProperty>` 标签：用于在JSP页面中获取一个 JavaBean 组件的属性。


####EL表达式
1. EL表达式用于获取数据，在 JSP 页面中可使用 `${标识符}` 的形式，通知 JSP 引擎调用 `pageContext.findAttribute()` 方法，以标识符为关键字从各各域对象中获取对象。如果域对象不存在标识符所对应的对象，则返回结果为 `""` (注意，不是 `null`)。
2. EL表达式中也可以使用 `${customerBean.address}` 的形式来访问JavaBean 对象的属性。
3. 结合 JSTL 标签, EL 表达式也可以轻松获取各个集合中的元素。
4. EL 表达式也可以使用类如 `${1==1}` 的形式进行简单的逻辑判断。


###JSTL 标签库
1. JSTL 是sun公司开发的一套标签库,使用JSTL可以在页面中实现一些简单的逻辑，从而替换页面中的脚本代码。
2. 在页面中使用JSTL标签需完成一下两个步骤:
   1. 导入 jstl.jar 和 standerd.jar 这两个 JSTL 的jar文件。
   2.  在 JSP 页面中使用 `<%@tablib url="" prifix="" %>` 元素导入标签库。

3. JSTL 标签库常用标签: `<c:foreach var="" items="">` , `<c:if test="">`
