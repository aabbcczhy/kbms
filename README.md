# 代码编写指南与规范

## 一、VO对象

VO即value object值对象,主要体现在视图的对象，对于一个WEB页面将整个页面需要的属性封装成一个对象。然后用一个VO对象在控制层与视图层进行传输交换。也就是说对于bean包中的对象可能不够前端页面使用，这时候你就要构造一个自定义的VO对象。

## 二、业务异常处理机制

异常对象已封装在error包中，关键的类是枚举类EmError，该类枚举了各种业务上可能出现的异常，可以根据开发需要添加新的异常，格式按照原有的异常来写，需要注意的规范是：添加的枚举需要全部大写同时单词之间要用下划线分隔开。不同的业务异常应该使用不同的错误码来区分，方便追踪异常产生的原因。

异常处理机制是MyExceptionHandler类，该类拦截了Spring所有即将被抛出的异常，并判断如果是自定义的业务异常，则返回可以给前端处理的JSON字符串，如果是其他异常则返回未知异常。值得注意的是，因为拦截了所有异常，当代码有其他异常时，控制台就没有日志输出了，因此我在异常处理中单独输出了错误日志。但是前端返回则是未知异常而不返回异常原因，这点需要注意。

## 三、统一返回对象的使用

统一返回对象则是response包中的Response类，该类已经封装好返回的两个方法，一般而言只需要使用Response.create(Object result)这个方法即可。如果涉及插入，删除等不需要返回result的业务是，参数可以是null也可以填写一些信息，比如```Response.create("删除成功")```。如果涉及到查询，则就将vo对象作为参数即可。输出的Json格式如下：

```json
{
  "status": "success",
  "data": "删除成功"
}
```

可以看到，create中的参数与data显示的是对应的。

## 四、数据表格的返回

统一返回对象Response可能无法满足一些特殊业务的需求，如数据表格要求返回的格式如下：

```json
{
  "code": 0,
  "msg": "",
  "count": 1000,
  "data": [{}, {}]
} 
```

这时候就需要开发者自己构造VO对象返回，该数据表格的封装我已经封装在vo包中了，对于有其他特殊Json格式要求的可以自行封装vo解决问题。但在大部分业务中使用Response对象就足够了。

最后的最后，每个类尽量都标上@author 作者，方便在出bug的时候追踪。