#maven

maven项目组成：
src
	-main
		-java
			-package
	-test
		-java
	resources
	
maven常用命令：
	mvn -v 查看maven版本
	compile 编译
	test 测试
	package 打包
	
	clean 删除target目录
	install 安装jar包到本地仓库中

创建目录的两种方式：
1.archetype:generate 按照提示进行选择
2.archetype:generate -DgroupId=组织名，公司网址的反写+项目名
					 -DartifactId=项目名-模块名
					 -Dversion=版本号
					 -Dpackage=代码所存在的包名
e.g:mvn archetype:generate -DgroupId:com.sync.maven -DartifactId:maven-demo
						   -Dversion:1.0.0-SNAPSHOT -Dpackage:com.sync.maven.demo
	
maven自动建立项目骨架：
1.创建文件夹。
2.cmd命令进入目录.
3.执行：mvn archetype:generate
	第一次执行会下载很多依赖包，耐心等待
4.依赖包下载完成之后选择版本:6
5.输入'groupId':com.sync.maven
6.输入'artifactId':maven-service
7.输入'version':1.0-SNAPSHOT
8.输入'package':com.sync.maven.service
9.确认：输入'y';完成项目骨架构建.

maven默认的全球仓库的地址：
maven解压缩路径→lib目录→maven-model-builder-3.3.9.jar→pom.xml→repositories→url

修改镜像地址：
maven解压缩路径→conf→setting.xml→找到<mirrors>标签→增加一个<mirror>标签如下：
  <mirror>
      <id>maven.net.cn</id>
      <mirrorOf>central</mirrorOf>
      <name>central mirror in china</name>
      <url>http://maven.net.cn/content/groups/public</url>
    </mirror>
	
一旦配置了镜像仓库，所有对原仓库的访问都将转到镜像仓库.


更改仓库位置:
maven从远程仓库中下载构建，所有的包默认都是放在当前用户的C盘:.m2文件中
修改:
maven解压缩路径→conf→setting.xml→增加如下标签:
	<localRepository>E:/mavan/repo</localRepository>
	
maven生命周期：
clean,compile,test,package,install

clean: 清理项目
	pre-clean 执行清理前的工作
	clean 清理上一次构建生成的所有文件
	post-clean 执行清理后的文件
	
default 构建项目(最核心)
	compile test package install
	
site 生成项目站点
	pre-site 在生成项目站点前要完成的工作
	site 生成项目的站点文档
	post-site 在生成项目站点后要完成的工作
	site-deploy 发布生成的站点到服务器上
	
	
pom.xml文件标签解析：
modelVersion:指定了当前pom的版本
groupId:反写的公司网址+项目名
artifactId:项目名+模块名
version:表示当前项目的版本号;第一个0表示大版本号，第二个0表示分支版本号，第三个0表示小版本号
		snapshot快照、alpha内部测试、beat公测、Release稳定、GA正式发布
packaging:打包信息;默认是jar,还可以指定war,zip,pom
name:项目名
url:项目地址
descpiption:项目描述
developers:开发人员信息
licenses:许可证信息
orgainzation:组织信息

dependencies:依赖列表
	dependecy:依赖项
		groupId
		archetype
		type:依赖的类型，pom
		scope:依赖的范围
		optional{true,false}:设置依赖是否可选
		exclusions:排除依赖传递列表:
			exclusion:可以多个

<!-- 依赖的管理,主要是定义在父模块中,供子模块使用 -->
dependencyManagement	
	dependencies
		dependecy
		

build:
	<!-- 插件列表 -->
	plugins
		plugin
			groupId
			archetype
			version

<!-- 通常用于子模块对父模块pom的继承 -->
<parent>

<!-- 用来聚合运行多个maven项目 -->
<modules>
	<module></module>
</modules>


依赖的范围：
maven提供了三种classpaath,分别是：
1、编译
2、测试
3、运行

<!-- 只存在测试的classpath，只存在测试的范围 -->
<scope>test</scope>
scope提供了6个值
compile:默认的级别，编译测试运行都有效
provided:在测试和编译时有效,serverlet
runtime:在测试和运行时有效,jdbc
test:测试时有效,junit
system:与本机系统相关联，编译测试时有效，可移植性差
import:导入的范围，它只在 dependencyManagement 中，表示从其他的pom中导入 dependecy 的配置

maven依赖传递

maven依赖冲突：
1、短路优先：
	A→B→C→X(V2.4.jar)
	A→D→X(V2.0.jar) 
	优先解析路径短的版本:A→X(V2.0.jar)

2、先声明先优先
	A→B→X(V2.4.jar)
	A→C→X(V2.0.jar)
	如果路径长度相同，则谁先声明，先解析谁，
如果B在C上面，则：A→X(V2.4.jar)

maven聚合和继承：
新建一个maven工程：hongxing-aggreation
<name>hongxing-aggreation</name>
<modules>
		<module>../hongxing-bge</module>
		<module>../hongxing-nange</module>
		<module>../hongxing-shanji</module>
</modules>
	







