# 第二章 一个简单的语法制导翻译器

## Exercise 2.2.1

考虑下面的上下文无关文法： S->S S + | S S * | a

1) 试说明如何使用该文法生成串aa+a*。
2) 试为这个串构造一棵语法分析树。
3) 该文法生成的语言式什么？证明你的答案。

### 2.2.1.1. Answer

<1> S=> S S *

<2> S=> S S + S *

<3> S=> a a + a *

### 2.2.1.2. Answer

<img src="./img/2.2.1-2.png" width="40%" >

### 2.2.1.3. Answer

由数字、加号和乘号组成的后缀表达式

## Exercise 2.2.2

下面的各个文法生成什么语言？证明你的每一个答案。

1. S->0 S 1 | 0 1
2. S->+ S S | - S S | a
3. S->S ( S ) S | ε
4. S->a S b S | b S a S | ε
5. S->a | S + S | S S | S * | ( S )

### 2.2.2Answer

1. {0<sup>n</sup>1<sup>n</sup> | n>=1}
2. 正负号前缀表达式
3. 匹配任意排列和嵌套的括号，包括ε
4. a和b组成的字符串，个数相同，包括ε
5. 正则表达式

## Exercise 2.2.3

练习2.2.2中哪些文法具有二义性？

### 2.2.3 Answer

1. No
2. No
3. Yes
   <img src="./img/2.2.3-3.png" width="40%" >
4. Yes
   <img src="./img/2.2.3-4.png" width="40%" >
5. Yes
   <img src="./img/2.2.3-5.png" width="40%" >
