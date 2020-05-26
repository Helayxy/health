### 传智健康介绍

#### 一、项目介绍：

传智健康管理系统是一款应用于健康管理机构的业务系统，实现健康管理机构工作内容可视化、会员管理专业化、健康评估数字化、健康干预流程化、知识库集成化，从而提高健康管理师的工作效率，加强与会员间的互动，增强管理者对健康管理机构运营情况的了解。

#### 二、系统架构

##### 1.技术架构图：

![](https://github.com/Helayxy/health/blob/master/assets/1.png)

##### 2.功能架构图：

![](https://github.com/Helayxy/health/blob/master/assets/2.png)

##### 3.系统架构解读：

整个传智健康项目可以分为两部分：传智健康管理后台、传智健康管理前台（微信端）。

###### 传智健康管理后台：

- 后台系统主要包含以下功能：
  - 预约管理，包括预约设置、套餐管理、检查组管理和检查项管理；
  - 统计分析，包括会员数量统计、套餐预约占比统计和运营数据统计；
  - 其他菜单涉及到的功能暂未开发。
- 后台管理系统预览图：

![](https://github.com/Helayxy/health/blob/master/assets/3.png)

###### 传智健康管理前台（微信端）：

- 前台面向的是客户，以诶新公众号的形式进行开发，包含与客户交互的相关功能。例如：
  - 体检预约；
  - 套餐选择；
  - 立即预约；
  - 填写预约信息；
  - 提交预约等；
  - 其他菜单涉及到的功能暂未开发。
- 前台系统（微信端）预览图：

![](https://github.com/Helayxy/health/blob/master/assets/4.png)

#### 三、项目结构：

本项目采用maven分模块开发方式，即对整个项目拆分为几个maven工程，每个maven工程存放特定的一类代码，具体如下：

##### 1.Maven模块结构图：

![](https://github.com/Helayxy/health/blob/master/assets/5.png)

##### 2.各模块职责定位：

- health_parent：父工程，打包方式为pom，统一锁定依赖的版本，同时聚合其他子模块便于统一执行maven命令；
- health_common：通用模块，打包方式为jar，存放项目中使用到的一些工具类、常量类、实体类和返回结果类等；
- health_interface：打包方式为jar，存放服务接口；
- health_service_provider：打包方式为war，Dubbo服务提供方，存放服务实现类、Dao接口和Mapper映射文件等，需要部署到tomcat运行；
- health_backend：后台系统，打包方式为war，Dubbo服务消费方，存放Controller、HTML页面、js、css、spring配置文件等，需要部署到tomcat运行；
- health_mobile：前台系统（微信端），打包方式为war，Dubbo服务消费方，存放Controller、HTML页面、js、css、spring配置文件等，需要部署到tomcat运行；
- health_jobs：定时任务，用来清理垃圾图片，打包方式为war，需要部署到tomcat运行；

以上打包方式为war包的均为Javaweb工程，在其pom文件中引入了tomcat插件，所以不需要另外提供tomcat。

#### 四、技术选型：

##### 1.相关技术：

###### 前端技术：

- 基础的HTML、CSS、JavaScript；
- Vue.js v2.5.16；
- ajax框架：axios，用来作异步请求处理。

###### 后端技术：

- 基础的SpringMVC、Spring 5.0和MyBatis3.4；
- Redis-4.0；
- 七牛云存储；
- 阿里大于短信发送；
- SpringSecurity5.0安全认证；
- Echarts图表统计等。

#### 五、项目启动、访问流程：

##### 1.启动zookeeper服务：

zookeeper用来作服务注册中心，双击C:\tools\zookeeper-3.4.6\bin目录下的zkServer.cmd命令脚本即可启动zookeeper服务；

##### 2.安装项目：

对项目进行整体安装。由于health_parent为父工程，聚合了其他子模块，所以对health_parent模块进行安装即代表了对所有模块进行安装。运行install命令，即双击install按钮即可。如下图所示：

![](https://github.com/Helayxy/health/blob/master/assets/6.png)

##### 3.启动项目：

需要启动的Maven模块有以下几个：

- health_service_provider：Dubbo服务提供方；
- health_backend：后台系统，Dubbo服务消费方；
- health_mobile：前台系统（微信端），Dubbo服务消费方；
- health_jobs：定时任务，用来清理垃圾图片，需要时启动；

health_jobs项目演示时一般不需要启动，生产环境下也需要部署。

##### 4.启动示例图：

由于以上web模块在其pom文件中引入了tomcat插件，所以双击tomcat的run或debug命令即可运行，如下图所示：

![](https://github.com/Helayxy/health/blob/master/assets/7.png)

其他模块启动方式也是如此；

##### 5.访问项目：

访问后台管理系统，tomcat端口为82，在浏览器中输入http://localhost:82/pages/main.html进行访问；

访问前台系统（微信端），tomcat端口为80，在浏览器中输入http://localhost进行访问；

用户名：admin，密码：admin

用户名：小明，密码：1234

对于后台管理系统，不同的用户拥有不同的权限，可以进行的操作也不同。

##### 6.注意事项：

health_common工程下的utils包下的SMSUtils是阿里云短信工具类，代码中的accessKeyId和accessKeySecret需要替换为自己阿里云的AK，这里使用***表示是为了防止其他人调用本人阿里云的相关API接口。

