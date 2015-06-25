@author 王鹏飞          
@since  2015/6/25

#java注解

定义：注解的定义使用关键词 @interface ,并在上面一行注明@Rentention(arg) 或者@Target(args) , 样例如下：

        @Rentention(RetentionPolicy.RUNTIME)
        public @interface Annotation01 {
        //定义公共的final静态属性
        //定以公共的抽象方法
        }

@Retention ：用来说明该注解类的生命周期。它有以下三个参数：

        RetentionPolicy.SOURCE  : 注解只保留在源文件中

        RetentionPolicy.CLASS  : 注解保留在class文件中，在加载到JVM虚拟机时丢弃

        RetentionPolicy.RUNTIME  : 注解保留在程序运行期间，此时可以通过反射获得定义在某个类上的所有注解。

@Target :  用来说明该注解可以被声明在那些元素之前。

        ElementType.TYPE：说明该注解只能被声明在一个类前。

        ElementType.FIELD：说明该注解只能被声明在一个类的字段前。

        ElementType.METHOD：说明该注解只能被声明在一个类的方法前。

        ElementType.PARAMETER：说明该注解只能被声明在一个方法参数前。

        ElementType.CONSTRUCTOR：说明该注解只能声明在一个类的构造方法前。

        ElementType.LOCAL_VARIABLE：说明该注解只能声明在一个局部变量前。

        ElementType.ANNOTATION_TYPE：说明该注解只能声明在一个注解类型前。

        ElementType.PACKAGE：说明该注解只能声明在一个包名前。
        

常见基本内置注解

        @Override  当我们想重写一个方法时，在方法上加@Override，当我们方法的名字出错时，编译器就会报错。 定义如下：

        @Retention(RetentionPolicy.SOURCE )

        public   @interface  Override

        @Deprecated  用来表示某个类的属性或方法已经过时，不想别人再用时，在属性和方法上用@Deprecated修饰。 定义如下：

        @Retention(RetentionPolicy.SOURCE )

        public   @interface  Deprecated

        @SuppressWarnings  用来压制程序中出来的警告。 定义如下：

        @Retention(RetentionPolicy.SOURCE )

        public   @interface  SuppressWarnings
        

注解的使用

        定义注解--》声明注解-->获得注解；

        其中 获得注解 通过被修饰的对象的 getAnnotation 或 getAnnotations 方法获得。
        
原文地址：http://www.tuicool.com/articles/2MRZJn