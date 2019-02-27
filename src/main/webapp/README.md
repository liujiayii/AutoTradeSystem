## 目录结构介绍 ##

	|-- login                             // 登录
	|   |-- login.jsp                     // 登录页面
	|-- pages                             // 页面目录
	|   |-- archives                      // 维修档案
	|   |-- carManage                     // 车辆管理
	|   |-- carSales                      // 售车管理
	|   |-- customerInfo                  // 客户信息
	|   |-- error                         // 没有权限
	|   |-- financialManage               // 财务管理
	|   |-- inventoryManage               // 库存管理
	|   |-- layout                        // 布局
	|   |-- personManage                  // 公司管理
	|   |-- repair                        // 维修管理
	|   |-- tradeManage                   // 交易管理
	|-- static                            // 静态资源
    |   |-- css                           // 全局样式
    |   |-- js                            // 工具类
	|-- README.md                         // 说明
	
## 工具类 ##
+ menu:：导航菜单
+ rules： 表单校验
+ mixin：全局变量和封装的函数
+ Vue.mixin: vue混入语法，需要调用表单校验就在mixin数组中添加rules
