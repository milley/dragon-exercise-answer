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
