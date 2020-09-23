### 注解

https://www.runoob.com/w3cnote/java-annotation.html

#### java中的原始注解

##### **作用在代码的注解是**

- @Override - 检查该方法是否是重写方法。如果发现其父类，或者是引用的接口中并没有该方法时，会报编译错误。
- @Deprecated - 标记过时方法。如果使用该方法，会报编译警告。
- @SuppressWarnings - 指示编译器去忽略注解中声明的警告。

##### 作用在其他注解的注解(或者说 元注解)是:

- @Retention - 标识这个注解怎么保存，被用来指定Annotation的RetentionPolicy属性。参考**RetentionPolicy** （保留政策）
- @Documented - 标记这些注解是否包含在用户文档中。@Documented 所标注内容，可以出现在javadoc中
- @Target - 标记这个注解应该标注哪种 Java 成员。被用来指定Annotation的ElementType属性。参考**ElementType**（类型）
- @Inherited - 标记这个注解是继承于哪个注解类(默认 注解并没有继承于任何子类)，它所标注的Annotation具有继承性。

#### 注解的架构

![img](D:\markdown\学习笔记markdown\开源社\workspace\Logistics-System-Simulator\notes\java注解.assets\28123151-d471f82eb2bc4812b46cc5ff3e9e6b82.jpg)



##### `Annotation`

annotation是一个接口。定义了三个方法。

boolean equals(Object obj);  //return true if the specified object represents an annotation that is logically equivalent to this one, otherwise false

int hashCode();	//return the hash code of this annotation

String toString();	//return a string representation of this annotation



##### **`RetentionPolicy` **

RetentionPolicy 是一个枚举，里面有三种类型。**每个注解只能有一种RetentionPolicy**类型。（策略属性）

**SOURCE**：说明这个注解只存在于代码，编译阶段会将这个注解丢失，编译器处理完之后，该 Annotation 就没用了。 例如，" @Override" 标志就是一个 Annotation。当它修饰一个方法的时候，就意味着该方法覆盖父类的方法；并且在编译期间会进行语法检查！编译器处理完后，"@Override" 就没有任何作用了。

**CLASS**：说明这个注解会被编译器编入class文件中，但是JVM虚拟器不必在运行保留。(默认的类型)

**RUNTIME**：说明这个注解会被编译器编入class文件中，运行时由JVM保留，可以通过反射来读取这些注解。



##### **`ElementType`** 

elementType是一个枚举，用来声明这个注解作用的对象。（类型属性）

TYPE,        */\* 类、接口（包括注释类型）或枚举声明  \*/*

FIELD,        */\* 字段声明（包括枚举常量）  \*/*

METHOD,       */\* 方法声明  \*/*  

PARAMETER,      */\* 参数声明  \*/*

CONSTRUCTOR,     */\* 构造方法声明  \*/*

LOCAL_VARIABLE,   */\* 局部变量声明  \*/*

ANNOTATION_TYPE,   */\* 注释类型声明  \*/*

PACKAGE       */\* 包声明  \*/*

```java
@Target(ElementType.METHOD)  // 说明Indexed这个注解，只能作用METHOD对象
public @interface Indexed {
}
```

#### 定义一个注解

使用@interface定义注解。

```java
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
}
```

#### Annotation 的作用

##### 编译检查

例如，@SuppressWarnings, @Deprecated 和 @Override 都具有编译检查作用。也就是RetentionPolice的source属性

##### 在反射中使用 Annotation

RetentionPolice的runtime属性。在反射的 Class, Method, Field 等函数中，有许多于 Annotation 相关的接口。

这也意味着，我们可以在反射中解析并使用 Annotation。？？？

##### 根据 Annotation 生成帮助文档

通过给 Annotation 注解加上 @Documented 标签，能使该 Annotation 标签出现在 javadoc 中。

##### 能够帮忙查看查看代码

通过 @Override, @Deprecated 等，我们能很方便的了解程序的大致结构。



#### 快捷方式

注解中定义了名为value的元素，使用该注解时，可以括号(key = value)的语法，如果不写参数，代表着用默认值。

#### 注解的本质

注解的本质，是继承了annotation接口的接口

@interface  test{}本质上等于 interface test extends Annotation{}

注解里的方法，本质上就是虚函数，接口默认方法修饰符是public abstract 。

然后就是**注解传值**问题了，传的值，其实本质上，是可以理解成是一个属性，万物皆对象，对象实体就有属性。

然而注解给的这个属性，是给程序看的

可以理解为，这段程序打了个标签，另一个程序就能看懂你啥意思了。

![preview](D:\markdown\学习笔记markdown\开源社\workspace\Logistics-System-Simulator\notes\java注解.assets\v2-3c4bab856af60100a255bdafecb3ce1e_r.jpg)

#### 如何读取注解？

利用的JAVA的反射机制。因为Annotation类里面，定义过了getValue方法。调用这个方法就能获取注解信息。

注解三要素：定义，使用，执行

而大多数情况下，我们只需要使用注解，框架会自动执行，也提前定义好了。