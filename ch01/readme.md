# 第一章 引论

## Exercise 1.1.1

> 编译器和解释器之间的区别式什么？

**Answer**
编译器就是一个程序，可以阅读以某一种语言（源语言）编写的程序，并把该程序翻译成为一个等价的、用另一种语言编写的程序。编译器的重要任务之一是报告它在翻译过程中发现的源程序中的错误。

解释器式另一种常见的语言解释器。它并不通过翻译的方式生成目标程序。解释器直接利用用户提供的输入执行源程序中的错误。

## Exercise 1.1.2

> 编译器相对于解释器的优点式什么？解释器相对于编译器的优点式什么？

**Answer**
编译器比起解释器速度更快。解释器相对于编译器错误诊断更好。

## Exercise 1.1.3

> 在一个语言处理系统中，编译器产生汇编说而不是机器语言的好处式什么？

**Answer**
汇编语言更容易输出调试。

## Exercise 1.1.4

> 把一种高级语言翻译成为另一种高级语言的编译器称为源到源(source-to-source)的编译器。编译器使用C语言作为目标语言有什么好处？

**Answer**
目标语言使用C语言可移植性更好，也更容易理解。

## Exercise 1.1.5

> 描述一下汇编器所要完成的一些任务。

**Answer**
汇编代码生成机器代码。

## Exercise 1.3.1

> 指出下面的术语：
>
> 1)强制性的     2)声明式的      3)冯·诺依曼式的     4)面向对象的
> 5)函数时的     6)第三代        7)第四代           8)脚本语言
>
> 可以被用于描述下面的哪些语言：
>
> 1)C [1,3,6]   2)C++ [1,3,4,6]   3)Cobol [1,3,6]   4)Fortran [1,3,6]
> 5)Java [1,3,4,6]   6)Lisp [2,5,6]   7)ML [2,5,7]    8)Perl [2,6,8]
> 9)Python [2,4,6,8]    10)VB [1,3,6]

## Exercise 1.6.1

> 对于ex1_13a.c中的块结构的C代码，指出赋值给w、x、y、z的值。

@import "ex1_13a.c"

## Exercise 1.6.2

> 对于ex1_13b.c中的代码重复练习。

@import "ex1_13b.c"

## Exercise 1.6.3

> 对于ex1_14.c中的块结构代码，假设使用常见的生命的静态作用域规则，给出其中12个声明中的每一个的作用域。

**Answer**

```console
Block B1:
	declarations:  ->   scope
		w				B1-B3-B4
		x				B1-B2-B4
		y				B1-B5
		z				B1-B2-B5
Block B2:
	declarations:  ->   scope
		x				B2-B3
		z				B2
Block B3:
	declarations:  ->   scope
		w				B3
		x				B3
Block B4:
	declarations:  ->   scope
		w				B4
		x				B4
Block B5:
	declarations:  ->   scope
		y				B5
		z				B5
```

## Exercise 1.6.4

> ex1_15.c的代码打印结果式什么？

@import "ex1_15.c"