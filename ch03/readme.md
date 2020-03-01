# 第三章 词法分析

## Exercise 3.1.1

将下面的C++程序

```c++
float limitedSquare(x) {
  float x;
  /* returns x-squared, but never more than 100 */
  return (x <= -10.0 || x >= 10.0) ? 100 : x * x;
}
```

划分为正确的词素序列。哪些词素应该有相关联的词法值？应该具有什么值？

### 3.1.1 Answer

```g4
<float> <id, limitedSquare> <(> <id, x> <)> <{>
  <float> <id, x>
  <return> <(> <id, x> <op, "<="> <num, -10.0> <op, "||"> <id, x> <op, ">="> <num, 10.0> <)> <op, "?"> <num, 100> <op, ":"> <id, x> <op, "*"> <id, x>
<}>
```

## Exercise 3.1.2

像HTML或XML之类的标记语言不同于传统的程序设计语言，它们要么包含有很多标点符号（标记）， 如HTML，要么使用用户自定义的标记集合，如XML。而且标记还可以带有参数。请指出如何把下面的HTML文档

```html
Her is a photo of <B>my house</B>;
<P><IMG SRC = "house.gif"><BR>
See <A HREF = "morePix.html">More Pictures</A> if you
liked that one.<P>
```

划分为适当的词素序列。哪些词素应该具有相关联的词法值？应该具有什么样的值？

### 3.1.2 Answer

```g4
<text, "Here is a photo of"> <nodestart, b> <text, "my house"> <nodeend, b>
<nodestart, p> <selfnode, img> <selfnode, br>
<text, "See"> <nodestart, a> <text, "More Pictures"> <nodeend, a>
<text, "if you liked that one."> <nodeend, p>
```

## Exercise 3.3.1

对于下列各个语言，查询语言使用手册以确定：

(i)形成各语言的输入字母表的字符集分别是什么（不包括那些只能出现在字符串或注释中的字符）？
(ii)各语言的数字常量的词法形式是什么？
(iii)各语言的标识符的词法形式是什么？

(1) C (2) C++ (3) C# (4) Fortran (5) Java (6) Lisp (7) SQL

### 3.3.1 Answer

(1)(2)(3)(5)

ASCII

```lex
digit -> 0|1|...|9

digits -> digit digit*

optionalFraction -> . digits | ε

optionalExponent -> (E(+|-|ε) digits) | ε

number -> digits optionalFraction optionalExponent

```

```lex
letter_ -> A|B|...|Z|a|b|...|z|_

digit -> 0|1|...|9

id -> letter_(letter_|digit)*
```

## Exercise 3.2.2

试描述下列正则表达式定义的语言：

1) a(a|b)*a
2) ((ε|a)b*)*
3) (a|b)*a(a|b)(a|b)
4) a*ba*ba*ba*
5) (aa|bb)*((ab|ba)(aa|bb)*(ab|ba)(aa|bb)*)*

### Answer 3.2.2

1) 字符串a开头a结尾，中间0个或者多个a或者b
2) 多个a和多个b组成的字符串
3) 多个a和多个b组成的字符串，倒数第三个是a
4) 多个a和多个b组成的字符串，其中b只出现3次
5) 多个a和多个b组成的字符串，其中a和b都出现偶数次

## Exercise 3.3.3

试说明在一个长度为n的字符串中，分别有多少个

1) 前缀
2) 后缀
3) 真前缀
4) 子串
5) 子序列

### Answer 3.3.3

1) n+1
2) n+1
3) n-1
4) C(n+1,2)+1
5) Σ(i=0,n) C(n, i)

## Exercise 3.3.5

写出下列语言的正则定义：

1) 包含5个元音的所有小写字母，这些串中的元音按顺序出现
2) 所有由按字典递增序列排列的小写字母组成的串
3) 注释，即/*和*/之间的串，且串中没有不在双引号(")中的*/。
4) 所有不重复的数位组成的串。
5) 所有最多只有一个重复数位的串。
6) 所有由偶数个a和奇数个b构成的串。
7) 以非正式方式表示的国际象棋的步法的集合，如p - k4或kbp x qn。
8) 所有由a和b组成并且不含子串abb的串。
9) 所有由a和b组成且不含子序列abb的串。

### Answer 3.3.5

1)

```lex
other -> [bcdfghjklmnpqrstvwxyz]

want -> other*a (other|a)* e (other|e)* i(other|i)* o(other|o)* u(other|u)*
```

2)

```lex
a*b*...z*
```

3)

```lex
\/\*([^*"]*|".*"|\*+[^/])*\*\/
```

4)

```lex
A -> 0?2(02)*

want -> 0|A?0?1(A0?1|01)*A?0?|A0?
```

5)

```lex
E -> b(aa)*b

F -> a(aa)*b

G -> b(aa)*ab|a

F -> ba(aa)*b

want -> (FE*G|(aa)*b)(E|FE*G)
```

6)

```lex
even_a_even_b -> (aa|bb)*((ab|ba)(aa|bb)*(ab|ba)(aa|bb)*)*

even_a_odd_b -> b even_a_even_b | a(aa|bb)*(ab|ba) even_a_even_b
```

8)

```lex
b*(a+b?)*
```

9)

```lex
b*|b*a+|b*a+ba*
```
