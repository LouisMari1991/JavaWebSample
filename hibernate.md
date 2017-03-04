###实体类对象状态
　　实体类状态有三种：

1. 瞬时态: 对象里面没有id值，对象与 `session` 没有关联;
2. 持久态: 对象里面有id值，对象与 `session` 关联;
3. 托管态: 对象有id值，对象与 `session` 没有关联.

#####`saveOrUpdate()`  方法:
1. 实体类对象是瞬时态,做添加操作 insert
2. 实体类对象是托管态,做修改操作 update
3. 实体类对象是持久态,做修改操作 update


###Hibernate 的一级缓存

####什么是缓存？
1. 数据存到数据库里面，数据库本身是文件系统，使用流方式操作文件效率不是很高。<br/>
	(1) 把数据存到内存里面，不需要使用流方式，可以直接读取内存中数据。<br/>
	(2)把数据放到内存中，提高读取效率

####Hibernate 缓存
1. Hibernate框架提供很多优化方式，hibernate的缓存就是一个优化方式。
2. hibernate缓存特点<br/>
#####第一类: hibernate的一级缓存
　　(1) hibernate 的一级缓存默认打开的。<br/>
　　(2) hibernate 的一级缓存使用范围,是session范围，从session创建到session关闭范围。<br/>
　　(3)hibernate 的一级缓存中，存储数据必须 `持久态` 数据

#####第二类: hibernate的二级缓存
　　(1) 二级缓存已经不使用了，替代技术 `redis`数据库<br/>
　　(2) 二级缓存默认不是打开的，需要配置<br/>
　　(3) 二级缓存使用范围,是 `sessionFactory` 范围<br/>

#####hibernate 一级缓存特性
1. 持久态自动更新数据库


####Hibernate 的api使用

Query 对象

Criteria 对象

SQLQuery 对象

