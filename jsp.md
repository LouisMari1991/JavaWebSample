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