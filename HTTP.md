**请求头**：

Accept:用于告诉服务器，客户机支持的数据类型
Accept-Charset:用于告诉服务器，客户机采用的编码
Accept-Encoding:用于告诉服务器，客户机支持的数据压缩格式
Accept-Language:客户机的语言环境
Host:用于告诉服务器，想访问的主句名
If-Modified-Since:客户机通过这个头用于告诉服务器，资源的缓存时间
Referrer:客户机器通过这个头告诉服务器，它是从哪个资源来访问服务器的(防盗链)
User-Agent:客户机通过这个头告诉服务器，客户机的软件环境
Cookie:客户机可以通过这个头可以向服务器带数据

<br/>

**响应头**：

Location:这个头配合302状态码使用，用于重定向
Server:服务器通过这个头，告诉浏览器服务器的类型
Content-Encoding:服务器通过这个头，数据的压缩格式
Content-Length:服务器通过这个头，告诉浏览器回送数据的长度
Content-Type:服务器通过这个头，告诉浏览器回送数据的类型
Last-Modified:服务器通过这个头，告诉浏览器当前资源缓存时间
Refresh:服务器通过这个头，告诉浏览器隔多长时间刷新一次
Content-Disposition:服务器通过这个头，告诉浏览器以下载方式打开数据
Transfer-Encoding:服务器通过这个头，告诉浏览器数据的传送格式
ETag:缓存相关的头,实时更新
Expires:服务器通过这个头，告诉浏览器把回送的数据缓存多长时间,0或-1,则是不缓存

Cache-Control:no-cache
Pragma:no-cache
服务器通过以上两个头，也是控制浏览器不要缓存数据