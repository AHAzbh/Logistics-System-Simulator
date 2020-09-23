# Logistics-System-Simulator


![license](http://github.zhangqx.com/file-checker/github/AHAzbh/Logistics-System-Simulator?path=LICENSE)
![readme](http://github.zhangqx.com/file-checker/github/AHAzbh/Logistics-System-Simulator?path=README.md)
![contributing](http://github.zhangqx.com/file-checker/github/AHAzbh/Logistics-System-Simulator?path=CONTRIBUTING.md)
![coc](http://github.zhangqx.com/file-checker/github/AHAzbh/Logistics-System-Simulator?path=CODE_OF_CONDUCT.md)
![codestyle](http://github.zhangqx.com/file-checker/github/AHAzbh/Logistics-System-Simulator?path=CODE_STYLE.md)
![pulltemplate](http://github.zhangqx.com/file-checker/github/AHAzbh/Logistics-System-Simulator?path=.github/PULL_REQUEST_TEMPLATE.md)



## 目标
本项目旨在学习开源的主要方式，并且在开源项目里提升团队合作能力，为将来的工程性项目开发打下良好基础

## 项目介绍
本项目分为笔记部分和项目部分，由十人团队共同完成。笔记部分大家可以提交自己的学习笔记或学习心得 ( 主要聚焦于Java开发 ) 。项目部分为以spring boot作为主要框架模拟物流配送系统的项目，大家可以利用该项目进行练手，提升自己的水平。

## 工具前提
|  Library   | Version  |
|  ----  | ----  |
| JDK  | 1.11 |
| apache-maven  | 3.6.3 |
|MySQL | 8.0.21 |
| spring boot | 2.3.3(由maven自动安装依赖包即可) |

## 项目结构
(pending)

## 详细说明

### 主要功能
本项目想要实现的主要功能是在人工设计物流节点的基础上搭建虚拟物流网络，从而模拟物流配送系统的部分主要功能，包括新物流配送任务的创建、物流查询、维护买方卖方以及配送员信息以及三方之间的通信、确认收货等，并尝试性地做一些功能创新。

### 各功能的实现
1. **网络搭建：** 物流网络的搭建是上述所有功能的基础，由于目前没有资源获得现实物流节点网络，因此采用人工模拟，人工模拟节点可从简灵活设计，主要思路与计算机路由网络雷同(可能与实际情况有偏差)，可包括大型枢纽节点和小型地方节点 (关系类似于单个设备与路由器)，枢纽节点内部应储存与其他节点和的配送路径 (可采用路由算法动态更新表项也可以采用静态方法手动添加)，由枢纽节点决定 如何配送到对应的地方节点。综述，应该定义一个物流图类，一个节点类，在物流图内部实现节点分类、连接和路径映射；节点应该有不同的编码用作底层数据库里的主码，数据库储存该节点的各种信息(实际上本项目实现的节点数和网络复杂度可能并不高，依然使用数据库的目的在于尽可能模拟实际生产环境)。
2. **网络更新：** 网络的更新交由配送员完成，定义配送员类，每个配送员对象负责一条或者多条路径之间的物流配送，配送员也应该注册，信息保存在配送员数据库里， 配送员向枢纽节点发起订单配送申请，节点审核订单信息和配送员信息是否匹配，是则将订单交由配送员，更新订单状态，配送员数据库更新配送员状态，配送员开始向目的地运输订单，到达目的地后向目标节点提交订单并返回。
![网络更新](/img/distributor_node.png)
3. **买方客户端功能实现：**
![买方客户端功能实现](/img/buyer.png)
&#160; &#160; &#160; &#160;买方应具有的基本功能包括编辑收货地址(对应到收货节点)，向卖方申请新订单、订单状态查询、确认收货、与卖方和配送员之间通信。定义买方类和订单类，每个账户对应一个买方对象，每个订单对应一个订单对象，底层使用数据库储存账户信息和订单信息，买方发起查询操作应输入订单号，系统审核该订单号是否合法，合法则进一步从订单数据库查询订单信息并返回给买方；买方可依据返回信息向配送员发起通信；买方受到货物后，可依据订单号确认收货，确认收货后数据库删除对应表项。
4. **卖方功能：** 卖方类实现卖家注册，应该具有接受购买申请，创建新订单注入网络的功能。

### 创新项
&#160; &#160; &#160; &#160;买方客户端输入订单号系统创建对话框，对话框返回订单查询信息，买方在此对话框内输入信息会自动发送到配送该订单的配送员，配送员收到信息后可与买方互发消息，确认收货后对话框自行删除。

&#160; &#160; &#160; &#160;现有网购软件中，买方若想与配送员发起通信，其操作大多较为繁琐，而买方进行物流查询的操作较容易实现，且部分买方有频繁查询物流的习惯，可采用这种方式简化买方与配送员之间发起通信的步骤。

