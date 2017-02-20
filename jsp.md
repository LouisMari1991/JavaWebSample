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